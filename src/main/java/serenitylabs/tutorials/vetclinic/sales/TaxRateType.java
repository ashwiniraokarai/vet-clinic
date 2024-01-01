package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

import java.util.function.Function;

/*
* Convert the interface to a functional interface because it contains a single abstract method
* The implementing classes will need to be converted to lambda expressions
* */
@FunctionalInterface public interface TaxRateType extends Function<LineItem, TaxRate>
{
    //Functional Interfaces come with their own implicit abstract method called apply(input)
   /* public TaxRate rateFor(LineItem item);*/
}
