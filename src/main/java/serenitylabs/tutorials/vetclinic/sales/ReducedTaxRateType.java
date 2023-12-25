package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ReducedTaxRateType implements TaxRateType {
    private final double REDUCED_RATE_PERCENT = 0.09;
    private final double REDUCED_RATE_VARIANT_PERCENT = 0.135;
    @Override
    public TaxRate rateFor(LineItem item) {
        if(item.getTotal() >= 100){
            return new TaxRate(REDUCED_RATE_VARIANT_PERCENT, "Reduced - Variant", item.getTotal()*REDUCED_RATE_VARIANT_PERCENT);
        }
        return new TaxRate(REDUCED_RATE_PERCENT, "Reduced", item.getTotal()*REDUCED_RATE_PERCENT);
    }
}
