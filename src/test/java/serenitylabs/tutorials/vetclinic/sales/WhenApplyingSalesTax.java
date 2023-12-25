package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;
    private final static double THIRTEEN_POINT_FIVE_PERCENT = 0.135;
    private static final double ZERO_PERCENT = 0.00;
    private static final double TWENTY_THREE_PERCENT = 0.23;

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
        SalesTax expectedSalesTax = SalesTax.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(crisps.getTotal()*NINE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void over_100_crisps_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(50)
                .itemCalled("crisps")
                .inCategory(Snacks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced - Variant").forAnAmountOf(crisps.getTotal()*THIRTEEN_POINT_FIVE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void meds_should_be_charged_at_the_exempt_rate() {
        // GIVEN
        LineItem meds = LineItem.forASaleOf(10)
                .itemCalled("tylenol")
                .inCategory(Medicine)
                .withAUnitPriceOf(10.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(meds);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Exempt").forAnAmountOf(meds.getTotal()*ZERO_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void toys_should_be_charged_at_the_standard_rate() {
        // GIVEN
        LineItem meds = LineItem.forASaleOf(10)
                .itemCalled("balloon")
                .inCategory(Toys)
                .withAUnitPriceOf(10.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(meds);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(meds.getTotal()*TWENTY_THREE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }
}
