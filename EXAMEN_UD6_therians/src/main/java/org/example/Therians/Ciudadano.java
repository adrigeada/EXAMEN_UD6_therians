package org.example.Therians;

public class Ciudadano extends Persona{

    private String dni;

    public Ciudadano(String nombre, String poblacion,String dni) {
        super(nombre, poblacion);
        this.dni = dni;
    }

    @Override
    public void mostrarTipoPersona() {
        System.out.println("Civil");
    }

    public void abonarTasas(Expediente expediente){
        System.out.println("\nCiudadano "+getNombre()+ " abonando tasas generadas en el expediente actual...");
        expediente.setEstado(EstadoTramite.PAGADO);
        System.out.println("Estado expediente: "+expediente.getEstado());
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "dni='" + dni + '\'' +
                "} " ;
    }
}
