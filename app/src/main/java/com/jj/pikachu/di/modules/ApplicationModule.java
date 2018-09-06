package com.jj.pikachu.di.modules;

import android.content.Context;

import com.jj.pikachu.aplication.AndroidAplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by imac2 on 5/09/18.
 */
@Module
public class ApplicationModule {

    private final AndroidAplication androidAplication;

    public ApplicationModule( AndroidAplication androidAplication){
        this.androidAplication = androidAplication;
    }

    @Singleton
    @Provides
    Context context(){
        return this.androidAplication;
    }

    @Singleton
    @Provides
    RealmConfiguration providerRealmConfiguration(Context context){
        Realm.init(context);
        return new RealmConfiguration.Builder().name("game").build();
    }

}
