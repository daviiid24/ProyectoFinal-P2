package co.edu.uniquindio.tallerProgramacion.model;



public interface PaymentGateway {
    boolean pagar(Compra compra, double monto);
}
