package com.grability.domain.source;

import android.support.annotation.NonNull;

import com.grability.domain.entity.Child;

import java.util.List;

/**
 * Created by rogerp91 on 19/01/17.
 */

public interface ThemeDataSource {

    interface LoadThemeCallback {

        void onThemeLoaded(List<Child> children);

        void onErrorOcurred();

        void onErrorNetwork();

        void onDataNotAvailable();
    }


    interface GetThemesLocalCallback {

        void onThemeLoaded(List<Child> children);

        void onDataNotAvailable();
    }

    interface GetThemeCallback {

        void onThemeLoaded(Child child);

        void onDataNotAvailable();
    }

    void getThemes(@NonNull LoadThemeCallback callback);

    void getThemesLocal(@NonNull GetThemesLocalCallback callback);

    void getTheme(@NonNull String themeId, @NonNull GetThemeCallback callback);

    void saveTheme(@NonNull Child child);

    void refreshThemes(@NonNull LoadThemeCallback callback);

    void deleteAllThemes();

}