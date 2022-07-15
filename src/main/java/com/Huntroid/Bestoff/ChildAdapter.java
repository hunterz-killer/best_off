package com.Huntroid.Bestoff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {


    private List<ChildItem> childItemList;


    public void setChildItemList(List<ChildItem> childItemList) {
        this.childItemList = childItemList;
        this.childItemList.removeAll(Collections.singleton(null));
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_view, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        ChildItem childItem = childItemList.get(position);
        holder.childName.setText(childItem.getChildName());
        holder.childSite.setText(childItem.getChildSite());
        holder.childMRP.setText(childItem.getChildMrp());
        Glide.with(holder.itemView.getContext()).load(childItem.getChildImage())
                .into(holder.childImage);
    }

    @Override
    public int getItemCount() {
        if (childItemList != null) {
            return childItemList.size();
        } else {
            return 0;
        }
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        private TextView childName, childMRP, childSite;
        private ImageView childImage;
        private Button button;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            childName = itemView.findViewById(R.id.ProductName);
            childMRP = itemView.findViewById(R.id.Price);
            childImage = itemView.findViewById(R.id.child_Image);
            childSite = itemView.findViewById(R.id.Avl);

        }
    }
}
