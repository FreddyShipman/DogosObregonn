package Entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author fred
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long num_cliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDateTime fechaNacimiento;
    
    @Transient
    private Integer edad;
    
    @ElementCollection
    @CollectionTable(name = "cliente_telefonos", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;
    
    @ElementCollection
    @CollectionTable(name = "cliente_preferencias", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "preferencia")
    private Set<String> preferencias;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;
    
    @ManyToOne
    @JoinColumn(name = "recomendador_id")
    private Cliente recomendadoPor;
    
    @OneToMany(mappedBy = "recomendadoPor")
    private Set<Cliente> clientesRecomendados;

    public Cliente() {
    }

    public Cliente(Long num_cliente, String nombre, String apellidoPaterno, String apellidoMaterno, LocalDateTime fechaNacimiento, Integer edad, Set<String> telefonos, Set<String> preferencias, Set<Pedido> pedidos, Cliente recomendadoPor, Set<Cliente> clientesRecomendados) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.telefonos = telefonos;
        this.preferencias = preferencias;
        this.pedidos = pedidos;
        this.recomendadoPor = recomendadoPor;
        this.clientesRecomendados = clientesRecomendados;
    }

    public Long getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(Long num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    public Set<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<String> preferencias) {
        this.preferencias = preferencias;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente getRecomendadoPor() {
        return recomendadoPor;
    }

    public void setRecomendadoPor(Cliente recomendadoPor) {
        this.recomendadoPor = recomendadoPor;
    }

    public Set<Cliente> getClientesRecomendados() {
        return clientesRecomendados;
    }

    public void setClientesRecomendados(Set<Cliente> clientesRecomendados) {
        this.clientesRecomendados = clientesRecomendados;
    }
    
    
}
