package lab3.characters.behaviour;

import lab3.characters.Character;

public class BigSwordKickBehaviour implements KickBehaviour {
    @Override
    public void kick(Character c1, Character c2) {
        c2.hitBy(c2, 0, c1.dataFactory.getNumberBetween(3, c1.getPower()));
    }
}
