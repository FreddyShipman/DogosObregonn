package Entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
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
    private Long id;

    @Column(name="nombre")
    private String nombre;
    @Column(name="ap_Paterno")
    private String apPaterno;
    @Column(name="ap_Materno")
    private String apMaterno;
    @Column(name="fch_nac")
    private LocalDate fchNac;
    
    @OneToOne
    @JoinColumn(name="cliente_recomienda_id",referencedColumnName = "id")
    private Cliente clienteRecomienda;
    
    @ElementCollection
    @CollectionTable(name="Cliente_Telefonos",joinColumns = @JoinColumn(name="cliente_id"))
    @Column(name="Telefono")
    private Set<String> telefonos;
    
    @ElementCollection
    @CollectionTable(name="Cliente_Preferencias",joinColumns = @JoinColumn(name="cliente_id"))
    @Column(name="Preferencia")
    private Set<String> preferencias;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apPaterno, String apMaterno, LocalDate fchNac, Cliente clienteRecomienda, Set<String> telefonos, Set<String> preferencias, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fchNac = fchNac;
        this.clienteRecomienda = clienteRecomienda;
        this.telefonos = telefonos;
        this.preferencias = preferencias;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public LocalDate getFchNac() {
        return fchNac;
    }

    public void setFchNac(LocalDate fchNac) {
        this.fchNac = fchNac;
    }

    public Cliente getClienteRecomienda() {
        return clienteRecomienda;
    }

    public void setClienteRecomienda(Cliente clienteRecomienda) {
        this.clienteRecomienda = clienteRecomienda;
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
}
