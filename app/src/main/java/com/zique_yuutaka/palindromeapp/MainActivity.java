package com.zique_yuutaka.palindromeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import woodferren.izak.palindrome.PalindromeChecker;
import woodferren.izak.palindrome.StringProcessor;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG = "DEBUG";

    private Button btSubmit;
    private Button btClear;
    private EditText etEntry;

    private String palindromeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //grab EditText view object
        etEntry = (EditText)findViewById(R.id.etEntry);

        //wire buttons
        wireButtons();
    }

    private void wireButtons(){
        btSubmit = (Button)findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d(DEBUG, "Submit button pressed");

                palindromeString = etEntry.getText().toString();

                Log.d(DEBUG, "Value of palindromeString: " + palindromeString);

                clearText("submit");

                if(StringProcessor.isValidString(palindromeString)){
                    Log.d(DEBUG, "Correctly formatted string");
                    PalindromeChecker checker = new PalindromeChecker(palindromeString);

                    Log.d(DEBUG, checker.getStr() + " is a palindrome: " + checker.isPalindrome());
                }else{
                    Log.d(DEBUG, "Incorrectly formatted string");
                }
            }
        });

        btClear = (Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d(DEBUG, "Clear button pressed");

                clearText("clear");
            }
        });

    }//end wireButtons

    private void clearText(String msg){
        if(etEntry.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"No entry to " + msg,Toast.LENGTH_SHORT).show();

        }else{
            Log.d(DEBUG, "Clearing text");
            etEntry.setText("");
        }
    }
}
