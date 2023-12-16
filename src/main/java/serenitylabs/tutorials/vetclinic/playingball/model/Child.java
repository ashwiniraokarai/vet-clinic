package serenitylabs.tutorials.vetclinic.playingball.model;

public class Child {

    public void goPlay(Game game){
      Player gameToPlay =  FetchGame.called(game);
      gameToPlay.play();
    }
}
