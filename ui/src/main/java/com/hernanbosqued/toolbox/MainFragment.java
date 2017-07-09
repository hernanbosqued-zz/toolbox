package com.hernanbosqued.toolbox;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.hernanbosqued.toolbox.domain.SectionEntity;
import java.util.List;

public class MainFragment extends BaseFragment<MainFragment.Callbacks> implements BaseFragmentActivity.BackPressedCallbacks, MainContract.View {

    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected Callbacks getDummyCallbacks() {
        return new Callbacks() {
            @Override
            public void onButtonClicked() {

            }
        };
    }

    public interface Callbacks {
        void onButtonClicked();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadSections();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSections(List<SectionEntity> entities) {
        recyclerView.setAdapter(new SectionAdapter(entities));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onBackPressedCallback() {
        return false;
    }
}
