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
import com.khatab.animalapp.data.model.ServicesNumber.Services.ServicesData;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    private Context context;

    private List<ServicesData> Items;

    public ServicesAdapter(Context context, List<ServicesData> items) {
        this.context = context;
        Items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( context ).inflate( R.layout.items_services, viewGroup, false );

        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ServicesData data = Items.get( i );

        viewHolder.name.setText( data.getName() );
        Glide.with( context ).load( data.getImage() ).into( viewHolder.image );

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            image = itemView.findViewById( R.id.Items_ervices_PIC_IV );
            name = itemView.findViewById( R.id.Services_AnimalName_TV );

        }
    }
}
