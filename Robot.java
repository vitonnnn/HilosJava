

import java.util.Random;

public class Robot extends Thread {
    private String nombre;
    private static boolean carreraTerminada = false;

    public Robot(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        Random random = new Random();
        int recorrido = 0;
        
        while (!carreraTerminada) {
            int avance = random.nextInt(10) + 1;
            recorrido += avance;
            System.out.println(nombre + " avanzó " + avance + " metros. Recorrido total: " + recorrido);
            
            if (recorrido >= 100) {
                carreraTerminada = true;
                System.out.println(nombre + " ha ganado la carrera");
            }
        }
    }

    public static void main(String[] args) {
        Robot robotRojo = new Robot("Robot Rojo");
        Robot robotAzul = new Robot("Robot Azul");

        robotRojo.start();
        robotAzul.start();
    }
}
