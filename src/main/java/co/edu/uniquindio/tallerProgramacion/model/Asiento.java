package co.edu.uniquindio.tallerProgramacion.model;


import java.util.UUID;

public class Asiento implements IEntidad {
    private String idAsiento;
    private String fila;
    private int numero;
    private EstadoAsiento estado;

    public Asiento(String fila, int numero) {
        this.idAsiento = UUID.randomUUID().toString();
        this.fila = fila;
        this.numero = numero;
        this.estado = EstadoAsiento.DISPONIBLE;
    }

    @Override
    public String getId() {
        return idAsiento;
    }

    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public EstadoAsiento getEstado() { return estado; }
    public void setEstado(EstadoAsiento estado) { this.estado = estado; }

    // RF-031 Eliminar asiento

    public void eliminarAsiento() {

        this.fila = null;
        this.numero = 0;
        this.estado = null;
    }
}
