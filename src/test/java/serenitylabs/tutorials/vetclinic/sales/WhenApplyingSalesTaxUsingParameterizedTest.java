package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class WhenApplyingSalesTaxUsingParameterizedTest {
    @ParameterizedTest(name="{0} * {1} categorized as {2} priced at {3}" )
    @MethodSource("data_provider_method")
    public void item_should_be_charged_at_the_appropriate_rate(int quantity, String item_name, ProductCategory product_category, double unit_price, double expected_tax_rate_percent, String expected_tax_rate_name, double expected_tax_amount){
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(quantity)
                .itemCalled(item_name)
                .inCategory(product_category)
                .withAUnitPriceOf(unit_price);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(expected_tax_rate_percent).withName(expected_tax_rate_name).forAnAmountOf(expected_tax_amount);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    public static Object[][] data_provider_method(){
        return new Object[][]{
            {1,"salt and vinegar crisps", Snacks,3.00,0.09,"Reduced",1*3.00*0.09},
            {1,"soda", SoftDrinks,5.00,0.09,"Reduced",1*5.00*0.09},
            {50,"salt and vinegar crisps", Snacks,3.00,0.135,"Reduced - Variant",50*3.00*0.135},
            {24,"soda", SoftDrinks,5.00,0.135,"Reduced - Variant",24*5.00*0.135},
            {10,"tylenol", Medicine,10.00,0.00,"Exempt",10*10.00*0.00},
            {10,"the da vinci code", Books,10.00,0.00,"Exempt",10*10.00*0.00},
            {10,"pedigree", PetFood,10.00,0.23,"Standard",10*10.00*0.23},
            {10,"balloons", Toys,10.00,0.23,"Standard",10*10.00*0.23}
        };
    }
}
