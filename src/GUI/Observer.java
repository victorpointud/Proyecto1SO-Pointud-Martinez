package GUI;

import Companies.Company;

/*
* made by: victorpointud
*/


public class Observer extends Thread {

    private CompanyFrame window;
    private Company company;
    public Observer(CompanyFrame window, Company company) {
        this.window = window;
        this.company = company;
    }

    @Override
    public void run() {
        while (true) {
            if (window.getBasePlatesProgress().getValue() != company.getDrive().getBasePlates()) {
                window.getBasePlatesProgress().setValue(company.getDrive().getBasePlates());
                window.gettextBasePlate().setText(String.valueOf(company.getDrive().getBasePlates()));
            }
            if (window.getCPUProgress().getValue() != company.getDrive().getCPUs()) {
                window.getCPUProgress().setValue(company.getDrive().getCPUs());
                window.gettextCPU().setText(String.valueOf(company.getDrive().getCPUs()));
            }
            if (window.getRAMProgress().getValue() != company.getDrive().getRAMs()) {
                window.getRAMProgress().setValue(company.getDrive().getRAMs());
                window.getTextRAM().setText(String.valueOf(company.getDrive().getRAMs()));
            }
            if (window.getPowerSupplyProgress().getValue() != company.getDrive().getPowerSupplies()) {
                window.getPowerSupplyProgress().setValue(company.getDrive().getPowerSupplies());
                window.gettextPowerSupply().setText(String.valueOf(company.getDrive().getPowerSupplies()));
            }
            if (window.getGraphicCardProgress().getValue() != company.getDrive().getGraphicsCards()) {
                window.getGraphicCardProgress().setValue(company.getDrive().getGraphicsCards());
                window.gettextGraphicCard().setText(String.valueOf(company.getDrive().getGraphicsCards()));
            }
            float costos = company.getDrive().getBasePlateCost() + company.getDrive().getCpuCost() + company.getDrive().getRamCost()
                    + company.getDrive().getPowerSupplyCost() + company.getDrive().getGraphicsCardCost()
                    + company.getDrive().getIntegratorCost() + company.getDrive().getPmCost() + company.getDrive().getDirectorCost();
            window.getCompanyCosts().setText(String.valueOf(costos));
            if (company.getDrive().getEarnings() < 1000) {
                window.getCompanyEarnings().setText(String.valueOf(company.getDrive().getEarnings()));
            } 
            else {
                window.getCompanyEarnings().setText(String.valueOf(company.getDrive().getEarnings() / 1000) + " K");
            }

            if ((company.getDrive().getEarnings() - costos) < 1000) {
                window.getCompanyUtilitys().setText(String.valueOf(company.getDrive().getEarnings() - costos));
            } 
            else {
                window.getCompanyUtilitys().setText(String.valueOf((company.getDrive().getEarnings() - costos) / 1000) + " K");
            }
            if (company.getDrive().getDirectorStatus() == 0) {
                window.getStatusDirector().setText("Revisando");
            } 
            else {
                window.getStatusDirector().setText("Trabajando");
            }
            if (company.getDrive().getPmStatus() == 0) {
                window.getStatusPM().setText("Trabajando");
            } 
            else {
                window.getStatusPM().setText("Viendo anime");
            }
            if (company.getDrive().getFaults() != Integer.parseInt(window.getFaults().getText())) {
                window.getFaults().setText(String.valueOf(company.getDrive().getFaults()));
            }
            if (company.getDrive().getBasePlateCost() < 1000) {
                window.getBasePlateCost().setText(String.valueOf(company.getDrive().getBasePlateCost()));
            } 
            else {
                window.getBasePlateCost().setText(String.valueOf(company.getDrive().getBasePlateCost() / 1000) + " K");
            }
            if (company.getDrive().getCpuCost() < 1000) {
                window.getCPUCost().setText(String.valueOf(company.getDrive().getCpuCost()));
            } 
            else {
                window.getCPUCost().setText(String.valueOf(company.getDrive().getCpuCost() / 1000) + " K");
            }
            if (company.getDrive().getRamCost() < 1000) {
                window.getRAMCost().setText(String.valueOf(company.getDrive().getRamCost()));
            } 
            else {
                window.getRAMCost().setText(String.valueOf(company.getDrive().getRamCost() / 1000) + " K");
            }
            if (company.getDrive().getPowerSupplyCost() < 1000) {
                window.getPowerSupplyCost().setText(String.valueOf(company.getDrive().getPowerSupplyCost()));
            } 
            else {
                window.getPowerSupplyCost().setText(String.valueOf(company.getDrive().getPowerSupplyCost() / 1000) + " K");
            }
            if (company.getDrive().getGraphicsCardCost() < 1000) {
                window.getGraphicCardCost().setText(String.valueOf(company.getDrive().getGraphicsCardCost()));
            } 
            else {
                window.getGraphicCardCost().setText(String.valueOf(company.getDrive().getGraphicsCardCost() / 1000) + " K");
            }
            if (company.getDrive().getIntegratorCost() < 1000) {
                window.getIntegratorCost().setText(String.valueOf(company.getDrive().getIntegratorCost()));
            } 
            else {
                window.getIntegratorCost().setText(String.valueOf(company.getDrive().getIntegratorCost() / 1000) + " K");
            }
            if (company.getDrive().getPmCost() < 1000) {
                window.getcostPM().setText(String.valueOf(company.getDrive().getPmCost()));
            } 
            else {
                window.getcostPM().setText(String.valueOf(company.getDrive().getPmCost() / 1000) + " K");
            }
            if (company.getDrive().getDirectorCost() < 1000) {
                window.getDirectorCosts().setText(String.valueOf(company.getDrive().getDirectorCost()));
            } 
            else {
                window.getDirectorCosts().setText(String.valueOf(company.getDrive().getDirectorCost() / 1000) + " K");
            }
            if (company.getDrive().getDaysUntilRelease() != Integer.parseInt(window.getCountDown().getText())) {
                window.getCountDown().setText(String.valueOf(company.getDrive().getDaysUntilRelease()));
            }
            if (company.getDrive().getComputers() != Integer.parseInt(window.getNormalPCQuantity().getText())) {
                window.getNormalPCQuantity().setText(String.valueOf(company.getDrive().getComputers()));
            }
            if (company.getDrive().getComputersWithGraphicsCard() != Integer.parseInt(window.getGraphicPCQuantity().getText())) {
                window.getGraphicPCQuantity().setText(String.valueOf(company.getDrive().getComputersWithGraphicsCard()));
            }
        }
    }

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
