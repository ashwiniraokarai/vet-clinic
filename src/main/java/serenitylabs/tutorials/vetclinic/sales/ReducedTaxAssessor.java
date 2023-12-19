package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ReducedTaxAssessor implements TaxRateAssessor {

    @Override
    public TaxRate rateFor(LineItem item) {
        if(item.getTotal() >= 100){
            return new TaxRate(0.135, "Reduced - Variant");
        }
        return new TaxRate(0.09, "Reduced");
    }
}
