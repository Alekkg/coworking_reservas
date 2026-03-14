package persistencia;

import java.util.List;
import logica.claseReserva;

public class controladoraPersistencia {

    claseReservaJpaController usuJpa = new claseReservaJpaController();

    //Create
    public void crearReserva(claseReserva res) {
        usuJpa.create(res);
    }

    //Read
    public List<claseReserva> traerReserva() {
        return usuJpa.findclaseReservaEntities();
    }
    //Delete
    public void eliminarReserva(int id) {
        try {
            usuJpa.destroy(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
