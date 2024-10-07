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

    /**
     * Constructs a ProjectManager instance with the specified parameters.
     */
    public ProjectManager(WorkerTypeNumber type, float costPerHour, Semaphore mutex, CompanyRules companyRules, Drive drive) {
        super(type, costPerHour, mutex, companyRules);
        this.drive = drive;
        this.hired = true;
    }

    /**
     * Represents the main loop of the Project Manager while they are hired.
     */
    @Override
    public void run() {
        while (hired) {
            try {
                double halfHourDuration = (double) getDayDuration() / 48;
                int workSessions = 0;

                while (workSessions < 16) {
                    drive.setPmStatus(0);

                    if (drive.getDirectorStatus() == 0) {
                        int newFaults = drive.getFaults() + 1;
                        drive.setFaults(newFaults);

                        drive.setSalaryDiscount(drive.getSalaryDiscount() + 50);

                        drive.getCostsMutex().acquire();
                        drive.setPmCost(drive.getPmCost() - 50);
                        drive.getCostsMutex().release();
                    }

                    sleep(Math.round(halfHourDuration));
                    drive.setPmStatus(1);
                    sleep(Math.round(halfHourDuration));
                    workSessions++;
                }

                drive.setPmStatus(0);
                sleep(Math.round(halfHourDuration * 16));

                drive.getDaysMutex().acquire();
                drive.setDaysUntilRelease(drive.getDaysUntilRelease() - 1);
                drive.getDaysMutex().release();

                drive.getCostsMutex().acquire();
                drive.setPmCost(drive.getPmCost() + costPerHour * 24);
                drive.getCostsMutex().release();

            } catch (InterruptedException ex) {
                System.err.println("Thread interrupted: " + ex.getMessage());
            } catch (Exception ex) {
                System.err.println("Unexpected error occurred: " + ex.getMessage());
            }
        }
    }

    /**
     * Placeholder for the work method. This must be implemented by derived classes.
     */
    @Override
    public void Work() {
        throw new UnsupportedOperationException("Work method is not implemented.");
    }
}
