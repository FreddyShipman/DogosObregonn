package Controllers;

import Entity.Pedido;
import Interfaces.IPedidoController;
import Interfaces.IPedidoServicio;
import Servicios.PedidoServicio;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoController implements IPedidoController {

    private IPedidoServicio pedidoService;

    public PedidoController() {
        this.pedidoService = new PedidoServicio();
    }

    @Override
    public boolean crear(Pedido pedido) {
        try {
            this.pedidoService.crear(pedido);
            System.out.println("Pedido creado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear Pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Pedido buscarPorId(Long id) {
        return this.pedidoService.buscarPorId(id);
    }

    @Override
    public List<Pedido> listar() {
        return this.pedidoService.listar();
    }

    @Override
    public boolean actualizar(Pedido pedido) {
        try {
            this.pedidoService.actualizar(pedido);
            System.out.println("Pedido actualizado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar Pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void eliminar(Long id) {
        this.pedidoService.eliminar(id);
        System.out.println("Pedido eliminado.");
    }
}