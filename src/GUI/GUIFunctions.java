package GUI;

import Companies.Company;
import Number.CompanyNumber;
import Rules.HPRules;
import Rules.DELLRules;
import Store.Drive;
import Store.FileEntity;
import Store.JSONStore;
import java.io.IOException;
import main.Global;

/*
* made by: victorpointud
*/

public class GUIFunctions {

    /**
     * Opens the simulation for the specified company or for both companies.
     */
    public static void openSim(int company) {
        if (company == 0) {
            HPRules hpRules = new HPRules();
            Drive hpDrive = new Drive();
            JSONStore storeJSON = new JSONStore();
            FileEntity entity;
            Company HP;
            try {
                entity = storeJSON.GetFile(CompanyNumber.HP);
            } 
            catch (IOException e) {
                entity = null;
            }
            if (entity != null) {
                HP = new Company(entity.getBasePlates(), entity.getCPUs(), entity.getGraphicsCards(), entity.getIntegrators(), entity.getPowerSupplies(), entity.getRAMs(), hpDrive, hpRules);
                Global.daysDuration = entity.getDurationDay();
                Global.daysBetweenReleases = entity.getDeadLineDays();
            } 
            else {
                HP = new Company(1, 1, 1, 1, 1, 1, hpDrive, hpRules);
                Global.daysDuration = 500f;
                Global.daysBetweenReleases = 15;
            }
            CompanyFrame companyFrame = new CompanyFrame(HP);
            Observer render = new Observer(companyFrame, HP);
            render.start();
            Chart hpChart = new Chart(HP, 1, null);
            companyFrame.setVisible(true);

        } 
        else if (company == 1) {
            DELLRules dellRules = new DELLRules();
            Drive dellDrive = new Drive();
            JSONStore storeJSON = new JSONStore();
            FileEntity entity;
            Company DELL;
            try {
                entity = storeJSON.GetFile(CompanyNumber.DELL);
            } catch (IOException e) {
                entity = null;
            }
            if (entity != null) {
                DELL = new Company(entity.getBasePlates(), entity.getCPUs(), entity.getGraphicsCards(), entity.getIntegrators(),
                        entity.getPowerSupplies(), entity.getRAMs(), dellDrive, dellRules);
                Global.daysDuration = entity.getDurationDay();
                Global.daysBetweenReleases = entity.getDeadLineDays();
            } else {
                DELL = new Company(1, 1, 1, 1, 1, 1, dellDrive, dellRules);
                Global.daysDuration = 500f;
                Global.daysBetweenReleases = 15;
            }
            CompanyFrame companyFrame = new CompanyFrame(DELL);
            Observer render = new Observer(companyFrame, DELL);
            render.start();
            Chart chart = new Chart(DELL, 2, null);
            companyFrame.setVisible(true);

        } 
        else {
            HPRules hpRules = new HPRules();
            Drive hpDrive = new Drive();
            JSONStore storeJSON = new JSONStore();
            FileEntity entity;
            Company HP;
            try {
                entity = storeJSON.GetFile(CompanyNumber.HP);
            } 
            catch (IOException e) {
                entity = null;
            }

            if (entity != null) {
                HP = new Company(entity.getBasePlates(), entity.getCPUs(), entity.getGraphicsCards(), entity.getIntegrators(),
                        entity.getPowerSupplies(), entity.getRAMs(), hpDrive, hpRules);
                Global.daysDuration = entity.getDurationDay();
            } 
            else {
                HP = new Company(1, 1, 1, 1, 1, 1, hpDrive, hpRules);
            }
            CompanyFrame companyFrame = new CompanyFrame(HP);
            Observer render = new Observer(companyFrame, HP);
            render.start();
            companyFrame.setVisible(true);
            DELLRules dellRules = new DELLRules();
            Drive dellDrive = new Drive();
            Company DELL;
            try {
                entity = storeJSON.GetFile(CompanyNumber.DELL);
            } 
            catch (IOException e) {
                entity = null;
            }
            if (entity != null) {
                DELL = new Company(entity.getBasePlates(), entity.getCPUs(), entity.getGraphicsCards(), entity.getIntegrators(),
                        entity.getPowerSupplies(), entity.getRAMs(), dellDrive, dellRules);
            } 
            else {
                DELL = new Company(1, 1, 1, 1, 1, 1, dellDrive, dellRules);
            }
            CompanyFrame company2Frame = new CompanyFrame(DELL);
            Observer render2 = new Observer(company2Frame, DELL);
            render2.start();
            Chart dellVsHPChart = new Chart(HP, 3, DELL);
            company2Frame.setVisible(true);
        }
    }
    
}
