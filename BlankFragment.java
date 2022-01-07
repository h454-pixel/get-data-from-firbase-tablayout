package com.example.firemili;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BlankFragment extends Fragment {

   RecyclerView recyclerView;
myadapter myadapter ;
ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        progressBar =(ProgressBar)v.findViewById(R.id.progress_11);
        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
     recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

     FirebaseRecyclerOptions<Productsmode> options= new FirebaseRecyclerOptions.Builder<Productsmode>()
             .setQuery(FirebaseDatabase.getInstance().getReference().child("person2") ,Productsmode.class)
             .build();




   myadapter= new myadapter(options ,
           new IsDataset() {
               @Override
               public void onDataset() {
                 progressBar.setVisibility(View.GONE);
               }
           });
   recyclerView.setAdapter(myadapter);

    return  v;

    }

    @Override
    public void onStart() {
        super.onStart();
progressBar.setVisibility(View.VISIBLE);
     myadapter.startListening();
    }




    @Override
    public void onStop() {
        super.onStop();

        myadapter.stopListening();



    }











}