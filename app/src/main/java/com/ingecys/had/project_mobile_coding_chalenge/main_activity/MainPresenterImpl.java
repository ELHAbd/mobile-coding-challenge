package com.ingecys.had.project_mobile_coding_chalenge.main_activity;

import android.util.Log;


import com.ingecys.had.project_mobile_coding_chalenge.model.Items;

import java.util.List;

public class MainPresenterImpl  implements MainContract.presenter, MainContract.GetItemsRepoIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetItemsRepoIntractor getNoticeIntractor;


    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetItemsRepoIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void requestDataFromServer() {

        getNoticeIntractor.getItemsRepoArrayList(this);


    }

    @Override
    public void onFinished(List<Items> noticeArrayList) {

        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);

        }

    }

    @Override
    public void onFailure(Throwable t) {

        if(mainView != null){
            mainView.onResponseFailure(t);

        }

    }
}
