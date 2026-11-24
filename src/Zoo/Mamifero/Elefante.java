package Zoo.Mamifero;

import java.util.Random;

public class Elefante extends Mamifero{
    public Elefante() {
        super();
    }
    public Elefante(String nombre, int edad, float peso, String tipoPelaje, double temperaturaCorporal, boolean esAcuatico) {
        super(nombre, edad, peso,tipoPelaje,temperaturaCorporal,esAcuatico);

    }

    public void usandoTrompa(){System.out.println(getNombre() + " esta pegnado una trompada.");}

    public void barritar(){System.out.println(getNombre() + " esta barritando con fuerza.");}

    @Override
    public void cuidarCrias(){ System.out.println(getNombre() + " esta protegiendo a sus crias de los leones de la sabana");}

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
                this::barritar,
                this::usandoTrompa
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
