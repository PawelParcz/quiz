package pl.sdacademy.projectplus.quiz;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.projectplus.quiz.database.entities.PlayerEntity;
import pl.sdacademy.projectplus.quiz.database.repositories.PlayerRepository;
import pl.sdacademy.projectplus.quiz.frontend.GameOptions;
import pl.sdacademy.projectplus.quiz.services.QuizDataService;

import java.util.List;

@Component
@Log
@AllArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private PlayerRepository playerRepository;
    private QuizDataService quizDataService;


    @Override
    public void run(String... args) {
        log.info("Executing startup actions...");
        quizDataService.getQuizCategories();

        playerRepository.save(new PlayerEntity("Jan"));
        playerRepository.save(new PlayerEntity("Tomasz"));

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
        for (PlayerEntity player : playersFromDatabase) {
            log.info("Retrieved player: " + player);
        }

    }
}
