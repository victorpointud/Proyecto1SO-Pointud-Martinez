
package Number;

/*
* made by: gabo2105MS
*/

public enum CompanyNumber {
    DELL(0),
    HP(1);
    private final int id;
    private CompanyNumber(int id) {
	this.id = id;
    }
    public int getId() {
	return id;
    }
}
