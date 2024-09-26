
package proyecto1so;

/**
 *
 * @author victorpointud
 */

public abstract class Trabajador implements Runnable {
    protected double salarioPorHora;
    protected int horasPorDia;
    protected int capacidadAlmacen;
    protected int produccionDiaria;
    protected int cantidadProducida;

    public Trabajador(double salarioPorHora, int capacidadAlmacen, int produccionDiaria) {
        this.salarioPorHora = salarioPorHora;
        this.horasPorDia = 24; 
        this.capacidadAlmacen = capacidadAlmacen;
        this.produccionDiaria = produccionDiaria;
        this.cantidadProducida = 0;
    }

    public abstract void producir();

    @Override
    public void run() {
        while (true) {
            try {
                // Simulación de un día de trabajo
                Thread.sleep(3000); 
                producir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
