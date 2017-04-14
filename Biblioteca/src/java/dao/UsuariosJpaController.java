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
import entidades.PrestamoLibro;
import entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Gangster
 */
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            PrestamoLibro prestamoLibro = usuarios.getPrestamoLibro();
            if (prestamoLibro != null) {
                prestamoLibro = em.getReference(prestamoLibro.getClass(), prestamoLibro.getIdPrestamo());
                usuarios.setPrestamoLibro(prestamoLibro);
            }
            em.persist(usuarios);
            if (prestamoLibro != null) {
                Usuarios oldIdUsuarioOfPrestamoLibro = prestamoLibro.getIdUsuario();
                if (oldIdUsuarioOfPrestamoLibro != null) {
                    oldIdUsuarioOfPrestamoLibro.setPrestamoLibro(null);
                    oldIdUsuarioOfPrestamoLibro = em.merge(oldIdUsuarioOfPrestamoLibro);
                }
                prestamoLibro.setIdUsuario(usuarios);
                prestamoLibro = em.merge(prestamoLibro);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUsuarios(usuarios.getIdusuario()) != null) {
                throw new PreexistingEntityException("Usuarios " + usuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getIdusuario());
            PrestamoLibro prestamoLibroOld = persistentUsuarios.getPrestamoLibro();
            PrestamoLibro prestamoLibroNew = usuarios.getPrestamoLibro();
            List<String> illegalOrphanMessages = null;
            if (prestamoLibroOld != null && !prestamoLibroOld.equals(prestamoLibroNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain PrestamoLibro " + prestamoLibroOld + " since its idUsuario field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (prestamoLibroNew != null) {
                prestamoLibroNew = em.getReference(prestamoLibroNew.getClass(), prestamoLibroNew.getIdPrestamo());
                usuarios.setPrestamoLibro(prestamoLibroNew);
            }
            usuarios = em.merge(usuarios);
            if (prestamoLibroNew != null && !prestamoLibroNew.equals(prestamoLibroOld)) {
                Usuarios oldIdUsuarioOfPrestamoLibro = prestamoLibroNew.getIdUsuario();
                if (oldIdUsuarioOfPrestamoLibro != null) {
                    oldIdUsuarioOfPrestamoLibro.setPrestamoLibro(null);
                    oldIdUsuarioOfPrestamoLibro = em.merge(oldIdUsuarioOfPrestamoLibro);
                }
                prestamoLibroNew.setIdUsuario(usuarios);
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
                Integer id = usuarios.getIdusuario();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
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
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getIdusuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            PrestamoLibro prestamoLibroOrphanCheck = usuarios.getPrestamoLibro();
            if (prestamoLibroOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the PrestamoLibro " + prestamoLibroOrphanCheck + " in its prestamoLibro field has a non-nullable idUsuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarios);
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

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
