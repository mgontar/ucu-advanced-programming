package lab3.characters;

import lab3.characters.behaviour.KickBehaviour;
import lab3.characters.behaviour.SmallSwordKickBehaviour;
import lab3.characters.behaviour.SwordKickBehaviour;

public class King extends Character {

    KickBehaviour kickBehaviour = new SwordKickBehaviour();

    public King()
    {
        setPower(dataFactory.getNumberBetween(5, 15));
        setHp(dataFactory.getNumberBetween(5, 15));
    }

    @Override
    public void kick(Character c) {
        super.kick(c);
        kickBehaviour.kick(this, c);
    }

    @Override
    public void hitBy(Character c, int powerDiff, int hpDiff) {
        super.hitBy(c, powerDiff, hpDiff);
        if(getHp() < 5 && !(kickBehaviour instanceof SmallSwordKickBehaviour))
        {
            say("Here is my knife!");
            kickBehaviour = new KickBehaviour() {
                @Override
                public void kick(Character c1, Character c2) {
                    c2.hitBy(c2, 1, c1.dataFactory.getNumberBetween(0, 1));
                }
            };
        }
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