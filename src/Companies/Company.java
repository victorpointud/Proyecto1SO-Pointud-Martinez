package Companies;

import Number.WorkerTypeNumber;
import Primitives.List;
import Primitives.Node;
import Rules.CompanyRules;
import Store.Drive;
import Worker.Worker;
import Worker.WorkerFactory;
import javax.swing.JOptionPane;
import main.Global;

/*
* made by: victorpointud
*/

public class Company {

    private CompanyRules companyRules;
    private Drive companyDrive;
    private List[] workforce = new List[8];
    private int totalEmployees;
    private int availableVacancies;

    /**
     * Constructs a Company with specified initial workers and parameters.
     */
    public Company(int numberOfBasePlateProducers, int numberOfCPUProducers, int numberOfRAMProducers, int numberOfPowerSupplyProducers, int numberOfGraphicsCardProducers, int numberOfIntegrators, Drive drive, CompanyRules rules) {
        WorkerFactory workerFactory = new WorkerFactory();

        for (int i = 0; i < workforce.length; i++) {
            workforce[i] = new List();
        }
        hireWorkers(numberOfBasePlateProducers, WorkerTypeNumber.BasePlateProducer, 0, workerFactory, drive, rules);
        hireWorkers(numberOfCPUProducers, WorkerTypeNumber.CPUProducer, 1, workerFactory, drive, rules);
        hireWorkers(numberOfRAMProducers, WorkerTypeNumber.RAMProducer, 2, workerFactory, drive, rules);
        hireWorkers(numberOfPowerSupplyProducers, WorkerTypeNumber.PowerSupplyProducer, 3, workerFactory, drive, rules);
        hireWorkers(numberOfGraphicsCardProducers, WorkerTypeNumber.GraphicsCardProducer, 4, workerFactory, drive, rules);
        hireWorkers(numberOfIntegrators, WorkerTypeNumber.Integrator, 5, workerFactory, drive, rules);
        Worker projectManager = workerFactory.makeWorker(WorkerTypeNumber.Manager, drive, drive.getProducerMutex(), rules);
        workforce[6].addToList(projectManager);
        Worker companyDirector = workerFactory.makeWorker(WorkerTypeNumber.Director, drive, drive.getProducerMutex(), rules);
        workforce[7].addToList(companyDirector);
        this.totalEmployees = numberOfBasePlateProducers + numberOfCPUProducers + numberOfRAMProducers + numberOfPowerSupplyProducers + numberOfGraphicsCardProducers + numberOfIntegrators;
        this.availableVacancies = rules.getEmployees()- totalEmployees;
        this.companyDrive = drive;
        this.companyRules = rules;
    }

    /**
     * Fires an employee of the specified type.
     */
    public void fireEmployee(int type) {
        if (totalEmployees > 0) {
            boolean removed = workforce[type].removeLast();
            if (removed) {
                totalEmployees--;
                availableVacancies++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay más empleados por despedir");
        }
    }

    /**
     * Hires a new worker of the specified type.
     */
    public void hireEmployee(int type) {
        if (availableVacancies > 0) {
            WorkerFactory workerFactory = new WorkerFactory();
            Worker newWorker = null;
            switch (type) {
                case 0 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.BasePlateProducer, companyDrive, companyDrive.getProducerMutex(), companyRules);
                case 1 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.CPUProducer, companyDrive, companyDrive.getProducerMutex(), companyRules);
                case 2 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.RAMProducer, companyDrive, companyDrive.getProducerMutex(), companyRules);
                case 3 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.PowerSupplyProducer, companyDrive, companyDrive.getProducerMutex(), companyRules);
                case 4 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.GraphicsCardProducer, companyDrive, companyDrive.getProducerMutex(), companyRules);
                case 5 -> newWorker = workerFactory.makeWorker(WorkerTypeNumber.Integrator, companyDrive, companyDrive.getProducerMutex(), companyRules);
            }
            if (newWorker != null) {
                workforce[type].addToList(newWorker);
                availableVacancies--;
                totalEmployees++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay presupuesto para más personal.");
        }
    }

    /**
     * Handles the company's bankruptcy by firing all employees.
     */
    public void initiateBankruptcy() {
        for (List employeeList : workforce) {
            int size = employeeList.getSize();
            for (int j = 0; j < size; j++) {
                employeeList.removeLast();
                System.out.println("Empleado despedido número: " + j);
            }
        }
    }

    /**
     * Updates the day duration for all employees.
     */
    public void updateEmployeeTimings() {
        for (List employeeList : workforce) {
            for (int j = 0; j < employeeList.getSize(); j++) {
                Node tempNode = employeeList.getNode(j);
                if (tempNode != null) {
                    tempNode.getData().setDayDuration((int) Global.daysDuration);
                }
            }
        }
    }

    private void hireWorkers(int count, WorkerTypeNumber type, int index, WorkerFactory workerFactory, Drive drive, CompanyRules rules) {
        for (int i = 0; i < count; i++) {
            Worker worker = workerFactory.makeWorker(type, drive, drive.getProducerMutex(), rules);
            workforce[index].addToList(worker);
        }
    }

    /**
     * Getters & Setters.
     */

    public CompanyRules getCompanyRules() {
        return companyRules;
    }

    public void setCompanyRules(CompanyRules companyRules) {
        this.companyRules = companyRules;
    }

    public Drive getCompanyDrive() {
        return companyDrive;
    }

    public void setCompanyDrive(Drive companyDrive) {
        this.companyDrive = companyDrive;
    }

    public List[] getWorkforce() {
        return workforce;
    }

    public void setWorkforce(List[] workforce) {
        this.workforce = workforce;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getAvailableVacancies() {
        return availableVacancies;
    }

    public void setAvailableVacancies(int availableVacancies) {
        this.availableVacancies = availableVacancies;
    }
}
