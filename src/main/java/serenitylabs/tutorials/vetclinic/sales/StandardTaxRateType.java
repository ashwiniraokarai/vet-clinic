package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class StandardTaxRateType implements TaxRateType {

    private static final double STANDARD_RATE_PERCENT = 0.23;

    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(STANDARD_RATE_PERCENT, "Standard", item.getTotal()*STANDARD_RATE_PERCENT);
    }
}
