package co.edu.uniquindio.tallerProgramacion.model;



public abstract class DecoratorBase implements ServicioAdicional {
    protected ServicioAdicional servicio;

    public DecoratorBase(ServicioAdicional servicio) {
        this.servicio = servicio;
    }

    @Override
    public double obtenerCosto() {
        return servicio != null ? servicio.obtenerCosto() : 0.0;
    }

    @Override
    public String obtenerDescripcion() {
        return servicio != null ? servicio.obtenerDescripcion() : "";
    }
}
