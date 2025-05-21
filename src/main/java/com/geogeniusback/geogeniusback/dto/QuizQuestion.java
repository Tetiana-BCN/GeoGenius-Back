package com.geogeniusback.geogeniusback.dto;

public class QuizQuestion {
    private String question;
    private String correctAnswer;
    private List<String> options;

    

    public QuizQuestion() {
    }
    public QuizQuestion(String question, String correctAnswer, List<String> options) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }


    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

}