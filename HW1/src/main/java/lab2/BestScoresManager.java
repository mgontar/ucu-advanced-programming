package lab2;

import java.io.*;
import java.util.ArrayList;

public class BestScoresManager {

    private static String filePath = "d:/guess_game_best_scores.obj";

    public static ArrayList<Score> readBestScores() throws IOException, InterruptedException, ClassNotFoundException {
        ArrayList<Score> result = new ArrayList<Score>();
        File file = new File(filePath);
        if(file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                // how many Scores to read.
                int size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    Object obj = ois.readObject();
                    if (obj instanceof Score) {
                        result.add((Score) obj);
                    } else {
                        throw new IllegalArgumentException("Deserialized object is not Score class instance");
                    }
                }
            } catch (EOFException e) {
            }
        }
        return result;
    }

    public static void writeBestScores(ArrayList<Score> scores) throws IOException, InterruptedException, ClassNotFoundException
    {
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(scores.size());
        for (Score score: scores) {
            oos.writeObject(score);
        }
    }
}
