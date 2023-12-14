package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class Child {

    public void goPlay(Game game){
        Player player = fetchRightGame(game);
        player.play();
    }

    public Player fetchRightGame(Game game){
        switch(game) {
            case Football: return new FootBallGame();
            case Tennis: return new TennisGame();
            case Cricket: return new CricketGame();
            case Handball: return new HandBallGame();
            case Hockey: return new HockeyGame();
            default: throw new DontRecognizeThatGameException();
        }
    }
}
