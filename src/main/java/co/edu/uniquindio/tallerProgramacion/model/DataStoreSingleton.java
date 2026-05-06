package co.edu.uniquindio.tallerProgramacion.model;



import java.util.HashMap;
import java.util.Map;

public class DataStoreSingleton {
    private static volatile DataStoreSingleton instance;

    private Map<String, Usuario> usuarios;
    private Map<String, Evento> eventos;
    private Map<String, Recinto> recintos;
    private Map<String, Compra> compras;

    private DataStoreSingleton() {
        usuarios = new HashMap<>();
        eventos = new HashMap<>();
        recintos = new HashMap<>();
        compras = new HashMap<>();
    }

    // RF-020 / RF-012 / RF-016: Singleton
    public static DataStoreSingleton getInstance() {
        if (instance == null) {
            synchronized (DataStoreSingleton.class) {
                if (instance == null) {
                    instance = new DataStoreSingleton();
                }
            }
        }
        return instance;
    }

    // Getters para repositorio en memoria
    public Map<String, Usuario> getUsuarios() { return usuarios; }
    public Map<String, Evento> getEventos() { return eventos; }
    public Map<String, Recinto> getRecintos() { return recintos; }
    public Map<String, Compra> getCompras() { return compras; }

    // Utilidades simples
    public void clearAll() {
        usuarios.clear();
        eventos.clear();
        recintos.clear();
        compras.clear();
    }
}