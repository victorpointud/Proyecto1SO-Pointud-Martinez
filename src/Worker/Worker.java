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

    /**
     * Constructs a Worker object with the given parameters.
     */
    public Worker(WorkerTypeNumber type, float costPerHour, Semaphore mutex, CompanyRules companyRules) {
        this.type = type;
        this.costPerHour = costPerHour;
        this.mutex = mutex;
        this.companyRules = companyRules;
        this.hired = true;
    }

    /**
     * Abstract method that defines the main working process of the worker.
     */
    @Override
    public abstract void run();

    /**
     * Abstract method that represents the work performed by the worker.
     */
    public abstract void Work();

    /**
     * Calculates the cost of the worker per day.
     * @return The daily cost or historical cost of the worker.
     */
    public float getWorkerCostPerDay(boolean historical) {
        return historical ? (costPerHour * 24f * daysWorked) : (costPerHour * 24f);
    }

    /**
     * Checks whether the worker is currently hired.
     * @return True if the worker is hired, otherwise false.
     */
    public boolean isHired() {
        return hired;
    }

    /**
     * Sets the hired status of the worker.
     */
    public void setHired(boolean hired) {
        this.hired = hired;
    }

    /**
     * Getters & Setters.
     */
    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
}
