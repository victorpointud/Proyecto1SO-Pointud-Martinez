package Store;

/*
* made by: gabo2105MS
*/

public class FileEntity {
    
    private int durationDay;
    private int deadLineDays;
    private int basePlates;
    private int CPUs;
    private int RAMs;
    private int powerSupplies;
    private int graphicsCards;
    private int integrators;
    
    /**
     * Default constructor for FileEntity.
     */
    public FileEntity(){}
    
    /**
     * Constructs a FileEntity with specified values for various components.
     */
    public FileEntity(int durationDay, int deadLineDays, int basePlates, int CPUs, int RAMs, int powerSupplies, int graphicsCards, int integrators) {
        this.durationDay = durationDay;
        this.deadLineDays = deadLineDays;
        this.basePlates = basePlates;
        this.CPUs = CPUs;
        this.RAMs = RAMs;
        this.powerSupplies = powerSupplies;
        this.graphicsCards = graphicsCards;
        this.integrators = integrators;
    }
    
    
    /**
     * Getters & Setters.
     */
    public int getBasePlates() {
        return basePlates;
    }

    public void setBasePlates(int basePlates) {
        this.basePlates = basePlates;
    }

    public int getCPUs() {
        return CPUs;
    }

    public void setCPUs(int CPUs) {
        this.CPUs = CPUs;
    }

    public int getRAMs() {
        return RAMs;
    }

    public void setRAMs(int RAMs) {
        this.RAMs = RAMs;
    }

    public int getPowerSupplies() {
        return powerSupplies;
    }

    public void setPowerSupplies(int powerSupplies) {
        this.powerSupplies = powerSupplies;
    }

    public int getGraphicsCards() {
        return graphicsCards;
    }

    public void setGraphicsCards(int graphicsCards) {
        this.graphicsCards = graphicsCards;
    }

    public int getDeadLineDays() {
        return deadLineDays;
    }

    public void setDeadLineDays(int deadLineDays) {
        this.deadLineDays = deadLineDays;
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
    }

    public int getIntegrators() {
        return integrators;
    }

    public void setIntegrators(int integrators) {
        this.integrators = integrators;
    }
}
