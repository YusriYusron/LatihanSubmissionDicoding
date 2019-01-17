package com.example.yusriyusron.volume.recycler_view.grid_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.recycler_view.model.Presiden;

import java.util.ArrayList;

public class GridPresidenAdapter extends RecyclerView.Adapter<GridPresidenAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Presiden> listPresiden;

    public GridPresidenAdapter(Context context) {
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
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_presiden,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListPresiden().get(i).getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(gridViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.foto_grid_presiden);
        }
    }
}
