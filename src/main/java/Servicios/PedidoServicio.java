package Servicios;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import Entity.Cliente;
import Entity.Pedido;
import Interfaces.IClienteDAO;
import Interfaces.IPedidoDAO;
import Interfaces.IPedidoServicio;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author alfre
 */
public class PedidoServicio implements IPedidoServicio {

    private IPedidoDAO pedidoDAO;
    private IClienteDAO clienteDAO;

    public PedidoServicio() {
        this.pedidoDAO = new PedidoDAO();
        this.clienteDAO = new ClienteDAO();
    }

    private void validar(Pedido pedido) throws Exception {
        if (pedido == null) {
            throw new Exception("El pedido no puede ser nulo");
        }
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new Exception("El cliente del pedido es obligatorio");
        }
        if (pedido.getFecha() == null) {
            throw new Exception("La fecha del pedido es obligatoria");
        }
        if (pedido.getFecha().isAfter(LocalDateTime.now())) {
            throw new Exception("La fecha del pedido no puede ser futura");
        }
        if (pedido.getMetodoPago() == null) {
            throw new Exception("El metodo de pago es obligatorio");
        }
    }

    @Override
    public void crear(Pedido pedido) throws Exception {
        validar(pedido);
        
        Cliente cliente = this.clienteDAO.buscarPorId(pedido.getCliente().getId());
        if (cliente == null) {
            throw new Exception("El cliente asociado al pedido no existe");
        }
        pedido.setCliente(cliente);
        
        this.pedidoDAO.crear(pedido);
    }

    @Override
    public Pedido buscarPorId(Long id) {
        return this.pedidoDAO.buscarPorId(id);
    }

    @Override
    public List<Pedido> listar() {
        int limiteMaximo = 100;
        return this.pedidoDAO.listar(limiteMaximo);
    }

    @Override
    public void actualizar(Pedido pedido) throws Exception {
        validar(pedido);
        
        Pedido pedidoExistente = this.pedidoDAO.buscarPorId(pedido.getId());
        if (pedidoExistente == null) {
            throw new Exception("No se encontro el pedido a actualizar");
        }
        
        Cliente cliente = this.clienteDAO.buscarPorId(pedido.getCliente().getId());
        if (cliente == null) {
            throw new Exception("El cliente asociado al pedido no existe");
        }
        pedido.setCliente(cliente);
        
        this.pedidoDAO.actualizar(pedido);
    }

    @Override
    public void eliminar(Long id) {
        this.pedidoDAO.eliminar(id);
    }
}