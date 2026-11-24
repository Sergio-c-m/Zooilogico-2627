package Zoo.Pez;

import java.util.Random;


public class PezPayaso extends Pez {
    private String tipoAgua;
    private String colorPiel;
    private double longitud;

    private static final String[] tipoAguaPosible = {"salada"};
    private static final String[] coloresPielPosibles = {"naranja", "rojizo", "con franjas azuladas", "amarillo"};


    public PezPayaso() {
        super();
        Random random = new Random();
        this.colorPiel = coloresPielPosibles[random.nextInt(coloresPielPosibles.length)];
        this.tipoAgua = tipoAguaPosible[random.nextInt(tipoAguaPosible.length)];
        this.longitud = 0.1 + (12.0 - 0.1) * random.nextDouble();
    }


    public PezPayaso(String nombre, int edad, float peso, String tipoAgua, String colorPiel, double longitud) {
        super(nombre, edad, peso, tipoAgua, colorPiel, longitud);
        this.tipoAgua = tipoAgua;
        this.colorPiel = colorPiel;
        this.longitud = longitud;

    }
    @Override
    public void comer() {
        System.out.println(getNombre() + ", El pez payaso esta comiendo parásitos de su anémona.");
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + ", El pez payaso esta durmiendo despues de por fin encontrar a su hijo.");
    }


    public void refugiarseEnAnemona() {
        System.out.println(getNombre() + ", El pez payaso se escondio en su anemona pq escucho un rempalago");
    }

    public void defenderTerritorio() {
        System.out.println(getNombre() + ", Al pez payaso le toco proteger el barrio de los inmigrantes ilegales");
    }


    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::nadar,
                this::respirarBajoAgua,
                this::buscarRefugio,
                this::refugiarseEnAnemona,
                this::defenderTerritorio


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

