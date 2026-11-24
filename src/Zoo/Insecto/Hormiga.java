package Zoo.Insecto;

import java.util.Random;

public class Hormiga extends Insecto {

    public Hormiga() {
        super();
        // las hormigas siempre tienen 6 patas y las obreras no tienen alas
        this.numeroPatas = 6;
        this.tieneAlas = false;
        this.color = COLORES[3];
    }

    public Hormiga(String nombre, int edad, float peso, int numeroPatas, boolean tieneAlas, String color) {
        super(nombre, edad, peso, numeroPatas, tieneAlas, color);
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " la hormiga camina en fila con sus compañeras.");
    }

    @Override
    public void buscarRefugio() {
        System.out.println(getNombre() + " se mete corriendo en el hormiguero.");
    }

    public void transportarComida() {
        // elige una comida al azar
        String[] comidas = {"una miga de pan", "una semilla", "un trozo de hoja", "un grano de azúcar"};
        Random r = new Random();
        String comida = comidas[r.nextInt(comidas.length)];
        System.out.println(getNombre() + " lleva " + comida + " al hormiguero, aunque pesa más que ella.");
    }

    public void seguirRastrosQuimicos() {
        System.out.println(getNombre() + " sigue el rastro químico que han dejado otras hormigas.");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        // acciones de Animal, Insecto y las de la hormiga
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::moverAntenas,
                this::buscarRefugio,
                this::detectarVibraciones,
                this::transportarComida,
                this::seguirRastrosQuimicos
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