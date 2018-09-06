package com.jj.pikachu.di.components;

import android.content.Context;

import com.jj.pikachu.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.RealmConfiguration;

/**
 * Created by imac2 on 5/09/18.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context context();

    RealmConfiguration realmConfiguration();

}
