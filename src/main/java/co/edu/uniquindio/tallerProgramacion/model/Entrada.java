package co.edu.uniquindio.tallerProgramacion.model;


public class Entrada implements IEntidad {
    private String idEntrada;
    private Zona zona;
    private Asiento asiento;
    private double precioFinal;
    private EstadoEntrada estado;

    public Entrada(Zona zona, Asiento asiento, double precioFinal) {
        this.idEntrada = java.util.UUID.randomUUID().toString();
        this.zona = zona;
        this.asiento = asiento;
        this.precioFinal = precioFinal;
        this.estado = EstadoEntrada.ACTIVA;
    }

    @Override
    public String getId() {
        return idEntrada;
    }

    public Zona getZona() { return zona; }
    public void setZona(Zona zona) { this.zona = zona; }

    public Asiento getAsiento() { return asiento; }
    public void setAsiento(Asiento asiento) { this.asiento = asiento; }

    public double getPrecioFinal() { return precioFinal; }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

    public EstadoEntrada getEstado() { return estado; }
    public void setEstado(EstadoEntrada estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Entrada{" + idEntrada + ", zona=" + (zona != null ? zona.getNombre() : "N/A") + ", precio=" + precioFinal + ", estado=" + estado + '}';
    }
}
