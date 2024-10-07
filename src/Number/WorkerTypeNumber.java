
package Number;

/*
* made by: gabo2105MS
*/

public enum WorkerTypeNumber {
    BasePlateProducer(0),
    CPUProducer(1),
    RAMProducer(2),
    PowerSupplyProducer(3),
    GraphicsCardProducer(4),
    Integrator(5),
    Manager(6),
    Director(7);
    private final int id;
    
    /**
     * Constructs a WorkerTypeNumber enum with the specified identifier.
     */
    private WorkerTypeNumber(int id) {
	this.id = id;
    }
    
     /**
     * Gets the unique identifier associated with the worker type.
     */
    public int getId() {
	return id;
    }
}
