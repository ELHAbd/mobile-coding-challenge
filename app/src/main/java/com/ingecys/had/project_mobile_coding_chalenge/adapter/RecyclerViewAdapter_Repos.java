package com.ingecys.had.project_mobile_coding_chalenge.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ingecys.had.project_mobile_coding_chalenge.R;
import com.ingecys.had.project_mobile_coding_chalenge.method.Method;
import com.ingecys.had.project_mobile_coding_chalenge.model.Items;

import java.util.List;

public abstract class RecyclerViewAdapter_Repos extends RecyclerView.Adapter<RecyclerViewAdapter_Repos.ViewHolder> {


   private List<Items> itemsList ;
    @NonNull
    @Override
    public RecyclerViewAdapter_Repos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_view, parent, false);
        RecyclerViewAdapter_Repos.ViewHolder viewHolder1 = new RecyclerViewAdapter_Repos.ViewHolder(parent.getContext(), view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_Repos.ViewHolder holder, int position) {

        Items items =itemsList.get(position);

      //  holder.tv_nbr_stars.setText(Method.coolFormat(Double.parseDouble(items.getStargazers_count()), 0));

        holder.tv_nbr_stars.setText(Method.getFormatNumber(Integer.parseInt(items.getStargazers_count())));

        holder.tv_repos_description.setText(items.getDescription());

        holder.tv_repos_name.setText(items.getName());


        holder.tv_repos_owner_name.setText(items.getOwner().getLogin());


        if ((position >= getItemCount() - 1) || position ==1) {
            load();
        }

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class    ViewHolder extends RecyclerView.ViewHolder {



        private TextView tv_nbr_stars, tv_repos_description,  tv_repos_owner_name, tv_repos_name;
        public ViewHolder(final Context context, View itemView) {
            super(itemView);


            tv_repos_name = itemView.findViewById(R.id.tv_repos_name);
            tv_repos_owner_name = itemView.findViewById(R.id.tv_repos_owner_name);
            tv_repos_description  = itemView.findViewById(R.id.tv_repos_description);
            tv_nbr_stars =  itemView.findViewById(R.id.tv_nbr_stars);

        }
    }

    public RecyclerViewAdapter_Repos(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public abstract void load();



}
