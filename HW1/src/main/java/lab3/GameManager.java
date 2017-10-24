package lab3;

import lab3.characters.Character;
import lab3.characters.Hobbit;

import java.util.ArrayList;

public class GameManager {
    public static void fight(Character c1, Character c2)
    {
        c1.action("enters the scene...");
        c2.action("comes from the other side...");
        while(c1.isAlive() && c2.isAlive())
        {
            c1.kick(c2);
            if(c2.isAlive())
            {
                c2.kick(c1);
            }

            if(!c1.canHit() && !c2.canHit())
            {
                c1.action("run away");
                c2.action("run away (in different direction)");
                break;
            }
        }
    }

    public static void manageFight()
    {
        fight(CharacterFactory.createCharacter(), CharacterFactory.createCharacter());
    }
}
