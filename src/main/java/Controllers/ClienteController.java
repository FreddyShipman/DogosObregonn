package Controllers;

import Entity.Cliente;
import Interfaces.IClienteController;
import Interfaces.IClienteServicio;
import Servicios.ClienteServicio;
import java.util.List;

/**
 *
 * @author alfre
 */
public class ClienteController implements IClienteController {

    private IClienteServicio clienteService;

    public ClienteController() {
        this.clienteService = new ClienteServicio();
    }

    @Override
    public boolean crear(Cliente cliente) {
        try {
            this.clienteService.crear(cliente);
            System.out.println("Cliente creado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear Cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return this.clienteService.buscarPorId(id);
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteService.listar();
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        try {
            this.clienteService.actualizar(cliente);
            System.out.println("Cliente actualizado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar Cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void eliminar(Long id) {
        this.clienteService.eliminar(id);
        System.out.println("Cliente eliminado.");
    }
}