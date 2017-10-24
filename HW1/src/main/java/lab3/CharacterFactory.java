package lab3;

import lab3.characters.*;
import lab3.characters.Character;


import java.lang.reflect.Type;
import java.util.Random;

public class CharacterFactory {
    static Class<Character>[] classes = new Class[]{Hobbit.class, Elf.class, King.class, Knight.class};
    public static Character createCharacter(){
        Character result = null;
        try {
            result = classes[(new Random()).nextInt(classes.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
