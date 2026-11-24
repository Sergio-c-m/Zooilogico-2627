package Zoo.Pez;

import java.util.Random;

public class PezGlobo extends Pez {
    private static final String[] coloresPielPosibles = {"amarillo", "marrón", "gris", "verde oliva"};

    // Constructor sin parámetros
    public PezGlobo() {
        super();
        Random random = new Random();
        setColorPiel(coloresPielPosibles[random.nextInt(coloresPielPosibles.length)]);
        setLongitud(0.10 + (0.50 - 0.10) * random.nextDouble());
    }

    // Constructor con parámetros
    public PezGlobo(String nombre, int edad, float peso, String tipoAgua, String colorPiel, double longitud) {
        super(nombre, edad, peso, tipoAgua, colorPiel, longitud);
    }

    // Métodos heredados
    @Override
    public void comer() {
        System.out.println(getNombre() + ", el pez globo, está comiendo pequeños moluscos y crustáceos.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + ", el pez globo, descansa tranquilamente entre las rocas.");
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + ", el pez globo, nada despacio moviendo sus pequeñas aletas.");
    }

    // Métodos propios
    public void inflarse() {
        System.out.println(getNombre() + ", el pez globo, se infla al sentirse amenazado y parece mucho más grande. El pez espada está molestando otra vez");
    }

    public void desinflarse() {
        System.out.println(getNombre() + ", el pez globo, expulsa el agua y recupera su tamaño habitual.");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::nadar,
                this::respirarBajoAgua,
                this::buscarRefugio,
                this::inflarse,
                this::desinflarse
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
