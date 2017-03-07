package com.grability.ui.activity.theme;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.grability.R;
import com.grability.ui.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class ThemeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getLayout() {
        return R.layout.activity_theme;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setToolbar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content, ThemeFragment.newInstance())
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();

        }
    }

}