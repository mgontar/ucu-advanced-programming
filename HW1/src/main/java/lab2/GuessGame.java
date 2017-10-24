package lab2;

import javax.swing.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static lab2.Status.CANCEL;
import static lab2.Status.CONTINUE;
import static lab2.Status.WINNER;

public class GuessGame {
    int max;
    int actual;
    int guess;
    int guessCount;

    public void play(int max)
    {
        this.max = max;
        actual = new Random().nextInt((max) + 1);
        guess = -1;
        guessCount = 0;
        boolean guessAgain = false;
        Status status = CONTINUE;
        do {
            status = playGuess(this.max, actual, guess);
            guessAgain = (CONTINUE == status);
            guessCount++;
        }while (guessAgain);

        if (WINNER == status)
        {
            int gameScore = this.max / guessCount;
            try {
                ArrayList<Score> scores = BestScoresManager.readBestScores();
                boolean addScore = true;
                if(scores.size() > 0)
                {
                    scores.sort(new ScoreComparator());
                    Score lastBestScore = scores.get(scores.size()-1);
                    addScore = gameScore > lastBestScore.getScore() || scores.size() < 5;
                }

                if (addScore)
                {
                    String name = JOptionPane.showInputDialog("Congratulations! You hit the top 5 best scores! What is your name?");
                    if (null == name || name.isEmpty())
                    {
                        name = "NONAME";
                    }
                    Score score = new Score(name,gameScore);
                    scores.add(score);
                    scores.sort(new ScoreComparator());
                    //Get top 5 scores
                    scores = new ArrayList<Score>(scores.subList(0, Math.min(5, scores.size())));
                    BestScoresManager.writeBestScores(scores);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void printBestScores()
    {
        try {
            ArrayList<Score> scores = BestScoresManager.readBestScores();
            if(scores.size()>0) {
                scores.sort(new ScoreComparator());

                StringBuilder sb = new StringBuilder();
                sb.append("Guess Game Top 5 Scores:\n\n");
                sb.append("Name\t\tScore\n");
                sb.append("----\t\t-----\n");
                for (Score score : scores) {
                    sb.append(score.getName());
                    sb.append("\t\t");
                    sb.append(score.getScore());
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, new JTextArea(sb.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Status playGuess(int maxValue, int actualValue, int prevGuessValue)
    {
        Status result = CONTINUE;
        StringBuilder sb = new StringBuilder();
        if (-1 == prevGuessValue)
        {
            sb.append("Try to guess number from 0 to ");
            sb.append(maxValue);
        }
        else
        {
            sb.append("Your number ");
            sb.append(prevGuessValue);
            sb.append(" is ");
            sb.append(prevGuessValue > actualValue ? "larger" : "smaller");
            sb.append(" than one I have think of. Try again?");
        }
        boolean repeatInput = false;
        do {
            String input = JOptionPane.showInputDialog(sb.toString());
            if (null == input) {
                result = CANCEL;
            } else {
                try {
                    this.guess = Integer.parseInt(input);
                    result = (guess == actualValue) ? WINNER : CONTINUE;
                } catch (NumberFormatException ex) {
                    //Not integer in input field
                    String msg = "We need a number from 0 up to "+maxValue+", try again?";
                    int choice = JOptionPane.showConfirmDialog(null, msg, null,
                            JOptionPane.YES_NO_OPTION);
                    if (JOptionPane.NO_OPTION == choice) {
                        result = CANCEL;
                    } else {
                        repeatInput = true;
                    }
                }
            }
        }while (repeatInput);
        return result;
    }



}
