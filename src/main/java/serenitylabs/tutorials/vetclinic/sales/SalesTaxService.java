package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

public class SalesTaxService {

    public SalesTax

    salesTaxEntryFor(LineItem item) {
/*//        attempt 1: return SalesTax object configured with hardcoded values
        return SalesTax.atRateOf(0.09).withName("Reduced").forAnAmountOf(0.27);*/

/*
// attempt 2: return SalesTax object configured with values provided by a hypothetical TaxRate object
        return SalesTax.atRateOf(taxRate.getRatePercent()).withName(taxRate.getRateName()).forAnAmountOf(taxRate.getRateAmount());
*/

/*// attempt 3: return SalesTax object configured with values provided by a real TaxRate object
        TaxRate taxRateForItem = new TaxRate(item);
        return SalesTax.atRateOf(taxRateForItem.getRatePercent()).withName(taxRateForItem.getRateName()).forAnAmountOf(taxRateForItem.getRateAmount());
    }*/

// attempt 4: same as Step 3 but move the TaxRate instantiation step to a separate method
// This gives us the space and distance to flesh out the conditional logic for varying tax rate and name
        TaxRate taxRateForItem = fetchTaxRate(item);
        return SalesTax.atRateOf(taxRateForItem.getRatePercent()).withName(taxRateForItem.getRateName()).forAnAmountOf(taxRateForItem.getRateAmount());
    }

    private TaxRate fetchTaxRate(LineItem item) {
/*//iteration 1:as a caller, send hardcoded values to set until you can write conditional logic
        return new TaxRate(0.09, "Reduced", 0.27);*/

/*//iteration 2: write the conditional logic to handle Reduced tax type. You can expand the logic to other two tax types in the next iteration
// We write the conditional logic using Strategy Pattern (a concrete implementation object set to its parent interface type)

        TaxRateType taxRateType = new ReducedTaxRateType();
        return taxRateType.rateFor(item);*/

// Iteration 3: expand the logic to all tax types: Reduced Rate, Standard Rate, Exempt Rate using switch-case
        switch (item.getCategory()) {
            case Snacks:
            case SoftDrinks:
                return new ReducedTaxRateType().rateFor(item);
            case Books:
            case Medicine:
                return new ExemptTaxRateType().rateFor(item);
            case Toys:
            case PetFood:
                return new StandardTaxRateType().rateFor(item);
            default:
                return null;
        }
    }
}
