package GUI;

import Companies.Company;

/*
* made by: victorpointud
*/

/**
 * Observer class that continuously monitors the state of the company and updates the GUI accordingly.
 */
public class Observer extends Thread {

    private CompanyFrame window;
    private Company company;
    
    /**
     * Constructs an Observer that monitors a given company and updates a given window.
     */
    public Observer(CompanyFrame window, Company company) {
        this.window = window;
        this.company = company;
    }
    
    @Override
    public void run() {
        while (true) {
            if (window.getBasePlatesProgress().getValue() != company.getCompanyDrive().getBasePlates()) {
                window.getBasePlatesProgress().setValue(company.getCompanyDrive().getBasePlates());
                window.gettextBasePlate().setText(String.valueOf(company.getCompanyDrive().getBasePlates()));
            }
            if (window.getCPUProgress().getValue() != company.getCompanyDrive().getCPUs()) {
                window.getCPUProgress().setValue(company.getCompanyDrive().getCPUs());
                window.gettextCPU().setText(String.valueOf(company.getCompanyDrive().getCPUs()));
            }
            if (window.getRAMProgress().getValue() != company.getCompanyDrive().getRAMs()) {
                window.getRAMProgress().setValue(company.getCompanyDrive().getRAMs());
                window.getTextRAM().setText(String.valueOf(company.getCompanyDrive().getRAMs()));
            }
            if (window.getPowerSupplyProgress().getValue() != company.getCompanyDrive().getPowerSupplies()) {
                window.getPowerSupplyProgress().setValue(company.getCompanyDrive().getPowerSupplies());
                window.gettextPowerSupply().setText(String.valueOf(company.getCompanyDrive().getPowerSupplies()));
            }
            if (window.getGraphicCardProgress().getValue() != company.getCompanyDrive().getGraphicsCards()) {
                window.getGraphicCardProgress().setValue(company.getCompanyDrive().getGraphicsCards());
                window.gettextGraphicCard().setText(String.valueOf(company.getCompanyDrive().getGraphicsCards()));
            }
            float costos = company.getCompanyDrive().getBasePlateCost() + company.getCompanyDrive().getCpuCost() + company.getCompanyDrive().getRamCost()
                    + company.getCompanyDrive().getPowerSupplyCost() + company.getCompanyDrive().getGraphicsCardCost()
                    + company.getCompanyDrive().getIntegratorCost() + company.getCompanyDrive().getPmCost() + company.getCompanyDrive().getDirectorCost();
            window.getCompanyCosts().setText(String.valueOf(costos));
            if (company.getCompanyDrive().getEarnings() < 1000) {
                window.getCompanyEarnings().setText(String.valueOf(company.getCompanyDrive().getEarnings()));
            } 
            else {
                window.getCompanyEarnings().setText(String.valueOf(company.getCompanyDrive().getEarnings() / 1000) + " K");
            }

            if ((company.getCompanyDrive().getEarnings() - costos) < 1000) {
                window.getCompanyUtilitys().setText(String.valueOf(company.getCompanyDrive().getEarnings() - costos));
            } 
            else {
                window.getCompanyUtilitys().setText(String.valueOf((company.getCompanyDrive().getEarnings() - costos) / 1000) + " K");
            }
            if (company.getCompanyDrive().getDirectorStatus() == 0) {
                window.getStatusDirector().setText("Revisando");
            } 
            else {
                window.getStatusDirector().setText("Trabajando");
            }
            if (company.getCompanyDrive().getPmStatus() == 0) {
                window.getStatusPM().setText("Trabajando");
            } 
            else {
                window.getStatusPM().setText("Viendo anime");
            }
            if (company.getCompanyDrive().getFaults() != Integer.parseInt(window.getFaults().getText())) {
                window.getFaults().setText(String.valueOf(company.getCompanyDrive().getFaults()));
            }
            if (company.getCompanyDrive().getBasePlateCost() < 1000) {
                window.getBasePlateCost().setText(String.valueOf(company.getCompanyDrive().getBasePlateCost()));
            } 
            else {
                window.getBasePlateCost().setText(String.valueOf(company.getCompanyDrive().getBasePlateCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getCpuCost() < 1000) {
                window.getCPUCost().setText(String.valueOf(company.getCompanyDrive().getCpuCost()));
            } 
            else {
                window.getCPUCost().setText(String.valueOf(company.getCompanyDrive().getCpuCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getRamCost() < 1000) {
                window.getRAMCost().setText(String.valueOf(company.getCompanyDrive().getRamCost()));
            } 
            else {
                window.getRAMCost().setText(String.valueOf(company.getCompanyDrive().getRamCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getPowerSupplyCost() < 1000) {
                window.getPowerSupplyCost().setText(String.valueOf(company.getCompanyDrive().getPowerSupplyCost()));
            } 
            else {
                window.getPowerSupplyCost().setText(String.valueOf(company.getCompanyDrive().getPowerSupplyCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getGraphicsCardCost() < 1000) {
                window.getGraphicCardCost().setText(String.valueOf(company.getCompanyDrive().getGraphicsCardCost()));
            } 
            else {
                window.getGraphicCardCost().setText(String.valueOf(company.getCompanyDrive().getGraphicsCardCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getIntegratorCost() < 1000) {
                window.getIntegratorCost().setText(String.valueOf(company.getCompanyDrive().getIntegratorCost()));
            } 
            else {
                window.getIntegratorCost().setText(String.valueOf(company.getCompanyDrive().getIntegratorCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getPmCost() < 1000) {
                window.getcostPM().setText(String.valueOf(company.getCompanyDrive().getPmCost()));
            } 
            else {
                window.getcostPM().setText(String.valueOf(company.getCompanyDrive().getPmCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getDirectorCost() < 1000) {
                window.getDirectorCosts().setText(String.valueOf(company.getCompanyDrive().getDirectorCost()));
            } 
            else {
                window.getDirectorCosts().setText(String.valueOf(company.getCompanyDrive().getDirectorCost() / 1000) + " K");
            }
            if (company.getCompanyDrive().getDaysUntilRelease() != Integer.parseInt(window.getCountDown().getText())) {
                window.getCountDown().setText(String.valueOf(company.getCompanyDrive().getDaysUntilRelease()));
            }
            if (company.getCompanyDrive().getComputers() != Integer.parseInt(window.getNormalPCQuantity().getText())) {
                window.getNormalPCQuantity().setText(String.valueOf(company.getCompanyDrive().getComputers()));
            }
            if (company.getCompanyDrive().getComputersWithGraphicsCard() != Integer.parseInt(window.getGraphicPCQuantity().getText())) {
                window.getGraphicPCQuantity().setText(String.valueOf(company.getCompanyDrive().getComputersWithGraphicsCard()));
            }
        }       
    }

     /**
     * Getters & Setters.
     */
    public CompanyFrame getWindow() {
        return window;
    }

    public void setWindow(CompanyFrame window) {
        this.window = window;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
