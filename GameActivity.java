package com.biomimetisme.val.bioquizz.controller;
/**
 * Created by Valérie Criton on 09/05/18.
 * Classe gameActivity - comptabilise le score et affiche le résultat
 */

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.biomimetisme.val.bioquizz.R;
import com.biomimetisme.val.bioquizz.model.Question;
import com.biomimetisme.val.bioquizz.model.QuestionBank;

import java.util.ArrayList;
import java.util.Arrays;


import static java.util.Arrays.asList;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore; // création de la variable score
    private int mNumberOfQuestion; // variable qui contient le nombre de questions que l'on va poser



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = generateQuestion();

        mScore = 0; // initialisation du score à 0
        mNumberOfQuestion =4;



        //wire widgets
        mQuestionTextView = findViewById(R.id.question);
        mAnswerButton1 = findViewById(R.id.button1);
        mAnswerButton2 = findViewById(R.id.button2);
        mAnswerButton3 = findViewById(R.id.button3);

        // les réponses sont identifiées : reponse 1 est identifiée par 0
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);

        mAnswerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                int responseIndex = (int) v.getTag();

                if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
                    //good answer
                    Toast.makeText(GameActivity.this, "Oui très bien", Toast.LENGTH_SHORT).show();
                    mScore++;
                } else

                {
                    // wrong answer
                    Toast.makeText(GameActivity.this, " :-( !", Toast.LENGTH_SHORT).show();

                }

                if (--mNumberOfQuestion == 0){
                //end the game
                    endGame();
                 } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }


            private void endGame(){
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);

                builder.setTitle(" Félicitation !")
                        .setMessage(" Ton score est de :" + mScore)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //End the activity or
                                // begin another activity, a stronger one
                                finish();
                            }
                        })
                        .create()
                        .show();
            }



        }); // new onclicklistener
        mAnswerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int responseIndex = (int) v.getTag();

                if (responseIndex == mCurrentQuestion.getAnswerIndex())
                {
                    //good answer
                    Toast.makeText(GameActivity.this, "Bravo !", Toast.LENGTH_SHORT).show();
                    mScore++;
                } else

                {
                    // wrong answer
                    Toast.makeText(GameActivity.this, "Ah non, c'est pas ça !", Toast.LENGTH_SHORT).show();

                }
            }
        });
        mAnswerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int responseIndex = (int) v.getTag();

                if (responseIndex == mCurrentQuestion.getAnswerIndex())
                {
                    //good answer
                    Toast.makeText(GameActivity.this, " Trop fort ! :-)", Toast.LENGTH_SHORT).show();
                    mScore++;
                } else

                {
                    // wrong answer
                    Toast.makeText(GameActivity.this, " Et non, c'est pas ça ..", Toast.LENGTH_SHORT).show();

                }
            }
        });

        mCurrentQuestion = mQuestionBank.getQuestion();
        // watch out
        this.displayQuestion(mCurrentQuestion);



            }
    private void displayQuestion(final Question question)
    {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));

    }


    private QuestionBank generateQuestion()
    {


        Question questionAigle = new Question("Qu'est-ce qui a été inspiré par l'aigle ?", Arrays.asList
                ("Une Led ?", "Un immeuble ?", " La photographie ?"), 2);

        Question questionScratch = new Question("Grâce à qui ou quoi le Velcro a été inventé ?", Arrays.asList
                ("Le Chardon ?", "La Bardane ?", "La grenouille ?"), 1);

        Question questionMoule = new Question("La moule a inspiré la chirurgie plastique, grâce à quoi ?", Arrays.asList
                ("Sa forme ?", "Ses fils ?", "Sa coque ?"), 1);

        Question questionAraignee = new Question("Par quoi les ingénieurs se sont inspirés pour régler le problème des oiseaux " +
                "qui se tuaient en percutant les fenêtres ?", Arrays.asList
                ("La toile d'araignée ?", "Le barrage des castors?", "Le nid des oiseaux ?"), 1);

        Question questionRequin = new Question("Quel animal inspire un dispositif antibactérien ? ", Arrays.asList
                ("le requin ?", "La pieuvre ?", "Le crabe ?"), 1);



        ArrayList<Question> questions = new ArrayList<>();
        questions.add(questionAigle);
        questions.add(questionScratch);
        questions.add(questionMoule);
        questions.add(questionAraignee);
        questions.add(questionRequin);

        return new QuestionBank(questions);
    }
}
