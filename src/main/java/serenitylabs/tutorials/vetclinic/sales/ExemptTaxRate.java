package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ExemptTaxRate implements TaxRateType {

    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(0.00, "Exempt");
    }
}

