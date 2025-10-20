package Interfaces;

import Entity.PedidoDetalle;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoDetalleController {
    
    boolean crear(PedidoDetalle detalle);
    
    PedidoDetalle buscarPorId(Long id);
    
    List<PedidoDetalle> listar();
    
    boolean actualizar(PedidoDetalle detalle);
    
    void eliminar(Long id);
}