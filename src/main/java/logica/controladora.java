    package logica;

import java.util.List;
import persistencia.controladoraPersistencia;


public class controladora {
    controladoraPersistencia controlPersis = new controladoraPersistencia();
    
    public void crearReserva (claseReserva res){
        controlPersis.crearReserva(res);
    }
    
    public List<claseReserva> traerReserva(){
        return controlPersis.traerReserva();
    }  

    public void eliminarReserva(int id) {
    controlPersis.eliminarReserva(id);    }
}
