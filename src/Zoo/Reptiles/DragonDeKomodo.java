package Zoo.Reptiles;

import Zoo.Animal;

import java.util.Random;
import java.util.List;

public class DragonDeKomodo extends Reptil {

    public static List<Animal> listaDeAnimales;

    public DragonDeKomodo() {
        super();
    }

    public DragonDeKomodo(String nombre, int edad, float peso, String tipoEscamas, String Habitat) {
        super(nombre, edad, peso, tipoEscamas, Habitat);
    }

    public void detectarOlor() {
        System.out.println(getNombre() + " está detectando el olor con su lengua.");
    }

    public void morder() {

        // Este metodo elige a un animal aleatorio para morder

        Random random = new Random();
        // La elección es aleatoria, es necesario crear un objeto Random.
        int posicion;
        Animal animalVictima;

        do {
            posicion = random.nextInt(listaDeAnimales.size());
            // Posición aleatoria, atendiendo al tamaño de listaDeAnimales

            animalVictima = listaDeAnimales.get(posicion);
            // Creamos un objeto Animal.
            // Obtenemos el animal de la posicion aleatoria que hemos obtenido
        } while (animalVictima == this);


        System.out.println(getNombre() + " está mordiendo a " + animalVictima.getClass().getSimpleName());
        // getClass().getSimpleName nos sirve para obtener el nombre de la clase.
        // En este caso, el nombre de la clase es el nombre del animal (Elefante, abeja, tortuga...)

    }

    // *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *

    // Sobrescribimos 2 clases heredadas para reflejar como se comporta esta especie.

    @Override
    public void comer(){ System.out.println(getNombre() + " está devorando carne con sus poderosas mandíbulas.");}

    @Override
    public void moverse() { System.out.println(getNombre() + " se mueve lentamente buscando presas.");}

    // *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *

    @Override
    public void verAnimal() {

        Random random = new Random();

        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
                this::mudarPiel,
                this::detectarOlor,
                this::morder
        };

        try {
            for (int i = 0; i < 3; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
