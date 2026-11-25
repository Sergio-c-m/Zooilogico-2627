package Zoo.Mamifero;

import java.util.Random;

public class Murcielago extends Mamifero{

    private boolean ecolocalizar;
    private boolean colgarseBocabajo;
    Random random = new Random();

    public Murcielago(){
        super();
        this.ecolocalizar = ecolocalizar;
        this.colgarseBocabajo = colgarseBocabajo;
    }

    public void ecolocalizar(){System.out.println(getNombre() + " está usando su radar.");}

    public void colgarseBocabajo(){
        colgarseBocabajo = random.nextBoolean();
        if (colgarseBocabajo){
            System.out.println(getNombre() + " está colgándose bocabajo.");
        } else{
            System.out.println(getNombre() + " está volando.");

        }
    }

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
                this::ecolocalizar,
                this::colgarseBocabajo,
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
