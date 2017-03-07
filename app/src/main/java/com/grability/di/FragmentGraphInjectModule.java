package com.grability.di;

import com.grability.ui.activity.detail.DetailThemeFragment;
import com.grability.ui.activity.theme.ThemeFragment;

import dagger.Module;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Module(injects = {
        ThemeFragment.class,
        DetailThemeFragment.class

}, complete = false, library = true)
public class FragmentGraphInjectModule {
}
