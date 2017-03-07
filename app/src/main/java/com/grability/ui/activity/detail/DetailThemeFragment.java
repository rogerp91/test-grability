package com.grability.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grability.R;
import com.grability.TestGrability;
import com.grability.domain.entity.ViewPacks;
import com.grability.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import icepick.State;


public class DetailThemeFragment extends BaseFragment implements ThemeDetailContract.View {

    private static String TAG = DetailThemeFragment.class.getSimpleName();

    public static final String ARGUMENT_THEME_ID = "THEME_ID";

    @State
    String mThemeId; // Landscape o portrait se pierde el contexto


    public static DetailThemeFragment newInstance(String themeId) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_THEME_ID, themeId);
        DetailThemeFragment fragment = new DetailThemeFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @BindView(R.id.img_banner)
    ImageView imageBanner;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.date)
    TextView mDate;

    @BindView(R.id.description)
    TextView mDescription;

    @BindView(R.id.submit_text)
    TextView mSubmitText;

    @Inject
    ThemeDetailContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mThemeId = getArguments().getString(ARGUMENT_THEME_ID);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            presenter.start(mThemeId);
        } catch (NullPointerException e) {// Landscape o portrait se pierde el contexto
            Log.e(TAG, "onResume: Null savedInstanceState");
        }
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_fragment_detail;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@NonNull ViewPacks viewPacks) {
        presenter.setView(this);
    }

    @Override
    public void showTitle(String title) {
        mName.setText(title);
        setName(title);
    }

    @Override
    public void showDate(String date) {
        mDate.setText(date);
    }

    @Override
    public void showImageBanner(String img) {
        Glide.with(TestGrability.getContext()).load(img).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageBanner);
    }

    @Override
    public void showDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public void showSubmit(String submit) {
        mSubmitText.setText(submit);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}