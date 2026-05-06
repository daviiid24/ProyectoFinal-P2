package co.edu.uniquindio.tallerProgramacion.model;



public class ParqueaderoDecorator extends DecoratorBase {
    public ParqueaderoDecorator(ServicioAdicional servicio) {
        super(servicio);
    }

    @Override
    public double obtenerCosto() {
        return super.obtenerCosto() + 15.0;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Parqueadero";
    }
}