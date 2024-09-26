
package proyecto1so;

/**
 *
 * @author victorpointud
 */

import java.util.Random;

public class Director implements Runnable {
    private double salarioPorHora = 60.0; 
    private double salarioTotal = 0.0;
    private ProjectManager pm; 
    private Almacen almacen; 

    public Director(ProjectManager pm, Almacen almacen) {
        this.pm = pm;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (pm.getDiasRestantes() > 0) {
            try {
                for (int i = 0; i < 24; i++) {
                    salarioTotal += salarioPorHora;
                    System.out.println("El Director está realizando labores administrativas...");
                    Thread.sleep(500); 
                    Random rand = new Random();
                    int horaRevisar = rand.nextInt(24); 
                    if (i == horaRevisar) {
                        revisarPM();
                    }
                }
                System.out.println("Día de trabajo del Director terminado.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (pm.getDiasRestantes() == 0) {
            enviarComputadoras();
        }
        System.out.println("El Director ha completado su trabajo. Salario total: $" + salarioTotal);
    }

    private void revisarPM() {
        if (pm.isViendoAnime()) {
            System.out.println("El Director ha descubierto al PM viendo anime.");
            pm.descontarSalario(100); 
        } else {
            System.out.println("El PM está trabajando bien.");
        }
    }

    private void enviarComputadoras() {
        System.out.println("El Director está enviando todas las computadoras a las distribuidoras.");
    }
}
