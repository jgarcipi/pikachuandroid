package com.jj.pikachu.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by imac2 on 5/09/18.
 */

public class SequencesEntity extends RealmObject{
    String name;
    String lastname;

    public SequencesEntity() {
    }

    public SequencesEntity(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public static List<Secuence> getListSecuence(RealmList<SequencesEntity> realmList){
        if(realmList==null)
            return Collections.emptyList();
        List<Secuence> secuenceList = new ArrayList<>();
        for (SequencesEntity sequencesEntity: realmList){
            secuenceList.add(SequencesEntity.toSecuence(sequencesEntity));
        }
        return secuenceList;
    }

    public static Secuence toSecuence(SequencesEntity sequencesEntity){
        return new Secuence(sequencesEntity.name,sequencesEntity.lastname);
    }
}
