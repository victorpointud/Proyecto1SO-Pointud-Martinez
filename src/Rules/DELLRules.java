
package Rules;

import Number.CompanyNumber;

/*
* made by: victorpointud
*/

public class DELLRules extends CompanyRules {

    public DELLRules() {

        this.basePlatesNeedIt = 1;
        this.CPUsNeedIt = 5;
        this.RAMsNeedIt = 6;
        this.powerSuppliesNeedIt = 5;
        this.graphicsCardsNeedIt = 1;
        this.income = 80000f;  
        this.incomeWithGraphicsCard = 120000f; 
        this.computersToGraphicsCard = 3;
        this.employees = 25;
        this.basePlatesProductionPerDay = 0.5f;
        this.CPUsProductionPerDay = 0.33f;
        this.RAMsProductionPerDay = 1f;
        this.powerSuppliesProductionPerDay = 1.67f;
        this.graphicsCardsProductionPerDay = 0.33f;
        this.companyNumber = CompanyNumber.DELL;
    }
}
