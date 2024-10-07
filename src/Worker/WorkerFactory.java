package Worker;

/*
* made by: gabo2105MS
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

public class WorkerFactory {

    /**
     * Creates a new worker based on the specified type.
     * @return A new Worker instance based on the given type, or null if the type is not recognized.
     */
    public Worker makeWorker(WorkerTypeNumber workerType, Drive drive, Semaphore mutex, CompanyRules companyRules) {

        if (workerType == null) {
            return null;
        }

        if (workerType == WorkerTypeNumber.BasePlateProducer) {
            return new Developer(workerType, companyRules.getBasePlatesProductionPerDay(), companyRules.getBasePlateCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.CPUProducer) {
            return new Developer(workerType, companyRules.getCPUsProductionPerDay(), companyRules.getCpuCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.RAMProducer) {
            return new Developer(workerType, companyRules.getRAMsProductionPerDay(), companyRules.getRamCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.PowerSupplyProducer) {
            return new Developer(workerType, companyRules.getPowerSuppliesProductionPerDay(), companyRules.getPowerSupplyCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.GraphicsCardProducer) {
            return new Developer(workerType, companyRules.getGraphicsCardsProductionPerDay(), companyRules.getGraphicsCardCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.Integrator) {
            return new Integrator(workerType, companyRules.getComputersToGraphicsCard(), companyRules.getIntegratorCost(), drive, mutex, companyRules);
        } else if (workerType == WorkerTypeNumber.Manager) {
            return new ProjectManager(workerType, companyRules.getPmCost(), mutex, companyRules, drive);
        } else if (workerType == WorkerTypeNumber.Director) {
            return new Director(workerType, companyRules.getDirectorCost(), mutex, companyRules, drive);
        }

        return null;
    }
}
