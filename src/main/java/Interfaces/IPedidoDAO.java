package Interfaces;

import Entity.Pedido;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoDAO {
    
    void crear(Pedido pedido);
    
    Pedido buscarPorId(Long id);
    
    List<Pedido> listar(int limit);
    
    void actualizar(Pedido pedido);
    
    void eliminar(Long id);
}