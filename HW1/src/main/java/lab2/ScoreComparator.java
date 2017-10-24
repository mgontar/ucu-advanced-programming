package lab2;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {
    public int compare(Score score1, Score score2) {
        //Sort from larger to smaller
        return Integer.compare(score2.getScore(), score1.getScore());
    }
}
