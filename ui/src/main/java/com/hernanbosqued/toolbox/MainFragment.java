package com.hernanbosqued.toolbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hernanbosqued.toolbox.domain.Item;
import com.hernanbosqued.toolbox.domain.Section;

import java.util.List;

public class MainFragment extends BaseFragment<MainFragment.Callbacks> implements BaseFragmentActivity.BackPressedCallbacks, MainContract.View, ItemViewHolder.OnItemClickListener {

    private MainPresenter presenter;
    private SectionAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            presenter = new MainPresenter(Injection.provideSectionsService(getContext()));
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    protected Callbacks getDummyCallbacks() {
        return new Callbacks() {
            @Override
            public void onButtonClicked(String video) {

            }
        };
    }

    @Override
    public void onItemClick(Item item) {
        if( item.video == null || item.video.isEmpty() ){
            callbacks.onButtonClicked(item.video);
        }
        else{
            callbacks.onButtonClicked(item.video);
        }
    }

    @Override
    public void showNoVideo() {
        Toast.makeText(getActivity(), R.string.no_video, Toast.LENGTH_SHORT).show();
    }

    public interface Callbacks {
        void onButtonClicked(String video);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bindView(this, adapter.hasData());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showSections(List<Section> entities) {
        adapter.setData(entities);
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
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SectionAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onBackPressedCallback() {
        return false;
    }
}
