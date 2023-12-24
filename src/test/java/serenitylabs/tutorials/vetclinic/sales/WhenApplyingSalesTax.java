package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Snacks;

public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;
    private final static double THIRTEEN_POINT_FIVE_PERCENT = 0.135;

    @Test
    public void crisps_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(1)
                                       .itemCalled("salt and vinegar crisps")
                                       .inCategory(Snacks)
                                       .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(1*3*NINE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }

    @Test
    public void over_100_euros_crisps_should_be_charged_at_a_higher_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(50)
                .itemCalled("salt and vinegar crisps")
                .inCategory(Snacks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced - Variant").forAnAmountOf(50*3*THIRTEEN_POINT_FIVE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }
}
