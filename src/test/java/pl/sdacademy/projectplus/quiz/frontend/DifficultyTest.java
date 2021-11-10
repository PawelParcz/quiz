package pl.sdacademy.projectplus.quiz.frontend;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;
import static pl.sdacademy.projectplus.quiz.frontend.Difficulty.*;

class DifficultyTest {

    @Test
    void calculateNextDifficulty_easy() {
        EnumSet<Difficulty> given = EnumSet.of(EASY);
        Difficulty result = calculateNextDifficulty(given);
        assertEquals(MEDIUM, result);
    }
    @Test
    void  calculateNextDifficult_hard(){
        //given
        EnumSet<Difficulty> given=EnumSet.of(Difficulty.HARD);
       // then
        Difficulty result= calculateNextDifficulty(given);

        assertEquals(MEDIUM,result);
    }
    @Test
    void  calculateNextDifficult_medium(){
        //given
        EnumSet<Difficulty> given=EnumSet.of(MEDIUM);
       // then
        Difficulty result= calculateNextDifficulty(given);

        assertEquals(Difficulty.HARD,result);
    }
    @Test
    void calculateNextDifficulty_null() {
        EnumSet<Difficulty> given = null;
        Difficulty result = calculateNextDifficulty(given);
        assertNull(result);
    }

    @Test
    void calculateNextDifficulty_none() {
        EnumSet<Difficulty> given = EnumSet.noneOf(Difficulty.class);
        Difficulty result = calculateNextDifficulty(given);
        assertNull(result);
    }
    @Test
    void calculateNextDifficulty_easy_medium() {
        EnumSet<Difficulty> given = EnumSet.of(EASY, MEDIUM);
        Difficulty result = calculateNextDifficulty(given);
        assertEquals(HARD, result);
    }

    @Test
    void calculateNextDifficulty_medium_hard() {
        EnumSet<Difficulty> given = EnumSet.of(MEDIUM, HARD);
        Difficulty result = calculateNextDifficulty(given);
        assertEquals(EASY, result);
    }

    @Test
    void calculateNextDifficulty_hard_easy() {
        EnumSet<Difficulty> given = EnumSet.of(HARD, EASY);
        Difficulty result = calculateNextDifficulty(given);
        assertEquals(MEDIUM, result);
    }

    @Test
    void calculateNextDifficulty_all() {
        EnumSet<Difficulty> given = EnumSet.of(EASY, MEDIUM, HARD);
        Difficulty result = calculateNextDifficulty(given);
        assertNull(result);
    }
}
