package co.edu.uniquindio.tallerProgramacion.model;


import java.time.LocalDateTime;
import java.util.List;

public interface IEventoService {
    // RF-023 Crear, actualizar, eliminar y consultar eventos
    void crearEvento(Evento evento);

    void actualizarEvento(Evento evento);

    void eliminarEvento(String idEvento);

    List<Evento> consultarEventos();

    // RF-024 Publicar/pausar/cancelar eventos
    void publicarEvento(String idEvento);

    void pausarEvento(String idEvento);

    void cancelarEvento(String idEvento);

    // RF-025 Consultar disponibilidad
    List<Asiento> consultarDisponibilidad(String idEvento, String idZona);
    List<Zona> consultarZonasConDisponibilidad(String idEvento);
}
