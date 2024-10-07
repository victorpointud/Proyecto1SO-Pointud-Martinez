package Worker;

/*
* made by: victorpointud
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Integrator extends Worker {

    private final Drive drive;
    private boolean assemblingComputer;
    private final int computersRequiredPerGraphicsCard;

    /**
     * Constructs an Integrator object with the given parameters.
     */
    public Integrator(WorkerTypeNumber type, int computersRequiredPerGraphicsCard, float costPerHour, Drive drive, Semaphore mutex, CompanyRules companyRules) {
        super(type, costPerHour, mutex, companyRules);
        this.drive = drive;
        this.assemblingComputer = false;
        this.computersRequiredPerGraphicsCard = computersRequiredPerGraphicsCard;
    }

    /**
     * Runs the integrator worker while hired. Handles the work process and cost calculations.
     */
    @Override
    public void run() {
        while (hired) {
            try {
                Work();
                if (assemblingComputer) {
                    sleep(2 * getDayDuration());
                    adjustIntegratorCost(costPerHour * 48);
                } else {
                    sleep(getDayDuration());
                    adjustIntegratorCost(costPerHour * 24);
                }
                assemblingComputer = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, "Thread interrupted", ex);
            }
        }
    }

    /**
     * Performs the work of assembling computers. Handles production logic based on resources available.
     */
    @Override
    public void Work() {
        this.daysWorked++;

        try {
            drive.getProducerMutex().acquire();

            boolean isGraphicsCardRequired = (drive.getComputers() >= computersRequiredPerGraphicsCard
                    && drive.getComputers() % computersRequiredPerGraphicsCard == 0);
            
            boolean canAssemble = isGraphicsCardRequired
                    ? companyRules.canAssembleComputerWithGraphicsCard(drive.getBasePlates(), drive.getCPUs(), drive.getRAMs(), drive.getPowerSupplies(), drive.getGraphicsCards())
                    : companyRules.canAssembleComputer(drive.getBasePlates(), drive.getCPUs(), drive.getRAMs(), drive.getPowerSupplies());

            if (canAssemble) {
                consumeComponents(isGraphicsCardRequired);
                updateProductionStatus();
                assemblingComputer = true;
            }

            drive.getProducerMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Integrator.class.getName()).log(Level.SEVERE, "Work process interrupted", ex);
        }
    }

    /**
     * Consumes the necessary components for assembling a computer.
     * @throws InterruptedException if thread operation is interrupted.
     */
    private void consumeComponents(boolean requiresGraphicsCard) throws InterruptedException {
        drive.setBasePlates(drive.getBasePlates() - companyRules.getBasePlatesNeedIt());
        drive.setCPUs(drive.getCPUs() - companyRules.getCPUsNeedIt());
        drive.setRAMs(drive.getRAMs() - companyRules.getRAMsNeedIt());
        drive.setPowerSupplies(drive.getPowerSupplies() - companyRules.getPowerSuppliesNeedIt());

        drive.getConsumerMutex().acquire();
        if (requiresGraphicsCard) {
            drive.setGraphicsCards(drive.getGraphicsCards() - companyRules.getGraphicsCardsNeedIt());
        }
    }

    /**
     * Updates the production status of the computers being assembled.
     */
    private void updateProductionStatus() {
        if (drive.getComputersReleasedSinceLastGraphicsCard() != computersRequiredPerGraphicsCard) {
            drive.setComputers(drive.getComputers() + 1);
            drive.setComputersReleasedSinceLastGraphicsCard(drive.getComputersReleasedSinceLastGraphicsCard() + 1);
        } else {
            drive.setComputersWithGraphicsCard(drive.getComputersWithGraphicsCard() + 1);
            drive.setComputersReleasedSinceLastGraphicsCard(0);
        }
        drive.getConsumerMutex().release();
    }

    /**
     * Adjusts the cost of the integrator worker.
     * @throws InterruptedException if thread operation is interrupted.
     */
    private void adjustIntegratorCost(float additionalCost) throws InterruptedException {
        drive.getCostsMutex().acquire();
        drive.setIntegratorCost(drive.getIntegratorCost() + additionalCost);
        drive.getCostsMutex().release();
    }
}
