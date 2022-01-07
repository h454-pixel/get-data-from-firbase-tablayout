package com.example.firemili;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment4 extends Fragment {


    ImageSlider imageSlider;
   String  name,course,email,purl;
   ImageView imagedownload,imageshare;



   public BlankFragment4() {
        // Required empty public constructor
    }

    // String name,String course,String email,

    public BlankFragment4(String purl) {
     //  this.name =name;
    //   this.course =course;
      // this.email = email;
  //    this.purl = purl;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank4, container, false);



        //  ImageView imageViewholder = v.findViewById(R.id.image_view_1);
        //  TextView  textView  = v.findViewById(R.id.textview_22);
       //   TextView textView2 = v.findViewById(R.id.textview_33);
       // TextView textview3 = v.findViewById(R.id.textview_34);
      //   textView.setText(name);
      //  textView2.setText(course);
      //  textview3.setText(email);
      //  Glide.with(getContext()).load(purl).into(imageViewholder);



        imageSlider=(ImageSlider) v.findViewById(R.id.image_slider);
        imagedownload=(ImageView) v.findViewById(R.id.image_view_black4);
        imageshare=(ImageView) v.findViewById(R.id.image_view_black5);


        final List<SlideModel> remoteimages = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("person2")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override //data.child("title").getValue().toString(),
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        for (DataSnapshot data : snapshot.getChildren()) {
                               remoteimages.add(new SlideModel(data.child("purl").getValue().toString(), ScaleTypes.FIT)); }
                        imageSlider.setImageList(remoteimages, ScaleTypes.FIT);

                     
                       imageSlider.setItemClickListener(new ItemClickListener() {
                           @Override
                           public void onItemSelected(int i) {
                               Toast.makeText(getContext(),  remoteimages.get(i).getImageUrl(), Toast.LENGTH_SHORT).show();
                           }
                       }); 
                        
                        
                       
                        
                        imageSlider.stopSliding();
                    }







                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

  imagedownload.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {





      }
  });
















        imageshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int i =0;
                String s  =  remoteimages.get(i).getImageUrl();

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                
                sharingIntent.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(Intent.createChooser(sharingIntent,"share using") );


            }
        });
return  v;

}
    }