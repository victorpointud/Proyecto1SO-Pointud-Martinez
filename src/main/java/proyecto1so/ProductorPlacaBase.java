
package proyecto1so;

/**
 *
 * @author gabo2105MS
 */

public class ProductorPlacaBase extends Trabajador {

    private Almacen almacen;

    public ProductorPlacaBase(int produccionDiaria, int capacidadAlmacen, Almacen almacen) {
        super(20.0, capacidadAlmacen, produccionDiaria);
        this.almacen = almacen;
    }

    @Override
    public void producir() {
        if (almacen.getPlacasBase() < almacen.getMaxPlacasBase()) {
            cantidadProducida += produccionDiaria;
            if (cantidadProducida > capacidadAlmacen) {
                cantidadProducida = capacidadAlmacen;
            }
            almacen.añadirComponentes(produccionDiaria, 0, 0, 0, 0);
            System.out.println("Productor de Placa Base ha producido " + produccionDiaria + " placas base.");
        } else {
            System.out.println("Almacén de Placas Base lleno, no se puede producir más.");
        }
    }
}
