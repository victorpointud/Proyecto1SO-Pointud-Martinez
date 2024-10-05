
package Rules;

import Number.CompanyNumber;

/*
* made by: victorpointud
*/

public class HPRules extends CompanyRules {

    public HPRules() {
        this.basePlatesNeedIt = 1;
        this.CPUsNeedIt = 1;
        this.RAMsNeedIt = 2;
        this.powerSuppliesNeedIt = 4;
        this.graphicsCardsNeedIt = 3;
        this.income = 90000f; 
        this.incomeWithGraphicsCard = 140000f; 
        this.computersToGraphicsCard = 2;
        this.employees = 19;//tomamos numero de carnet = 7
        this.basePlatesProductionPerDay = 0.5f;
        this.CPUsProductionPerDay = 1f;
        this.RAMsProductionPerDay = 2f;
        this.powerSuppliesProductionPerDay = 1.33f;
        this.graphicsCardsProductionPerDay = 0.5f;
        this.companyNumber = CompanyNumber.HP;
    }
}
