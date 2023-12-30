package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

import java.util.function.Function;

/*
// Before: Used to be a Regular Interface with one explicit abstract methods
// Implementing classes provided their implementations of the rateFor(LineItem item) method
    public interface TaxRateType {
    TaxRate rateFor(LineItem item);
}*/

/*
// After: Converted to a Functional Interface
//This interface extends a built-in functional interface called Function
// The "Function" functional interface comes with its own implicit abstract method called apply(T)
//Implementors (lambdas) are in turn expected to implement the apply(T) method
*/
public interface TaxRateType extends Function<LineItem, TaxRate> { }
