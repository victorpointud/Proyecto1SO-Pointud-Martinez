package Worker;

/*
* made by: victorpointud
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

public class Developer extends Worker {

    private float productionPerDay;
    private float accumulatedProduction = 0;
    private final Drive drive;

    /**
     * Constructs a Developer with specified parameters.
     */
    public Developer(WorkerTypeNumber workerType, float productionPerDay, float costPerHour, Drive drive, Semaphore mutex, CompanyRules companyRules) {
        super(workerType, costPerHour, mutex, companyRules);
        this.productionPerDay = productionPerDay;
        this.drive = drive;
    }

    /**
     * Main run method for the Developer thread.
     */
    @Override
    public void run() {
        while (hired) {
            try {
                Work();
                sleep(getDayDuration());
            } catch (InterruptedException ex) {
                System.err.println("Developer run interrupted: " + ex.getMessage());
            }
        }
    }

    /**
     * Performs the work assigned to the Developer.
     */
    @Override
    public void Work() {
        accumulatedProduction += productionPerDay;
        daysWorked++;

        try {
            while (accumulatedProduction >= 1) {
                mutex.acquire();
                drive.addProduct(1, type);
                accumulatedProduction -= 1;
                if (accumulatedProduction < 1) {
                    accumulatedProduction = 0;
                }
                mutex.release();
            }

            updateProductionCost();

        } catch (InterruptedException ex) {
            System.err.println("Work process interrupted: " + ex.getMessage());
        }
    }

    /**
     * Updates the production cost in the drive based on the worker type.
     * @throws InterruptedException if the thread is interrupted during mutex acquisition/release.
     */
    private void updateProductionCost() throws InterruptedException {
        drive.getCostsMutex().acquire();

        switch (type) {
            case BasePlateProducer:
                drive.setBasePlateCost(drive.getBasePlateCost() + costPerHour * 24);
                break;
            case CPUProducer:
                drive.setCpuCost(drive.getCpuCost() + costPerHour * 24);
                break;
            case RAMProducer:
                drive.setRamCost(drive.getRamCost() + costPerHour * 24);
                break;
            case PowerSupplyProducer:
                drive.setPowerSupplyCost(drive.getPowerSupplyCost() + costPerHour * 24);
                break;
            case GraphicsCardProducer:
                drive.setGraphicsCardCost(drive.getGraphicsCardCost() + costPerHour * 24);
                break;
            default:
                break;
        }

        drive.getCostsMutex().release();
    }
}
