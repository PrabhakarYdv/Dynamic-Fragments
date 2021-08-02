package com.prabhakar.dynamicfragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private ImageView userImage;
    private TextView userTitle;
    private TextView userSubtitle;

    public UserViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        userImage = itemView.findViewById(R.id.user_image);
        userTitle = itemView.findViewById(R.id.user_title);
        userSubtitle = itemView.findViewById(R.id.user_subTitle);
    }
    public void setUserData(ResponseModel responseModel){
        Glide.with(userImage).load(responseModel.getImage()).into(userImage);
        userTitle.setText(responseModel.getTitle());
        userSubtitle.setText(responseModel.getSubTitle());
    }
}
