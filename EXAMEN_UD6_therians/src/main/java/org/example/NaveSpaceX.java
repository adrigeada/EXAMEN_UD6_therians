package org.example;

/**
 * Es la clase madre que representa a una nave de SpaceX
 * Se puede crear una nave con su nombre y la cantidad de combustible que tiene.
 * El motor siempre será una clase motor con tipo Merlin y potencia 845
 */
public class NaveSpaceX {

    protected String nombre;
    protected double combustible;
    protected Motor motor;
    protected boolean enVuelo;

    public NaveSpaceX(String nombre, double combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.motor = new Motor("Merlin", 845);
        this.enVuelo = false;
    }

    /**
     * Este método es para que la nave despegue. Primero comprueba que el combustible sea mayor a 0. Si no lo es, se lanza una excepción.
     * Si es mayor a 0, el atributo enVuelo se cambia a true y se enseña un mensaje en consola.
     */
    public void lanzar() {
        if (combustible <= 0) {
            throw new IllegalArgumentException("No hay combustible para lanzar");
        }
        enVuelo = true;
        System.out.println("Lanzando nave " + nombre);
    }

    /**
     * Se comprueba el atributo enVuelo. Si es false se lanza una excepción. Si es true, se cambia a false y se enseña un mensaje en consola
     */
    public void aterrizar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave no está en vuelo");
        }
        enVuelo = false;
        System.out.println("Aterrizando nave " + nombre);
    }

    /**
     * Si la cantidad pasada por parametro es 0 o menor, se lanza una excepción.
     * Si el atributo enVuelo es true, se lanza una excepción, por no poder repostar en el aire.
     * Si no salta ninguna execepción, se suma la cantidad pasada por parametro, al combustible de la nave.
     * @param cantidad Cantidad de combustible que se va a rellenar en la nave.
     */
    public void repostar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (enVuelo) {
            throw new IllegalArgumentException("No se puede repostar en vuelo");
        }
        this.combustible += cantidad;
    }

    /**
     * Si la cantidad pasada por parametro es 0 o menor, se lanza una excepción.
     * Si la cantidad que se quiere usar de combustible es mayor a la cantidad de combustible que tiene la nave, se lanza una excepción.
     * Si no salta ninguna excepción, se resta la cantidad pasada por parámetro al combustible total de la nave.
     * @param cantidad Cantidad de combustible que se consume por la nave.
     */
    public void consumirCombustible(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (cantidad > combustible) {
            throw new IllegalArgumentException("Combustible insuficiente");
        }
        this.combustible -= cantidad;
    }

    /**
     * @return Devuelve la cantidad de combustible que tiene la nave.(double)
     */
    public double consultarCombustible() {
        return combustible;
    }

    /**
     * @return Devuelve el estado del atributo enVuelo.(boolean)
     */
    public boolean isEnVuelo() {
        return enVuelo;
    }
}//

/**
 * Es una clase hija de la clase NaveSpaceX.
 * Hereda todos sus atributos y además añade numeroAstronautas y capacidadMaxima
 */
class NaveTripulada extends NaveSpaceX {

    private int numeroAstronautas;
    private int capacidadMaxima;

    public NaveTripulada(String nombre, double combustible, int numeroAstronautas, int capacidadMaxima) {
        super(nombre, combustible);
        this.numeroAstronautas = numeroAstronautas;
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * @return Devuelve el número de astronautas que ocupan la nave. (int)
     */
    public int getNumeroAstronautas() {
        return numeroAstronautas;
    }

    /**
     * Se comprubea que el número pasado por parámetro es válido. Es igual o mayor a 0 y no es mayor que la capacidad máxima de la nave.
     * Si no salta ninguna excepción, el numero de astronautas se actualiza con el parámetro pasado.
     * @param numeroAstronautas Número de astronautas que se añaden a la nave.
     */
    public void setNumeroAstronautas(int numeroAstronautas) {
        if (numeroAstronautas < 0 || numeroAstronautas > capacidadMaxima) {
            throw new IllegalArgumentException("Número de astronautas inválido");
        }
        this.numeroAstronautas = numeroAstronautas;
    }

    /**
     * @return Devuelve el atributo capacidadMaxima de la nave (int)
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Se comprueba primero que la cantidad pasada como parámetro es mayor a 0
     * Se comprueba que el número actual de astronautas sumado a la cantidad que se quiere añadir (parámetro), no supera a la capacidad máxima.
     * Si no salta ninguna excepción, se añaden los nuevos astronautas a la nave
     * @param cantidad Cantidad de nuevos astronautas que van a entrar en la nave
     */
    public void embarcar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (numeroAstronautas + cantidad > capacidadMaxima) {
            throw new IllegalArgumentException("Capacidad excedida");
        }
        numeroAstronautas += cantidad;
    }

    /**
     * Se comprueba que la cantidad pasada como parametro no sea menor a 0
     * Se comprueba que la cantidad de astronautas que quieren salir de la nave no sea mayor a la cantidad de astronautas que hay actualmente en la nave
     * Si no salta excepción, se restan la cantidad pasada por parámetro al numero de astronautas en la nave
     * @param cantidad Cantidad de astronautas que salen de la nave
     */
    public void desembarcar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        if (cantidad > numeroAstronautas) {
            throw new IllegalArgumentException("No hay suficientes astronautas");
        }
        numeroAstronautas -= cantidad;
    }

    /**
     * Se comprueba que la nave esté en vuelo. Si no está en vuelo, salta una excepción.
     * Si no salta execpción sale un mensaje por consola.
     */
    public void acoplar() {
        if (!enVuelo) {
            throw new IllegalArgumentException("La nave debe estar en vuelo para acoplarse");
        }
        System.out.println("La nave " + nombre + " se está acoplando en órbita.");
    }
}//

/**
 * Esta clase representa a los motores que usan las naves espaciales.
 * Se puede crear un motor con el tipo de motor y la potencia de este.
 */
class Motor {

    private String tipo;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    /**
     * @return Devuelve el tipo del motor
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return Devuelve la potencia del motor
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Enseña un mensaje por consola encendiendo el motor.
     */
    public void encender() {
        System.out.println("Motor " + tipo + " encendido con potencia " + potencia);
    }

    /**
     * Enseña un mensaje en consola apagando el motor.
     */
    public void apagar() {
        System.out.println("Motor apagado");
    }
}