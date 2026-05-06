package co.edu.uniquindio.tallerProgramacion.model;



public class AccesoPreferencialDecorator extends DecoratorBase {
    public AccesoPreferencialDecorator(ServicioAdicional servicio) {
        super(servicio);
    }

    @Override
    public double obtenerCosto() {
        return super.obtenerCosto() + 25.0;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Acceso Preferencial";
    }
}
