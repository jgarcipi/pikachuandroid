package com.jj.pikachu.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by imac2 on 3/09/18.
 */

public class GameEntity extends RealmObject {

    @PrimaryKey
    private int gameid;
    private String name;
    private String description;
    private RealmList<SequencesEntity> sequences;

    public GameEntity() {
    }

    public GameEntity(Game game){
        gameid = game.getGameid();
        description = game.getDescription();
    }

    public GameEntity(int gameid, String name, String description, RealmList<SequencesEntity> sequences) {
        this.gameid = gameid;
        this.name = name;
        this.description = description;
        this.sequences = sequences;

    }

    public static List<Game> getGameList(RealmList<GameEntity> gameEntityRealmList){
        if(gameEntityRealmList==null)
            return Collections.emptyList();
        List<Game> gameList = new ArrayList<>();
        for (GameEntity gameEntity: gameEntityRealmList){
            gameList.add(GameEntity.toGame(gameEntity));
        }
        return  gameList;
    }

    public static Game toGame(GameEntity gameEntity) {
        return new Game(gameEntity.getId(),gameEntity.getName(),gameEntity.getDescription(),
                SequencesEntity.getListSecuence(gameEntity.getSequences()));
    }

    public int getId() {
        return gameid;
    }

    public void setId(int id) {
        this.gameid = id;
    }

    public String getName() {
        return name;
    }

    public RealmList<SequencesEntity> getSequences() {
        return sequences;
    }

    public void setSequences(RealmList<SequencesEntity> sequences) {
        this.sequences = sequences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
