package DAO;

import Config.JpaUtil;
import Entity.PedidoDetalle;
import Interfaces.IPedidoDetalleDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoDetalleDAO implements IPedidoDetalleDAO {

    private EntityManager getEntityManager() {
        return JpaUtil.getInstance().getEntityManager();
    }
    
    @Override
    public void crear(PedidoDetalle detalle) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(detalle);
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
    public PedidoDetalle buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PedidoDetalle.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<PedidoDetalle> listar(int limit) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT d FROM PedidoDetalle d";
            TypedQuery<PedidoDetalle> query = em.createQuery(jpql, PedidoDetalle.class);
            
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
    public void actualizar(PedidoDetalle detalle) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(detalle);
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
            
            PedidoDetalle detalle = em.find(PedidoDetalle.class, id);
            if (detalle != null) {
                em.remove(detalle);
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