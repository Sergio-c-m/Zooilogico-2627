package Zoo.Ave;

import Zoo.Animal;

import java.util.Random;



    public class Ave extends Animal {
        private String colorPlumas;
        private double envergadura;
        private boolean puedeVolar;
        private boolean ponerHuevos;
        private boolean acicalarse;

        private static final String[] colorPlumaje = {"Marrón", "Blanco", "Gris", "Azul", "Rojo", "Amarillo", "Verde"};

        // Constructor sin parámetros
        public Ave() {
            super();
            Random random = new Random();
            this.colorPlumas = colorPlumaje[random.nextInt(colorPlumaje.length)];
            this.ponerHuevos = random.nextBoolean();
            this.puedeVolar = random.nextBoolean();
            this.envergadura = random.nextDouble();
            this.acicalarse = random.nextBoolean();
        }

        // Constructor con parámetros
        public Ave(String nombre, int edad, float peso, boolean puedeVolar, String colorPlumaje, double envergadura, boolean ponerHuevos, boolean acicalarse) {
            super(nombre, edad, peso);
            this.colorPlumas = colorPlumaje;
            this.ponerHuevos = ponerHuevos;
            this.puedeVolar = puedeVolar;
            this.envergadura = envergadura;
            this.acicalarse = acicalarse;
        }

        protected void setColorPlumaje(String colorPlumaje) {
            this.colorPlumas = colorPlumaje;
        }

        public void volar() {
            System.out.println(getNombre() + " está volando.");
        }

        public void ponerHuevos() {
            System.out.println(getNombre() + " está poniendo un huevo.");
        }

        public void acicalarse() {
            System.out.println(getNombre() + " se está acicalando.");
        }

        public void nadar() {
            System.out.println(getNombre() + " está nadando.");
        }

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
                    this::nadar
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