package com.grability.ui.activity.detail;

/**
 * Created by rogerp91 on 03/03/17.
 */

public interface ThemeDetailContract {

    // TODO: View
    interface View {

        void showTitle(String title);

        void showDate(String date);

        void showImageBanner(String img);

        void showDescription(String description);

        void showSubmit(String submit);

        boolean isActive();

    }


    // TODO: Presenter
    interface Presenter {

        void setView(View view);

        void start(String themeId);

    }

}