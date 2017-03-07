package com.grability;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;

import com.grability.di.AppModules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import dagger.ObjectGraph;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class TestGrability extends Application {

    // Dagger
    private ObjectGraph objectGraph;

    // App Global
    private static TestGrability instance;

    /**
     * @return Application
     */
    public static TestGrability getInstance() {
        return instance;
    }

    /**
     * @return Context
     */
    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //Dagger
        initDependencyInjection();

        SystemClock.sleep(TimeUnit.SECONDS.toMillis(1));//Splash
    }

    /**
     * @param modules {@link Object}
     * @return ObjectGraph
     */
    public ObjectGraph buildGraphWithAditionalModules(List<Object> modules) {
        if (modules == null) {
            throw new IllegalArgumentException("Los módulos no pueden ir a los nulos");
        }
        return objectGraph.plus(modules.toArray());
    }

    /**
     * Inject to {@link Application}
     */
    public void initDependencyInjection() {
        objectGraph = ObjectGraph.create(new AppModules(this));
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }

}