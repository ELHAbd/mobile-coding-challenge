package com.ingecys.had.project_mobile_coding_chalenge.main_activity;

import com.ingecys.had.project_mobile_coding_chalenge.model.Items;

import java.util.List;

public interface MainContract {



    interface presenter{

        //fetch data from server
        void requestDataFromServer();
    }


    interface MainView {

        void setDataToRecyclerView(List<Items> itemsArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface GetItemsRepoIntractor {

        interface OnFinishedListener {
            void onFinished(List<Items> noticeArrayList);
            void onFailure(Throwable t);
        }

        void getItemsRepoArrayList(OnFinishedListener onFinishedListener);
    }
}
