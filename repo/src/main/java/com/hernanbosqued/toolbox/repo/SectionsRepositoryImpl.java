package com.hernanbosqued.toolbox.repo;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hernanbosqued.toolbox.domain.Section;
import com.hernanbosqued.toolbox.domain.SectionsRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SectionsRepositoryImpl implements SectionsRepository {

    private Context context;

    public SectionsRepositoryImpl(Context context){
        this.context = context;
    }

    @Override
    public List<Section> getSections() {
        InputStream raw = this.context.getResources().openRawResource(R.raw.data);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new Gson();
        return gson.fromJson(rd, new TypeToken<ArrayList<Section>>() { }.getType());
    }
}
