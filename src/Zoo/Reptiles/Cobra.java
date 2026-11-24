package Zoo.Reptiles;

import Zoo.Animal;

import java.util.Random;

public class Cobra extends Reptil {

    // Constructor sin parámetros
    public Cobra() {
        super();
        setEsVenenoso(true);
    }

    // Constructor con parámetros
    public Cobra(String nombre, int edad, float peso, String tipoEscamas, String habitat) {
        super(nombre, edad, peso, tipoEscamas, habitat);
        setEsVenenoso(true);
    }

    // Comportamientos propios
    public void desplegarCapucha() {
        System.out.println(getNombre() + " ha desplegado su capucha para intimidar.");
    }

    public void sisear() {
        System.out.println(getNombre() + " sisea de forma amenazante. No quiere compañía.");
    }

    // Sobrescribir método
    @Override
    public void moverse() {
        System.out.println(getNombre() + " serpentea silenciosamente por el suelo.");
    }

    // Sobrescribir del método verAnimal
    @Override
    public void verAnimal() {
        Random random = new Random();

        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
                this::mudarPiel,
                this::esconderse,
                this::desplegarCapucha,
                this::sisear
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

