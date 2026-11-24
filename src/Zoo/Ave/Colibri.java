package Zoo.Ave;

import java.util.Random;

public class Colibri extends Ave {

    // Constructor sin parámetros: toma los valores aleatorios de Ave y Animal
    public Colibri() {
        super();
    }

    // Constructor con parámetros
    public Colibri(String nombre, int edad, float peso, boolean puedeVolar,
                   String colorPlumaje, double envergadura, boolean ponerHuevos, boolean acicalarse) {
        super(nombre, edad, peso, puedeVolar, colorPlumaje, envergadura, ponerHuevos, acicalarse);
    }
    //Comportamientos propios del Colibrí
    // Primero
    public void suspenderseEnVuelo() {
        System.out.println(getNombre() + " se queda suspendido en el aire batiendo las alas muy rapido.");
    }

    // Segundo
    public void beberNectar() {
        System.out.println(getNombre() + " mete el pico en una flor y bebe néctar.");
    }

    // Sobrescribimos un método heradado que sería la forma de volar específica
    @Override
    public void volar() {
        System.out.println(getNombre() + " vuela muy rápido de flor en flor y puede ir hacia atrás.");
    }

    // Ejecuta 3 acciones al azar mezclando heredadas y propias del colibrí
    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::volar,
                this::acicalarse,
                this::suspenderseEnVuelo,
                this::beberNectar
        };

        try {
            for (int i = 0; i < 3; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
