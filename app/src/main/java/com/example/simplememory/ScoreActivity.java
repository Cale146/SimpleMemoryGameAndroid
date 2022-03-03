package com.example.simplememory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        RelativeLayout rl = findViewById(R.id.relativeLayout);
       // rl.setBackgroundColor(Color.GRAY);

        Intent intent = getIntent();
        Integer totalClicks = intent.getIntExtra("clicks", 0);

        TextView tv = findViewById(R.id.scoretextview);
        tv.setText(totalClicks.toString());
    }

    public void startOver(View view){
        Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
