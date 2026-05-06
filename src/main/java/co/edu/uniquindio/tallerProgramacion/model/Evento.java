package co.edu.uniquindio.tallerProgramacion.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements IEntidad {
    private String idEvento;
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private String ciudad;
    private LocalDateTime fechaHora;
    private EstadoEvento estado;
    private String politicas;
    private Recinto recinto;
    private List<Zona> zonas;

    public Evento(String idEvento, String nombre, Categoria categoria, String descripcion, String ciudad,
                  LocalDateTime fechaHora, Recinto recinto) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.fechaHora = fechaHora;
        this.recinto = recinto;
        this.estado = EstadoEvento.BORRADOR;
        this.zonas = new ArrayList<>();
    }


    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String getId() {
        return idEvento;
    }

    // RF-023, RF-024, RF-025: getters/setters básicos
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public EstadoEvento getEstado() { return estado; }
    public void setEstado(EstadoEvento estado) { this.estado = estado; }

    public String getPoliticas() { return politicas; }
    public void setPoliticas(String politicas) { this.politicas = politicas; }

    public Recinto getRecinto() { return recinto; }
    public void setRecinto(Recinto recinto) { this.recinto = recinto; }

    public List<Zona> getZonas() { return zonas; }
    public void setZonas(List<Zona> zonas) { this.zonas = zonas; }

    public void añadirZona(Zona zona) {
        if (zonas == null) zonas = new ArrayList<>();
        zonas.add(zona);
    }

    // RF-025 Consultar zonas disponibles

    public List<Zona> consultarZonasDisponibles() {

        List<Zona> zonasDisponibles = new ArrayList<>();

        for (Zona z : zonas) {

            if (z.obtenerOcupacion() < z.getCapacidad()) {
                zonasDisponibles.add(z);
            }
        }

        return zonasDisponibles;
    }

    // RF-025 Consultar asientos disponibles

    public List<Asiento> consultarAsientosDisponibles() {

        List<Asiento> asientosDisponibles = new ArrayList<>();

        for (Zona z : zonas) {

            for (Asiento a : z.getAsientos()) {

                if (a.getEstado() == EstadoAsiento.DISPONIBLE) {
                    asientosDisponibles.add(a);
                }
            }
        }

        return asientosDisponibles;
    }

}