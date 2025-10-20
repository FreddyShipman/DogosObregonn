package Controllers;

import Entity.PedidoDetalle;
import Interfaces.IPedidoDetalleController;
import Interfaces.IPedidoDetalleServicio;
import Servicios.PedidoDetalleServicio;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoDetalleController implements IPedidoDetalleController {

    private IPedidoDetalleServicio detalleService;

    public PedidoDetalleController() {
        this.detalleService = new PedidoDetalleServicio();
    }

    @Override
    public boolean crear(PedidoDetalle detalle) {
        try {
            this.detalleService.crear(detalle);
            System.out.println("Detalle de pedido creado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear Detalle de Pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public PedidoDetalle buscarPorId(Long id) {
        return this.detalleService.buscarPorId(id);
    }

    @Override
    public List<PedidoDetalle> listar() {
        return this.detalleService.listar();
    }

    @Override
    public boolean actualizar(PedidoDetalle detalle) {
        try {
            this.detalleService.actualizar(detalle);
            System.out.println("Detalle de pedido actualizado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar Detalle de Pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void eliminar(Long id) {
        this.detalleService.eliminar(id);
        System.out.println("Detalle de pedido eliminado.");
    }
}