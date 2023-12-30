package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/*// Implementing class no longer needed. Functional Interface has Lambda based implementor instead.
public class ReducedTaxRate implements TaxRateType {

    @Override
    public TaxRate rateFor(LineItem item) {
        if(item.getTotal() >= 100){
            return new TaxRate(0.135, "Reduced - Variant");
        }
        return new TaxRate(0.09, "Reduced");
    }
}*/
