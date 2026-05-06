package co.edu.uniquindio.tallerProgramacion.model;



public class EntradaImprimibleDecorator extends EntradaImprimible {
    protected Imprimible decorado;

    public EntradaImprimibleDecorator(Imprimible decorado) {
        super(null);
        this.decorado = decorado;
    }

    @Override
    public String imprimir() {
        String base = decorado != null ? decorado.imprimir() : "";
        return base;
    }
}
