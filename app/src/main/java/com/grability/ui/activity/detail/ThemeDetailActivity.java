package com.grability.ui.activity.detail;

import android.app.ActionBar;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.grability.R;
import com.grability.ui.activity.BaseActivity;

import butterknife.BindView;
import icepick.Icepick;
import icepick.State;

public class ThemeDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    protected ActionBar ab;
    public static final String EXTRA_TASK_ID = "THEME_ID";

    @BindView(R.id.back)
    ImageView back;

    @State
    String themeId;

    @Override
    public int getLayout() {
        return R.layout.activity_theme_detail;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        Icepick.restoreInstanceState(this, savedInstanceState);
        setToolbar(toolbar);
        themeId = getIntent().getStringExtra(EXTRA_TASK_ID);
        if (themeId.isEmpty()) finish();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content, DetailThemeFragment.newInstance(themeId))
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();

        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}