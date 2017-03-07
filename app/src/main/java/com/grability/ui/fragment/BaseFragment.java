package com.grability.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grability.TestGrability;
import com.grability.di.FragmentModule;
import com.grability.domain.entity.ViewPacks;
import com.grability.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import icepick.Icepick;

/**
 * Created by rogerp91 on 03/03/17.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    private BaseActivity activity;

    @Nullable
    private ObjectGraph activityGraph;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        activity = (BaseActivity) getActivity();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);// Landscape o portrait se pierde el contexto
        setRetainInstance(true);
        activity = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getLayoutView(), container, false);
        ButterKnife.bind(this, view);
        onViewReady(new ViewPacks(inflater, container, savedInstanceState, view));
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState); // Landscape o portrait se pierde el contexto
    }

    private void injectDependencies() {
        TestGrability app = (TestGrability) getActivity().getApplication();
        List<Object> activityScopeModules = new ArrayList<>();
        activityScopeModules.add(new FragmentModule(getActivity()));
        activityGraph = app.buildGraphWithAditionalModules(activityScopeModules);
        inject(this);
    }

    public void showView(final boolean active, final View view) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        view.setVisibility(active ? View.VISIBLE : View.GONE);
        view.animate().setDuration(shortAnimTime).alpha(active ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(active ? View.VISIBLE : View.GONE);
            }
        });
    }

    public void showText(TextView textView, String txt) {
        textView.setText(txt);
    }

    private void inject(Object entityToGetInjected) {
        activityGraph.inject(entityToGetInjected);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    public void setName(String name) {
        assert activity != null;
        activity.setName(name);
    }

    abstract public int getLayoutView();

    abstract public String getName();

    abstract public void onViewReady(@NonNull ViewPacks viewPacks);

}