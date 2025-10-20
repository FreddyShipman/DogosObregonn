package DAO;

import Config.JpaUtil;
import Entity.Pedido;
import Interfaces.IPedidoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoDAO implements IPedidoDAO {

    private EntityManager getEntityManager() {
        return JpaUtil.getInstance().getEntityManager();
    }
    
    @Override
    public void crear(Pedido pedido) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
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
    public Pedido buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Pedido> listar(int limit) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT p FROM Pedido p";
            TypedQuery<Pedido> query = em.createQuery(jpql, Pedido.class);
            
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
    public void actualizar(Pedido pedido) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pedido);
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
            
            Pedido pedido = em.find(Pedido.class, id);
            if (pedido != null) {
                em.remove(pedido);
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