package com.jj.pikachu.di.modules;

import android.app.Activity;

import com.jj.pikachu.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imac2 on 5/09/18.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule( Activity activity){

        this.activity = activity;
    }

    @PerActivity
    @Provides
    Activity providerActivity (){
        return this.activity;
    }

}
