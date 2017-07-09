package com.hernanbosqued.toolbox;

import com.hernanbosqued.toolbox.domain.SectionsService;

class MainPresenter implements MainContract.Presenter {
    private SectionsService service;
    private MainContract.View view;

    MainPresenter(SectionsService service, MainContract.View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadSections() {
        view.showSections(service.getSections());
    }
}
