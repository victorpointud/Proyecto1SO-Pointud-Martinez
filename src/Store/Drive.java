package Store;

import Number.WorkerTypeNumber;
import java.util.concurrent.Semaphore;

/*
* made by: gabo2105MS
*/

public class Drive {
    private int basePlates;
    private int CPUs;
    private int RAMs;
    private int powerSupplies;
    private int graphicsCards;
    private int computers;
    private int computersWithGraphicsCard;
    private float utility;
    private final int maxBasePlates = 25;
    private final int maxCPUs = 20;
    private final int maxRAMs = 55;
    private final int maxPowerSupplies = 35;
    private final int maxGraphicsCards = 10;
    private Semaphore producerMutex = new Semaphore(1);
    private Semaphore consumerMutex = new Semaphore(1);
    private int daysUntilRelease;
    private Semaphore daysMutex = new Semaphore(1);
    private int directorStatus = 1;
    private int pmStatus = 0;
    private int faults = 0;
    private int salaryDiscount = 0;
    private Semaphore costsMutex = new Semaphore(1);
    private float basePlateCost = 20f;
    private float cpuCost = 26f;
    private float ramCost = 40f;
    private float powerSupplyCost = 16f;
    private float graphicsCardCost = 34f;
    private float integratorCost = 50f;
    private float pmCost = 40f;
    private float directorCost = 60f; 
    private float earnings = 0;
    private int computersReleasedSinceLastGraphicsCard = 0;
    
    public Drive(int basePlates, int CPUs, int RAMs, int powerSupplies, int graphicsCards) {
        this.basePlates = basePlates;
        this.CPUs = CPUs;
        this.RAMs = RAMs;
        this.powerSupplies = powerSupplies;
        this.graphicsCards = graphicsCards;
    }
    
    public Drive() {
        this.basePlates = 0;
        this.CPUs = 0;
        this.RAMs = 0;
        this.powerSupplies = 0;
        this.graphicsCards = 0;
    }
    
    public void addProduct(int productQty, WorkerTypeNumber type){
    
        switch(type) {
            case BasePlateProducer:
                basePlates = (basePlates + productQty > maxBasePlates) ? maxBasePlates : basePlates + productQty;
                break;
            case CPUProducer:
                CPUs = (CPUs + productQty > maxCPUs) ? maxCPUs : CPUs + productQty;
                break;
            case RAMProducer:
                RAMs = (RAMs + productQty > maxRAMs) ? maxRAMs : RAMs + productQty;
                break;
            case PowerSupplyProducer:
                powerSupplies = (powerSupplies + productQty > maxPowerSupplies) ? maxPowerSupplies : powerSupplies + productQty;
                break;
            case GraphicsCardProducer:
                graphicsCards = (graphicsCards + productQty > maxGraphicsCards) ? maxGraphicsCards : graphicsCards + productQty;
                break;
            default:
                break;
        }
    }

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

    public int getMaxBasePlates() {
        return maxBasePlates;
    }

    public int getMaxCPUs() {
        return maxCPUs;
    }

    public int getMaxRAMs() {
        return maxRAMs;
    }

    public int getMaxPowerSupplies() {
        return maxPowerSupplies;
    }

    public int getMaxGraphicsCards() {
        return maxGraphicsCards;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }
    
    public int getComputersWithGraphicsCard() {
        return computersWithGraphicsCard;
    }

    public void setComputersWithGraphicsCard(int computersWithGraphicsCard) {
        this.computersWithGraphicsCard = computersWithGraphicsCard;
    }

    public float getUtility() {
        return utility;
    }
    
    public void setUtility(float utility) {
        this.utility = utility;
    }

    public Semaphore getProducerMutex() {
        return producerMutex;
    }

    public void setProducerMutex(Semaphore producerMutex) {
        this.producerMutex = producerMutex;
    }

    public Semaphore getConsumerMutex() {
        return consumerMutex;
    }

    public void setConsumerMutex(Semaphore consumerMutex) {
        this.consumerMutex = consumerMutex;
    }

    public int getDaysUntilRelease() {
        return daysUntilRelease;
    }

    public void setDaysUntilRelease(int daysUntilRelease) {
        this.daysUntilRelease = daysUntilRelease;
    }

    public Semaphore getDaysMutex() {
        return daysMutex;
    }

    public void setDaysMutex(Semaphore daysMutex) {
        this.daysMutex = daysMutex;
    }

    public int getDirectorStatus() {
        return directorStatus;
    }

    public void setDirectorStatus(int directorStatus) {
        this.directorStatus = directorStatus;
    }

    public int getPmStatus() {
        return pmStatus;
    }

    public void setPmStatus(int pmStatus) {
        this.pmStatus = pmStatus;
    }

    public int getFaults() {
        return faults;
    }

    public void setFaults(int faults) {
        this.faults = faults;
    }

    public int getSalaryDiscount() {
        return salaryDiscount;
    }

    public void setSalaryDiscount(int salaryDiscount) {
        this.salaryDiscount = salaryDiscount;
    }

    public Semaphore getCostsMutex() {
        return costsMutex;
    }

    public void setCostsMutex(Semaphore costsMutex) {
        this.costsMutex = costsMutex;
    }

    public float getBasePlateCost() {
        return basePlateCost;
    }

    public void setBasePlateCost(float basePlateCost) {
        this.basePlateCost = basePlateCost;
    }

    public float getCpuCost() {
        return cpuCost;
    }

    public void setCpuCost(float cpuCost) {
        this.cpuCost = cpuCost;
    }

    public float getRamCost() {
        return ramCost;
    }

    public void setRamCost(float ramCost) {
        this.ramCost = ramCost;
    }

    public float getPowerSupplyCost() {
        return powerSupplyCost;
    }

    public void setPowerSupplyCost(float powerSupplyCost) {
        this.powerSupplyCost = powerSupplyCost;
    }

    public float getGraphicsCardCost() {
        return graphicsCardCost;
    }

    public void setGraphicsCardCost(float graphicsCardCost) {
        this.graphicsCardCost = graphicsCardCost;
    }

    public float getIntegratorCost() {
        return integratorCost;
    }

    public void setIntegratorCost(float integratorCost) {
        this.integratorCost = integratorCost;
    }

    public float getPmCost() {
        return pmCost;
    }

    public void setPmCost(float pmCost) {
        this.pmCost = pmCost;
    }

    public float getDirectorCost() {
        return directorCost;
    }

    public void setDirectorCost(float directorCost) {
        this.directorCost = directorCost;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public int getComputersReleasedSinceLastGraphicsCard() {
        return computersReleasedSinceLastGraphicsCard;
    }

    public void setComputersReleasedSinceLastGraphicsCard(int computersReleased) {
        this.computersReleasedSinceLastGraphicsCard = computersReleased;
    }
}
