package com.example.texttovoice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button resultbtn;

    TextToSpeech textToSpeech;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edittext);
        resultbtn=findViewById(R.id.resultbtn);

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text=editText.getText().toString();

                if (text.length()>0){
                    textToSpeech.speak(""+text,TextToSpeech.QUEUE_FLUSH,null,null);
                }else {
                    editText.setError("Input here");
                }

            }
        });



    }
}