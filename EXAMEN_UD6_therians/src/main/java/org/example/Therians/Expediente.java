package org.example.Therians;

import java.util.ArrayList;
import java.util.Scanner;

public class Expediente {

    static Scanner teclado = new Scanner(System.in);

    private Ciudadano ciudadano;
    private ArrayList<TipoSer> listaSeres;
    private  EstadoTramite estado;

    public Expediente(Ciudadano ciudadano){
        this.ciudadano = ciudadano;
        listaSeres = new ArrayList<>();
        estado = EstadoTramite.INICIADO;
    }

    public void insertarSeres(){
        String repetir = "";

        do {

            System.out.println("\nInserta el tipo de ser que quieres censar[THERIAN,DOMESTICO,EXOTICO]");

            boolean control = false;
            TipoSer ser = null;

            try {
                ser = TipoSer.valueOf(teclado.nextLine().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Tipo no contemplado");
                control = true;
            }

            if (!control){
                listaSeres.add(ser);
                double tasas = ser.getPunto();

                System.out.println("Importe tasas actual: "+tasas+" €");
            }

            System.out.println("Quieres añadir otro tipo? [S/N]");
            repetir = teclado.nextLine();

        }while (repetir.equalsIgnoreCase("s"));



    }

    public void verTasas(){

    }


    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public EstadoTramite getEstado() {
        return estado;
    }

    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    public ArrayList<TipoSer> getListaSeres() {
        return listaSeres;
    }

    public void setListaSeres(ArrayList<TipoSer> listaSeres) {
        this.listaSeres = listaSeres;
    }

    @Override
    public String toString() {
        return "Expediente{" +
                "ciudadano=" + ciudadano +
                ", listaSeres=" + listaSeres +
                ", estado=" + estado +
                '}';
    }
}
