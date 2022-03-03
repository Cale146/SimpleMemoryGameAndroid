package com.example.simplememory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startEasyActivity(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("gridsize", "three");
        startActivity(intent);
    }

    public void startMediumActivity(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("gridsize", "four");
        startActivity(intent);
    }

    public void startHardActivity(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("gridsize", "five");
        startActivity(intent);
    }
}
