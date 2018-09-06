package com.jj.pikachu.entities;

import java.util.List;

/**
 * Created by imac2 on 6/09/18.
 */

public class Game {
    private int gameid;
    private String name;
    private String description;
    private List<Secuence> sequences;

    public Game() {
    }

    public Game(int gameid, String name, String description, List<Secuence> sequences) {
        this.gameid = gameid;
        this.name = name;
        this.description = description;
        this.sequences = sequences;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getName() {
        return name;
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

    public List<Secuence> getSequences() {
        return sequences;
    }

    public void setSequences(List<Secuence> sequences) {
        this.sequences = sequences;
    }
}
