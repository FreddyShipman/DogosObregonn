package Interfaces;

import Entity.Cliente;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IClienteServicio {
    
    void crear(Cliente cliente) throws Exception;
    
    Cliente buscarPorId(Long id);
    
    List<Cliente> listar();
    
    void actualizar(Cliente cliente) throws Exception;
    
    void eliminar(Long id);
}