package com.jj.pikachu.di.components;

import com.jj.pikachu.di.modules.ActivityModule;
import com.jj.pikachu.di.scopes.PerActivity;
import com.jj.pikachu.Views.saveGame.SaveGame;

import dagger.Component;

/**
 * Created by imac2 on 6/09/18.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface SaveGameComponent {

    void inject(SaveGame saveGame);

}
