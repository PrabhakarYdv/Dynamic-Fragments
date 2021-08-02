package com.prabhakar.dynamicfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<ResponseModel> userLists;

    public UserAdapter(ArrayList<ResponseModel> userLists) {
        this.userLists = userLists;
    }

    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserViewHolder holder, int position) {
        ResponseModel model = userLists.get(position);
        holder.setUserData(model);
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }
}
