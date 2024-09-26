
package proyecto1so;

/**
 *
 * @author victorpointud
 */

public class ProjectManager implements Runnable {
    private int diasRestantes; 
    private double salarioPorHora = 40.0; 
    private double salarioTotal = 0.0;
    private int horasAnime = 16; 
    private boolean viendoAnime = false; 
    private final int tiempoRevision = 8; 

    public ProjectManager(int diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    @Override
    public void run() {
        while (diasRestantes > 0) {
            try {
                
                for (int i = 0; i < horasAnime * 2; i++) {
                    if (i % 2 == 0) {
                        viendoAnime = true;
                        System.out.println("El PM está viendo anime...");
                    } else {
                        viendoAnime = false;
                        System.out.println("El PM está trabajando...");
                    }
                    salarioTotal += salarioPorHora / 2;
                    Thread.sleep(500); 
                }

                for (int i = 0; i < tiempoRevision; i++) {
                    System.out.println("El PM está revisando el proyecto...");
                    salarioTotal += salarioPorHora;
                    Thread.sleep(1000);
                }

                diasRestantes--;
                System.out.println("Día terminado. Días restantes: " + diasRestantes);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El PM ha completado su trabajo. Salario total: $" + salarioTotal);
    }

    public boolean isViendoAnime() {
        return viendoAnime;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }

    public void descontarSalario(double cantidad) {
        salarioTotal -= cantidad;
        System.out.println("Al PM se le ha descontado $" + cantidad + " por ver anime.");
    }
}
