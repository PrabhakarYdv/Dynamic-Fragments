package com.prabhakar.dynamicfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMain extends Fragment {

    private Button ButtonFetchData;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<ResponseModel> userList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        ButtonFetchData = view.findViewById(R.id.btnFetchData);
        recyclerView = view.findViewById(R.id.recyclerView);
        ButtonFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAPI();
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void callAPI() {
        APIService apiService = Network.getInstance().create(APIService.class);
        apiService.getData().enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {

                if (response.body() != null) {
                    userList = response.body();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Data Fetching Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter() {
        userAdapter = new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(userAdapter);
    }
}