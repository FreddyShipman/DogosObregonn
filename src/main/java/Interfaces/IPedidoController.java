package Interfaces;

import Entity.Pedido;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoController {
    
    boolean crear(Pedido pedido);
    
    Pedido buscarPorId(Long id);
    
    List<Pedido> listar();
    
    boolean actualizar(Pedido pedido);
    
    void eliminar(Long id);
}