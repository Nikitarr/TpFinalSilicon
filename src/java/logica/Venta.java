
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int num_venta;
    @Basic
    private String modo_pago;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    
    @ManyToMany
    private List<Paquete_turistico> paquete;
    
    @ManyToMany
    private List<Servicio_turistico> servicio;
    
    @ManyToOne(targetEntity=Cliente.class)
    Cliente cliente = new Cliente();
    
    @ManyToOne(targetEntity=Usuario.class)
    Usuario usu1 = new Usuario();


    public Venta() {
    }

    public Venta(int num_venta, String modo_pago, Date fecha_venta, List<Paquete_turistico> paquete, List<Servicio_turistico> servicio, Cliente cliente, Usuario usu1) {
        this.num_venta = num_venta;
        this.modo_pago = modo_pago;
        this.fecha_venta = fecha_venta;
        this.paquete = paquete;
        this.servicio = servicio;
        this.cliente = cliente;
        this.usu1 = usu1;
    
    }
    public Venta(String modo_pago, Date fecha_venta, List<Paquete_turistico> paquete, List<Servicio_turistico> servicio, Cliente cliente, Usuario usu1) {
        this.modo_pago = modo_pago;
        this.fecha_venta = fecha_venta;
        this.paquete = paquete;
        this.servicio = servicio;
        this.cliente = cliente;
        this.usu1 = usu1;
    }

    public Venta(int id, String modoPago, Date fecha_venta, Cliente cliente, Usuario empleado) {
        this.num_venta = num_venta;
        this.modo_pago = modo_pago;
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.usu1 = usu1;
    
    }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public String getModo_pago() {
        return modo_pago;
    }

    public void setModo_pago(String modo_pago) {
        this.modo_pago = modo_pago;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public List<Paquete_turistico> getPaquete() {
        return paquete;
    }

    public void setPaquete(List<Paquete_turistico> paquete) {
        this.paquete = paquete;
    }

    public List<Servicio_turistico> getServicio() {
        return servicio;
    }

    public void setServicio(List<Servicio_turistico> servicio) {
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsu1() {
        return usu1;
    }

    public void setUsu1(Usuario usu1) {
        this.usu1 = usu1;
    }

    
    
}
