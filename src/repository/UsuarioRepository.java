package repository;

import model.Usuario;
import java.util.*;
import java.io.*;

// Clase encargada de guardar y cargar usuarios desde un archivo
public class UsuarioRepository {
    private final String archivo = "data/usuarios.txt"; // Ruta del archivo de datos

    // Método para cargar usuarios desde el archivo
    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Lee cada línea del archivo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String email = partes[2];
                    int edad = Integer.parseInt(partes[3]);
                    usuarios.add(new Usuario(id, nombre, email, edad));
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, lo crea vacío
            guardarUsuarios(usuarios);
        }
        return usuarios;
    }

    // Método para guardar la lista de usuarios en el archivo
    public void guardarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Usuario u : usuarios) {
                // Escribe cada usuario en una línea, separado por comas
                bw.write(u.getId() + "," + u.getNombre() + "," + u.getEmail() + "," + u.getEdad());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
}