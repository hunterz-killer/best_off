package com.Huntroid.Bestoff;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;
import java.util.List;

public class Firebaserepo {

    private DatabaseReference databaseReference;
    private OnRealtimeDbTaskComplete onRealtimeDbTaskComplete;


    public Firebaserepo(OnRealtimeDbTaskComplete onRealtimeDbTaskComplete){
        this.onRealtimeDbTaskComplete = onRealtimeDbTaskComplete;
        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("best off");
    }

    public void  GetAllData(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ParentItem> parentItemList = new ArrayList<>();
                for ( DataSnapshot ds : snapshot.getChildren()){
                    ParentItem parentItem = new ParentItem();
                    parentItem.setParentName(ds.child("grp_name").getValue(String.class));
                    GenericTypeIndicator<ArrayList<ChildItem>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<ChildItem>>() {};
                    parentItem.setChildItemList(ds.child("data").getValue(genericTypeIndicator));
                    parentItemList.add(parentItem);
                }
                Log.e("TAG", "onDataChange: "+parentItemList);
                onRealtimeDbTaskComplete.onSucess(parentItemList);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                onRealtimeDbTaskComplete.onFailure(error);

            }
        });
    }

    public interface OnRealtimeDbTaskComplete{
        void onSucess(List<ParentItem> parentItemList);
        void onFailure(DatabaseError error);
    }
}
