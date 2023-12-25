package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ReducedTaxRateType implements TaxRateType {
    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(0.09, "Reduced", 0.27);
    }
}
