package dogosobregonjpa.dogosobregon;

import Controllers.ClienteController;
import Controllers.HotDogController;
import Controllers.PedidoController;
import Controllers.PedidoDetalleController;
import Entity.Cliente;
import Entity.HotDog;
import Entity.MetodoPago;
import Entity.Pedido;
import Entity.PedidoDetalle;
import Interfaces.IClienteController;
import Interfaces.IHotDogController;
import Interfaces.IPedidoController;
import Interfaces.IPedidoDetalleController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author alfre
 */

public class DogosObregon {

    public static void main(String[] args) {
        
        IHotDogController hotdogController = new HotDogController();
        IClienteController clienteController = new ClienteController();
        IPedidoController pedidoController = new PedidoController();
        IPedidoDetalleController detalleController = new PedidoDetalleController();

        System.out.println("--- 1. CREANDO HOTDOGS ---");
        
        HotDog hotdog1 = new HotDog();
        hotdog1.setNombre("Clasico");
        hotdog1.setPrecio(new BigDecimal("50.00"));
        hotdog1.setIva(new BigDecimal("8.00"));
        hotdogController.crear(hotdog1);

        HotDog hotdog2 = new HotDog();
        hotdog2.setNombre("Especial");
        hotdog2.setPrecio(new BigDecimal("65.00"));
        hotdog2.setIva(new BigDecimal("10.40"));
        hotdogController.crear(hotdog2);

        HotDog hotdog3 = new HotDog();
        hotdog3.setNombre("Jumbo");
        hotdog3.setPrecio(new BigDecimal("70.00"));
        hotdog3.setIva(new BigDecimal("11.20"));
        hotdogController.crear(hotdog3);

        System.out.println("\n--- 2. CREANDO CLIENTES ---");

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan");
        cliente1.setApPaterno("Perez");
        cliente1.setApMaterno("Lopez");
        cliente1.setFchNac(LocalDate.of(1990, 5, 15));
        
        Set<String> telefonos1 = new HashSet<>();
        telefonos1.add("644-111-1111");
        cliente1.setTelefonos(telefonos1);
        
        Set<String> prefs1 = new HashSet<>();
        prefs1.add("Sin cebolla");
        prefs1.add("Con extra queso");
        cliente1.setPreferencias(prefs1);
        clienteController.crear(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Ana");
        cliente2.setApPaterno("Garcia");
        cliente2.setApMaterno("Martinez");
        cliente2.setFchNac(LocalDate.of(1995, 10, 20));
        cliente2.setClienteRecomienda(cliente1);
        clienteController.crear(cliente2);
        
        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Carlos");
        cliente3.setApPaterno("Sanchez");
        cliente3.setFchNac(LocalDate.of(1985, 3, 30));
        clienteController.crear(cliente3);
        
        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Maria");
        cliente4.setApPaterno("Rodriguez");
        cliente4.setFchNac(LocalDate.of(2000, 7, 22));
        clienteController.crear(cliente4);
        
        Cliente cliente5 = new Cliente();
        cliente5.setNombre("Luis");
        cliente5.setApPaterno("Hernandez");
        cliente5.setFchNac(LocalDate.of(1998, 11, 12));
        clienteController.crear(cliente5);

        System.out.println("\n--- 3. CREANDO PEDIDOS Y DETALLES ---");
        
        Pedido pedido1 = new Pedido();
        pedido1.setCliente(cliente1);
        pedido1.setFecha(LocalDateTime.now().minusDays(2));
        pedido1.setMetodoPago(MetodoPago.TARJETA);
        pedidoController.crear(pedido1);
        
        PedidoDetalle d1p1 = new PedidoDetalle();
        d1p1.setPedido(pedido1);
        d1p1.setHotdog(hotdog1);
        d1p1.setCantidad(2);
        detalleController.crear(d1p1);
        
        PedidoDetalle d2p1 = new PedidoDetalle();
        d2p1.setPedido(pedido1);
        d2p1.setHotdog(hotdog2);
        d2p1.setCantidad(1);
        detalleController.crear(d2p1);
        
        Pedido pedido2 = new Pedido();
        pedido2.setCliente(cliente2);
        pedido2.setFecha(LocalDateTime.now().minusDays(1));
        pedido2.setMetodoPago(MetodoPago.EFECTIVO);
        pedidoController.crear(pedido2);

        PedidoDetalle d1p2 = new PedidoDetalle();
        d1p2.setPedido(pedido2);
        d1p2.setHotdog(hotdog3);
        d1p2.setCantidad(3);
        detalleController.crear(d1p2);
        
        Pedido pedido3 = new Pedido();
        pedido3.setCliente(cliente1);
        pedido3.setFecha(LocalDateTime.now());
        pedido3.setMetodoPago(MetodoPago.TRANSFERENCIA);
        pedidoController.crear(pedido3);

        PedidoDetalle d1p3 = new PedidoDetalle();
        d1p3.setPedido(pedido3);
        d1p3.setHotdog(hotdog1);
        d1p3.setCantidad(1);
        detalleController.crear(d1p3);

        System.out.println("\n--- 4. PRUEBAS DE LISTADO ---");
        
        System.out.println("LISTA DE HOTDOGS:");
        List<HotDog> hotdogs = hotdogController.listar();
        for (HotDog h : hotdogs) {
            System.out.println("ID: " + h.getId() + ", Nombre: " + h.getNombre() + ", Precio: " + h.getPrecio());
        }

        System.out.println("\nLISTA DE CLIENTES:");
        List<Cliente> clientes = clienteController.listar();
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + " " + c.getApPaterno());
            if (c.getClienteRecomienda() != null) {
                System.out.println("  Recomendado por: " + c.getClienteRecomienda().getNombre());
            }
        }
        
        System.out.println("\nLISTA DE PEDIDOS:");
        List<Pedido> pedidos = pedidoController.listar();
        for (Pedido p : pedidos) {
            System.out.println("ID: " + p.getId() + ", Cliente: " + p.getCliente().getNombre() + ", Fecha: " + p.getFecha() + ", Pago: " + p.getMetodoPago());
        }

        System.out.println("\nLISTA DE DETALLES:");
        List<PedidoDetalle> detalles = detalleController.listar();
        for (PedidoDetalle d : detalles) {
            System.out.println("ID: " + d.getId() + ", PedidoID: " + d.getPedido().getId() + ", Hotdog: " + d.getHotdog().getNombre() + ", Cant: " + d.getCantidad() + ", Subtotal: " + d.getSubtotal());
        }

        System.out.println("\n--- 5. PRUEBA DE ACTUALIZACION (UPDATE) ---");
        System.out.println("Precio ANTES: " + hotdog1.getPrecio());
        hotdog1.setPrecio(new BigDecimal("52.00"));
        hotdogController.actualizar(hotdog1);
        HotDog hotdogActualizado = hotdogController.buscarPorId(hotdog1.getId());
        System.out.println("Precio DESPUES: " + hotdogActualizado.getPrecio());

        System.out.println("\n--- 6. PRUEBA DE ELIMINACION (DELETE) ---");
        System.out.println("Eliminando Pedido 2 y sus detalles (Cascade)");
        pedidoController.eliminar(pedido2.getId());
        
        if (pedidoController.buscarPorId(pedido2.getId()) == null) {
            System.out.println("Pedido 2 eliminado con exito.");
        }
        if (detalleController.buscarPorId(d1p2.getId()) == null) {
            System.out.println("Detalle de Pedido 2 eliminado por cascada.");
        }
    }
}