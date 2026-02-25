package org.example.Therians;

import java.util.ArrayList;
import java.util.Scanner;

public class CensoMutxamelApp {

    public static ArrayList<Agente> agentesPoliciaRegistrados = new ArrayList<>();
    public static ArrayList<Expediente> listaExpedientes = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    static void main(String[] args) {

        Agente luisa = new Agente("Luisa","Mutxamel",2334);
        Agente raul = new Agente("Raúl","Mutxamel",1234);

        agentesPoliciaRegistrados.add(luisa);
        agentesPoliciaRegistrados.add(raul);


        System.out.println("=== BIENVENIDO A LA APP DEL CENSO DE BESTIAS MUTXAMEL ===");


        if (raul.login()){
            System.out.println("Bienvenido "+raul.getNombre());
        }

        Expediente expediente = raul.crearExpediente();
        listaExpedientes.add(expediente);

        expediente.insertarSeres();
        raul.siguienteEstado(expediente);

        try {
            raul.archivarExpediente(expediente);
        }catch (ExpedienteNoPagadoException e){
            System.out.println("\nAun no se han pagado las tasas");
        }

        Ciudadano ciudadano = expediente.getCiudadano();

       ciudadano.abonarTasas(expediente);

       raul.archivarExpediente(expediente);


        System.out.println("\n*** Resumen de expediente creados ***");
        for (Expediente expedientee : listaExpedientes){
            System.out.println(expedientee);
        }



    }






}
