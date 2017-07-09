package com.hernanbosqued.toolbox.domain;

import java.util.List;

public class SectionsService {
    private SectionsRepository repo;

    public SectionsService(SectionsRepository repo){
        this.repo = repo;
    }

    public SectionEntity getFirstSection(){
        return repo.getSections().get(0);
    }
    public List<SectionEntity> getSections(){
        return repo.getSections();
    }
}
