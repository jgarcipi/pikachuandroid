package com.jj.pikachu.aplication;
import android.app.Application;

import com.jj.pikachu.di.injector.DependencyInjector;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by imac2 on 4/09/18.
 */

public class AndroidAplication extends  Application {
    @Override
    public void onCreate(){
        super.onCreate();

        this.initializeInjector();

    }


    private void initializeInjector() {

        DependencyInjector.initialize(this);

    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }
}
