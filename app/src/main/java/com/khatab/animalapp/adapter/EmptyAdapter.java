package com.khatab.animalapp.adapter;

//package com.example.sofra.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//
//import com.example.sofra.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.ButterKnife;
//
//public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ViewHolder> {
//
//    private Context context;
//    private List<ResturantDetailsData> Items = new ArrayList<>();
//
//    public EmptyAdapter(List<ResturantDetailsData> arrayList, Context context) {
//        this.Items = arrayList;
//        this.context = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//
//        View v = LayoutInflater.from(context).inflate(R.layout.items_list_of_food, viewGroup, false);
//
//        return new ViewHolder(v);
//    }
//
//
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        setData(viewHolder, i);
//        setActions(viewHolder, i);
//    }
//
//    private void setData(ViewHolder viewHolder, int i) {
//
//       // viewHolder.itemsFoodListTitle.setText(Items.get(i).getName());
//
//    }
//
//    private void setActions(ViewHolder viewHolder, int i) {
//        viewHolder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return Items.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        View view;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            view = itemView;
//            ButterKnife.bind(this, view);
//        }
//    }
//
//}