package co.edu.uniquindio.tallerProgramacion.model;


import java.time.LocalDateTime;

public class EventoFactory {
    // RF-023: Factory para crear eventos de forma estandarizada
    public static Evento crearEvento(String id, String nombre, Categoria categoria, String descripcion,
                                     String ciudad, LocalDateTime fechaHora, Recinto recinto) {
        Evento e = new Evento(id, nombre, categoria, descripcion, ciudad, fechaHora, recinto);
        e.setEstado(EstadoEvento.BORRADOR);
        return e;
    }
}
