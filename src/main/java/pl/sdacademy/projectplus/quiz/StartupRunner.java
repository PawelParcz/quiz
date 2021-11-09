package pl.sdacademy.projectplus.quiz;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.projectplus.quiz.database.entities.PlayerEntity;
import pl.sdacademy.projectplus.quiz.database.repositories.PlayerRepository;
import pl.sdacademy.projectplus.quiz.services.QuizDataService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Log
@AllArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private PlayerRepository playerRepository;
    private QuizDataService quizDataService;

    @Override
        public void run(String...args) throws Exception {
            log.info("Executing startup actions...");
            quizDataService.getQuizCategories();
            playerRepository.save(new PlayerEntity("John"));
            playerRepository.save(new PlayerEntity("Harry"));
            playerRepository.save(new PlayerEntity("George"));

            log.info("List of players from database:");
            List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
            for (PlayerEntity player : playersFromDatabase) {
                log.info("Retrieved player: " + player);
            }
    }
}
