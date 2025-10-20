package Interfaces;

import Entity.PedidoDetalle;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IPedidoDetalleServicio {
    
    void crear(PedidoDetalle detalle) throws Exception;
    
    PedidoDetalle buscarPorId(Long id);
    
    List<PedidoDetalle> listar();
    
    void actualizar(PedidoDetalle detalle) throws Exception;
    
    void eliminar(Long id);
}