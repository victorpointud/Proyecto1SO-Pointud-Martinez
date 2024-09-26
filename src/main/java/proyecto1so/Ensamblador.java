
package proyecto1so;

/**
 *
 * @author victorpointud
 */

public class Ensamblador extends Trabajador {

    private Almacen almacen;
    private String compania;
    private int contadorComputadoras;
    private double gananciasTotales = 0;
    private int computadorasEnsambladas = 0;

    public Ensamblador(Almacen almacen, String compania) {
        super(50.0, 0, 0); 
        this.almacen = almacen;
        this.compania = compania;
        this.contadorComputadoras = 0;
    }

    @Override
    public void producir() {
        // No se utiliza en Ensamblador
    }

    public void ensamblarComputadora() {
        try {
            if (compania.equals("DELL")) {
                ensamblarDELL();
            } else if (compania.equals("HP")) {
                ensamblarHP();
            }
        } catch (InterruptedException e) {
            System.out.println("El ensamblaje fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }

    private void ensamblarDELL() throws InterruptedException {
        contadorComputadoras++;
        System.out.println("Intentando ensamblar una computadora DELL...");

        if (contadorComputadoras % 4 == 0) {
            // Ensamblar computadora con tarjeta gráfica
            if (almacen.retirarComponentes(1, 5, 6, 5, 1)) {
                System.out.println("Computadora DELL con tarjeta gráfica ensamblada.");
                gananciasTotales += 120000;
                computadorasEnsambladas++;
                System.out.println("Ganancias DELL: " + gananciasTotales + ", Computadoras ensambladas: " + computadorasEnsambladas);
            } else {
                System.out.println("No hay suficientes componentes para ensamblar una computadora DELL con tarjeta gráfica.");
            }
        } else {
            // Ensamblar computadora estándar
            if (almacen.retirarComponentes(1, 5, 6, 5, 0)) {
                System.out.println("Computadora estándar DELL ensamblada.");
                gananciasTotales += 80000;
                computadorasEnsambladas++;
                System.out.println("Ganancias DELL: " + gananciasTotales + ", Computadoras ensambladas: " + computadorasEnsambladas);
            } else {
                System.out.println("No hay suficientes componentes para ensamblar una computadora estándar DELL.");
            }
        }
    }

    private void ensamblarHP() throws InterruptedException {
        contadorComputadoras++;
        System.out.println("Intentando ensamblar una computadora HP...");
        if (contadorComputadoras % 3 == 0) {
            if (almacen.retirarComponentes(1, 1, 2, 4, 3)) {
                System.out.println("Computadora HP con tarjeta gráfica ensamblada.");
                gananciasTotales += 140000;
                computadorasEnsambladas++;
            } else {
                System.out.println("No hay suficientes componentes para ensamblar una computadora HP con tarjeta gráfica.");
            }
        } else {
            if (almacen.retirarComponentes(1, 1, 2, 4, 0)) {
                System.out.println("Computadora estándar HP ensamblada.");
                gananciasTotales += 90000;
                computadorasEnsambladas++;
            } else {
                System.out.println("No hay suficientes componentes para ensamblar una computadora estándar HP.");
            }
        }
    }

    public void trabajar() {
        System.out.println("Ensamblador de " + compania + " está ensamblando una computadora...");
        try {
            Thread.sleep(2000); // Simulación de 2 días (en milisegundos)
            ensamblarComputadora();
        } catch (InterruptedException e) {
            System.out.println("El ensamblaje fue interrumpido.");
            Thread.currentThread().interrupt(); // Volver a establecer el flag de interrupción
        }
    }

    public int getComputadorasEnsambladas() {
        return computadorasEnsambladas;
    }

    public double getGananciasTotales() {
        return gananciasTotales;
    }
}
