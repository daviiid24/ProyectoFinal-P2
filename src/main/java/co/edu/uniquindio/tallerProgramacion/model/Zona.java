package co.edu.uniquindio.tallerProgramacion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Zona implements IEntidad {
    private String idZona;
    private String nombre;
    private int capacidad;
    private double precioBase;
    private List<Asiento> asientos;

    public Zona(String nombre, int capacidad, double precioBase) {
        this.idZona = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.asientos = new ArrayList<>();
    }

    @Override
    public String getId() {
        return idZona;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public List<Asiento> getAsientos() { return asientos; }
    public void setAsientos(List<Asiento> asientos) { this.asientos = asientos; }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    // RF-030: consultar ocupación por zona

    public int obtenerOcupacion() {

        int ocupacion = 0;

        for (Asiento a : asientos) {

            if (a.getEstado() == EstadoAsiento.VENDIDO ||
                    a.getEstado() == EstadoAsiento.RESERVADO) {

                ocupacion++;
            }
        }

        return ocupacion;
    }

    // RF-028 Eliminar zona

    public void eliminarZona() {

        this.nombre = null;
        this.capacidad = 0;
        this.precioBase = 0;
        this.asientos.clear();
    }
}