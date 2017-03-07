package com.grability.di;


import com.grability.ui.activity.detail.ThemeDetailActivity;
import com.grability.ui.activity.theme.ThemeActivity;

import dagger.Module;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(
        injects = {
                ThemeActivity.class,
                ThemeDetailActivity.class
        },
        complete = false
)
class ActivityGraphModule {

}
