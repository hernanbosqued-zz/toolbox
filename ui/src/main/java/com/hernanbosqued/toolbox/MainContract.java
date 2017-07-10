package com.hernanbosqued.toolbox;

import com.hernanbosqued.toolbox.domain.Section;

import java.util.List;

public class MainContract {
    public interface View{
        void showEmpty();
        void showLoading();
        void showSections(List<Section> entities);
    }
    public interface Presenter{
        void loadSections();
    }
}
