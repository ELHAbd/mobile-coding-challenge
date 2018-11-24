package com.ingecys.had.project_mobile_coding_chalenge.main_activity;



import com.ingecys.had.project_mobile_coding_chalenge.method.Method;
import com.ingecys.had.project_mobile_coding_chalenge.model.Repos;
import com.ingecys.had.project_mobile_coding_chalenge.rest_network.GitHubService;
import com.ingecys.had.project_mobile_coding_chalenge.rest_network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetItemsRepoIntractorImpl implements MainContract.GetItemsRepoIntractor {


   public static int nbrPage =1;
    @Override
    public void getItemsRepoArrayList(final OnFinishedListener onFinishedListener) {


        GitHubService service = RetrofitInstance.getRetrofitInstance().create(GitHubService.class);

        /** Call the method with parameter in the interface to get the Items Repos data*/


        Call<Repos> call = service.getItemsRepository("created:>"+ Method.getYesterdayDateString() , String.valueOf(nbrPage));


        call.enqueue(new Callback<Repos>() {
            @Override
            public void onResponse(Call<Repos> call, Response<Repos> response) {


               if (response.body() != null)
                onFinishedListener.onFinished(response.body().getItems());

                nbrPage++;
            }

            @Override
            public void onFailure(Call<Repos> call, Throwable t) {


                onFinishedListener.onFailure(t);
            }
        });

    }
}
