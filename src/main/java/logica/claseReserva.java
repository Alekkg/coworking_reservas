package logica;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class claseReserva implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int id;
    private String nombre_usuario;
    private String fecha_reserva;
    private String espacio_trabajo;
    private String duracion;
    //Constructor
    public claseReserva(){
    }
    
    public claseReserva(int id, String nombre_usuario, String fecha_reserva, String espacio_trabajo, String duracion) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.fecha_reserva = fecha_reserva;
        this.espacio_trabajo = espacio_trabajo;
        this.duracion = duracion;
    }
    //Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fechae_reserva) {
        this.fecha_reserva = fechae_reserva;
    }

    public String getEspacio_trabajo() {
        return espacio_trabajo;
    }

    public void setEspacio_trabajo(String espacio_trabajo) {
        this.espacio_trabajo = espacio_trabajo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
