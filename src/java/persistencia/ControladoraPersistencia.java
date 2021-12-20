package persistencia;

import java.util.List;
import logica.Usuario;
import java.util.logging.Logger;
import java.util.logging.Level;
import logica.Cliente;
import logica.Paquete_turistico;
import logica.Servicio_turistico;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    Servicio_turisticoJpaController serviciosJPA = new Servicio_turisticoJpaController();
    Paquete_turisticoJpaController paqueteJPA = new Paquete_turisticoJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    UsuarioJpaController userJPA = new UsuarioJpaController();

    
    
    //<---------------------Usuarios Empleados------------------>
    
    public void salvarUsuario(Usuario usu) {

        try {
            userJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarUsuario(Usuario usu) {

        try {
            userJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuario traerUsuario(int idUser) {
        Usuario U = null;
        try {
            U = userJPA.findUsuario(idUser);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return U;
    }

    public List<Usuario> traerUsuarios() {
        List<Usuario> U = null;
        try {
            U = userJPA.findUsuarioEntities();
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return U;
    }

    public void borrarUsuario(int idUser) {

        try {
            userJPA.destroy(idUser);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //<----------------------Clientes------------------------->

    public List<Cliente> traerClietes() {
        List<Cliente> C = null;
        try {
            C = clienteJPA.findClienteEntities() ;
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
        
        public void salvarCliente(Cliente cliente1) {

        try {
            clienteJPA.create(cliente1);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
    public void borrarCliente(int idCliente) {

        try {
            clienteJPA.destroy(idCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
    public void modificarCliente(Cliente cliente1) {

        try {
            clienteJPA.edit(cliente1);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Cliente traerCliente(int idCliente) {
      Cliente C = null;
        try {
            C = clienteJPA.findCliente(idCliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }

//===============================SERVICIOS
    
        public List<Servicio_turistico> traerServicios() {
        List<Servicio_turistico> ST = null;
        try {
            ST = serviciosJPA.findServicio_turisticoEntities() ;
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ST;
    }
        
        public void salvarServicio(Servicio_turistico serv) {

        try {
            serviciosJPA.create(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
    public void borrarServicio(int idServ) {

        try {
            serviciosJPA.destroy(idServ);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
    public void modificarServicio(Servicio_turistico serv) {

        try {
            serviciosJPA.edit(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Servicio_turistico traerServicio(int idServ) {
      Servicio_turistico ST = null;
        try {
            ST = serviciosJPA.findServicio_turistico(idServ);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ST;
    }

    //====================Paquetes
       
    public List<Paquete_turistico> traerPaquetes() {
        List<Paquete_turistico> P = null;
        try {
            P = paqueteJPA.findPaquete_turisticoEntities() ;
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
    }
        
        public void salvarPaquete(Paquete_turistico paq) {

        try {
            paqueteJPA.create(paq);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
    public void borrarPaquete(int idPaq) {

        try {
            paqueteJPA.destroy(idPaq);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
    public void modificarPaquete(Paquete_turistico paq) {

        try {
            paqueteJPA.edit(paq);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Paquete_turistico traerPaquete(int idPaq) {
      Paquete_turistico P = null;
        try {
            P = paqueteJPA.findPaquete_turistico(idPaq);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
    }
    
    //<----------------------Ventas------------------------->

    public List<Venta> traerVentas() {
        List<Venta> v = null;
        try {
            v = ventaJPA.findVentaEntities() ;
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
        
        public void salvarVenta(Venta venta) {

        try {
            ventaJPA.create(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
           
    public void borrarVenta(int idVenta) {

        try {
            ventaJPA.destroy(idVenta);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
    public void modificarVenta(Venta venta) {

        try {
            ventaJPA.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Venta traerVenta (int idVenta) {
      Venta v = null;
        try {
            v = ventaJPA.findVenta(idVenta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    
}
