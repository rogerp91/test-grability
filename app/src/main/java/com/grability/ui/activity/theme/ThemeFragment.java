package com.grability.ui.activity.theme;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.roger91.mlprogress.MlProgress;
import com.grability.R;
import com.grability.domain.entity.Child;
import com.grability.domain.entity.Data_;
import com.grability.domain.entity.ViewPacks;
import com.grability.ui.activity.detail.ThemeDetailActivity;
import com.grability.ui.adapte.ThemeAdapte;
import com.grability.ui.fragment.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFragment extends BaseFragment implements ThemeContract.View {

    public static ThemeFragment newInstance() {
        return new ThemeFragment();
    }

    @BindView(R.id.progress)
    MlProgress mProgressView;
    @BindView(R.id.layout_message)
    RelativeLayout mLayoutMessage;
    @BindView(R.id.text_message)
    TextView mTextMessage;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    ThemeContract.Presenter presenter;

    private ThemeAdapte mAdapte;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_theme;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@NonNull ViewPacks viewPacks) {
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(linearManager);

        presenter.setView(this);

        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorAccent)
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadModels(false);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipe);
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(active);
            }
        });
    }

    @Override
    public void showTheme(List<Child> children) {
        mAdapte = new ThemeAdapte(children, themeItemListener);
        mAdapte.setHasStableIds(true);
        mRecycler.setAdapter(mAdapte);
    }

    @Override
    public void showThemeDetailsUi(String themeId) {
        Intent intent = new Intent(getActivity(), ThemeDetailActivity.class);
        intent.putExtra(ThemeDetailActivity.EXTRA_TASK_ID, themeId);
        startActivity(intent);
    }

    @Override
    public void showProgress(final boolean active) {
        showView(active, mProgressView);
    }

    @Override
    public void showNoTheme(final boolean active) {
        showView(active, mLayoutMessage);
        showText(mTextMessage, getString(R.string.no_data_available));
    }

    @Override
    public void showSuccessfullyMessage() {
        Snackbar.make(getView(), getActivity().getResources().getString(R.string.load_content), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(final boolean active) {
        showView(active, mLayoutMessage);
        showText(mTextMessage, getString(R.string.no_connection));
    }

    @Override
    public void showErrorOcurred(final boolean active) {
        showView(active, mLayoutMessage);
        showText(mTextMessage, getString(R.string.error_occurred));
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showOnline() {
        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.yes_connection), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNotOnline() {
        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.no_connection), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @OnClick(R.id.text_try_again)
    void onClickTryAgain() {
        presenter.start();
    }

    ThemeItemListener themeItemListener = new ThemeItemListener() {
        @Override
        public void onDetailTheme(Data_ data_) {
            presenter.themeOpen(data_.getId());
        }
    };

    /**
     * CallBack - Adapte - Boton Detail
     */
    public interface ThemeItemListener {

        void onDetailTheme(Data_ data_);

    }

}
