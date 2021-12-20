package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Paquete_turistico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private int codigo_paquete;
    
    @Basic
    private String nombre; 
    
    @ManyToMany
    private List<Servicio_turistico> servicio;
    
    public Paquete_turistico() {
    }

    public Paquete_turistico(int codigo_paquete, String nombre, List<Servicio_turistico> servicio) {
        this.codigo_paquete = codigo_paquete;
        this.nombre = nombre;
        this.servicio = servicio;
    }

    public Paquete_turistico(String nombre, List<Servicio_turistico> servicio) {
        this.nombre = nombre;
        this.servicio = servicio;
    }

    public Paquete_turistico(int codigo_servicio, String nombre) {
        this.codigo_paquete = codigo_paquete;
        this.nombre = nombre;
    }
    
    public List<Servicio_turistico> getServicio() {
        return servicio;
    }

    public void setServicio(List<Servicio_turistico> servicio) {
        this.servicio = servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }
    
    public double getCosto_paquete() {
     
        double costo =0.0;
        for ( Servicio_turistico ser : servicio){
            costo +=  ser.getCosto_servicio();
        }
        
        costo = costo *0.9;
        
        return costo;
    }

    
}
