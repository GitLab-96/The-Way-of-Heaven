package com.example.soundtest.Question;

import android.widget.ImageView;

public class TypeQuestionClass {
    private String typeQuestion;
    private String typeAnswer;

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(String typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public TypeQuestionClass(String typeQuestion, String typeAnswer) {
        this.typeQuestion = typeQuestion;
        this.typeAnswer = typeAnswer;
    }

    public TypeQuestionClass() {
    }
}
