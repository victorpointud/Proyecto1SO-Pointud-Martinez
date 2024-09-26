
package proyecto1so;

/**
 *
 * @author gabo2105MS
 */

public class ProductorMemoriaRAM extends Trabajador {

    private Almacen almacen;

    public ProductorMemoriaRAM(int produccionDiaria, int capacidadAlmacen, Almacen almacen) {
        super(40.0, capacidadAlmacen, produccionDiaria);
        this.almacen = almacen;
    }

    @Override
    public void producir() {
        if (almacen.getMemoriasRam() < almacen.getMaxMemoriasRam()) {
            cantidadProducida += produccionDiaria;
            if (cantidadProducida > capacidadAlmacen) {
                cantidadProducida = capacidadAlmacen;
            }
            almacen.añadirComponentes(0, 0, produccionDiaria, 0, 0);
            System.out.println("Productor de Memoria RAM ha producido " + produccionDiaria + " memorias RAM.");
        } else {
            System.out.println("Almacén de Memorias RAM lleno, no se puede producir más.");
        }
    }
}
