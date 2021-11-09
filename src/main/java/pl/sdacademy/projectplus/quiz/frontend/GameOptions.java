package pl.sdacademy.projectplus.quiz.frontend;

import lombok.Data;

@Data
public class GameOptions {
    private int numberOfQuestions=5;
    private int categoryId;
    private Difficulty difficulty;
}
