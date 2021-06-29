package com.example.welearn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.welearn.Activity.Fragment.SoalAngkaAdapter;
import com.example.welearn.R;
import com.example.welearn.Response.Api.ResponseType.ListSoalHuruf;

import java.util.ArrayList;
import java.util.List;

public class BankSoalAngkaActivity extends AppCompatActivity implements SoalAngkaAdapter.ItemClickListener {

    SoalAngkaAdapter adapter;
    ArrayList<ListSoalHuruf> mData = new ArrayList<>();
    int id;
    ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_soal_angka);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BankSoalAngkaActivity.this, LevelAngkaActivity.class);
                startActivity(i);
            }
        });

        // data to populate the RecyclerView with
        Bundle bundle = getIntent().getExtras();
        ArrayList<ListSoalHuruf> arraylist = bundle.getParcelableArrayList("mylist");

        for(int i=0; i<arraylist.size(); i++){
            Log.e("data", arraylist.get(i).getSoal());
            Log.e("data", String.valueOf(arraylist.get(i).getIdSoal()));
        }

        mData.addAll(arraylist);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvSoal);
        GridLayoutManager llm = new GridLayoutManager(getApplicationContext(),3);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new SoalAngkaAdapter(this, arraylist);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        int level;
        Intent intent = new Intent();
        level = getIntent().getIntExtra("level",0);
        if (level==0) {
            intent = new Intent(BankSoalAngkaActivity.this, AngkaLv0aActivity.class);
        } else if(level==1) {
            intent = new Intent(BankSoalAngkaActivity.this, HurufLv1Activity.class);
        } else if(level==2) {
            intent = new Intent(BankSoalAngkaActivity.this, HurufLv2Activity.class);
        } else if(level==3) {
            intent = new Intent(BankSoalAngkaActivity.this, HurufLv3Activity.class);
        } else if(level==4) {
            intent = new Intent(BankSoalAngkaActivity.this, HurufLv3Activity.class);
        }

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("mylist", mData);
        bundle.putInt("id", position);
        intent.putExtras(bundle);;
//        intent.putExtra("id", arraylist);
        startActivity(intent);

    }
}