package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Paquete_turistico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:42:39")
@StaticMetamodel(Servicio_turistico.class)
public class Servicio_turistico_ { 

    public static volatile SingularAttribute<Servicio_turistico, Date> fecha_servicio;
    public static volatile SingularAttribute<Servicio_turistico, Double> costo_servicio;
    public static volatile SingularAttribute<Servicio_turistico, Integer> codigo_servicio;
    public static volatile SingularAttribute<Servicio_turistico, String> nombre;
    public static volatile SingularAttribute<Servicio_turistico, String> descripcion_breve;
    public static volatile SingularAttribute<Servicio_turistico, String> destino_servicio;
    public static volatile ListAttribute<Servicio_turistico, Paquete_turistico> paquete;

}