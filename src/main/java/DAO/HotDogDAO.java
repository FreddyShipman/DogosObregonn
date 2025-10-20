package DAO;

import Config.JpaUtil;
import Entity.HotDog;
import Interfaces.IHotDogDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author alfre
 */


public class HotDogDAO implements IHotDogDAO {

    private EntityManager getEntityManager() {
        return JpaUtil.getInstance().getEntityManager();
    }

    @Override
    public void crear(HotDog hotdog) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hotdog);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); // Manejo de excepcion
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public HotDog buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HotDog.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<HotDog> listar(int limit) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT h FROM HotDog h";
            TypedQuery<HotDog> query = em.createQuery(jpql, HotDog.class);
            
            // Aplicamos el limite
            if (limit > 0) {
                query.setMaxResults(limit);
            }
            
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizar(HotDog hotdog) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(hotdog);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            
            HotDog hotdog = em.find(HotDog.class, id);
            if (hotdog != null) {
                em.remove(hotdog);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}