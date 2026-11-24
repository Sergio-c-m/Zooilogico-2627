package Zoo.Ave;

public class Pinguino extends Ave {

    private boolean puedeBucear;

    public Pinguino() {
        super();
        this.puedeBucear = true;
    }

    public Pinguino(String nombre, int edad, float peso, boolean puedeBucear, String colorPlumas) {
        super(nombre, edad, peso, false, colorPlumas, 0.0, true, true);
        this.puedeBucear = puedeBucear;
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " el pinguino se desliza sobre el hielo.");
    }

    public void acicalarse() {
        System.out.println(getNombre() + " está acicalándose.");
    }

    public void bucear() {
        if (puedeBucear) {
            System.out.println(getNombre() + " el pinguino está buceando en busca de peces.");
        } else {
            System.out.println(getNombre() + " se queda en la superficie porque no puede bucear.");
        }
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
                this::ponerHuevos,
                this::acicalarse,
                this::bucear
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
