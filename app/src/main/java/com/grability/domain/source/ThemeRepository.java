package com.grability.domain.source;

import android.support.annotation.NonNull;

import com.grability.domain.entity.Child;
import com.grability.ui.activity.theme.ThemeContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class ThemeRepository implements ThemeContract.Repository {

    private ThemeContract.ThemeLocalDataSource localDataSource;
    private ThemeContract.ThemeRemoteDataSource remoteDataSource;

    @Inject
    public ThemeRepository(ThemeContract.ThemeLocalDataSource localDataSource, ThemeContract.ThemeRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getThemes(@NonNull final LoadThemeCallback callback) {
        localDataSource.getThemesLocal(new GetThemesLocalCallback() {
            @Override
            public void onThemeLoaded(List<Child> children) {
                callback.onThemeLoaded(children);
            }

            @Override
            public void onDataNotAvailable() {
                remoteDataSource.getThemes(new LoadThemeCallback() {
                    @Override
                    public void onThemeLoaded(List<Child> children) {
                        refreshLocalDataSource(children);
                        callback.onThemeLoaded(children);
                    }

                    @Override
                    public void onErrorOcurred() {
                        callback.onErrorOcurred();
                    }

                    @Override
                    public void onErrorNetwork() {
                        callback.onErrorNetwork();
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void getThemesLocal(@NonNull final GetThemesLocalCallback callback) {
        localDataSource.getThemesLocal(new GetThemesLocalCallback() {
            @Override
            public void onThemeLoaded(List<Child> children) {
                callback.onThemeLoaded(children);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getTheme(@NonNull String themeId, @NonNull final GetThemeCallback callback) {
        localDataSource.getTheme(themeId, new GetThemeCallback() {
            @Override
            public void onThemeLoaded(Child child) {
                callback.onThemeLoaded(child);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveTheme(@NonNull Child child) {

    }

    @Override
    public void refreshThemes(@NonNull final LoadThemeCallback callback) {
        remoteDataSource.getThemes(new LoadThemeCallback() {
            @Override
            public void onThemeLoaded(List<Child> children) {
                refreshLocalDataSource(children);
                callback.onThemeLoaded(children);
            }

            @Override
            public void onErrorOcurred() {
                callback.onErrorOcurred();
            }

            @Override
            public void onErrorNetwork() {
                callback.onErrorNetwork();
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void deleteAllThemes() {
        localDataSource.deleteAllThemes();
    }

    private void refreshLocalDataSource(List<Child> children) {
        localDataSource.deleteAllThemes();
        for (Child child : children) {
            localDataSource.saveTheme(child);
        }
    }

}