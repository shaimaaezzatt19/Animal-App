package com.khatab.animalapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.Services.Services;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServicesPicAnimalNameAdapter extends RecyclerView.Adapter<ServicesPicAnimalNameAdapter.ViewHolder> {

    private Context context;

    private List<Services> Items;
    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    public ServicesPicAnimalNameAdapter(List<Services> arrayList, Context context) {
        this.Items = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from( context ).inflate( R.layout.items_services, viewGroup, false );

        return new ViewHolder( v );
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        setData( viewHolder, position );
        setActions( viewHolder, position );

      //  viewHolder.ServicesAnimalNameTV.setText( Items.get( position ).getData().toString() );
    }

    private void setData(ViewHolder viewHolder, int position) {

        Services postsData = Items.get( position );
       // String image = postsData.getImage();
       // Glide.with( context ).load( image ).into( viewHolder.ItemsErvicesPICIV );
      //  viewHolder.ServicesAnimalNameTV.setText( postsData.getName() );

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

    @OnClick({R.id.Items_ervices_PIC_IV, R.id.Services_AnimalName_TV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Items_ervices_PIC_IV:
                break;
            case R.id.Services_AnimalName_TV:
                break;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View view;


        @BindView(R.id.Items_ervices_PIC_IV)
        ImageView ItemsErvicesPICIV;
        @BindView(R.id.Services_AnimalName_TV)
        TextView ServicesAnimalNameTV;

        public ViewHolder(View itemView) {
            super( itemView );
            view = itemView;
            ButterKnife.bind( this, view );

            //   ServicesAnimalNameTV =  < itemView > itemView.findViewById( R.id.Items_ervices_PIC_IV );
            ServicesAnimalNameTV = (TextView) itemView.findViewById( R.id.Services_AnimalName_TV );
            itemView.setOnClickListener( this );


        }

        @Override
        public void onClick(View v) {
            // if (mClickListener != null) mClickListener.onItemClick( view, getAdapterPosition() );

        }
    }

    String getItem(int id) {
        return mData.get( id );
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}