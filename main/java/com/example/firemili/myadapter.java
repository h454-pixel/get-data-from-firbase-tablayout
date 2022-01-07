package com.example.firemili;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends FirebaseRecyclerAdapter<Productsmode ,myadapter.MyViewHolder> {





    /**
     *
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     * @param isDataset
     */

    IsDataset isDataset;
    public myadapter(@NonNull FirebaseRecyclerOptions<Productsmode> options, IsDataset isDataset) {
        super(options);

    this.isDataset = isDataset;


    }

    @NonNull
    @Override
    public myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.acitivtiymain2,parent,false);
        return new MyViewHolder(view);






    }



    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Productsmode model) {
        holder.name2.setText(model.getName());
        holder.name1.setText(model.getCourse());
        holder.name3.setText(model.getEmail());
        Glide.with(holder.imageView.getContext()).load(model.getPurl()).into(holder.imageView);

        holder.imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(holder.imageView.getContext());
                builder.setTitle("delete panel ");
                builder.setMessage("Delete..........");

       builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               FirebaseDatabase.getInstance().getReference().child("person2")
                       .child(getRef(position).getKey()).removeValue();


           }
       });
       builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {



           }
       });

 builder.show();
            }
        });






        holder.imageView.setOnClickListener(new View.OnClickListener() {   //model.getName(),model.getCourse(),model.getEmail(),
            @Override
            public void onClick(View v) {
   //fragment in same activity....////  //
                // AppCompatActivity appCompatActivity = (AppCompatActivity)v.getContext();
               // appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.framing, new BlankFragment4(model.getPurl())).addToBackStack(null).commit();
            Intent intent = new Intent(holder.imageView.getContext(),MainActivity2.class);
             // intent .putExtra( "image",Productsmode.getPurl()) ;

                holder.imageView.getContext().startActivity(intent);


            }
        });



       if(position==0){

     isDataset.onDataset();
       }



    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name1,name2,name3;
        ImageView imageview1,imageview2;
        ImageView imageView;// init the item view's


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name1 = (TextView) itemView.findViewById(R.id.textview_22);
            name2 = (TextView) itemView.findViewById(R.id.textview_33);
            name3 = (TextView) itemView.findViewById(R.id.textview_34);
            imageview1 = (ImageView) itemView.findViewById(R.id.imageview_111);
            imageview2 =(ImageView)itemView.findViewById(R.id.imageview_222);
            imageView = (ImageView) itemView.findViewById(R.id.image_view_1);


            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

        }




    }
}