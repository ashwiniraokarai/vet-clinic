package serenitylabs.tutorials.vetclinic.playingball.model;

//A Factory Class/ Object whose job is to simply instantiate and return an entirely different object
//Notice how the caller doesn't ever have to instantiate this Class
public class FetchGame {
    public static Player called(Game game){
        switch(game) {
            case Football: return new FootBallGame();
            case Tennis: return new TennisGame();
            case Cricket: return new CricketGame();
            case Handball: return new HandBallGame();
            case Hockey: return new HockeyGame();
            default: throw new DontRecognizeThisGameException();
        }
    }
}
