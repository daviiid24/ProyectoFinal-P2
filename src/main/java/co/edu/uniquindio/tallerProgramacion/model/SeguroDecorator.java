package co.edu.uniquindio.tallerProgramacion.model;



public class SeguroDecorator extends DecoratorBase {
    public SeguroDecorator(ServicioAdicional servicio) {
        super(servicio);
    }

    @Override
    public double obtenerCosto() {
        return super.obtenerCosto() + 10.0;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Seguro";
    }
}
