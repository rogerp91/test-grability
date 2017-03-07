package com.grability.di;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(
        includes = {
                ActivityGraphModule.class
        },
        library = true,
        complete = false)
public class ActivityModule {

    private Activity activityContext;

    public ActivityModule(Activity activityContext) {
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