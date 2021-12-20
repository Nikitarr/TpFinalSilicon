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
import logica.Servicio_turistico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Mariano
 */
public class Servicio_turisticoJpaController implements Serializable {

    public Servicio_turisticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Servicio_turisticoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("tp_final_silicon_PU");
    }
    
    public void create(Servicio_turistico servicio_turistico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(servicio_turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio_turistico servicio_turistico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            servicio_turistico = em.merge(servicio_turistico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicio_turistico.getCodigo_servicio();
                if (findServicio_turistico(id) == null) {
                    throw new NonexistentEntityException("The servicio_turistico with id " + id + " no longer exists.");
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
            Servicio_turistico servicio_turistico;
            try {
                servicio_turistico = em.getReference(Servicio_turistico.class, id);
                servicio_turistico.getCodigo_servicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio_turistico with id " + id + " no longer exists.", enfe);
            }
            em.remove(servicio_turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio_turistico> findServicio_turisticoEntities() {
        return findServicio_turisticoEntities(true, -1, -1);
    }

    public List<Servicio_turistico> findServicio_turisticoEntities(int maxResults, int firstResult) {
        return findServicio_turisticoEntities(false, maxResults, firstResult);
    }

    private List<Servicio_turistico> findServicio_turisticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio_turistico.class));
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

    public Servicio_turistico findServicio_turistico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio_turistico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicio_turisticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio_turistico> rt = cq.from(Servicio_turistico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
