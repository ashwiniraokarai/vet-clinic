package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Books;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Snacks;

public class WhenApplyingSalesTaxParameterizedTest {

    private static final double NINE_PERCENT = 0.09;
    private static final double THIRTEEN_POINT_FIVE_PERCENT = 0.135;
    private static final  double ZERO_PERCENT = 0.00 ;
    private static final double TWENTY_THREE_PERCENT = 00.23;

    @ParameterizedTest(name="{0} * {1} in category {2} priced at {3} euros")
    @MethodSource("dataProviderMethod")
    public void item_should_be_charged_at_appropriate_tax_rate(int quantity, String item_name, ProductCategory product_category, double unit_price, double expected_tax_rate_percent, String expected_tax_rate_name, double expected_amount){
        // GIVEN
        LineItem lineItem = LineItem.forASaleOf(quantity)
                .itemCalled(item_name)
                .inCategory(product_category)
                .withAUnitPriceOf(unit_price);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(lineItem);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(expected_tax_rate_percent).withName(expected_tax_rate_name).forAnAmountOf(expected_amount);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }
    public static Object[][] dataProviderMethod(){
        return new Object[][]{
                {1,"salt and vinegar crisps", Snacks,3.00,NINE_PERCENT, "Reduced",1*3*NINE_PERCENT},
                {50,"salt and vinegar crisps", Snacks,3.00,THIRTEEN_POINT_FIVE_PERCENT, "Reduced - Variant",50*3*THIRTEEN_POINT_FIVE_PERCENT},
                {10,"the da vinci code", Books,3.00,ZERO_PERCENT, "Exempt",10*10*ZERO_PERCENT},
                {10,"lovey", ProductCategory.Toys,10.00,TWENTY_THREE_PERCENT, "Standard",10*10*TWENTY_THREE_PERCENT}
        };
    }
}
