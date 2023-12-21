package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Books;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.Snacks;

public class WhenApplyingSalesTax {

    private static final double NINE_PERCENT = 0.09;
    private static final double THIRTEEN_POINT_FIVE_PERCENT = 0.135;
    private static final  double ZERO_PERCENT = 0.00 ;
    private static final double TWENTY_THREE_PERCENT = 00.23;

    @Test
    public void crisps_should_be_charged_at_the_reduced_tax_rate() {
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
    public void over_100_euros_crisps_should_be_charged_at_a_higher_tax_rate() {
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

    @Test
    public void books_should_be_charged_zero_tax_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(10)
                .itemCalled("the da vinci code")
                .inCategory(Books)
                .withAUnitPriceOf(10.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Exempt").forAnAmountOf(10*10*ZERO_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void toys_should_be_charged_standard_tax_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(10)
                .itemCalled("lovey")
                .inCategory(ProductCategory.Toys)
                .withAUnitPriceOf(10.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(10*10*TWENTY_THREE_PERCENT);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }
}
