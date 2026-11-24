package Zoo.Mamifero;

import java.util.Random;

public class Canguro extends Mamifero{

    private boolean saltar;
    private boolean guardarCriaEnBolsa;
    Random random = new Random();

    public Canguro(){
        super();
        this.saltar = saltar;
        this. guardarCriaEnBolsa = guardarCriaEnBolsa;
    }

    public void saltar(){System.out.println(getNombre() + " está saltando.");}

    public void guardarCria(){
        guardarCriaEnBolsa = random.nextBoolean();
         if (guardarCriaEnBolsa){
             System.out.println(getNombre() + " está guardando a su cría en la bolsa.");
         } else{
             System.out.println(getNombre() + " está caminando junto a su cría.");

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
                this::saltar,
                this::guardarCria
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
