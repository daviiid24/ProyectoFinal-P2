package co.edu.uniquindio.tallerProgramacion.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recinto implements IEntidad {
    private String idRecinto;
    private String nombre;
    private String direccion;
    private String ciudad;
    private List<Zona> zonas;

    public Recinto(String nombre, String direccion, String ciudad) {
        this.idRecinto = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.zonas = new ArrayList<>();
    }

    @Override
    public String getId() {
        return idRecinto;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public List<Zona> getZonas() { return zonas; }
    public void setZonas(List<Zona> zonas) { this.zonas = zonas; }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

// RF-026 Eliminar recinto

    public void eliminarRecinto() {

        this.nombre = null;
        this.direccion = null;
        this.ciudad = null;
        this.zonas.clear();
    }

    // RF-027 Eliminar zona asociada al recinto

    public void eliminarZona(String idZona) {

        zonas.removeIf(z -> z.getId().equals(idZona));
    }

}
