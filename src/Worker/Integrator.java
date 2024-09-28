package Worker;

/*
* made by: victorpointud
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Integrator extends Worker {

    private final Drive drive;
    private boolean makingComputer;
    private int computersToGraphicsCard;

    public Integrator(WorkerTypeNumber type, int computersToGraphicsCard, float cph, Drive drive, Semaphore m, CompanyRules gameRules) {
        super(type, cph, m, gameRules);
        this.drive = drive;
        this.makingComputer = false;
        this.computersToGraphicsCard = computersToGraphicsCard;
    }

    @Override
    public void run() {
        while (hired) {
            try {
                Work();
                if (makingComputer) {
                    sleep(2 * getDayDuration());
                    drive.getCostsMutex().acquire();
                    drive.setIntegratorCost(drive.getIntegratorCost() + costPerHour * 48);
                    drive.getCostsMutex().release();
                } 
                else {
                    sleep(getDayDuration());
                    drive.getCostsMutex().acquire();
                    drive.setIntegratorCost(drive.getIntegratorCost() + costPerHour * 24); 
                    drive.getCostsMutex().release();
                }
                this.makingComputer = false;
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Work() {
        this.daysWorked++;

        try {
            drive.getProducerMutex().acquire();
            boolean validation = (drive.getComputers() >= computersToGraphicsCard && drive.getComputers() % computersToGraphicsCard == 0)
                    ? companyRules.canAssembleComputerWithGraphicsCard(drive.getBasePlates(), drive.getCPUs(), drive.getRAMs(), drive.getPowerSupplies(), drive.getGraphicsCards())
                    : companyRules.canAssembleComputer(drive.getBasePlates(), drive.getCPUs(), drive.getRAMs(), drive.getPowerSupplies());
            if (validation) {
                drive.setBasePlates(drive.getBasePlates() - companyRules.getBasePlatesNeedIt());
                drive.setCPUs(drive.getCPUs() - companyRules.getCPUsNeedIt());
                drive.setRAMs(drive.getRAMs() - companyRules.getRAMsNeedIt());
                drive.setPowerSupplies(drive.getPowerSupplies() - companyRules.getPowerSuppliesNeedIt());
                drive.getConsumerMutex().acquire();
                if (drive.getComputers() >= computersToGraphicsCard && drive.getComputers() % computersToGraphicsCard == 0) {
                    drive.setGraphicsCards(drive.getGraphicsCards() - companyRules.getGraphicsCardsNeedIt()); 
                }
                if (drive.getComputersReleasedSinceLastGraphicsCard() != computersToGraphicsCard) {
                    drive.setComputers(drive.getComputers() + 1);
                    drive.setComputersReleasedSinceLastGraphicsCard(drive.getComputersReleasedSinceLastGraphicsCard() + 1);
                } 
                else {
                    drive.setComputersWithGraphicsCard(drive.getComputersWithGraphicsCard() + 1);
                    drive.setComputersReleasedSinceLastGraphicsCard(0);
                }
                drive.getConsumerMutex().release();
                makingComputer = true; 
            }

            drive.getProducerMutex().release();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
