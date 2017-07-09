package com.hernanbosqued.toolbox;

import android.content.Context;
import android.support.annotation.NonNull;
import com.hernanbosqued.toolbox.domain.SectionsService;
import com.hernanbosqued.toolbox.repo.SectionsRepositoryImpl;


class Injection {
    static SectionsService provideSectionsService(@NonNull Context context) {
        return new SectionsService(new SectionsRepositoryImpl(context));
    }
}
