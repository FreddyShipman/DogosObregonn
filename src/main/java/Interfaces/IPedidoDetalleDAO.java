package Interfaces;

import Entity.PedidoDetalle;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoDetalleDAO {
    
    void crear(PedidoDetalle detalle);
    
    PedidoDetalle buscarPorId(Long id);
    
    List<PedidoDetalle> listar(int limit);
    
    void actualizar(PedidoDetalle detalle);
    
    void eliminar(Long id);
}