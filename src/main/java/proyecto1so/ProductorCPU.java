
package proyecto1so;

/**
 *
 * @author gabo2105MS
 */

public class ProductorCPU extends Trabajador {

    private Almacen almacen;

    public ProductorCPU(int produccionDiaria, int capacidadAlmacen, Almacen almacen) {
        super(26.0, capacidadAlmacen, produccionDiaria); 
        this.almacen = almacen;
    }

    public void producir() {
        
        if (almacen.getCpus() < almacen.getMaxCpus()) {
            cantidadProducida += produccionDiaria;
            if (cantidadProducida > capacidadAlmacen) {
                cantidadProducida = capacidadAlmacen;
            }
            
            almacen.añadirComponentes(0, produccionDiaria, 0, 0, 0);
            System.out.println("Productor de CPU ha producido " + produccionDiaria + " CPUs.");
        } else {
            System.out.println("Almacén de CPUs lleno, no se puede producir más.");
        }
    }
}
