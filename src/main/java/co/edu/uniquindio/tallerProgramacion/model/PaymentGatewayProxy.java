package co.edu.uniquindio.tallerProgramacion.model;



public class PaymentGatewayProxy implements PaymentGateway {
    private final PaymentGateway real;
    private boolean usuarioAutorizado;

    public PaymentGatewayProxy(PaymentGateway real) {
        this.real = real;
        this.usuarioAutorizado = true;
    }

    @Override
    public boolean pagar(Compra compra, double monto) {
        // RF-007/RF-008: envoltura con verificación simple y logging
        if (!usuarioAutorizado) {
            System.out.println("Acceso no autorizado al gateway de pagos.");
            return false;
        }
        System.out.println("Proxy: procesando pago..."); // logging
        boolean ok = real.pagar(compra, monto);
        if (ok) {
            compra.setEstadoCompra(EstadoCompra.PAGADA);
        }
        return ok;
    }
}
