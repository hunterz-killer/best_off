package com.Huntroid.Bestoff;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.Huntroid.Bestoff.ParentItem;

import com.google.firebase.database.DatabaseError;

import java.util.List;

public class FirebaseViewModel extends ViewModel implements Firebaserepo.OnRealtimeDbTaskComplete {

   private MutableLiveData<List<ParentItem>> parentItemMutableLiveData = new MutableLiveData<>();
   private MutableLiveData<DatabaseError> databaseErrorMutableLiveData = new MutableLiveData<>();
   private Firebaserepo firebaserepo;

    public MutableLiveData<List<ParentItem>> getParentItemMutableLiveData() {
        return parentItemMutableLiveData;
    }

    public MutableLiveData<DatabaseError> getDatabaseErrorMutableLiveData() {
        return databaseErrorMutableLiveData;
    }

    public FirebaseViewModel(){
       firebaserepo = new Firebaserepo(this);
   }

   public void getallData(){
       firebaserepo.GetAllData();
   }

    @Override
    public void onSucess(List<ParentItem> parentItemList) {
        parentItemMutableLiveData.setValue(parentItemList);
    }

    @Override
    public void onFailure(DatabaseError error) {
       databaseErrorMutableLiveData.setValue(error);

    }
}
