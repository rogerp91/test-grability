package com.grability.di;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(includes = {
        FragmentGraphInjectModule.class,
        PresenterModule.class,
        RepositoryModule.class,
        DataSourceModule.class,
        ClientModule.class
},
        library = true,
        complete = false)
public class FragmentModule {

    private final Activity activityContext;

    public FragmentModule(Activity activityContext) {
        this.activityContext = activityContext;
    }

    @Provides
    Context provideActivityContext() {
        return activityContext;
    }

    @Provides
    Activity provideActivityActivity() {//para el fragment
        return activityContext;
    }
}