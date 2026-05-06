package co.edu.uniquindio.tallerProgramacion.model;



import java.time.LocalDateTime;

public class Incidencia implements IEntidad {
    private String idIncidencia;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha;
    private String entidadAfectada; // id de Evento/Compra/Usuario

    public Incidencia(String tipo, String descripcion, String entidadAfectada) {
        this.idIncidencia = java.util.UUID.randomUUID().toString();
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.entidadAfectada = entidadAfectada;
    }

    @Override
    public String getId() {
        return idIncidencia;
    }

    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public LocalDateTime getFecha() { return fecha; }
    public String getEntidadAfectada() { return entidadAfectada; }

    @Override
    public String toString() {
        return "Incidencia{" + idIncidencia + ", tipo=" + tipo + ", fecha=" + fecha + ", entidad=" + entidadAfectada + '}';
    }
}