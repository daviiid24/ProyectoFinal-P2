package co.edu.uniquindio.tallerProgramacion.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario implements IEntidad {
    private String idUsuario;
    private String nombreCompleto;
    private String correoElectronico;
    private String telefono;
    private List<String> metodosPagoSimulados;
    private List<Compra> compras;


    // RF-020
    public Usuario(String nombreCompleto, String correoElectronico, String telefono) {
        this.idUsuario = UUID.randomUUID().toString();
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.metodosPagoSimulados = new ArrayList<>();
        this.compras = new ArrayList<>();
    }


    // RF-020
    @Override
    public String getId() {
        return idUsuario;
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getMetodosPagoSimulados() {
        return metodosPagoSimulados;
    }

    public List<Compra> getCompras() {
        return compras;
    }




// FR 07
    public void pagarCompra(Compra compra) {
        compra.setEstadoCompra(EstadoCompra.PAGADA);
    }

    // RF 08

    public EstadoCompra consultarEstadoCompra(String idCompra) {

        for (Compra c : compras) {

            if (c.getIdCompra().equals(idCompra)) {
                return c.getEstadoCompra();
            }
        }

        return null;
    }

    // RF 09

    public void agregarServicioCompra(Compra compra, ServicioAdicional servicio) {
        compra.agregarServicio(servicio);
    }

    // RF-021: gestionar métodos de pago simulados
    public void agregarMetodoPagoSimulado(String metodoPago) {
        if (metodosPagoSimulados == null) metodosPagoSimulados = new ArrayList<>();
        metodosPagoSimulados.add(metodoPago);
    }

    // RF 10

    public List<Compra> filtrarComprasPorFecha(LocalDateTime fecha) {

        List<Compra> resultado = new ArrayList<>();

        for (Compra c : compras) {

            if (c.getFechaCreacion().toLocalDate().equals(fecha.toLocalDate())) {
                resultado.add(c);
            }
        }

        return resultado;
    }

    public List<Compra> filtrarComprasPorEvento(String nombreEvento) {

        List<Compra> resultado = new ArrayList<>();

        for (Compra c : compras) {

            if (c.getEventoAsociado().getNombre().equalsIgnoreCase(nombreEvento)) {
                resultado.add(c);
            }
        }

        return resultado;
    }

    public List<Compra> filtrarComprasPorEstado(EstadoCompra estado) {

        List<Compra> resultado = new ArrayList<>();

        for (Compra c : compras) {

            if (c.getEstadoCompra() == estado) {
                resultado.add(c);
            }
        }

        return resultado;
    }


    // RF-022: consultar compras asociadas
    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }



    // RF-082 (utilidad): para ver detalles de compras
    public Compra consultarDetalleCompra(String idCompra) {
        for (Compra c : compras) {
            if (c.getIdCompra().equals(idCompra)) return c;
        }
        return null;
    }

    // RF-020
    public boolean iniciarSesion(String correo) {
        // En un ejemplo real se verificaría credenciales.
        return this.correoElectronico != null && this.correoElectronico.equals(correo);
    }

    // RF-020: editar perfil
    public void modificarPerfil(String nombre, String correo, String telefono) {
        this.nombreCompleto = nombre != null ? nombre : this.nombreCompleto;
        this.correoElectronico = correo != null ? correo : this.correoElectronico;
        this.telefono = telefono != null ? telefono : this.telefono;
    }

}