package co.edu.uniquindio.tallerProgramacion.model;

public class MerchandisingDecorator extends DecoratorBase {
    public MerchandisingDecorator(ServicioAdicional servicio) {
        super(servicio);
    }

    @Override
    public double obtenerCosto() {
        return super.obtenerCosto() + 20.0;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Merchandising";
    }
}