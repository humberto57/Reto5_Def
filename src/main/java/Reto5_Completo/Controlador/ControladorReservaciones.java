package Reto5_Completo.Controlador;

import Reto5_Completo.Modelo.Reservaciones;
import Reto5_Completo.Repositorio.ContadorClientes;
import Reto5_Completo.Repositorio.StatusReservas;
import Reto5_Completo.Servicio.ServiciosReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservaciones {
    @Autowired
    private ServiciosReservaciones servicio;
    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicio.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return servicio.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return servicio.reporteClientesServicios();
    }
}

