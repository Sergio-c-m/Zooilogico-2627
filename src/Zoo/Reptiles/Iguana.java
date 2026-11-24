package Zoo.Reptiles;

import java.util.Random;

public class Iguana extends Reptil {

    // Constructor sin parámetros
    public Iguana() {
        super();
    }

    // Constructor con parámetros
    public Iguana (String nombre, int edad, float peso, String tipoEscamas, String habitat, String esVenenoso) {
        super (nombre, edad, peso, tipoEscamas, habitat, esVenenoso);
    }

    @Override
    public void mudarPiel() {
        System.out.println(getNombre() + " la iguana está mudando su piel mediante un proceso llamado ecdisis");
    }

    @Override
    public void esconderse() {
        System.out.println(getNombre() + " la iguana se está escondiendo de sus depredadores");
    }

    //Métodos únicos de la iguana
    public void trepar() {
        System.out.println(getNombre()+ " la iguana está trepando como sino hubiera un mañana");
    }
    public void agitarCola() {
        System.out.println(getNombre() + " la iguana está agitando su cola de forma sospechosa");
    }

    @Override
    public void verAnimal() {
        // acciones aleatorias, incluyendo las propias de esta especie.
        java.util.Random random = new java.util.Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
                this::mudarPiel,
                this::esconderse,
                this::trepar,
                this::agitarCola,
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
