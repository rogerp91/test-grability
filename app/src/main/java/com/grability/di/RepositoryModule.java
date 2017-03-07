package com.grability.di;

import com.grability.domain.source.ThemeRepository;
import com.grability.ui.activity.theme.ThemeContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(complete = false, library = true)
public class RepositoryModule {

    @Provides
    @Singleton
    ThemeContract.Repository provideRepositoryRepository(ThemeRepository repository) {
        return repository;
    }

}