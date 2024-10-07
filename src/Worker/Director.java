package Worker;

/*
* made by: victorpointud
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import Store.Drive;
import java.util.Random;
import java.util.concurrent.Semaphore;
import main.Global;

public class Director extends Worker {

    private final Drive drive;

    /**
     * Constructs a Director object with specified parameters.
     */
    public Director(WorkerTypeNumber workerType, float costPerHour, Semaphore semaphore, CompanyRules companyRules, Drive drive) {
        super(workerType, costPerHour, semaphore, companyRules);
        this.drive = drive;
        this.hired = true;
    }

    /**
     * Runs the main process for the Director while hired.
     */
    @Override
    public void run() {
        while (hired) {
            try {
                double elapsedHours = 0;
                drive.getDaysMutex().acquire();

                if (drive.getDaysUntilRelease() <= 0) {
                    handleReleaseDay();
                } else {
                    drive.getDaysMutex().release();
                    elapsedHours = monitorWorkDay();
                }

                adjustDirectorCost();
            } catch (InterruptedException e) {
                System.err.println("Director's run interrupted: " + e.getMessage());
            }
        }
    }

    /**
     * Handles the work performed by the Director.
     */
    @Override
    public void Work() {
        // This method is intentionally not implemented
    }

    /**
     * Handles the operations on a release day, including updating earnings and resetting computer counts.
     * @throws InterruptedException if thread is interrupted during operation
     */
    private void handleReleaseDay() throws InterruptedException {
        drive.getConsumerMutex().acquire();
        drive.setEarnings(drive.getEarnings() 
                        + (drive.getComputers() * this.companyRules.getIncome()) 
                        + (drive.getComputersWithGraphicsCard() * companyRules.getIncomeWithGraphicsCard()));

        drive.setComputers(0);
        drive.setComputersWithGraphicsCard(0);
        drive.setDaysUntilRelease(Global.daysBetweenReleases);
        drive.getDaysMutex().release();
        drive.getConsumerMutex().release();
        sleep(getDayDuration());
    }

    /**
     * Monitors the work activities throughout the day, simulating periodic checks by the Director.
     * @return The total time passed during the checks.
     * @throws InterruptedException if thread is interrupted during operation
     */
    private double monitorWorkDay() throws InterruptedException {
        Random random = new Random();
        double oneHourDuration = (double) getDayDuration() / 24;
        double randomCheckHour = random.nextInt(24) * oneHourDuration;

        double timePassed = 0;
        while (timePassed < getDayDuration()) {
            if (timePassed == randomCheckHour) {
                executeRandomCheck(oneHourDuration);
            }
            sleep(Math.round(oneHourDuration));
            timePassed += oneHourDuration;
        }
        return timePassed;
    }

    /**
     * Executes a random check by the Director at a certain point during the day.
     * @param oneHourDuration The duration of one hour in the Director's context.
     * @throws InterruptedException if thread is interrupted during operation
     */
    private void executeRandomCheck(double oneHourDuration) throws InterruptedException {
        drive.setDirectorStatus(0);
        double oneMinuteDuration = oneHourDuration / 60;
        sleep(Math.round(25 * oneMinuteDuration));
        drive.setDirectorStatus(1);
        sleep(Math.round(35 * oneMinuteDuration));
    }

    /**
     * Adjusts the daily cost for the Director based on hours worked.
     * @throws InterruptedException if thread is interrupted during semaphore acquire/release
     */
    private void adjustDirectorCost() throws InterruptedException {
        drive.getCostsMutex().acquire();
        drive.setDirectorCost(drive.getDirectorCost() + (costPerHour * 24));
        drive.getCostsMutex().release();
    }
}
