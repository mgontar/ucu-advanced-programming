package lab3.characters;

public class Elf extends Character {

    public Elf()
    {
        setPower(10);
        setHp(10);
    }

    @Override
    public void kick(Character c) {
        super.kick(c);
        if (c.getPower() < this.getPower())
        {
            c.killedBy(this);
        }
        else
        {
            c.hitBy(this, 1, 0);
        }
    }

    @Override
    void battleCry(Character c) {
        say("I will follow you to death and beyond, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void horrorCry(Character c) {
        say("You are king in your imagination, " + c.getClass().getSimpleName() + "!");
    }

    @Override
    void dyingCry(Character c) {
        say("Oh! Farewell my people, I shalt see thee in the Halls of Mandos!...");
    }
}
