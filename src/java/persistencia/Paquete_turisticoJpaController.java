/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import logica.Paquete_turistico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Mariano
 */
public class Paquete_turisticoJpaController implements Serializable {

    public Paquete_turisticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public Paquete_turisticoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("tp_final_silicon_PU");
    }

    public void create(Paquete_turistico paquete_turistico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paquete_turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete_turistico paquete_turistico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            paquete_turistico = em.merge(paquete_turistico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete_turistico.getCodigo_paquete();
                if (findPaquete_turistico(id) == null) {
                    throw new NonexistentEntityException("The paquete_turistico with id " + id + " no longer exists.");
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
            Paquete_turistico paquete_turistico;
            try {
                paquete_turistico = em.getReference(Paquete_turistico.class, id);
                paquete_turistico.getCodigo_paquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete_turistico with id " + id + " no longer exists.", enfe);
            }
            em.remove(paquete_turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete_turistico> findPaquete_turisticoEntities() {
        return findPaquete_turisticoEntities(true, -1, -1);
    }

    public List<Paquete_turistico> findPaquete_turisticoEntities(int maxResults, int firstResult) {
        return findPaquete_turisticoEntities(false, maxResults, firstResult);
    }

    private List<Paquete_turistico> findPaquete_turisticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete_turistico.class));
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

    public Paquete_turistico findPaquete_turistico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete_turistico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaquete_turisticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete_turistico> rt = cq.from(Paquete_turistico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
