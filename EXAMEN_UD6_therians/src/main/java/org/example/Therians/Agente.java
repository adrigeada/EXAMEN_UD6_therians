package org.example.Therians;

import java.util.ArrayList;
import java.util.Scanner;

public class Agente extends Persona implements AccionesPoliciales{
    static Scanner teclado = new Scanner(System.in);

    public static int contadorid = 0;

    private int id;
    private int codigo_acceso;

    public Agente(String nombre, String poblacion,int codigo_acceso) {
        ++contadorid;
        super(nombre, poblacion);
        this.codigo_acceso = codigo_acceso;
        setId();
    }

//    public Agente(int id,int codigo_acceso){  No se como crear un Agente con este constructor en login
//        super(null,null);
//        this.id = id;
//        this.codigo_acceso = codigo_acceso;
//
//    }

    @Override
    public void mostrarTipoPersona() {
        System.out.println("Autoridad");
    }


    @Override
    public String toString() {
        return "Agente{" +
                "id=" + id +
                ", codigo_acceso=" + codigo_acceso +
                "} " + super.toString();
    }

    @Override
    public Ciudadano solicitarDatosCiudadano() {
        return null;
    }

    @Override
    public Expediente crearExpediente() {
        System.out.println("Bienvenido "+getNombre());
        System.out.println("\nCreando expediente");
        System.out.println("Introduce los datos del Ciudadano a registrar");
        System.out.println("Nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Poblacion:");
        String poblacion = teclado.nextLine();
        System.out.println("DNI:");
        String dni = teclado.nextLine();

        Ciudadano ciudadano = new Ciudadano(nombre,poblacion,dni);
        Expediente expediente = new Expediente(ciudadano);

        System.out.println("Expediente para el ciudadano "+ciudadano.getNombre()+" creado.");

        return expediente;
    }

    @Override
    public void siguienteEstado(Expediente expediente) {
        switch (expediente.getEstado()){

            case INICIADO:
                System.out.println("\nAgente modificando estado INICIADO a COMPLETADO");
                expediente.setEstado(EstadoTramite.COMPLETADO);
                break;
            case COMPLETADO:
                System.out.println("\nAgente modificando estado COMPLETADO a PAGADO");
                expediente.setEstado(EstadoTramite.PAGADO);
                break;
            case PAGADO:
                System.out.println("\nAgente modificando estado PAGADO a ARCHIVADO");
                expediente.setEstado(EstadoTramite.ARCHIVADO);
                break;

            default:
                System.out.println("\nExpediente archivado");


        }
    }

    @Override
    public void archivarExpediente(Expediente expediente) {

        if (!expediente.getEstado().equals(EstadoTramite.PAGADO)){
            throw new ExpedienteNoPagadoException();
        }else {
            System.out.println("\nArchivando expediente");
            expediente.setEstado(EstadoTramite.ARCHIVADO);
        }
    }



    public boolean login(){

        boolean control = false;

        do {
            control = false;
        System.out.println("Introduce tu id");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce codigo de acceso");
        int codigo = teclado.nextInt();
        teclado.nextLine();

            if (id == this.id && codigo == this.codigo_acceso){
                return true;
            }else {
                System.out.println("Vuelve a intentarlo");
                control = true;
            }
        }while (control);

        return true;

    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = contadorid;
        System.out.println("Agente "+getNombre()+" registrado. Tu id es: "+contadorid);
    }

    public int getCodigo_acceso() {
        return codigo_acceso;
    }

    public void setCodigo_acceso(int codigo_acceso) {
        this.codigo_acceso = codigo_acceso;
    }



}
