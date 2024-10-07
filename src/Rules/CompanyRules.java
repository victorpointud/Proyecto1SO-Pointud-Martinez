package Rules;

import Number.CompanyNumber;

/*
* made by: victorpointud
*/

public class CompanyRules {
    protected int basePlatesNeedIt;
    protected int CPUsNeedIt;
    protected int RAMsNeedIt;
    protected int powerSuppliesNeedIt;
    protected int graphicsCardsNeedIt;
    protected float income; 
    protected float incomeWithGraphicsCard;
    protected int computersToGraphicsCard;
    protected int employees;
    private float basePlateCost = 20f;
    private float cpuCost = 26f;
    private float ramCost = 40f;
    private float powerSupplyCost = 16f;
    private float graphicsCardCost = 34f;
    private float integratorCost = 50f;
    private float pmCost = 40f;
    private float directorCost = 60f;
    protected float basePlatesProductionPerDay;
    protected float CPUsProductionPerDay;
    protected float RAMsProductionPerDay;
    protected float powerSuppliesProductionPerDay;
    protected float graphicsCardsProductionPerDay;
    protected String logo;
    protected String background;

    protected CompanyNumber companyNumber;

    /**
     * Checks if it is possible to assemble a computer with the available resources.
     * @return true if a computer can be assembled, false otherwise.
     */
    public boolean canAssembleComputer(int basePlates, int CPUs, int RAMs, int powerSupplies) {
        return (basePlates >= this.basePlatesNeedIt && CPUs >= this.CPUsNeedIt && RAMs >= this.RAMsNeedIt && powerSupplies >= this.powerSuppliesNeedIt);
    }
    
    /**
     * Checks if it is possible to assemble a computer with a graphics card.
     * @return true if a computer with a graphics card can be assembled, false otherwise.
     */
    public boolean canAssembleComputerWithGraphicsCard(int basePlates, int CPUs, int RAMs, int powerSupplies, int graphicsCards) {
        return (basePlates >= this.basePlatesNeedIt && CPUs >= this.CPUsNeedIt && RAMs >= this.RAMsNeedIt && powerSupplies >= this.powerSuppliesNeedIt && graphicsCards >= this.graphicsCardsNeedIt);
    }

    /**
     * Getters & Setters.
     */
    public float getIncome() {
        return income;
    }

    public float getIncomeWithGraphicsCard() {
        return incomeWithGraphicsCard;
    }

    public int getBasePlatesNeedIt() {
        return basePlatesNeedIt;
    }

    public int getCPUsNeedIt() {
        return CPUsNeedIt;
    }

    public int getRAMsNeedIt() {
        return RAMsNeedIt;
    }

    public int getPowerSuppliesNeedIt() {
        return powerSuppliesNeedIt;
    }

    public int getGraphicsCardsNeedIt() {
        return graphicsCardsNeedIt;
    }

    public int getEmployees() {
        return employees;
    }

    public float getBasePlateCost() {
        return basePlateCost;
    }

    public float getCpuCost() {
        return cpuCost;
    }

    public float getRamCost() {
        return ramCost;
    }

    public float getPowerSupplyCost() {
        return powerSupplyCost;
    }

    public float getGraphicsCardCost() {
        return graphicsCardCost;
    }

    public float getIntegratorCost() {
        return integratorCost;
    }

    public float getBasePlatesProductionPerDay() {
        return basePlatesProductionPerDay;
    }

    public float getCPUsProductionPerDay() {
        return CPUsProductionPerDay;
    }

    public float getRAMsProductionPerDay() {
        return RAMsProductionPerDay;
    }

    public float getPowerSuppliesProductionPerDay() {
        return powerSuppliesProductionPerDay;
    }

    public float getGraphicsCardsProductionPerDay() {
        return graphicsCardsProductionPerDay;
    }

    public int getComputersToGraphicsCard() {
        return computersToGraphicsCard;
    }

    public float getPmCost() {
        return pmCost;
    }

    public float getDirectorCost() {
        return directorCost;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public CompanyNumber getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(CompanyNumber companyNumber) {
        this.companyNumber = companyNumber;
    }
}
