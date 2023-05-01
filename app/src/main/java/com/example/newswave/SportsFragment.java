package com.example.newswave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    String api="cb9de153f96f4c40a05e696d4f0fd6f6";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="us";
    private RecyclerView recyclerViewOfSports;
    private String category="sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sports_fragment,null);
        recyclerViewOfSports=view.findViewById(R.id.sportsRecyler);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewOfSports.setAdapter(adapter);

        findNews();


        return view;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategotyNews(country,category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}