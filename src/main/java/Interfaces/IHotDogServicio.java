package Interfaces;

import Entity.HotDog;
import java.util.List;

/**
 *
 * @author alfre
 */
public interface IHotDogServicio {
    void crear(HotDog hotdog) throws Exception;
    
    HotDog buscarPorId(Long id);
    
    List<HotDog> listar();
    
    void actualizar(HotDog hotdog) throws Exception;
    
    void eliminar(Long id);
}