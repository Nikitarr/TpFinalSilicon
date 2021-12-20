package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
          
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

 //======================USUARIOS EMPLEADOS   
    public void salvarUsuario(Usuario usu){
        controlPersis.salvarUsuario(usu);
    }

    public void modificarUsuario(Usuario usu){
        controlPersis.modificarUsuario(usu);
    }

    public Usuario traerUsuario(int idUser){
        return controlPersis.traerUsuario(idUser);
    }

    public List<Usuario> traerUsuarios(){
        return controlPersis.traerUsuarios();
    }

   
    public void borrarUsuario (int idUser){
        controlPersis.borrarUsuario(idUser);
    }
    
 //===================CLIENTES
    public List<Cliente> traerClientes(){
        return controlPersis.traerClietes();
    }
    
   public void salvarCliente (Cliente cliente1){
        controlPersis.salvarCliente(cliente1);
    }

    public void modificarCliente(Cliente cliente1){
        controlPersis.modificarCliente(cliente1);
    }

    
    public void borrarCliente (int idCliente){
        controlPersis.borrarCliente(idCliente);
    }
    
    public Cliente traerCliente(int idCliente){
        return controlPersis.traerCliente(idCliente);
    }
    
//======================SERVICIOS
    public List<Servicio_turistico> traerServicios(){
        return controlPersis.traerServicios();
    }
    
   public void salvarServicio (Servicio_turistico serv){
        controlPersis.salvarServicio(serv);
    }

    public void modificarServicio(Servicio_turistico serv){
        controlPersis.modificarServicio(serv);
    }

    
    public void borrarServicio (int idServ){
        controlPersis.borrarServicio(idServ);
    }
    
    public Servicio_turistico traerServicio(int idServ){
        return controlPersis.traerServicio(idServ);
    }

//=======================LOGIN
    public boolean verificarUsuario(String user, String contra){
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();   
        
        if (listaUsuarios != null){
            for(Usuario usu: listaUsuarios){
                if (usu.getUsername().equals(user)&& usu.getContrasenia().equals(contra))
               {
                return true;
                }  
            }
        }
        return false;
    }
    
    

 //===========================PAQUETES
     public List<Paquete_turistico> traerPaquetes(){
        return controlPersis.traerPaquetes();
    }
    
   public void salvarPaquete (Paquete_turistico paq){
        controlPersis.salvarPaquete(paq);
    }

    public void modificarPaquete(Paquete_turistico paq){
        controlPersis.modificarPaquete(paq);
    }

    
    public void borrarPaquete (int idPaq){
        controlPersis.borrarPaquete(idPaq);
    }
    
    public Paquete_turistico traerPaquete(int idPaq){
        return controlPersis.traerPaquete(idPaq);
    }
    
    //===================VENTAS
    public List<Venta> traerVentas(){
        return controlPersis.traerVentas();
    }
    
   public void salvarVenta (Venta venta){
        controlPersis.salvarVenta(venta);
    }

    public void modificarVenta(Venta venta){
        controlPersis.modificarVenta(venta);
    }

    
    public void borrarVenta (int idVenta){
        controlPersis.borrarVenta(idVenta);
    }
    
    public Venta traerVenta(int idVenta){
        return controlPersis.traerVenta(idVenta);
    }
    
}
