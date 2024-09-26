
package proyecto1so;

/**
 *
 * @author gabo2105MS
 */

public class ProductorFuenteAlimentacion extends Trabajador {

    private Almacen almacen;

    public ProductorFuenteAlimentacion(int produccionDiaria, int capacidadAlmacen, Almacen almacen) {
        super(16.0, capacidadAlmacen, produccionDiaria); // $16 por hora
        this.almacen = almacen;
    }

    @Override
    public void producir() {
        // Verificar si hay espacio para más fuentes de alimentación
        if (almacen.getFuentesAlimentacion() < almacen.getMaxFuentesAlimentacion()) {
            cantidadProducida += produccionDiaria;
            if (cantidadProducida > capacidadAlmacen) {
                cantidadProducida = capacidadAlmacen;
            }
            // Añadir fuentes de alimentación al almacén
            almacen.añadirComponentes(0, 0, 0, produccionDiaria, 0);
            System.out.println("Productor de Fuente de Alimentación ha producido " + produccionDiaria + " fuentes.");
        } else {
            System.out.println("Almacén de Fuentes de Alimentación lleno, no se puede producir más.");
        }
    }
}
