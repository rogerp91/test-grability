package com.grability.di;

import com.grability.ForApplication;
import com.grability.TestGrability;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(
        injects = TestGrability.class,
        library = true,
        includes = {
                ExecutorModule.class
        }
)
public class AppModules {

    public TestGrability app;

    public AppModules(TestGrability app) {
        this.app = app;
    }

    @ForApplication
    @Provides
    @Singleton
    TestGrability provideApplication() {
        return this.app;
    }

}