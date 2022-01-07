package com.example.firemili;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainAcitivity extends AppCompatActivity  implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    ProgressBar progressBar;
    FrameLayout frameLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabbb);
        toolbar = (Toolbar) findViewById(R.id.toool_barr);
        setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = (ProgressBar)findViewById(R.id.progress_11);
        frameLayout = (FrameLayout) findViewById(R.id.framing);
        //
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_computer_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_computer_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_computer_24));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment fragment = null;

        switch (tab.getPosition()) {

            case 0:
                fragment = new BlankFragment2();

              //    progressBar.setVisibility(View.VISIBLE);

                break;


            case 1:
                fragment = new BlankFragment();
                break;


            case 2:
                fragment = new BlankFragment3();
                break;


        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framing, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fii, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navigation_homeee) {

            Intent intent = new Intent(MainAcitivity.this,MainActivity3.class);
            startActivity(intent);


        }

        if (id == R.id.navigation_home) {

            Toast.makeText(this, "toolbar first working", Toast.LENGTH_SHORT).show();
        }



        return super.onOptionsItemSelected(item);
    }
}