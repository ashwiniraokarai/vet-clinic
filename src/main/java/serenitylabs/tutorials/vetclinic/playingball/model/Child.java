package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class Child {
    public void goPlay(Game game) {
        Player rightTypeOfGame = fetchRightTypeOfGame(game);
        rightTypeOfGame.play();
    }

    public Player fetchRightTypeOfGame(Game game) {
        switch(game){
            case Football: return new FootBallGame();
            case Tennis: return new TennisGame();
            case Hockey: return new HockeyGame();
            case Handball: return new HandBallGame();
            case Cricket: return new CricketGame();
            default: throw new DontRecognizeThisGameException();
        }
    }
}
