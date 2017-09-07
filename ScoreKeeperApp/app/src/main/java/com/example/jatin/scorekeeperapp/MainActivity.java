package com.example.jatin.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String first,second,message = "";
    private int score=0,scoreOfTeamA,scoreOfTeamB, ns=0 ,no4=0, no6=0;
    public void submit_s(View view){
        EditText editText = (EditText) findViewById(R.id.edit);
        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"!!!Please Enter Team Name!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        ns++;
        if(ns == 1){
            scoreOfTeamA = score;
            score=0;
            first = editText.getText().toString();
            message ="Team: "+first+" Score: "+scoreOfTeamA;
            message += "\nno of fours "+no4;
            message += "\nno of six "+no6+"\n";
            no4=0;
            no6=0;

            editText.setText("");
            TextView textView = (TextView) findViewById(R.id.score);
            textView.setText("0");
        }
        if(ns == 2){

            second = editText.getText().toString();
            scoreOfTeamB = score;
            message +="Team: "+second+ " Score: "+scoreOfTeamB;
            message += "\nno of fours "+no4;
            message += "\nno of six "+no6;
            editText.setText("");
            TextView sc = (TextView) findViewById(R.id.score);
            sc.setText("0");
            no4=0;
            no6=0;
            TextView textView = (TextView) findViewById(R.id.match_summary);
            textView.setText(message);
            ns=0;

            if(scoreOfTeamA > scoreOfTeamB){
                Toast.makeText(this,first +" Won the game by "+(scoreOfTeamA-scoreOfTeamB)+" runs" ,
                        Toast.LENGTH_LONG).show();
            }
            else if(scoreOfTeamA < scoreOfTeamB){
                Toast.makeText(this,second+" Won the game by "+(scoreOfTeamB-scoreOfTeamA)+" runs" ,
                        Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this," Tie Game ",
                        Toast.LENGTH_LONG).show();

            }
        }

    }
    public void display(int number){
        TextView textView = (TextView) findViewById(R.id.score);
        textView.setText(""+number);
    }
    public void add_1(View view){

        score += 1;
       display(score);
    }
    public void add_2(View view){
        score += 2;
        display(score);
    }
    public void add_3(View view){
        score += 3;
        display(score);
    }
    public void add_4(View view){
        no4++;
        score += 4;
        display(score);
    }
    public void add_5(View view){
        score += 5;
        display(score);
    }
    public void add_6(View view){
        no6++;
        score += 6;
        display(score);
    }

}
