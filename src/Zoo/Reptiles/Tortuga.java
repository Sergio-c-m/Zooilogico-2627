package Zoo.Reptiles;
import java.util.Random;

public class Tortuga extends Reptil {


    public Tortuga() {
        super();
    }

    public Tortuga(String nombre, int edad, float peso, String tipoEscamas, String Habitat, String esVenenoso) {
        super(nombre, edad, peso, tipoEscamas, Habitat, esVenenoso);
    }

    public void meterCabeza() {
        System.out.println(getNombre() + " esta metiendo la cabeza en su caparazón.");
    }

    public void caminarLento() {
        System.out.println(getNombre() + " esta caminando lentamente.");
    }

    @Override
    public void esconderse() {
        meterCabeza();
    }


    @Override
    public void verAnimal() {
        Random random = new Random();

        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
               //this::mudarPiel, Las tortugas no se desprenden de la piel como los reptiles.
                this::esconderse, //Este llama al metodo meterCabeza();
                this::caminarLento
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
