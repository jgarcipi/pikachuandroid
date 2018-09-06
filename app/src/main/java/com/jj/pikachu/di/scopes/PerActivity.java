package com.jj.pikachu.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by imac2 on 5/09/18.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity{

}
