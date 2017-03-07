package com.grability.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by rogerp91 on 03/03/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        onCreateView(savedInstanceState);
    }

    public void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            mToolbar = toolbar;
            mToolbar.setTitle("");
            mToolbar.setSubtitle("");
            setSupportActionBar(toolbar);
        }
    }

    public void setName(String name) {
        if (mToolbar != null) {
            mToolbar.setTitle(name);
        }
    }

    abstract public int getLayout();

    abstract public void onCreateView(Bundle savedInstanceState);

}