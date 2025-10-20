package Servicios;

import DAO.HotDogDAO;
import DAO.PedidoDAO;
import DAO.PedidoDetalleDAO;
import Entity.HotDog;
import Entity.Pedido;
import Entity.PedidoDetalle;
import Interfaces.IHotDogDAO;
import Interfaces.IPedidoDAO;
import Interfaces.IPedidoDetalleDAO;
import Interfaces.IPedidoDetalleServicio;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoDetalleServicio implements IPedidoDetalleServicio {

    private IPedidoDetalleDAO detalleDAO;
    private IPedidoDAO pedidoDAO;
    private IHotDogDAO hotdogDAO;

    public PedidoDetalleServicio() {
        this.detalleDAO = new PedidoDetalleDAO();
        this.pedidoDAO = new PedidoDAO();
        this.hotdogDAO = new HotDogDAO();
    }

    private void validarYCalcular(PedidoDetalle detalle) throws Exception {
        if (detalle == null) {
            throw new Exception("El detalle no puede ser nulo");
        }
        if (detalle.getPedido() == null || detalle.getPedido().getId() == null) {
            throw new Exception("El pedido es obligatorio");
        }
        if (detalle.getHotdog() == null || detalle.getHotdog().getId() == null) {
            throw new Exception("El hotdog es obligatorio");
        }
        if (detalle.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        
        Pedido pedido = this.pedidoDAO.buscarPorId(detalle.getPedido().getId());
        if (pedido == null) {
            throw new Exception("El pedido asociado no existe");
        }
        detalle.setPedido(pedido);

        HotDog hotdog = this.hotdogDAO.buscarPorId(detalle.getHotdog().getId());
        if (hotdog == null) {
            throw new Exception("El hotdog asociado no existe");
        }
        detalle.setHotdog(hotdog);
        
        if (detalle.getPrecioVenta() == null || detalle.getPrecioVenta().compareTo(BigDecimal.ZERO) <= 0) {
            detalle.setPrecioVenta(hotdog.getPrecio());
        }
        
        BigDecimal cantidad = new BigDecimal(detalle.getCantidad());
        BigDecimal subtotal = detalle.getPrecioVenta().multiply(cantidad);
        detalle.setSubtotal(subtotal);
    }

    @Override
    public void crear(PedidoDetalle detalle) throws Exception {
        validarYCalcular(detalle);
        this.detalleDAO.crear(detalle);
    }

    @Override
    public PedidoDetalle buscarPorId(Long id) {
        return this.detalleDAO.buscarPorId(id);
    }

    @Override
    public List<PedidoDetalle> listar() {
        int limiteMaximo = 100;
        return this.detalleDAO.listar(limiteMaximo);
    }

    @Override
    public void actualizar(PedidoDetalle detalle) throws Exception {
        validarYCalcular(detalle);
        
        PedidoDetalle detalleExistente = this.detalleDAO.buscarPorId(detalle.getId());
        if (detalleExistente == null) {
            throw new Exception("No se encontro el detalle a actualizar");
        }
        
        this.detalleDAO.actualizar(detalle);
    }

    @Override
    public void eliminar(Long id) {
        this.detalleDAO.eliminar(id);
    }
}