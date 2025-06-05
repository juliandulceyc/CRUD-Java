package service;

import model.Usuario;
import repository.UsuarioRepository;
import java.util.*;

// Clase que contiene la lógica de negocio para gestionar usuarios
public class UsuarioService {
    private List<Usuario> usuarios;           // Lista de usuarios en memoria
    private UsuarioRepository repo;           // Repositorio para persistencia

    // Constructor: carga los usuarios desde el archivo al iniciar
    public UsuarioService() {
        repo = new UsuarioRepository();
        usuarios = repo.cargarUsuarios();
    }

    // Devuelve la lista de usuarios
    public List<Usuario> listar() {
        return usuarios;
    }

    // Crea un nuevo usuario y lo guarda
    public void crear(String nombre, String email, int edad) {
        int id = usuarios.isEmpty() ? 1 : usuarios.get(usuarios.size() - 1).getId() + 1;
        usuarios.add(new Usuario(id, nombre, email, edad));
        repo.guardarUsuarios(usuarios);
    }

    // Busca un usuario por su ID
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // Actualiza los datos de un usuario existente
    public boolean actualizar(int id, String nombre, String email, int edad) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            u.setNombre(nombre);
            u.setEmail(email);
            u.setEdad(edad);
            repo.guardarUsuarios(usuarios);
            return true;
        }
        return false;
    }

    // Elimina un usuario por su ID
    public boolean eliminar(int id) {
        Usuario u = buscarPorId(id);
        if (u != null) {
            usuarios.remove(u);
            repo.guardarUsuarios(usuarios);
            return true;
        }
        return false;
    }
}