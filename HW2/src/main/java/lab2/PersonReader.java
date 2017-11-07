package lab2;

import lombok.SneakyThrows;

import java.util.ArrayList;

public class PersonReader {

    @SneakyThrows
    public static void read(ArrayList<Person> persons)
    {
        Person prev = null;
        for (Person p : persons)
        {
            if(p.equals(prev))
            {
                System.out.println("You again?");
            }
            else
            {
                System.out.println(p.toString());
            }
            prev = p;
        }
    }
}
