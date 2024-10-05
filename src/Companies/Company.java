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

    private CompanyRules rules;
    private Drive drive;
    private List[] employees = new List[8];
    private int amountOfEmployees;
    private int vacancy;

    public Company(int numberOfBasePlateProducers, int numberOfCPUProducers, int numberOfRAMProducers, int numberOfPowerSupplyProducers, int numberOfGraphicsCardProducers, int numberOfIntegrators, Drive drive, CompanyRules rules) {
        WorkerFactory workerFactory = new WorkerFactory();
        
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new List();
        }
        for (int i = 0; i < numberOfBasePlateProducers; i++) {
            Worker basePlateWorker = workerFactory.makeWorker(WorkerTypeNumber.BasePlateProducer, drive, drive.getProducerMutex(), rules);
            employees[0].addToList(basePlateWorker);
        }
        for (int i = 0; i < numberOfCPUProducers; i++) {
            Worker cpuWorker = workerFactory.makeWorker(WorkerTypeNumber.CPUProducer, drive, drive.getProducerMutex(), rules);
            employees[1].addToList(cpuWorker);
        }
        for (int i = 0; i < numberOfRAMProducers; i++) {
            Worker ramWorker = workerFactory.makeWorker(WorkerTypeNumber.RAMProducer, drive, drive.getProducerMutex(), rules);
            employees[2].addToList(ramWorker);
        }
        for (int i = 0; i < numberOfPowerSupplyProducers; i++) {
            Worker powerSupplyWorker = workerFactory.makeWorker(WorkerTypeNumber.PowerSupplyProducer, drive, drive.getProducerMutex(), rules);
            employees[3].addToList(powerSupplyWorker);
        }
        for (int i = 0; i < numberOfGraphicsCardProducers; i++) {
            Worker graphicsCardWorker = workerFactory.makeWorker(WorkerTypeNumber.GraphicsCardProducer, drive, drive.getProducerMutex(), rules);
            employees[4].addToList(graphicsCardWorker);
        }
        for (int i = 0; i < numberOfIntegrators; i++) {
            Worker integratorWorker = workerFactory.makeWorker(WorkerTypeNumber.Integrator, drive, drive.getProducerMutex(), rules);
            employees[5].addToList(integratorWorker);
        }
        Worker PM = workerFactory.makeWorker(WorkerTypeNumber.Manager, drive, drive.getProducerMutex(), rules);
        employees[6].addToList(PM);
        Worker director = workerFactory.makeWorker(WorkerTypeNumber.Director, drive, drive.getProducerMutex(), rules);
        employees[7].addToList(director);
        this.amountOfEmployees = numberOfBasePlateProducers + numberOfCPUProducers + numberOfRAMProducers + numberOfPowerSupplyProducers + numberOfGraphicsCardProducers + numberOfIntegrators;
        this.vacancy = rules.getEmployees() - amountOfEmployees;
        this.drive = drive;
        this.rules = rules;
    }
    
    //funcion despedir empleado
    public void fireEmployee(int type) {
        if (amountOfEmployees > 0) {
            boolean eliminado = employees[type].removeLast();
            if (eliminado) {
                amountOfEmployees--;
                vacancy++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay más empleados por despedir");
        }
    }
    
    //funcion contratar empleado
    public void hireEmployee(int type) {
        if (vacancy > 0) {
            WorkerFactory workerFactory = new WorkerFactory();
            Worker newWorker = null;
            switch (type) {
                case 0:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.BasePlateProducer, drive, drive.getProducerMutex(), rules);
                    break;
                case 1:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.CPUProducer, drive, drive.getProducerMutex(), rules);
                    break;
                case 2:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.RAMProducer, drive, drive.getProducerMutex(), rules);
                    break;
                case 3:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.PowerSupplyProducer, drive, drive.getProducerMutex(), rules);
                    break;
                case 4:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.GraphicsCardProducer, drive, drive.getProducerMutex(), rules);
                    break;
                case 5:
                    newWorker = workerFactory.makeWorker(WorkerTypeNumber.Integrator, drive, drive.getProducerMutex(), rules);
                    break;
            }
            employees[type].addToList(newWorker);
            vacancy--;
            amountOfEmployees++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay presupuesto para más personal.");
        }
    }
    
    public void bankrupcy(){
        for (List employee : employees) {
            int size = employee.getSize();
            for (int j = 0; j < size; j++) {
                System.out.println(employee.getSize());
                employee.removeLast();
                System.out.println("Empleado despedido número: " + j);
            }
        }
    }
    
    public void updateTimes(){
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees[i].getSize(); j++) {
                Node temp = employees[i].getNode(j);
                if(temp != null)
                    employees[i].getNode(j).getData().setDayDuration((int) Global.daysDuration);
            }
        }
    }

    public CompanyRules getRules() {
        return rules;
    }

    public void setRules(CompanyRules rules) {
        this.rules = rules;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public List[] getEmployees() {
        return employees;
    }

    public void setEmployees(List[] employees) {
        this.employees = employees;
    }

    public int getAmountOfEmployees() {
        return amountOfEmployees;
    }

    public void setAmountOfEmployees(int amountOfEmployees) {
        this.amountOfEmployees = amountOfEmployees;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

}
