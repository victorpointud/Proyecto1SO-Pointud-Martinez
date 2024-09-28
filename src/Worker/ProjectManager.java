package Worker;

/*
* made by: victorpointud
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

public class ProjectManager extends Worker {

    private Drive drive;

    public ProjectManager(WorkerTypeNumber type, float cph, Semaphore m, CompanyRules gameRules, Drive drive) {
        super(type, cph, m, gameRules);
        this.drive = drive;
        this.hired = true;
    }

    @Override
    public void run() {
        while (hired) {
            try {
                double halfHour = getDayDuration() / 48;
                int counter = 0;
                while (counter < 16) {
                    drive.setPmStatus(0); 
                    if (drive.getDirectorStatus() == 0) {
                        drive.setFaults(drive.getFaults() + 1);
                        drive.setSalaryDiscount(drive.getSalaryDiscount() + 50);
                        drive.getCostsMutex().acquire();
                        drive.setPmCost(drive.getPmCost() - 50);
                        drive.getCostsMutex().release();
                    }
                    sleep(Math.round(halfHour));
                    drive.setPmStatus(1); 
                    sleep(Math.round(halfHour));
                    counter++;
                }
                drive.setPmStatus(0); 
                sleep(Math.round(halfHour * 16));
                drive.getDaysMutex().acquire();
                drive.setDaysUntilRelease(drive.getDaysUntilRelease() - 1);  
                drive.getDaysMutex().release();
                drive.getCostsMutex().acquire();
                drive.setPmCost(drive.getPmCost() + costPerHour * 24);
                drive.getCostsMutex().release();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void Work() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
