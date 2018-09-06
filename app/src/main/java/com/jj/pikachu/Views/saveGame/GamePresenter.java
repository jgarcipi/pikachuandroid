package com.jj.pikachu.Views.saveGame;

import android.support.annotation.NonNull;

import com.jj.pikachu.di.scopes.PerActivity;
import com.jj.pikachu.entities.Game;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by imac2 on 6/09/18.
 */
@PerActivity
public class GamePresenter {
    private GameView gameView;
    @Inject
    public GamePresenter() {
    }

    public void setGameView(@NonNull GameView gameView) {
        this.gameView = gameView;
    }

    public void saveGame(Game game){
        if(gameView==null)
            return;
        this.gameView.saveGame(game);
    }

    public void loadGames(){
        if(gameView==null)
            return;
        this.gameView.loadGames();
    }

    public void showGames(List<Game> gameList){
        if(gameView==null)
            return;
        this.gameView.showGames(gameList);
    }

    public interface GameView {
        void saveGame(Game game);

        void showGames(List<Game> gameList);

        void loadGames();
    }
}
