package com.khatab.animalapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khatab.animalapp.R;
import com.khatab.animalapp.data.model.Services.Services;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServicesPicAnimalNameAdapter extends RecyclerView.Adapter<ServicesPicAnimalNameAdapter.ViewHolder> {

    private Context context;
    private List<Services> Items = new ArrayList<>();

    public ServicesPicAnimalNameAdapter(List<Services> arrayList, Context context) {
        this.Items = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.items_services, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        setData(viewHolder, i);
        setActions(viewHolder, i);
    }

    private void setData(ViewHolder viewHolder, int i) {

        Services postsData = Items.get(i);
        Glide.with(context).load(postsData.getData()).into(viewHolder.ItemsErvicesPICIV);
        viewHolder.ServicesAnimalNameTV.setText(postsData.getData().indexOf(5));

    }

    private void setActions(ViewHolder viewHolder, int i) {
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        @BindView(R.id.Items_ervices_PIC_IV)
        ImageView ItemsErvicesPICIV;
        @BindView(R.id.Services_AnimalName_TV)
        TextView ServicesAnimalNameTV;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }

}
