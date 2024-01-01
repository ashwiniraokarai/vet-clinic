package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

/*
//Implementing class is no longer needed because it is replaced by an equivalent lambda expression
public class ExemptTaxRateType implements TaxRateType{
    private final double EXEMPT_RATE_PERCENT = 0.00;

    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(EXEMPT_RATE_PERCENT, "Exempt", item.getTotal()*EXEMPT_RATE_PERCENT);
    }
}*/
