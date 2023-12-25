package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class TaxRate {
    private double ratePercent;
    private String rateName;
    private double rateAmount;

    public TaxRate(double ratePercent, String rateName, double rateAmount) {
/*// set hardcoded values until I can figure out who the caller is and how these values get passed down
        this.ratePercent = 0.09;
        this.rateName = "Reduced";
        this.rateAmount = 0.27;    // item.getTotal() * this.ratePercent;*/

        this.ratePercent = ratePercent;
        this.rateName = rateName;
        this.rateAmount = rateAmount;    // item.getTotal() * this.ratePercent;
    }

    public double getRatePercent() {
        return this.ratePercent;
    }

    public String getRateName() {
        return this.rateName;
    }

    public double getRateAmount() {
        return this.rateAmount;
    }
}
