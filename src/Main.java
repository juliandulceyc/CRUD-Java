import service.UsuarioService;
import model.Usuario;
import java.util.Scanner;
import java.util.List;

// Clase principal que muestra el menú y gestiona la interacción con el usuario
public class Main {
    public static void main(String[] args) {
        UsuarioService servicio = new UsuarioService(); // Servicio para gestionar usuarios
        Scanner sc = new Scanner(System.in);            // Para leer la entrada del usuario
        int opcion;                                     // Opción elegida en el menú

        do {
            // Muestra el menú principal
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    // Crear usuario
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    servicio.crear(nombre, email, edad);
                    System.out.println("Usuario creado.");
                    break;
                case 2:
                    // Listar usuarios
                    List<Usuario> usuarios = servicio.listar();
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios.");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }
                    break;
                case 3:
                    // Actualizar usuario
                    System.out.print("ID del usuario a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    Usuario uAct = servicio.buscarPorId(idAct);
                    if (uAct != null) {
                        System.out.print("Nuevo nombre: ");
                        String nNombre = sc.nextLine();
                        System.out.print("Nuevo email: ");
                        String nEmail = sc.nextLine();
                        System.out.print("Nueva edad: ");
                        int nEdad = sc.nextInt();
                        sc.nextLine();
                        servicio.actualizar(idAct, nNombre, nEmail, nEdad);
                        System.out.println("Usuario actualizado.");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    // Eliminar usuario
                    System.out.print("ID del usuario a eliminar: ");
                    int idElim = sc.nextInt();
                    sc.nextLine();
                    if (servicio.eliminar(idElim)) {
                        System.out.println("Usuario eliminado.");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}