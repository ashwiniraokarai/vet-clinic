package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

public class SalesTaxService {

    public SalesTax salesTaxEntryFor(LineItem item) {
/*    //Finding a direction when problem solving:
        // Write a return statement with your desired result (hardcoded values on the SalexTax object configuration)
        // Ask the question: How do I determine these tax properties for any Line Item?
        //Then replace the hardcoded values with hypothetical code (object and method names) you'd like to be available to you
        return SalesTax
                    .atRateOf(0.09).withName("Reduced").forAnAmountOf(3*1*0.09);*/

        TaxRate taxRateForItem = taxRateFor(item);
        return SalesTax
                .atRateOf(taxRateForItem.getTaxRateValue())
                .withName(taxRateForItem.getTaxRateName())
                .forAnAmountOf(item.getTotal()*taxRateForItem.getTaxRateValue());
    }

    private TaxRate taxRateFor(LineItem item) {
        TaxRateAssessor taxRateGenerator = new ReducedTaxAssessor();
        return taxRateGenerator.rateFor(item);
    }
}
