package com.ljr.study.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljr.study.R;
import com.ljr.study.service.TestIntentService;

public class TestFragment extends Fragment {

    private String name;

    public static Fragment newInstance(String title) {
        Fragment fragment = new TestFragment();
        Bundle arguments = new Bundle();
        arguments.putString("title", title);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("FragmentAct2", "FragmentAct2  --- onAttach");
        Log.d("FragmentAct2", "-------------");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        name = arguments.getString("title");
        Log.d("FragmentAct2", "FragmentAct2  --- onCreate ; name =  " +  name) ;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_view, container, false);
        TextView textView = root.findViewById(R.id.title);
        textView.setText(name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), TestIntentService.class);
                getActivity().startService(intent);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FragmentAct2", "FragmentAct2  --- onViewCreated  name  = " + name);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentAct2", "FragmentAct2  --- onStart  name  = " + name);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentAct2", "FragmentAct2  --- onResume  name  = " + name);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("FragmentAct2", "FragmentAct2  --- onSaveInstanceState  name  = " + name);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("FragmentAct2", "FragmentAct2  --- onViewStateRestored  name  = " + name);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentAct2", "FragmentAct2  --- onPause  name  = " + name);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FragmentAct2", "FragmentAct2  --- onStop  name  = " + name);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentAct2", "FragmentAct2  --- onDestroyView  name  = " + name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentAct2", "FragmentAct2  --- onDestroy  name  = " + name);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FragmentAct2", "FragmentAct2  --- onDetach  name  = " + name);
        Log.d("FragmentAct2", "----------------");
    }
}
