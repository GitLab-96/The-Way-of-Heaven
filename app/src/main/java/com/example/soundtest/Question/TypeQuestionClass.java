package com.example.soundtest.Question;

import android.widget.ImageView;

public class TypeQuestionClass {
    private String typeQuestion;
    private String typeAnswer;
    private String key;

    public TypeQuestionClass() {
    }

    public TypeQuestionClass(String typeQuestion, String typeAnswer, String key) {
        this.typeQuestion = typeQuestion;
        this.typeAnswer = typeAnswer;
        this.key = key;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public String getTypeAnswer() {
        return typeAnswer;
    }

    public String getKey() {
        return key;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public void setTypeAnswer(String typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
