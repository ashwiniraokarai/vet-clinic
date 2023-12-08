package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

    //Demos Hamcrest matcher based assertions on strings
    //NOTE: the java built-in toString() is overridden in the Dog class to produce a readable and tailored string vs the hexcode
    @Test
    public void a_dog_should_be_printed_in_a_readable_form(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(), equalTo("Fido the black labrador"));
        assertThat(fido.toString(), startsWith("Fido"));
        assertThat(fido.toString(), containsString("black"));
        assertThat(fido.toString(), endsWith("labrador"));
    }

    //Demos Hamcrest matcher based assertions on Collection (List) of String
    //NOTE: the java built-in toString() is overridden in the Dog class to produce a readable and tailored string vs the he
    @Test
    public void a_dog_can_have_several_colors(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black", "Tan");

        assertThat(fido.getColour(), hasItem("Black"));
        assertThat(fido.getColour(), hasItems("Black", "Tan"));
        assertThat(fido.getColour(), not(hasItems("White", "Brown")));
    }
}
