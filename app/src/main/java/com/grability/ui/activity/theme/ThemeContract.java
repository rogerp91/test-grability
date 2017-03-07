package com.grability.ui.activity.theme;

import android.provider.BaseColumns;

import com.grability.domain.entity.Child;
import com.grability.domain.source.ThemeDataSource;

import java.util.List;

/**
 * Created by rogerp91 on 19/01/17.
 */

public interface ThemeContract {

    // TODO: View
    interface View {

        void setLoadingIndicator(boolean active);

        void showTheme(List<Child> children);

        void showThemeDetailsUi(String themeId);

        void showProgress(final boolean active);

        void showNoTheme(boolean active);

        void showSuccessfullyMessage();

        void showNetworkError(boolean active);

        void showErrorOcurred(boolean active);

        void showMessage(String message);

        void showOnline();

        void showNotOnline();

        boolean isActive();

    }


    // TODO: Presenter
    interface Presenter {

        void setView(View view);

        void start();

        void loadModels(boolean showLoadingUI);

        void deleteAllModels();

        void checkInternet();

        void themeOpen(String idTheme);
    }


    // TODO: Repositorio
    interface Repository extends ThemeDataSource {

    }

    // TODO: Origen de datos remoto
    interface ThemeRemoteDataSource extends ThemeDataSource {

    }

    // TODO: Origen de datos local
    interface ThemeLocalDataSource extends ThemeDataSource {

    }

    abstract class ThemeEntry implements BaseColumns {
        public static final String TABLE_NAME = "Theme";
        public static final String COLUMN_ID_AUX = "id_aux";
        public static final String COLUMN_BANNER_IMG = "banner_img";
        public static final String COLUMN_SUBMIT_TEXT_HTML = "submit_text_html";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SUBMIT_TEX = "submit_tex";
        public static final String COLUMN_DISPLAY_NAME = "display_name";
        public static final String COLUMN_HEADER_IMG = "header_img";
        public static final String COLUMN_DESCRIPTION_HTML = "description_html";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_ICON_IMG = "icon_img";
        public static final String COLUMN_HEADER_TITLE = "header_title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_SUBSCRIBERS = "subscribers";
        public static final String COLUMN_SUBMIT_TEXT_LABEL = "submit_text_label";
        public static final String COLUMN_LANG = "lang";
        public static final String COLUMN_KEY_COLOR = "key_color";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CREATED = "created";
        public static final String COLUMN_CREATED_UTC = "created_utc";
        public static final String COLUMN_PUBLIC_DESCRIPTION = "public_description";
    }

}