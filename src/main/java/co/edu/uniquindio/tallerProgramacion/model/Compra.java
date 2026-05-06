package co.edu.uniquindio.tallerProgramacion.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra implements IEntidad {

    private String idCompra;
    private Usuario usuarioAsociado;
    private Evento eventoAsociado;
    private LocalDateTime fechaCreacion;
    private double total;
    private EstadoCompra estadoCompra;
    private List<Entrada> entradas;
    private List<ServicioAdicional> serviciosAdicionales;

    // Constructor privado para obligar uso del Builder
    private Compra() {
        this.idCompra = java.util.UUID.randomUUID().toString();
        this.fechaCreacion = LocalDateTime.now();
        this.estadoCompra = EstadoCompra.CREADA;
        this.entradas = new ArrayList<>();
        this.serviciosAdicionales = new ArrayList<>();
        this.total = 0.0;
    }


    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Evento getEventoAsociado() {
        return eventoAsociado;
    }

    public void setEventoAsociado(Evento eventoAsociado) {
        this.eventoAsociado = eventoAsociado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public EstadoCompra getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(EstadoCompra estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    @Override
    public String getId() {
        return idCompra;
    }

    // =========================
    // MÉTODOS DE LA COMPRA
    // =========================

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void agregarServicio(ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }

    public void cancelarCompra() {
        this.estadoCompra = EstadoCompra.CANCELADA;
    }

    public void calcularTotal() {

        double t = 0.0;

        for (Entrada e : entradas) {
            t += e.getPrecioFinal();
        }

        for (ServicioAdicional s : serviciosAdicionales) {
            t += s.obtenerCosto();
        }

        this.total = t;
    }

    public String detalleCompra() {

        return "Compra: " + idCompra +
                ", Usuario: " + usuarioAsociado.getId() +
                ", Evento: " + eventoAsociado.getNombre() +
                ", Total: " + total +
                ", Estado: " + estadoCompra;
    }



    // =========================
    // BUILDER INTERNO
    // =========================

    public static class Builder {

        private Compra compra;

        public Builder() {
            compra = new Compra();
        }

        // RF-034 Crear compras nuevas
        public Builder conUsuarioEvento(Usuario usuario, Evento evento) {

            compra.usuarioAsociado = usuario;
            compra.eventoAsociado = evento;

            return this;
        }

        public Builder agregarEntrada(Entrada entrada) {

            compra.agregarEntrada(entrada);
            return this;
        }

        // RF-035 Modificar compra
        public Builder agregarServicio(ServicioAdicional servicio) {

            compra.agregarServicio(servicio);
            return this;
        }

        public Compra build() {

            compra.calcularTotal();
            return compra;
        }
    }

    // RF-035 Eliminar entrada de la compra

    public void eliminarEntrada(Entrada entrada) {

        if (estadoCompra == EstadoCompra.CREADA) {
            entradas.remove(entrada);
            calcularTotal();
        }
    }

    // RF-035 Cambiar entrada de la compra

    public void cambiarEntrada(Entrada entradaAnterior, Entrada nuevaEntrada) {

        if (estadoCompra == EstadoCompra.CREADA) {

            entradas.remove(entradaAnterior);
            entradas.add(nuevaEntrada);

            calcularTotal();
        }
    }


    // RF-035 Eliminar servicio adicional

    public void eliminarServicio(ServicioAdicional servicio) {

        if (estadoCompra == EstadoCompra.CREADA) {

            serviciosAdicionales.remove(servicio);

            calcularTotal();
        }
    }

    // RF-036 Cancelar compra según políticas

    public boolean cancelarCompraSegunPoliticas() {

        if (estadoCompra == EstadoCompra.CONFIRMADA) {
            return false;
        }

        if (eventoAsociado.getFechaHora().isBefore(LocalDateTime.now())) {
            return false;
        }

        this.estadoCompra = EstadoCompra.CANCELADA;

        return true;
    }

}