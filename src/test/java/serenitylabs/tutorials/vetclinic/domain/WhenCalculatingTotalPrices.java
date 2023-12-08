package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN (assert using classic junit. Boo)
        Assert.assertEquals(120, totalPrice);

        // THEN (assert using hamcrest matcher)
        assertThat(totalPrice, equalTo(120));

        //THEN (assert using other flavors/ variations of hamcrest matchers)
        assertThat(totalPrice, greaterThan(100));
        assertThat(totalPrice, lessThan(130));
    }
}
