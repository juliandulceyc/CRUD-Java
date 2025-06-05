package model;

//Clase que representa a un usuario en el sistema
public class Usuario {
    private int id, edad;
    private String nombre, email;

    //Constructor para inicializar un usuario
    public Usuario(int id, String nombre, String email, int edad){
        this.id = id;
        this.nombre = nombre;
        this.email =  email;
        this.edad= edad;
    }

    //Métodos getter para acceder a los atributos privados
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getEdad() { return edad; }

    //Métodos setter para modificar los atributos privados
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEmail(String email) {this.email = email;}
    public void setEdad(int edad) {this.edad = edad;}

    //Metodo para mostrar la informacion del usuario
    @Override
    public String toString() {
        return id + " | " + nombre + " | " + email + " | " + edad;
    }
}