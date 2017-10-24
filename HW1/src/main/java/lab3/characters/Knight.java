package lab3.characters;

public class Knight extends Character {

    public Knight()
    {
        setPower(dataFactory.getNumberBetween(2, 12));
        setHp(dataFactory.getNumberBetween(2, 12));
    }

    @Override
    public void kick(Character c) {
        super.kick(c);
        c.hitBy(c, 0, dataFactory.getNumberBetween(0, getPower()));
    }

    @Override
    void battleCry(Character c) {
        say("Death to the foes of the king!");
    }

    @Override
    void horrorCry(Character c) {
        say("Listen to my laughter, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void dyingCry(Character c) {
        say("Go kiss an orc!...");
    }
}
