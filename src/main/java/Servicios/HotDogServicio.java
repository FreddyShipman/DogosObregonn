package Servicios;

import DAO.HotDogDAO;
import Entity.HotDog;
import Interfaces.IHotDogDAO;
import Interfaces.IHotDogServicio;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alfre
 */
public class HotDogServicio implements IHotDogServicio {

    private IHotDogDAO hotdogDAO;

    public HotDogServicio() {
        this.hotdogDAO = new HotDogDAO();
    }

    private void validar(HotDog hotdog) throws Exception {
        if (hotdog == null) {
            throw new Exception("El hotdog no puede ser nulo");
        }
        if (hotdog.getNombre() == null || hotdog.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del hotdog es obligatorio");
        }
        if (hotdog.getPrecio() == null || hotdog.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("El precio debe ser mayor a 0");
        }
    }

    @Override
    public void crear(HotDog hotdog) throws Exception {
        validar(hotdog);
        this.hotdogDAO.crear(hotdog);
    }

    @Override
    public HotDog buscarPorId(Long id) {
        return this.hotdogDAO.buscarPorId(id);
    }

    @Override
    public List<HotDog> listar() {
        int limiteMaximo = 100;
        return this.hotdogDAO.listar(limiteMaximo);
    }

    @Override
    public void actualizar(HotDog hotdog) throws Exception {
        validar(hotdog);
        HotDog hotdogExistente = this.hotdogDAO.buscarPorId(hotdog.getId());
        if (hotdogExistente == null) {
            throw new Exception("No se encontro el hotdog a actualizar");
        }
        
        this.hotdogDAO.actualizar(hotdog);
    }

    @Override
    public void eliminar(Long id) {
        this.hotdogDAO.eliminar(id);
    }
}