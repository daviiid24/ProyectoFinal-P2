package co.edu.uniquindio.tallerProgramacion.model;


public class EntradaImprimible implements Imprimible {
    protected Entrada entrada;

    public EntradaImprimible(Entrada entrada) {
        this.entrada = entrada;
    }

    @Override
    public String imprimir() {
        return "Entrada: " + (entrada != null ? entrada.getId() : "N/A") +
                " | Zona: " + (entrada != null && entrada.getZona() != null ? entrada.getZona().getNombre() : "N/A") +
                " | Precio: " + (entrada != null ? entrada.getPrecioFinal() : 0.0);
    }
}
