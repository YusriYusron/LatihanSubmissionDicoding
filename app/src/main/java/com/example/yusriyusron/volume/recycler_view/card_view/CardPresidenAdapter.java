package com.example.yusriyusron.volume.recycler_view.card_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yusriyusron.volume.R;
import com.example.yusriyusron.volume.recycler_view.model.Presiden;

import java.util.ArrayList;

public class CardPresidenAdapter extends RecyclerView.Adapter<CardPresidenAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Presiden> listPresiden;

    public CardPresidenAdapter(Context context) {
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
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_presiden,viewGroup,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Presiden presiden = getListPresiden().get(i);

        Glide.with(context)
                .load(presiden.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(cardViewHolder.imageView);
        cardViewHolder.textName.setText(presiden.getName());
        cardViewHolder.textRemarks.setText(presiden.getRemarks());

        cardViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Favorite "+getListPresiden().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Share "+getListPresiden().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textName,textRemarks;
        private Button btnFavorite,btnShare;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_presiden);
            textName = itemView.findViewById(R.id.item_name);
            textRemarks = itemView.findViewById(R.id.item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}
