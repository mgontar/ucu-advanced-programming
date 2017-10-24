package lab3.characters;

public class King extends Character {

    public King()
    {
        setPower(dataFactory.getNumberBetween(5, 15));
        setHp(dataFactory.getNumberBetween(5, 15));
    }

    @Override
    public void kick(Character c) {
        super.kick(c);
        c.hitBy(c, 0, dataFactory.getNumberBetween(0, getPower()));
    }

    @Override
    void battleCry(Character c) {
        say("Have at thee, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void horrorCry(Character c) {
        say("Help me! Guards!");
    }

    @Override
    void dyingCry(Character c) {
        say("Thee hath killed me, but I will be revenged!...");
    }
}