package pl.sdacademy.projectplus.quiz.services;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class QuizDataService {

    public void getQuizCategories(){
        RestTemplate restTemplate=new RestTemplate();
        CategoriesDto result= restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
        log.info("Quiz categories: " + result.getCategories());
    }
}
