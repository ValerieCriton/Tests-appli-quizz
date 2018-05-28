package com.biomimetisme.val.bioquizz.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.biomimetisme.val.bioquizz.R;
import com.biomimetisme.val.bioquizz.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView mTextHello;
    private Button mPlayButton;
    private Button mCreateButton;
    private EditText mPleaseType;
    private User mUser; // Import du package User

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextHello =  (TextView) findViewById(R.id.activity_main_text_helloWord);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btr);
        mCreateButton = (Button) findViewById(R.id.activity_main_create_btr);
        mPleaseType = (EditText)findViewById(R.id.activity_main_text_pleaseType);
        mUser = new User(); //initialisation de la variable mUser

        mPlayButton.setEnabled(false);
        mCreateButton.setEnabled(false);
        mPleaseType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
                mCreateButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        // démarre activité jeu
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = mPlayButton.getText().toString(); //récupération du prénom
                mUser.setFirstName(firstName); // valorisation de l'utilisateur avec le setter en lui passant en paramètre le first name
                //User clicked button
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
        //TODO définir méthode pour la partie création
        //Démarre activité création
        //mCreateButton.setOnClickListener();
    }
}
