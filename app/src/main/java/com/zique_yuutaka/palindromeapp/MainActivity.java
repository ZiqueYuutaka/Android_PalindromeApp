package com.zique_yuutaka.palindromeapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fragments.EntryFragment;
import woodferren.izak.palindrome.PalindromeChecker;
import woodferren.izak.palindrome.StringProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_main_fragment_container);

        if(fragment == null){
            fragment = new EntryFragment();
            fm.beginTransaction()
                    .add(R.id.activity_main_fragment_container, fragment)
                    .commit();
        }
    }
}
