
package Number;

/*
* made by: gabo2105MS
*/

public enum CompanyNumber {
    DELL(0),
    HP(1);
    private final int id;
    
     /**
     * Constructs a CompanyNumber enum with the specified identifier.
     */
    private CompanyNumber(int id) {
	this.id = id;
    }
    
    /**
     * Gets the unique identifier associated with the company.
     * @return The company identifier.
     */
    public int getId() {
	return id;
    }
}
