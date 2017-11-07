package lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Мстислав", 36, MaritalStatus.SINGLE);
        Person person2 = new Person("Мстислав", 36, MaritalStatus.SINGLE);
        Person person3 = new Person("Ярослав", 35, MaritalStatus.DIVORCED);
        Person person4 = new Person("Ярослав", 35, MaritalStatus.SINGLE);
        ArrayList<Person> persons = new ArrayList<Person>(Arrays.asList(person1, person2, person3, person4));
        PersonReader.read(persons);
    }
}
