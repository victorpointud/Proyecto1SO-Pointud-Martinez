
package proyecto1so;

/**
 *
 * @author victorpointud
 */

public class Almacen {

    
    private int placasBase;
    private int cpus;
    private int memoriasRam;
    private int fuentesAlimentacion;
    private int tarjetasGraficas;
    private final int maxPlacasBase = 25;
    private final int maxCpus = 20;
    private final int maxMemoriasRam = 55;
    private final int maxFuentesAlimentacion = 35;
    private final int maxTarjetasGraficas = 10;

    public Almacen() {
        this.placasBase = 0;
        this.cpus = 0;
        this.memoriasRam = 0;
        this.fuentesAlimentacion = 0;
        this.tarjetasGraficas = 0;
    }

    public synchronized void añadirComponentes(int placasBase, int cpus, int memoriasRam, int fuentesAlimentacion, int tarjetasGraficas) {
        this.placasBase += placasBase;
        this.cpus += cpus;
        this.memoriasRam += memoriasRam;
        this.fuentesAlimentacion += fuentesAlimentacion;
        this.tarjetasGraficas += tarjetasGraficas;

        if (this.placasBase > maxPlacasBase) this.placasBase = maxPlacasBase;
        if (this.cpus > maxCpus) this.cpus = maxCpus;
        if (this.memoriasRam > maxMemoriasRam) this.memoriasRam = maxMemoriasRam;
        if (this.fuentesAlimentacion > maxFuentesAlimentacion) this.fuentesAlimentacion = maxFuentesAlimentacion;
        if (this.tarjetasGraficas > maxTarjetasGraficas) this.tarjetasGraficas = maxTarjetasGraficas;

        System.out.println("Componentes añadidos al almacén: " +
                "Placas Base: " + this.placasBase +
                ", CPUs: " + this.cpus +
                ", Memorias RAM: " + this.memoriasRam +
                ", Fuentes de Alimentación: " + this.fuentesAlimentacion +
                ", Tarjetas Gráficas: " + this.tarjetasGraficas + "\n");
    }

    public synchronized boolean retirarComponentes(int placasBase, int cpus, int memoriasRam, int fuentesAlimentacion, int tarjetasGraficas) {
    System.out.println("Intentando retirar componentes: " +
            "Placas Base: " + placasBase + ", CPUs: " + cpus +
            ", Memorias RAM: " + memoriasRam + ", Fuentes de Alimentación: " + fuentesAlimentacion +
            ", Tarjetas Gráficas: " + tarjetasGraficas);

    System.out.println("Componentes disponibles: " +
            "Placas Base: " + this.placasBase + ", CPUs: " + this.cpus +
            ", Memorias RAM: " + this.memoriasRam + ", Fuentes de Alimentación: " + this.fuentesAlimentacion +
            ", Tarjetas Gráficas: " + this.tarjetasGraficas);

    if (this.placasBase >= placasBase && this.cpus >= cpus && this.memoriasRam >= memoriasRam &&
            this.fuentesAlimentacion >= fuentesAlimentacion && this.tarjetasGraficas >= tarjetasGraficas) {
        this.placasBase -= placasBase;
        this.cpus -= cpus;
        this.memoriasRam -= memoriasRam;
        this.fuentesAlimentacion -= fuentesAlimentacion;
        this.tarjetasGraficas -= tarjetasGraficas;

        System.out.println("Componentes retirados. Nuevas cantidades: " +
                "Placas Base: " + this.placasBase +
                ", CPUs: " + this.cpus +
                ", Memorias RAM: " + this.memoriasRam +
                ", Fuentes de Alimentación: " + this.fuentesAlimentacion +
                ", Tarjetas Gráficas: " + this.tarjetasGraficas);
        return true;
    } else {
        System.out.println("No hay suficientes componentes para retirar.");
        return false;
    }
}
    public synchronized int getPlacasBase() {
        return placasBase;
    }

    public synchronized int getCpus() {
        return cpus;
    }

    public synchronized int getMemoriasRam() {
        return memoriasRam;
    }

    public synchronized int getFuentesAlimentacion() {
        return fuentesAlimentacion;
    }

    public synchronized int getTarjetasGraficas() {
        return tarjetasGraficas;
    }

    public int getMaxPlacasBase() {
        return maxPlacasBase;
    }

    public int getMaxCpus() {
        return maxCpus;
    }

    public int getMaxMemoriasRam() {
        return maxMemoriasRam;
    }

    public int getMaxFuentesAlimentacion() {
        return maxFuentesAlimentacion;
    }

    public int getMaxTarjetasGraficas() {
        return maxTarjetasGraficas;
    }
}
