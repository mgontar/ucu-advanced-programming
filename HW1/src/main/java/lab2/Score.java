package lab2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Score implements Serializable
{
    String name;
    int score;
}

