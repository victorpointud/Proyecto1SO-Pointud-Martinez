package Worker;

/*
* made by: gabo2105MS
*/

import Number.WorkerTypeNumber;
import Rules.CompanyRules;
import java.util.concurrent.Semaphore;

public abstract class Worker extends Thread {
    
    protected WorkerTypeNumber type;
    private int dayDuration = 500;
    protected int daysWorked = 0;
    protected float costPerHour;
    protected Semaphore mutex;
    protected CompanyRules companyRules;
    protected boolean hired;
    
    public Worker (WorkerTypeNumber type, float cph, Semaphore m, CompanyRules gameRules) {
        this.type = type;
        this.costPerHour = cph;
        this.mutex = m;
        this.companyRules = gameRules;
        this.hired = true;
    }

    public abstract void run();

    public abstract void Work();

    public float getWorkerCostPerDay(boolean historical) {
        return (!historical) ? costPerHour * 24f : costPerHour * 24f * this.daysWorked;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }
    
    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
}
