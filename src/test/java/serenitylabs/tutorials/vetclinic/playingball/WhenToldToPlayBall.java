package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class WhenToldToPlayBall {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setOutput() {
        System.setOut(new PrintStream(output, true));
    }

    @Test
    public void child_should_play_cricket_if_asked() {

        Child bill = new Child();

        bill.goPlay(Cricket);

        assertThat(output.toString(), equalTo("Hit the wicket\r\n"));
    }

    @Test
    public void child_should_play_tennis_if_asked() {

        Child bill = new Child();

        bill.goPlay(Tennis);

        assertThat(output.toString(), equalTo("Serve the ball\r\n"));
    }

    @Test
    public void child_should_play_football_if_asked() {

        Child bill = new Child();

        bill.goPlay(Football);

        assertThat(output.toString(), equalTo("Kick the ball\r\n"));
    }

    @Test
    public void child_should_play_handball_if_asked() {

        Child bill = new Child();

        bill.goPlay(Handball);

        assertThat(output.toString(), equalTo("Throw the ball\r\n"));
    }

    @Test
    public void child_should_play_hockey_if_asked() {

        Child bill = new Child();

        bill.goPlay(Hockey);

        assertThat(output.toString(), equalTo("Hit the ball with the stick\r\n"));
    }
}
