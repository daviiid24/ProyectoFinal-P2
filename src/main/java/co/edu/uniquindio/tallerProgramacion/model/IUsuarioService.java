package co.edu.uniquindio.tallerProgramacion.model;



public interface IUsuarioService {
    // RF-020 Registrarse, iniciar sesión y modificar datos del perfil
    void registrarUsuario(Usuario usuario);

    boolean iniciarSesion(String correo, String password);

    void modificarPerfil(String idUsuario, String nombre, String correo, String telefono);

    // RF-021 Gestionar métodos de pago simulados
    void agregarMetodoPagoSimulado(String idUsuario, String metodoPago);

}
