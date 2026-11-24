package Zoo.Ave;

import java.util.Random;

public class Aguila extends Ave { //edit push

    private static final String[] colorPlumaje = {"Marrón", "Blanco", "Gris", "Azul", "Rojo", "Amarillo", "Verde"};

    // Constructor sin parámetros
    public Aguila() {
        super();
        Random random = new Random();
        setColorPlumaje(colorPlumaje[random.nextInt(colorPlumaje.length)]);
    }

    // Constructor con parámetros
    public Aguila(String nombre, int edad, float peso, String colorPlumaje, double envergadura, boolean ponerHuevos, boolean puedeVolar, boolean acicalarse) {
        super(nombre, edad, peso, puedeVolar, colorPlumaje, envergadura, ponerHuevos, acicalarse);
    }



    @Override
    public void moverse() {
        System.out.println(getNombre() + " el águila se está desplazando con paso firme.");}

    @Override
    public void comer() {
        System.out.println(getNombre() + " el águila está devorando su presa.");}

    @Override
    public void dormir() {
        System.out.println(getNombre() + " el águila está descansando.");}

    @Override
    public void volar() {
        System.out.println(getNombre() + " el águila está surcando el cielo.");}

    // Primer comportamiento propio
    public void planear() {
        System.out.println(getNombre() + " - el águila esta planeando");}

    // Segundo comportamiento propio
    public void lanzarseEnPicado() {
        System.out.println(getNombre() + " - el águila se lanzo en picado");}

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::volar,
                this::ponerHuevos,
                this::acicalarse,
                this::nadar,
                this::planear,
                this::lanzarseEnPicado
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


