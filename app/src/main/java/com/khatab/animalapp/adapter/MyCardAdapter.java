package com.khatab.animalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.SaveOrder.SaveOrder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.ViewHolder> {

    @BindView(R.id.Items_Card_IV_MainPic)
    ImageView ItemsCardIVMainPic;
    @BindView(R.id.items_card_deatilsinTV)
    TextView itemsCardDeatilsinTV;
    @BindView(R.id.Items_Card_TV_TotalCard)
    TextView ItemsCardTVTotalCard;
    @BindView(R.id.ItemsCard_Close_IV)
    ImageView ItemsCardCloseIV;
    @BindView(R.id.ItemsCard_Edit_IV)
    ImageView ItemsCardEditIV;
    private Context context;
    private List<SaveOrder> Items = new ArrayList<>();

    public MyCardAdapter(List<SaveOrder> arrayList, Context context) {
        this.Items = arrayList;
        this.context = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from( context ).inflate( R.layout.items_card, viewGroup, false );

        return new ViewHolder( v );
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        setData( viewHolder, i );
        setActions( viewHolder, i );
    }

    private void setData(ViewHolder viewHolder, int i) {

        // viewHolder.itemsFoodListTitle.setText(Items.get(i).getName());

    }

    private void setActions(ViewHolder viewHolder, int i) {
        viewHolder.view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
    }

    @Override
    public int getItemCount() {

        return Items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        public ViewHolder(View itemView) {
            super( itemView );
            view = itemView;
            ButterKnife.bind( this, view );
        }
    }

}
