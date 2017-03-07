package com.grability.ui.activity.detail;

import com.grability.domain.entity.Child;
import com.grability.domain.entity.Data_;
import com.grability.domain.source.ThemeDataSource;
import com.grability.ui.activity.theme.ThemeContract;
import com.grability.util.Functions;
import com.grability.util.SelectsImage;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class DetailThemePresenter implements ThemeDetailContract.Presenter {

    private ThemeDetailContract.View view;
    private ThemeContract.Repository repository;

    @Inject
    DetailThemePresenter(ThemeContract.Repository repository) {
        this.repository = repository;
    }

    @Override
    public void setView(ThemeDetailContract.View view) {
        checkNotNull(view, "View not null!");
        this.view = view;
    }

    @Override
    public void start(String themeId) {
        repository.getTheme(themeId, new ThemeDataSource.GetThemeCallback() {
            @Override
            public void onThemeLoaded(Child child) {
                if (!view.isActive()) {
                    return;
                }
                showTheme(child);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    /**
     * @param child @{@link Child}
     */
    private void showTheme(Child child) {
        Data_ data_ = child.getData();
        view.showTitle(data_.getTitle());
        view.showDate(Functions.getDate(data_.getCreatedUtc()));
        String url = data_.getBannerImg();
        if (url.isEmpty()) {
            url = SelectsImage.selectImg();
        }
        view.showImageBanner(url);

        view.showDescription(data_.getDescription());

        if (data_.getSubmitText().isEmpty()) {
            view.showSubmit(data_.getSubmitText());
        } else {
            view.showSubmit("Actualmente este texto no disponible!");
        }
    }

}
