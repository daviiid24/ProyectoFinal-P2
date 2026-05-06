package co.edu.uniquindio.tallerProgramacion.model;



public class VIPDecorator extends DecoratorBase {
    public VIPDecorator(ServicioAdicional servicio) {
        super(servicio);
    }

    @Override
    public double obtenerCosto() {
        return super.obtenerCosto() + 50.0; // costo adicional VIP
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + VIP";
    }
}
