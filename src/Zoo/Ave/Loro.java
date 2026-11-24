package Zoo.Ave;

import java.util.Random;


public class Loro extends Ave{
    private static final String[] colorPlumaje = {"Marrón", "Blanco", "Gris", "Azul", "Rojo", "Amarillo", "Verde"};

    // Constructor sin parámetros
    public Loro() {
        super();
        Random random = new Random();
        setColorPlumaje(colorPlumaje[random.nextInt(colorPlumaje.length)]);
    }

    // Constructor con parámetros
    public Loro(String nombre, int edad, float peso, String colorPlumaje, double envergadura, boolean ponerHuevos, boolean puedeVolar, boolean acicalarse) {
        super(nombre, edad, peso, puedeVolar, colorPlumaje, envergadura, ponerHuevos, acicalarse);
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " el loro se está moviendo.");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + " el loro está comiendo.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + " el loro está durmiendo.");
    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " el loro está volando.");
    }
    @Override
    public void acicalarse() {
        System.out.println(getNombre() + " el loro se está acicalando.");
    }
    @Override
    public void ponerHuevos() {
        System.out.println(getNombre() + " el loro está poniendo huevos.");
    }

    // Método único de Loro
    public void imitarPalabras () {
        System.out.println(getNombre() + " el loro está imitando palabras.");
    }
    public void treparRamas() {
        System.out.println(getNombre() + " el loro está trepando por las ramas.");
    }

    @Override
    public void verAnimal() {
        // Tres acciones aleatorias, incluyendo las propias de esta especie.
        java.util.Random random = new java.util.Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::volar,
                this::ponerHuevos,
                this::acicalarse,
                this::nadar,
                this::imitarPalabras,
                this::treparRamas
        };

        for (int i = 0; i < 3; i++) {
            acciones[random.nextInt(acciones.length)].run();
            try {
                Thread.sleep(random.nextInt(2000) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
