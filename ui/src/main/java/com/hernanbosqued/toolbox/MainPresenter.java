package com.hernanbosqued.toolbox;

import android.support.annotation.NonNull;

import com.hernanbosqued.toolbox.domain.Section;
import com.hernanbosqued.toolbox.domain.SectionsService;

import java.util.List;

class MainPresenter extends BasePresenter<List<Section>, MainContract.View> {
    private SectionsService service;

    MainPresenter(SectionsService service) {
        this.service = service;
    }

    public void bindView(@NonNull MainContract.View view, boolean hasData) {
        super.bindView(view);

        if (model == null || !hasData) {
            view.showLoading();
            setModel(service.getSections());
        }
    }

    @Override
    protected void updateView() {
        if (model.size() == 0) {
            view().showEmpty();
        } else {
            view().showSections(model);
        }
    }
}
