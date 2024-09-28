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

    private Drive drive;

    public Director(WorkerTypeNumber wte, float f, Semaphore smphr, CompanyRules cr, Drive drive) {
        super(wte, f, smphr, cr);
        this.drive = drive;
        this.hired = true;
    }

    @Override
    public void run() {
        while (hired) {
            double timePassed = 0;
            try {
                drive.getDaysMutex().acquire();
                if (drive.getDaysUntilRelease() <= 0) {
                    drive.getConsumerMutex().acquire();
                    drive.setEarnings(drive.getEarnings() 
                                      + drive.getComputers() * this.companyRules.getIncome() 
                                      + drive.getComputersWithGraphicsCard() * companyRules.getIncomeWithGraphicsCard());
                    drive.setComputers(0); 
                    drive.setComputersWithGraphicsCard(0); 
                    drive.setDaysUntilRelease(Global.daysBetweenReleases); 
                    drive.getDaysMutex().release();
                    drive.getConsumerMutex().release();
                    sleep(getDayDuration());
                } else {
                    drive.getDaysMutex().release();
                    Random r = new Random();
                    double oneHour = getDayDuration() / 24;
                    double checkingHour = r.nextInt(24) * oneHour;
                    timePassed = (checkingHour + 1) * oneHour;
                    double contador = 0;
                    while (contador < getDayDuration()) {
                        if (contador == checkingHour) {
                            drive.setDirectorStatus(0);
                            double oneMinute = oneHour / 60;
                            sleep(Math.round(25 * oneMinute));
                            drive.setDirectorStatus(1); 
                            sleep(Math.round(35 * oneMinute));
                        }
                        sleep(Math.round(oneHour));
                        contador += oneHour;
                    }
                }
                drive.getCostsMutex().acquire();
                drive.setDirectorCost(drive.getDirectorCost() + costPerHour * 24);
                drive.getCostsMutex().release();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void Work() {
        
    }
}
