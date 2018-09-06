package com.jj.pikachu.di.injector;

import com.jj.pikachu.aplication.AndroidAplication;
import com.jj.pikachu.di.components.ApplicationComponent;
import com.jj.pikachu.di.components.DaggerApplicationComponent;
import com.jj.pikachu.di.modules.ApplicationModule;


/**
 * Created by imac2 on 5/09/18.
 */

public class DependencyInjector {
    private static ApplicationModule applicationModule;
    private static ApplicationComponent applicationComponent;

    public DependencyInjector(){
    }

    public static  void initialize(AndroidAplication androidAplication){

        applicationModule = new ApplicationModule(androidAplication);
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(applicationModule).build();

    }

    public static ApplicationComponent applicationComponent(){
        return applicationComponent;
    }

}
