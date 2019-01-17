package com.example.yusriyusron.volume.recycler_view.list_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.recycler_view.model.Presiden;

import java.util.ArrayList;

public class PresidenAdapter extends RecyclerView.Adapter<PresidenAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Presiden> listPresiden;

    public PresidenAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Presiden> getListPresiden() {
        return listPresiden;
    }

    public void setListPresiden(ArrayList<Presiden> listPresiden) {
        this.listPresiden = listPresiden;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president,viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.textName.setText(getListPresiden().get(i).getName());
        categoryViewHolder.textRemarks.setText(getListPresiden().get(i).getRemarks());
        Glide.with(context)
                .load(getListPresiden().get(i).getPhoto())
                .apply(new RequestOptions().override(60,60))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView textName,textRemarks;
        private ImageView imgPhoto;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.item_name);
            textRemarks = itemView.findViewById(R.id.item_remarks);
            imgPhoto = itemView.findViewById(R.id.item_presiden);
        }
    }
}
