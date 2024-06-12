package dev.n3shemmy3.kutamba.ui.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.CircularProgressIndicator;

import dev.n3shemmy3.kutamba.R;
import dev.n3shemmy3.kutamba.ui.util.InsetsUtil;
import dev.n3shemmy3.kutamba.ui.widget.ThemedSwipeRefreshLayout;

/*
    Created 17.04.2024
    A Fragment that holds a RecyclerView
    Shows a SwipeRefreshLayout, errorView & loaderView;
    Based on the list content
 */
public abstract class BaseRecyclerFragment extends BaseFragment {
    public BaseRecyclerFragment(){}
    protected View root;
    protected ThemedSwipeRefreshLayout refreshLayout;
    protected FrameLayout wrapperView;
    public RecyclerView recyclerView;
    protected RelativeLayout statusView;
    protected CircularProgressIndicator statusLoader;
    protected TextView statusTitle;
    protected TextView statusSubTitle;
    protected Button statusButton;

    protected boolean refreshEnabled;
    protected boolean isRefreshing;
    protected boolean isLoading;
    @NonNull
    protected abstract RecyclerView.LayoutManager onCreateLayoutManager();
    public void onRefresh(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_recycler, container, false);
        refreshLayout = root.findViewById(R.id.refreshLayout);
        wrapperView = root.findViewById(R.id.wrapperView);
        recyclerView = root.findViewById(R.id.recyclerView);
        statusView = root.findViewById(R.id.statusView);
        statusLoader = root.findViewById(R.id.statusLoader);
        statusTitle = root.findViewById(R.id.statusTitle);
        statusSubTitle = root.findViewById(R.id.statusSubTitle);
        statusButton = root.findViewById(R.id.statusButton);

        if (refreshEnabled) {
            refreshLayout.setOnRefreshListener(this::onRefresh);
            refreshLayout.setEnabled(refreshEnabled);
        }
        RecyclerView.LayoutManager layoutManager = onCreateLayoutManager();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        InsetsUtil.addSystemBarsInsets(recyclerView,false,false,false,true);
        showLoader();
        return root;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("layoutManager", onCreateLayoutManager().onSaveInstanceState());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getArguments() == null) return;
        RecyclerView.LayoutManager layoutManager = onCreateLayoutManager();
        layoutManager.onRestoreInstanceState(getArguments().getParcelable("layoutManager"));
        recyclerView.setLayoutManager(layoutManager);
    }  public void setRefreshEnabled(boolean refreshEnabled) {
        this.refreshEnabled = refreshEnabled;
        if (refreshLayout != null) refreshLayout.setEnabled(refreshEnabled);
    }

    public void showLoader() {
        if (statusView == null) return;
        isLoading = true;
        setRefreshEnabled(false);
        statusView.setVisibility(View.VISIBLE);
        statusLoader.show();

        recyclerView.setVisibility(View.GONE);
        statusTitle.setVisibility(View.GONE);
        statusSubTitle.setVisibility(View.GONE);
        statusButton.setVisibility(View.GONE);
    }

    public void showRecycler() {
        if (recyclerView == null) return;
        isLoading = false;
        recyclerView.setVisibility(View.VISIBLE);

        statusView.setVisibility(View.GONE);
        statusLoader.hide();
        statusTitle.setVisibility(View.GONE);
        statusSubTitle.setVisibility(View.GONE);
        statusButton.setVisibility(View.GONE);
    }
}
