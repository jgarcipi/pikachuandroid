package com.jj.pikachu.Views.saveGame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;

import com.jj.pikachu.di.components.ApplicationComponent;
import com.jj.pikachu.di.components.DaggerSaveGameComponent;
import com.jj.pikachu.di.components.SaveGameComponent;
import com.jj.pikachu.di.injector.DependencyInjector;
import com.jj.pikachu.entities.Game;
import com.jj.pikachu.entities.GameEntity;
import com.jj.pikachu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

public class SaveGame extends AppCompatActivity implements GamePresenter.GameView {

    @BindView(R.id.edtName)
    EditText edtName;

    @BindView(R.id.edtDescription)
    EditText edtDescription;

    @BindView((R.id.list_games))
    RecyclerView recyclerGames;

    SaveGameComponent saveGameComponent;

    String message = "Default message";

    private RecyclerView.LayoutManager mlayoutManager;

    @Inject
    SaveGameAdapter mAdapter;
    @Inject
    GamePresenter presenter;

    @Inject
    RealmConfiguration realmConfiguration;


    public static Intent getCallIntent(Context context) {

        return new Intent(context, SaveGame.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savegame);
        ButterKnife.bind(this);
        setUpView();
        loadGameList();
    }


    private void loadGameList() {
        try (Realm realm = Realm.getInstance(realmConfiguration)) {
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmList<GameEntity> listGameEntities = new RealmList<GameEntity>();
                    RealmResults<GameEntity> gameEntities = realm.where(GameEntity.class).findAll();
                    listGameEntities.addAll(gameEntities.subList(0, gameEntities.size()));
                    presenter.showGames(GameEntity.getGameList(listGameEntities));
                }
            });
        }
    }

    private void setUpView() {
        ButterKnife.bind(this);
        this.initializeInjector(DependencyInjector.applicationComponent());
        this.saveGameComponent.inject(this);
        this.presenter.setGameView(this);
        setUptRecyclerView();

    }

    private void initializeInjector(ApplicationComponent applicationComponent) {

        this.saveGameComponent = DaggerSaveGameComponent.builder().applicationComponent(applicationComponent).build();
    }


    private void setUptRecyclerView() {
        // this.mAdapter.setItemClick(this.itemClick);
        recyclerGames.setHasFixedSize(true);
        recyclerGames.setNestedScrollingEnabled(false);
        mlayoutManager = new LinearLayoutManager(this);
        recyclerGames.setLayoutManager(mlayoutManager);
        recyclerGames.setLayoutManager(mlayoutManager);
        recyclerGames.setAdapter(mAdapter);
    }

   /*  SaveGameAdapter.ItemClick itemClick = (this:: menuItemClick);

   private void menuItemClick() {

        this.menuPresenter.goToLink(menuItem.first);

    } */

    @OnClick(R.id.save_game)
    public void clickSaveGame() {
        if (!edtName.getText().toString().isEmpty() && !edtDescription.getText().toString().isEmpty()){
            Game game = new Game();
            game.setName(edtName.getText().toString());
            game.setDescription(edtDescription.getText().toString());
            this.presenter.saveGame(game);
            edtName.setText("");
            edtDescription.setText("");
        }
    }

    @Override
    public void saveGame(Game game) {
        GameEntity gameEntity = new GameEntity(game);
        Realm realm = Realm.getInstance(realmConfiguration);
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Number currentIdNum = realm.where(GameEntity.class).max("gameid");
                    int nextId;
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    gameEntity.setId(nextId);

                    realm.insertOrUpdate(gameEntity);
                    message = "success play game";
                    System.out.print(message);
                }
            });

        } catch (Exception ex) {
            this.message = "Error save play game" + ex.getMessage();
            System.out.print(message);
        } finally {
            realm.close();
        }
        System.out.print("load games");
        this.presenter.loadGames();
    }

    @Override
    public void showGames(List<Game> gameList) {
        mAdapter.setGamesList(gameList);
    }

    @Override
    public void loadGames() {
        loadGameList();
    }

}