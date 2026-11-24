package Zoo.Reptiles;
import Zoo.Animal;
import java.util.Random;

public class Reptil extends Animal {
    private String tipoEscamas;
    private String habitat;
    private boolean esVenenoso = false;

    private static final String[] tipoEscamasPosibles= {"lisas", "quilladas", "granulares"};
    private static final String[] habitatPosibles = {"desiertos", "selva", "bosque" , "rios"};


    public Reptil (){
        super ();
        Random random = new Random();
        this.tipoEscamas = tipoEscamasPosibles[random.nextInt(tipoEscamasPosibles.length)];
        this.habitat = habitatPosibles[random.nextInt(habitatPosibles.length)];
    }

    public Reptil (String nombre, int edad, float peso, String tipoEscamas, String habitat, String especiePosible) {
        super(nombre, edad, peso);
        this.tipoEscamas = tipoEscamas;
        this.habitat = habitat;
    }

    public void setEsVenenoso(boolean esVenenoso) {
        this.esVenenoso = esVenenoso;
    }

    public void tomarSol(){
        System.out.println(getNombre() + " esta calentandose al sol.");
    }
    public void mudarPiel(){
        System.out.println(getNombre() + " esta renovando su capa externa.");
    }
    public void esconderse(){
        System.out.println(getNombre() + " esta buscando refugio.");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
                this::mudarPiel,
                this::esconderse,

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
