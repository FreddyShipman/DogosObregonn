package Servicios;

import DAO.ClienteDAO;
import Entity.Cliente;
import Interfaces.IClienteDAO;
import Interfaces.IClienteServicio;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alfre
 */
public class ClienteServicio implements IClienteServicio {

    private IClienteDAO clienteDAO;

    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    private void validar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del cliente es obligatorio");
        }
        if (cliente.getApPaterno() == null || cliente.getApPaterno().trim().isEmpty()) {
            throw new Exception("El apellido paterno es obligatorio");
        }
        if (cliente.getFchNac() == null) {
            throw new Exception("La fecha de nacimiento es obligatoria");
        }
        if (cliente.getFchNac().isAfter(LocalDate.now())) {
            throw new Exception("La fecha de nacimiento no puede ser futura");
        }
    }

    @Override
    public void crear(Cliente cliente) throws Exception {
        validar(cliente);
        
        if (cliente.getClienteRecomienda() != null) {
            Cliente clienteRecomienda = this.clienteDAO.buscarPorId(cliente.getClienteRecomienda().getId());
            if (clienteRecomienda == null) {
                throw new Exception("El cliente que recomienda no existe");
            }
        }
        
        this.clienteDAO.crear(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return this.clienteDAO.buscarPorId(id);
    }

    @Override
    public List<Cliente> listar() {
        int limiteMaximo = 100;
        return this.clienteDAO.listar(limiteMaximo);
    }

    @Override
    public void actualizar(Cliente cliente) throws Exception {
        validar(cliente);
        
        Cliente clienteExistente = this.clienteDAO.buscarPorId(cliente.getId());
        if (clienteExistente == null) {
            throw new Exception("No se encontro el cliente a actualizar");
        }
        
        if (cliente.getClienteRecomienda() != null) {
            Cliente clienteRecomienda = this.clienteDAO.buscarPorId(cliente.getClienteRecomienda().getId());
            if (clienteRecomienda == null) {
                throw new Exception("El cliente que recomienda no existe");
            }
        }
        
        this.clienteDAO.actualizar(cliente);
    }

    @Override
    public void eliminar(Long id) {
        this.clienteDAO.eliminar(id);
    }
}