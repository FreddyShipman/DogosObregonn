package Interfaces;

import Entity.Cliente;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IClienteDAO {
    
    void crear(Cliente cliente);

    Cliente buscarPorId(Long id);

    List<Cliente> listar(int limit);

    void actualizar(Cliente cliente);

    void eliminar(Long id);
    
}