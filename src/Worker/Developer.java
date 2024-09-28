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
    private float acc = 0;
    private Drive drive;
  
    public Developer(WorkerTypeNumber type, float pp, float cph, Drive drive, Semaphore m, CompanyRules gameRules) {
        super(type, cph, m, gameRules);
        this.productionPerDay = pp;
        this.drive = drive;
    }

    @Override
    public void run() {
        while (hired) {
            try {
                Work();
                sleep(getDayDuration());
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void Work() {
        this.acc += this.productionPerDay;
        this.daysWorked++;
        try {
            while (this.acc >= 1) {
                this.mutex.acquire();
                this.drive.addProduct(1, type);  
                this.acc -= 1;
                if (acc < 1) acc = 0;
                this.mutex.release();
            }
            drive.getCostsMutex().acquire();
            switch(this.type) {
                case BasePlateProducer:
                    drive.setBasePlateCost(drive.getBasePlateCost() + this.costPerHour * 24);
                    break;
                case CPUProducer:
                    drive.setCpuCost(drive.getCpuCost() + this.costPerHour * 24);
                    break;
                case RAMProducer:
                    drive.setRamCost(drive.getRamCost() + this.costPerHour * 24);
                    break;
                case PowerSupplyProducer:
                    drive.setPowerSupplyCost(drive.getPowerSupplyCost() + this.costPerHour * 24);
                    break;
                case GraphicsCardProducer:
                    drive.setGraphicsCardCost(drive.getGraphicsCardCost() + this.costPerHour * 24);
                    break;
                default:
                    break;
            }
            drive.getCostsMutex().release();
        
        } catch (InterruptedException ex) {
        }
    }
}
