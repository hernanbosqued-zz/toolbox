package com.hernanbosqued.toolbox.repo;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hernanbosqued.toolbox.domain.SectionEntity;
import com.hernanbosqued.toolbox.domain.SectionsRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SectionsRepositoryImpl implements SectionsRepository {
    private Context context;

    public SectionsRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<SectionEntity> getSections() {
        InputStream raw = context.getResources().openRawResource(R.raw.data);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();
        return gson.fromJson(rd, new TypeToken<ArrayList<SectionEntity>>() { }.getType());
    }
}
