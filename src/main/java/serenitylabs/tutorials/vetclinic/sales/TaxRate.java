package serenitylabs.tutorials.vetclinic.sales;

public class TaxRate {
    private final double taxRateValue;
    private final String taxRateName;

    public TaxRate(double taxRateValue, String taxRateName) {
        this.taxRateValue = taxRateValue;
        this.taxRateName = taxRateName;
    }

    public double getTaxRateValue() {
        return taxRateValue;
    }

    public String getTaxRateName() {
        return taxRateName;
    }

}
