package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Score;
import co.usa.citasMedicas.citasMedicas.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    public List<Score> getAll(){
        return (List<Score>) scoreRepository.getAll();
    }
    public Optional<Score> getCalificacionById(int id){
        return scoreRepository.getCalificacionById(id);
    }
    public Score save(Score score){
        if (score.getStars() >= 0 && score.getStars() <= 5) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> e = scoreRepository.getCalificacionById(score.getIdScore());
                if (e.isEmpty()) {
                    return scoreRepository.save(score);
                }
            }

        }
        return score;
    }

    public Score update (Score score){
        if (score.getIdScore() != null) {
            Optional<Score> e = scoreRepository.getCalificacionById(score.getIdScore());
            if (!e.isEmpty()) {
                if (score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null && score.getStars() >= 0 && score.getStars() <= 5) {
                    e.get().setStars(score.getStars());
                }
                scoreRepository.save(e.get());
                return e.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }
    public Boolean delete(int id){
        Boolean aboolean = getCalificacionById(id).map(calificacion -> {
        scoreRepository.delete(calificacion);
        return true;
        }).orElse(false);
        return aboolean;
    }
}
