package com.biomimetisme.val.bioquizz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.biomimetisme.val.bioquizz.R;
import com.biomimetisme.val.bioquizz.model.Question;
import com.biomimetisme.val.bioquizz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        //wire widgets
        mQuestionTextView = (TextView) findViewById(R.id.question);
        mAnswerButton1 = (Button) findViewById(R.id.button1);
        mAnswerButton2 = (Button) findViewById(R.id.button2);
        mAnswerButton3 = (Button) findViewById(R.id.button3);

        // name the buttons
        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

        @Override
        public void onClick(View v)
        {
        int responseIndex = (int)v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerindex())
        {
            //good answer
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
             }else

            {Toast.makeText(this, "wrong answer !", Toast.LENGTH_SHORT).show();
            // wrong answer
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


            Question questionAigle = new Question("Qu'est-ce qui a été inspiré par l'aigle ?"),
            Arrays.asList("Un Led ?", "Un immeuble ?", "Un capteur ?", 2);

            Question questionScratch = new Question("Grâce à qui ou quoi le Velcro a été inventé ?"),
            Arrays.asList("Le Chardon ?", "La Bardane ?", "La grenouille ?", 2);

           return new QuestionBank(Arrays.asList(questionAigle,
                                                 questionScratch));
        }






    }
}
