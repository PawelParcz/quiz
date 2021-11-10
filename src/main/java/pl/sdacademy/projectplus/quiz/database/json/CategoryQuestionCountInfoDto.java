package pl.sdacademy.projectplus.quiz.database.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.sdacademy.projectplus.quiz.frontend.Difficulty;

@NoArgsConstructor
@Getter
@ToString
public class CategoryQuestionCountInfoDto {

    @JsonProperty("category_id")
    private int categoryId;
    @JsonProperty("category_question_count")
    private CategoryQuestionCountDto categoryQuestionCount;

    public CategoryQuestionCountInfoDto(int easyQuestionCount, int mediumQuestionCount, int hardQuestionCount) {
        this.categoryQuestionCount = new CategoryQuestionCountDto(easyQuestionCount+mediumQuestionCount+hardQuestionCount,
                easyQuestionCount, mediumQuestionCount, hardQuestionCount);
    }
    @NoArgsConstructor
    @Getter
    @ToString
    @AllArgsConstructor
    public static class CategoryQuestionCountDto {
        @JsonProperty("total_question_count")
        private int totalQuestionCount;
        @JsonProperty("total_easy_question_count")
        private int totalEasyQuestionCount;
        @JsonProperty("total_medium_question_count")
        private int totalMediumQuestionCount;
        @JsonProperty("total_hard_question_count")
        private int totalHardQuestionCount;
    }


    public int getQuestionCountForDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return categoryQuestionCount.getTotalEasyQuestionCount();
            case MEDIUM:
                return categoryQuestionCount.getTotalMediumQuestionCount();
            case HARD:
                return categoryQuestionCount.getTotalHardQuestionCount();
        }
        return 0;
    }

}
