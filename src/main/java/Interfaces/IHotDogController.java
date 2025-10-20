package Interfaces;

import Entity.HotDog;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IHotDogController {
    boolean crear(HotDog hotdog);
    
    HotDog buscarPorId(Long id);
    
    List<HotDog> listar();
    
    boolean actualizar(HotDog hotdog);
    
    void eliminar(Long id);
}