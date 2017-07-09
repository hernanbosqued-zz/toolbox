package com.hernanbosqued.toolbox;

import com.hernanbosqued.toolbox.domain.SectionEntity;

import java.util.List;

public class MainContract {
    public interface View extends BaseView<Presenter>{
        void showToast(String message);
        void showSections(List<SectionEntity> entities);
    }
    public interface Presenter{
        void loadSections();
    }
}
