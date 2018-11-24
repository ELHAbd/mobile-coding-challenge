package com.ingecys.had.project_mobile_coding_chalenge.main_activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ingecys.had.project_mobile_coding_chalenge.R;
import com.ingecys.had.project_mobile_coding_chalenge.adapter.RecyclerViewAdapter_Repos;
import com.ingecys.had.project_mobile_coding_chalenge.model.Items;


import java.util.ArrayList;
import java.util.List;


public class ReposFrag extends Fragment implements MainContract.MainView{


    private View rootView;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private MainContract.presenter presenter;
    List<Items> itemsList ;

    public static int nbrPage =1;
    public ReposFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_repos, container, false);


        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        initializeRecyclerView();



        presenter = new MainPresenterImpl(this, new GetItemsRepoIntractorImpl());
        presenter.requestDataFromServer();

    }

    private void initializeRecyclerView() {

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mLayoutManager= new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        itemsList = new ArrayList<>();
    }



    @Override
    public void setDataToRecyclerView(List<Items> itemsArrayList) {



        itemsList.addAll(itemsArrayList);

        Log.d("itemsList", new Gson().toJson(itemsList));
        mAdapter = new RecyclerViewAdapter_Repos(itemsList) {
            @Override
            public void load() {

                presenter.requestDataFromServer();

            }
        };
        mRecyclerView.setAdapter(mAdapter);

        nbrPage++ ;

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}
