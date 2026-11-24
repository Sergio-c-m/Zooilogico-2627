package Zoo.Pez;

import java.util.Random;

public class PezEspada extends Pez {
    private static final String[] coloresPielPosibles = {"amarillo", "gris", "azul"};

    // Constructor sin parámetros
    public PezEspada() {
        super();
        Random random = new Random();
        setColorPiel(coloresPielPosibles[random.nextInt(coloresPielPosibles.length)]);
        setLongitud(1.0 + (4.5 - 1.0) * random.nextDouble());
    }

    // Constructor con parámetros
    public PezEspada(String nombre, int edad, float peso, String tipoAgua, String colorPiel, double longitud) {
        super(nombre, edad, peso, tipoAgua, colorPiel, longitud);
    }

    //Métodos heredados
    @Override
    public void comer() {
        System.out.println(getNombre() + ", el pez espada, se está mandando un festín de peces pequeños y calamares.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + ", el pez espada, está descansando todo chill, pero no puede dormir :(");
    }

    //Método propios
    public void acelerar() {
        System.out.println(getNombre() + ", el pez espada, acelera para perseguir a un pez que se quiere comer, hay mucha hambre.");
    }

    public void golpear() {
        System.out.println(getNombre() + ", el pez espada, le pega con su pico a un pez globo por pura diversión, que cruel.");
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
                this::respirarBajoAgua,
                this::buscarRefugio,
                this::acelerar,
                this::golpear

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
