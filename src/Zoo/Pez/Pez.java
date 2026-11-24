package Zoo.Pez;

import Zoo.Animal;

import java.util.Random;

    public class Pez extends Animal {
        private String tipoAgua;
        private String colorPiel;
        private double longitud;

        private static final String[] tipoAguaPosible = {"salada", "dulce"};
        private static final String[] coloresPielPosibles = {"colorido", "color simple"};

        // Constructor sin parámetros
        public Pez() {
            super();
            Random random = new Random();
            this.colorPiel = coloresPielPosibles[random.nextInt(coloresPielPosibles.length)];
            this.tipoAgua = tipoAguaPosible[random.nextInt(tipoAguaPosible.length)];
            this.longitud = 0.1 + (12.0 - 0.1) * random.nextDouble();
        }

        // Constructor con parámetros
        public Pez(String nombre, int edad, float peso, String tipoAgua, String colorPiel, double longitud) {
            super(nombre, edad, peso);
            this.tipoAgua = tipoAgua;
            this.colorPiel = colorPiel;
            this.longitud = longitud;
        }

        public void setTipoAgua(String tipoAgua) {
            this.tipoAgua = tipoAgua;
        }

        public void setColorPiel(String colorPiel) {
            this.colorPiel = colorPiel;
        }

        public void setLongitud(double longitud) {
            this.longitud = longitud;
        }

        public void nadar() {
            System.out.println(getNombre() + " está avanzando con aletas.");
        }

        public void respirarBajoAgua() {
            System.out.println(getNombre() + " está usando sus branquias para respirar.");
        }

        public void buscarRefugio() {
            System.out.println(getNombre() + " se esconde en el agua.");
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
                    this::buscarRefugio
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
