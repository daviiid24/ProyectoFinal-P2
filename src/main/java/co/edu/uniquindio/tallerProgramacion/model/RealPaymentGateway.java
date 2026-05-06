package co.edu.uniquindio.tallerProgramacion.model;



public class RealPaymentGateway implements PaymentGateway {
    @Override
    public boolean pagar(Compra compra, double monto) {
        // Simulación de pago exitoso
        compra.setTotal(monto);
        compra.setEstadoCompra(EstadoCompra.PAGADA);
        return true;
    }
}
