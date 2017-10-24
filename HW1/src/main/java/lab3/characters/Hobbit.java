package lab3.characters;

public class Hobbit extends Character {

    public Hobbit()
    {
        setPower(0);
        setHp(3);
    }

    @Override
    public void kick(Character c) {
        super.kick(c);
    }

    @Override
    void battleCry(Character c) {
        say("I don't fear you, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void horrorCry(Character c) {
        say("Now I fear you, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void dyingCry(Character c) {
        say("Oh, my sweet hobbit hole, I will newer see you again...");
    }
}
