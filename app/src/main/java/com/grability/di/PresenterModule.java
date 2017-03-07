package com.grability.di;

import com.grability.ui.activity.detail.DetailThemePresenter;
import com.grability.ui.activity.detail.ThemeDetailContract;
import com.grability.ui.activity.theme.ThemeContract;
import com.grability.ui.activity.theme.ThemePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(library = true, complete = false)
public class PresenterModule {

    @Provides
    @Singleton
    ThemeContract.Presenter provideThemePresenter(ThemePresenter presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    ThemeDetailContract.Presenter provideThemeDetailPresenter(DetailThemePresenter presenter) {
        return presenter;
    }
}