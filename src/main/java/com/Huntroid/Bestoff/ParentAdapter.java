package com.Huntroid.Bestoff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {


    private List<ParentItem> parentItemList;

    public void setParentItemList(List<ParentItem> parentItemList) {
        this.parentItemList = parentItemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grp_view, parent, false);
        return new ParentViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        ParentItem parentItem = parentItemList.get(position);
        holder.ParentName.setText(parentItem.getParentName());
        holder.childRecyclerView.setHasFixedSize(true);
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        ChildAdapter childAdapter = new ChildAdapter();
        childAdapter.setChildItemList(parentItem.getChildItemList());
        holder.childRecyclerView.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (parentItemList != null){
            return parentItemList.size();
        }
        else {
            return 0;
        }
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private TextView ParentName;
        private RecyclerView childRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            ParentName = itemView.findViewById(R.id.grp_title);
            childRecyclerView = itemView.findViewById(R.id.ChildRecyclerView);
        }
    }
}
