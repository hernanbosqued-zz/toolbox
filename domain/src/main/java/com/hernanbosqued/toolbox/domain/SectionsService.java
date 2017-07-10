package com.hernanbosqued.toolbox.domain;

import java.util.List;

public class SectionsService {
    private SectionsRepository repo;

    public SectionsService(SectionsRepository repo){
        this.repo = repo;
    }

    public List<Section> getSections(){
        return repo.getSections();
    }
}
