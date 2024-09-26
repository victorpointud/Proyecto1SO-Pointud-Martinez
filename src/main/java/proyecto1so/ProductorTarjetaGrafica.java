
package proyecto1so;

/**
 *
 * @author gabo2105MS
 */

public class ProductorTarjetaGrafica extends Trabajador {

    private Almacen almacen;

    public ProductorTarjetaGrafica(int produccionDiaria, int capacidadAlmacen, Almacen almacen) {
        super(34.0, capacidadAlmacen, produccionDiaria);
        this.almacen = almacen;
    }

    @Override
    public void producir() {
        if (almacen.getTarjetasGraficas() < almacen.getMaxTarjetasGraficas()) {
            cantidadProducida += produccionDiaria;
            if (cantidadProducida > capacidadAlmacen) {
                cantidadProducida = capacidadAlmacen;
            }
            almacen.añadirComponentes(0, 0, 0, 0, produccionDiaria);
            System.out.println("Productor de Tarjeta Gráfica ha producido " + produccionDiaria + " tarjetas gráficas.");
        } else {
            System.out.println("Almacén de Tarjetas Gráficas lleno, no se puede producir más.");
        }
    }
}
