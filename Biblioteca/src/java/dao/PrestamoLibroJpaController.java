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
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Usuarios;
import entidades.Libros;
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
public class PrestamoLibroJpaController implements Serializable {

    public PrestamoLibroJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PrestamoLibro prestamoLibro) throws IllegalOrphanException, PreexistingEntityException, RollbackFailureException, Exception {
        List<String> illegalOrphanMessages = null;
        Usuarios idUsuarioOrphanCheck = prestamoLibro.getIdUsuario();
        if (idUsuarioOrphanCheck != null) {
            PrestamoLibro oldPrestamoLibroOfIdUsuario = idUsuarioOrphanCheck.getPrestamoLibro();
            if (oldPrestamoLibroOfIdUsuario != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Usuarios " + idUsuarioOrphanCheck + " already has an item of type PrestamoLibro whose idUsuario column cannot be null. Please make another selection for the idUsuario field.");
            }
        }
        Libros codigoLibroOrphanCheck = prestamoLibro.getCodigoLibro();
        if (codigoLibroOrphanCheck != null) {
            PrestamoLibro oldPrestamoLibroOfCodigoLibro = codigoLibroOrphanCheck.getPrestamoLibro();
            if (oldPrestamoLibroOfCodigoLibro != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Libros " + codigoLibroOrphanCheck + " already has an item of type PrestamoLibro whose codigoLibro column cannot be null. Please make another selection for the codigoLibro field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuarios idUsuario = prestamoLibro.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdusuario());
                prestamoLibro.setIdUsuario(idUsuario);
            }
            Libros codigoLibro = prestamoLibro.getCodigoLibro();
            if (codigoLibro != null) {
                codigoLibro = em.getReference(codigoLibro.getClass(), codigoLibro.getCodigoLibro());
                prestamoLibro.setCodigoLibro(codigoLibro);
            }
            em.persist(prestamoLibro);
            if (idUsuario != null) {
                idUsuario.setPrestamoLibro(prestamoLibro);
                idUsuario = em.merge(idUsuario);
            }
            if (codigoLibro != null) {
                codigoLibro.setPrestamoLibro(prestamoLibro);
                codigoLibro = em.merge(codigoLibro);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPrestamoLibro(prestamoLibro.getIdPrestamo()) != null) {
                throw new PreexistingEntityException("PrestamoLibro " + prestamoLibro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PrestamoLibro prestamoLibro) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PrestamoLibro persistentPrestamoLibro = em.find(PrestamoLibro.class, prestamoLibro.getIdPrestamo());
            Usuarios idUsuarioOld = persistentPrestamoLibro.getIdUsuario();
            Usuarios idUsuarioNew = prestamoLibro.getIdUsuario();
            Libros codigoLibroOld = persistentPrestamoLibro.getCodigoLibro();
            Libros codigoLibroNew = prestamoLibro.getCodigoLibro();
            List<String> illegalOrphanMessages = null;
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                PrestamoLibro oldPrestamoLibroOfIdUsuario = idUsuarioNew.getPrestamoLibro();
                if (oldPrestamoLibroOfIdUsuario != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Usuarios " + idUsuarioNew + " already has an item of type PrestamoLibro whose idUsuario column cannot be null. Please make another selection for the idUsuario field.");
                }
            }
            if (codigoLibroNew != null && !codigoLibroNew.equals(codigoLibroOld)) {
                PrestamoLibro oldPrestamoLibroOfCodigoLibro = codigoLibroNew.getPrestamoLibro();
                if (oldPrestamoLibroOfCodigoLibro != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Libros " + codigoLibroNew + " already has an item of type PrestamoLibro whose codigoLibro column cannot be null. Please make another selection for the codigoLibro field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdusuario());
                prestamoLibro.setIdUsuario(idUsuarioNew);
            }
            if (codigoLibroNew != null) {
                codigoLibroNew = em.getReference(codigoLibroNew.getClass(), codigoLibroNew.getCodigoLibro());
                prestamoLibro.setCodigoLibro(codigoLibroNew);
            }
            prestamoLibro = em.merge(prestamoLibro);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.setPrestamoLibro(null);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.setPrestamoLibro(prestamoLibro);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            if (codigoLibroOld != null && !codigoLibroOld.equals(codigoLibroNew)) {
                codigoLibroOld.setPrestamoLibro(null);
                codigoLibroOld = em.merge(codigoLibroOld);
            }
            if (codigoLibroNew != null && !codigoLibroNew.equals(codigoLibroOld)) {
                codigoLibroNew.setPrestamoLibro(prestamoLibro);
                codigoLibroNew = em.merge(codigoLibroNew);
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
                Integer id = prestamoLibro.getIdPrestamo();
                if (findPrestamoLibro(id) == null) {
                    throw new NonexistentEntityException("The prestamoLibro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PrestamoLibro prestamoLibro;
            try {
                prestamoLibro = em.getReference(PrestamoLibro.class, id);
                prestamoLibro.getIdPrestamo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestamoLibro with id " + id + " no longer exists.", enfe);
            }
            Usuarios idUsuario = prestamoLibro.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.setPrestamoLibro(null);
                idUsuario = em.merge(idUsuario);
            }
            Libros codigoLibro = prestamoLibro.getCodigoLibro();
            if (codigoLibro != null) {
                codigoLibro.setPrestamoLibro(null);
                codigoLibro = em.merge(codigoLibro);
            }
            em.remove(prestamoLibro);
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

    public List<PrestamoLibro> findPrestamoLibroEntities() {
        return findPrestamoLibroEntities(true, -1, -1);
    }

    public List<PrestamoLibro> findPrestamoLibroEntities(int maxResults, int firstResult) {
        return findPrestamoLibroEntities(false, maxResults, firstResult);
    }

    private List<PrestamoLibro> findPrestamoLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PrestamoLibro.class));
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

    public PrestamoLibro findPrestamoLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PrestamoLibro.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestamoLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PrestamoLibro> rt = cq.from(PrestamoLibro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
