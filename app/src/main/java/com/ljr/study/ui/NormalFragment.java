package com.ljr.study.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NormalFragment extends Fragment {

    public NormalFragment(){
        super();
    }

    @SuppressLint("ValidFragment")
    public NormalFragment(String i){
        super();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
