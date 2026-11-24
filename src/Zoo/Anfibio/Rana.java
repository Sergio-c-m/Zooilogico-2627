package Zoo.Anfibio;

import java.util.Random;

public class Rana extends Anfibio {
    private static final String[] coloresPielPosibles = {"verde", "rojo", "azul"};

    // Constructor sin parámetros
    public Rana() {
        super();
        Random random = new Random();
        setColorPiel(coloresPielPosibles[random.nextInt(coloresPielPosibles.length)]);
    }

    // Constructor con parámetros
    public Rana(String nombre, int edad, float peso, boolean puedeRespirarBajoAgua, String colorPiel) {
        super(nombre, edad, peso, puedeRespirarBajoAgua, colorPiel);
    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " la rana está dando saltos en el agua.");
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " la rana está saltando por la tierra.");
    }

    // Metodo único de Rana
    public void croar() {
        System.out.println(getNombre() + " está croando.");
    }

    @Override
    public void verAnimal() {
        // Tres acciones aleatorias, incluyendo las propias de esta especie.
        java.util.Random random = new java.util.Random();
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::nadar,
            this::metamorfosis,
            this::croar
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
