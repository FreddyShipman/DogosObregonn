package Interfaces;

import Entity.Pedido;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoServicio {
    void crear(Pedido pedido) throws Exception;
    
    Pedido buscarPorId(Long id);
    
    List<Pedido> listar();
    
    void actualizar(Pedido pedido) throws Exception;
    
    void eliminar(Long id);
}
