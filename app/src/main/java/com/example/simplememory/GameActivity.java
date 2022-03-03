package com.example.simplememory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameActivity extends AppCompatActivity {
    Integer totalClicks = 0;
    List<Integer> cards = new ArrayList<Integer>();
    List<Integer> matchedNumbers = new ArrayList<Integer>();
    List<Button> buttons = new ArrayList<Button>();
    Button b;
    Integer cardCounter = 0;
    List<Integer> activeCards = new ArrayList<Integer>();
    List<Button> activeButtons = new ArrayList<Button>();

    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String gridsize = intent.getStringExtra("gridsize");

        RelativeLayout rl = new RelativeLayout(this);

        if(gridsize.equals("three")){
            setContentView(R.layout.activity_game_three);
            rl = findViewById(R.id.relativeLayoutWithButtons);
            assignCards(9);
            assignGrid(rl, 9);
        }
        else if(gridsize.equals("four")){
            setContentView(R.layout.activity_game_four);
            rl = findViewById(R.id.relativeLayoutWithButtons);
            assignCards(16);
            assignGrid(rl, 16);
        }
        else if(gridsize.equals("five")){
            setContentView(R.layout.activity_game_five);
            rl = findViewById(R.id.relativeLayoutWithButtons);
            assignCards(25);
            assignGrid(rl, 25);
        }

        scoreTextView = findViewById(R.id.gamescoretextview);
    }

    public void assignGrid(RelativeLayout rl, Integer size){
        for(int i = 0; i < size; i++){
            View view = rl.getChildAt(i);
            Button button = (Button)view;
            buttons.add(button);
            button.setText(cards.get(i).toString());
        }
    }


    public void buttonPressed(View v) {
        Button button;

        Integer test = v.getId();

        switch (v.getId()) {
            case R.id.button1:
                button = buttons.get(0);
                setColorOfButton(button);
                break;

            case R.id.button2:
                button = buttons.get(1);
                setColorOfButton(button);
                break;

            case R.id.button3:
                button = buttons.get(2);
                setColorOfButton(button);
                break;

            case R.id.button4:
                button = buttons.get(3);
                setColorOfButton(button);
                break;

            case R.id.button5:
                button = buttons.get(4);
                setColorOfButton(button);
                break;

            case R.id.button6:
                button = buttons.get(5);
                setColorOfButton(button);
                break;

            case R.id.button7:
                button = buttons.get(6);
                setColorOfButton(button);
                break;

            case R.id.button8:
                button = buttons.get(7);
                setColorOfButton(button);
                break;

            case R.id.button9:
                button = buttons.get(8);
                setColorOfButton(button);
                break;

            case R.id.button10:
                button = buttons.get(9);
                setColorOfButton(button);
                break;

            case R.id.button11:
                button = buttons.get(10);
                setColorOfButton(button);
                break;

            case R.id.button12:
                button = buttons.get(11);
                setColorOfButton(button);
                break;

            case R.id.button13:
                button = buttons.get(12);
                setColorOfButton(button);
                break;

            case R.id.button14:
                button = buttons.get(13);
                setColorOfButton(button);
                break;

            case R.id.button15:
                button = buttons.get(14);
                setColorOfButton(button);
                break;

            case R.id.button16:
                button = buttons.get(15);
                setColorOfButton(button);
                break;

            case R.id.button17:
                button = buttons.get(16);
                setColorOfButton(button);
                break;

            case R.id.button18:
                button = buttons.get(17);
                setColorOfButton(button);
                break;

            case R.id.button19:
                button = buttons.get(18);
                setColorOfButton(button);
                break;

            case R.id.button20:
                button = buttons.get(19);
                setColorOfButton(button);
                break;

            case R.id.button21:
                button = buttons.get(20);
                setColorOfButton(button);
                break;

            case R.id.button22:
                button = buttons.get(21);
                setColorOfButton(button);
                break;

            case R.id.button23:
                button = buttons.get(22);
                setColorOfButton(button);
                break;

            case R.id.button24:
                button = buttons.get(23);
                setColorOfButton(button);
                break;

            case R.id.button25:
                button = buttons.get(24);
                setColorOfButton(button);
                break;
        }
    }

    private void setColorOfButton(Button button){
        ColorDrawable buttonColor = (ColorDrawable)button.getBackground();

        if(buttonColor.getColor() == Color.BLACK){
            totalClicks++;
            scoreTextView.setText("Score: " + totalClicks.toString());


            if(cardCounter < 2){
                button.setBackgroundColor(Color.WHITE);

                Integer tempcard = Integer.parseInt((String)button.getText());
                Integer tempIndex = activeCards.indexOf(tempcard);

                if(activeCards.contains(tempcard) && button.getId() != activeButtons.get(tempIndex).getId()){
                    Integer tempIndice = activeCards.indexOf(tempcard);
                    Button tempButton = activeButtons.get(tempIndice);
                    tempButton.setEnabled(false);
                    button.setEnabled(false);
                    activeButtons = new ArrayList<Button>();
                    activeCards = new ArrayList<Integer>();
                    matchedNumbers.add(tempcard);
                    cardCounter = 0;
                }
                else if(matchedNumbers.contains(tempcard) && activeCards.size() < 1){
                    button.setEnabled(false);
                    activeButtons = new ArrayList<Button>();
                    activeCards = new ArrayList<Integer>();
                    matchedNumbers.add(tempcard);
                    cardCounter = 0;
                }
                else{
                    if(cardCounter <=  1){
                        activeCards.add(tempcard);
                        activeButtons.add(button);
                        cardCounter++;
                    }
                }
            }
        }
        else{
            if(cardCounter > 0){
                if(activeButtons.size() <= 1){
                    button.setBackgroundColor(Color.BLACK);
                    activeButtons = new ArrayList<Button>();
                    activeCards = new ArrayList<Integer>();
                    cardCounter = 0;
                }
                else if(activeButtons.size() == 2){
                    activeButtons.get(0).setBackgroundColor(Color.BLACK);
                    activeButtons.get(1).setBackgroundColor(Color.BLACK);
                    activeButtons = new ArrayList<Button>();
                    activeCards = new ArrayList<Integer>();
                    cardCounter = 0;
                }
            }
        }

        try{
            if(!checkActiveButtons()){
                Intent intent = new Intent(GameActivity.this, ScoreActivity.class);
                intent.putExtra("clicks", totalClicks);
                startActivity(intent);
            }
        }
        catch(Exception e){
            String exception = e.getMessage();
        }

    }

    private Boolean checkActiveButtons(){
        RelativeLayout rl = findViewById(R.id.relativeLayoutWithButtons);

        for(int i = 0; i < rl.getChildCount(); i++){
            Button b = (Button)rl.getChildAt(i);

            if(b.isEnabled() == true){
                return true;
            }
        }
        return false;
    }

    public void assignCards(Integer size){
        int helperCount = 1;

        if(size == 9){
            for(int i = 1; i < 9; i+=2){
                cards.add(helperCount);
                cards.add(helperCount);
                helperCount++;
            }
            cards.add(helperCount - 1);
        }
        else if(size == 16){
            for(int i = 0; i < 16; i+=2){

                    cards.add(helperCount);
                    cards.add(helperCount);

                helperCount++;
            }
        }
        else if (size == 25){
            for(int i = 1; i < 25; i+=2){
                cards.add(helperCount);
                cards.add(helperCount);
                helperCount++;
            }
            cards.add(helperCount - 1);
        }

        Collections.shuffle(cards);
    }
}
