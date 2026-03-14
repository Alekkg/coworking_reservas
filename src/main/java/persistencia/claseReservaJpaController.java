/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.claseReserva;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Alejandra
 */
public class claseReservaJpaController implements Serializable {

    public claseReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public claseReservaJpaController(){
        emf=Persistence.createEntityManagerFactory("reservascoworkinggPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseReserva claseReserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseReserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseReserva claseReserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseReserva = em.merge(claseReserva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseReserva.getId();
                if (findclaseReserva(id) == null) {
                    throw new NonexistentEntityException("The claseReserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseReserva claseReserva;
            try {
                claseReserva = em.getReference(claseReserva.class, id);
                claseReserva.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseReserva with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseReserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseReserva> findclaseReservaEntities() {
        return findclaseReservaEntities(true, -1, -1);
    }

    public List<claseReserva> findclaseReservaEntities(int maxResults, int firstResult) {
        return findclaseReservaEntities(false, maxResults, firstResult);
    }

    private List<claseReserva> findclaseReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseReserva.class));
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

    public claseReserva findclaseReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseReserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseReserva> rt = cq.from(claseReserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
