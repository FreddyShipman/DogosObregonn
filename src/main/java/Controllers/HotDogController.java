package Controllers;

import Entity.HotDog;
import Interfaces.IHotDogController;
import Interfaces.IHotDogServicio;
import Servicios.HotDogServicio;
import java.util.List;

/**
 *
 * @author alfre
 */
public class HotDogController implements IHotDogController {

    private IHotDogServicio hotDogService;

    public HotDogController() {
        this.hotDogService = new HotDogServicio();
    }

    @Override
    public boolean crear(HotDog hotdog) {
        try {
            this.hotDogService.crear(hotdog);
            System.out.println("HotDog creado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear HotDog: " + e.getMessage());
            return false;
        }
    }

    @Override
    public HotDog buscarPorId(Long id) {
        return this.hotDogService.buscarPorId(id);
    }

    @Override
    public List<HotDog> listar() {
        return this.hotDogService.listar();
    }

    @Override
    public boolean actualizar(HotDog hotdog) {
        try {
            this.hotDogService.actualizar(hotdog);
            System.out.println("HotDog actualizado con exito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar HotDog: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void eliminar(Long id) {
        this.hotDogService.eliminar(id);
        System.out.println("HotDog eliminado.");
    }
}