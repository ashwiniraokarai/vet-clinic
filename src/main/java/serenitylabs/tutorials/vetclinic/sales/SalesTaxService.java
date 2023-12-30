package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class SalesTaxService {

    private static final Map<ProductCategory, TaxRateType> taxRateByProductCategoryMap = new HashMap<ProductCategory, TaxRateType>();

    //Several Lambda-based implementors of the Functional Interface TaxRateType, for each Tax rate type
    private static final TaxRateType LAMBDA_EXEMPT_TAX_RATE = (item) -> new TaxRate(0.00, "Exempt");

    private static final TaxRateType LAMBDA_REDUCED_TAX_RATE = (item) -> {
        if(item.getTotal() >= 100){
            return new TaxRate(0.135, "Reduced - Variant");
        }
        return new TaxRate(0.09, "Reduced");
    };

    private static final TaxRateType LAMBDA_STANDARD_TAX_RATE = (item) -> new TaxRate(0.23, "Standard");

    static{
/*    taxRateByProductCategoryMap.put(Medicine, new ExemptTaxRate() );
        taxRateByProductCategoryMap.put(Books, new ExemptTaxRate());
        taxRateByProductCategoryMap.put(Snacks, new ReducedTaxRate());
        taxRateByProductCategoryMap.put(SoftDrinks, new ReducedTaxRate());*/

       taxRateByProductCategoryMap.put(Medicine, LAMBDA_EXEMPT_TAX_RATE);
       taxRateByProductCategoryMap.put(Books, LAMBDA_EXEMPT_TAX_RATE);
       taxRateByProductCategoryMap.put(Snacks, LAMBDA_REDUCED_TAX_RATE);
       taxRateByProductCategoryMap.put(SoftDrinks, LAMBDA_REDUCED_TAX_RATE);
    }

    public SalesTax salesTaxEntryFor(LineItem item) {
/*    //Finding a direction when problem solving:
        // Write a return statement with your desired result (hardcoded values on the SalesTax object configuration)
        // Ask the question: How do I determine these SalesTax object properties for any Line Item?
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
        //TaxRateType taxRateType = new ReducedTaxRate();
        //replace new ReducedTaxRate() with a method that can return the right kind of TaxRateType implementation
        TaxRateType taxRateType =  fetchRightTaxRateType(item);
       return taxRateType.apply(item);
    }

/* // Refactored to use a Map for the conditional, in place of the switch-case
//Using Maps as conditionals is a popular strategy pattern
    private TaxRateType fetchRightTaxRateType(LineItem item) {
        ProductCategory productCategoryOfItem = item.getCategory();
        switch(productCategoryOfItem){
            case Books:
            case Medicine:
                 return new ExemptTaxRate();
            case Snacks:
            case SoftDrinks:
                return new ReducedTaxRate();
            default:
               return new StandardTaxRate();
        }
    }*/

    private TaxRateType fetchRightTaxRateType(LineItem item) {
        ProductCategory itemCategory = item.getCategory();
        return taxRateByProductCategoryMap.getOrDefault(itemCategory, LAMBDA_STANDARD_TAX_RATE);
    }
}
