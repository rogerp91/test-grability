package com.grability.di;

import com.grability.domain.source.local.ThemeLocalDataSource;
import com.grability.domain.source.remote.ThemeRemoteDataSource;
import com.grability.ui.activity.theme.ThemeContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(complete = false, library = true)
public class DataSourceModule {

    @Provides
    @Singleton
    ThemeContract.ThemeLocalDataSource provideLocalDataSourceTheme(ThemeLocalDataSource dataSource) {
        return dataSource;
    }

    @Provides
    @Singleton
    ThemeContract.ThemeRemoteDataSource provideRemoteDataSourceTheme(ThemeRemoteDataSource dataSource) {
        return dataSource;
    }

}