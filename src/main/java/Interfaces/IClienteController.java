package Interfaces;

import Entity.Cliente;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IClienteController {
    
    boolean crear(Cliente cliente);
    
    Cliente buscarPorId(Long id);
    
    List<Cliente> listar();
    
    boolean actualizar(Cliente cliente);
    
    void eliminar(Long id);
}