package com.grability.di;

import com.grability.executor.Executor;
import com.grability.executor.MainThread;
import com.grability.executor.MainThreadImpl;
import com.grability.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(library = true)
public class ExecutorModule {

    @Provides
    @Singleton
    Executor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides
    @Singleton
    MainThread provideMainThread(MainThreadImpl impl) {
        return impl;
    }
}