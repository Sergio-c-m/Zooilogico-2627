package Zoo.Mamifero;

import java.util.Random;

public class Leon extends Mamifero {

    public Leon() {
        super("Leon", 8, 190.0f, "corto", 38.5, false);
    }

    public Leon(String nombre, int edad, float peso,
                String tipoPelaje, double temperaturaCorporal,
                boolean esAcuatico) {

        super(nombre, edad, peso, tipoPelaje,
                temperaturaCorporal, esAcuatico);
    }

    // Primer comportamiento propio: rugir
    public void rugir() {
        System.out.println(getNombre() + " ruge con fuerza para marcar su territorio.");
    }

    // Segundo comportamiento propio: acechar
    public void acecharPresa() {
        System.out.println(getNombre() + " se agacha entre la hierba y acecha silenciosamente a su presa.");
    }

    // Comportamiento propio del leon
    @Override
    public void moverse() {
        System.out.println(getNombre() + " camina sigilosamente por la sabana en busca de alimento.");
    }

    // Mostrar acciones aleatorias del leon
    @Override
    public void verAnimal() {

        Random random = new Random();

        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::amamantar,
                this::cuidarCrias,
                this::regularTemperatura,
                this::rugir,
                this::acecharPresa
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



