package Worker;

/*
* made by: gabo2105MS
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

public class WorkerFactory {

    public Worker makeWorker(WorkerTypeNumber workerType, Drive drive, Semaphore mutex, CompanyRules companyRules) {

        switch (workerType) {
            case BasePlateProducer:
                return new Developer(workerType, companyRules.getBasePlatesProductionPerDay(), companyRules.getBasePlateCost(), drive, mutex, companyRules);
            case CPUProducer:
                return new Developer(workerType, companyRules.getCPUsProductionPerDay(), companyRules.getCpuCost(), drive, mutex, companyRules);
            case RAMProducer:
                return new Developer(workerType, companyRules.getRAMsProductionPerDay(), companyRules.getRamCost(), drive, mutex, companyRules);
            case PowerSupplyProducer:
                return new Developer(workerType, companyRules.getPowerSuppliesProductionPerDay(), companyRules.getPowerSupplyCost(), drive, mutex, companyRules);
            case GraphicsCardProducer:
                return new Developer(workerType, companyRules.getGraphicsCardsProductionPerDay(), companyRules.getGraphicsCardCost(), drive, mutex, companyRules);
            case Integrator:
                return new Integrator(workerType, companyRules.getComputersToGraphicsCard(), companyRules.getIntegratorCost(), drive, mutex, companyRules);
            case Manager:
                return new ProjectManager(workerType, companyRules.getPmCost(), mutex, companyRules, drive);
            case Director:
                return new Director(workerType, companyRules.getDirectorCost(), mutex, companyRules, drive);
            default:
                break;
        }

        return null;
    }
}
