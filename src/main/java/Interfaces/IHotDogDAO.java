package Interfaces;

import Entity.HotDog;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IHotDogDAO {
    
    void crear(HotDog hotdog);
    
    HotDog buscarPorId(Long id);
    
    List<HotDog> listar(int limit);
    
    void actualizar(HotDog hotdog);
    
    void eliminar(Long id);
    
}