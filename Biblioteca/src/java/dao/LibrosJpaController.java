/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dao.exceptions.IllegalOrphanException;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.Libros;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.PrestamoLibro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Gangster
 */
public class LibrosJpaController implements Serializable {

    public LibrosJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libros libros) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PrestamoLibro prestamoLibro = libros.getPrestamoLibro();
            if (prestamoLibro != null) {
                prestamoLibro = em.getReference(prestamoLibro.getClass(), prestamoLibro.getIdPrestamo());
                libros.setPrestamoLibro(prestamoLibro);
            }
            em.persist(libros);
            if (prestamoLibro != null) {
                Libros oldCodigoLibroOfPrestamoLibro = prestamoLibro.getCodigoLibro();
                if (oldCodigoLibroOfPrestamoLibro != null) {
                    oldCodigoLibroOfPrestamoLibro.setPrestamoLibro(null);
                    oldCodigoLibroOfPrestamoLibro = em.merge(oldCodigoLibroOfPrestamoLibro);
                }
                prestamoLibro.setCodigoLibro(libros);
                prestamoLibro = em.merge(prestamoLibro);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findLibros(libros.getCodigoLibro()) != null) {
                throw new PreexistingEntityException("Libros " + libros + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libros libros) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Libros persistentLibros = em.find(Libros.class, libros.getCodigoLibro());
            PrestamoLibro prestamoLibroOld = persistentLibros.getPrestamoLibro();
            PrestamoLibro prestamoLibroNew = libros.getPrestamoLibro();
            List<String> illegalOrphanMessages = null;
            if (prestamoLibroOld != null && !prestamoLibroOld.equals(prestamoLibroNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain PrestamoLibro " + prestamoLibroOld + " since its codigoLibro field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (prestamoLibroNew != null) {
                prestamoLibroNew = em.getReference(prestamoLibroNew.getClass(), prestamoLibroNew.getIdPrestamo());
                libros.setPrestamoLibro(prestamoLibroNew);
            }
            libros = em.merge(libros);
            if (prestamoLibroNew != null && !prestamoLibroNew.equals(prestamoLibroOld)) {
                Libros oldCodigoLibroOfPrestamoLibro = prestamoLibroNew.getCodigoLibro();
                if (oldCodigoLibroOfPrestamoLibro != null) {
                    oldCodigoLibroOfPrestamoLibro.setPrestamoLibro(null);
                    oldCodigoLibroOfPrestamoLibro = em.merge(oldCodigoLibroOfPrestamoLibro);
                }
                prestamoLibroNew.setCodigoLibro(libros);
                prestamoLibroNew = em.merge(prestamoLibroNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libros.getCodigoLibro();
                if (findLibros(id) == null) {
                    throw new NonexistentEntityException("The libros with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Libros libros;
            try {
                libros = em.getReference(Libros.class, id);
                libros.getCodigoLibro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libros with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            PrestamoLibro prestamoLibroOrphanCheck = libros.getPrestamoLibro();
            if (prestamoLibroOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libros (" + libros + ") cannot be destroyed since the PrestamoLibro " + prestamoLibroOrphanCheck + " in its prestamoLibro field has a non-nullable codigoLibro field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(libros);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libros> findLibrosEntities() {
        return findLibrosEntities(true, -1, -1);
    }

    public List<Libros> findLibrosEntities(int maxResults, int firstResult) {
        return findLibrosEntities(false, maxResults, firstResult);
    }

    private List<Libros> findLibrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libros.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Libros findLibros(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libros.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libros> rt = cq.from(Libros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
