package lab3.characters;

import org.fluttercode.datafactory.impl.DataFactory;

public abstract class Character {
    int power = 0;
    int hp = 0;
    String name = "";
    public static DataFactory dataFactory = new DataFactory();

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void battleCry(Character c);

    abstract void horrorCry(Character c);

    abstract void dyingCry(Character c);

    public Character()
    {
        this.name = dataFactory.getName();
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void kick(Character c) {
        battleCry(c);
    }

    void killedBy(Character c) {
        setHp(0);
        dyingCry(c);
        action("killed", c);
    }

    public void hitBy(Character c, int powerDiff, int hpDiff) {
        setPower(Math.max(getPower() - powerDiff, 0));
        setHp(Math.max(getHp() - hpDiff, 0));
        action("hit", c);
        if(powerDiff > 0)
            action("lost "+powerDiff+" of power");
        if(hpDiff > 0)
            action("lost "+hpDiff+" of health");
        if(isAlive())
        {
            horrorCry(c);
        }
        else
        {
            dyingCry(c);
            action("killed", c);
        }
    }

    String getFullName(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("[");
        sb.append(this.getClass().getSimpleName());
        sb.append("]");
        sb.append("{");
        sb.append("POW:");
        sb.append(getPower());
        sb.append(" ");
        sb.append("HP:");
        sb.append(getHp());
        sb.append("}");
        return sb.toString();
    }

    public void say(String speech)
    {
        System.out.println(getFullName() + ": " + speech);
    }

    public void action(String action, Character by)
    {
        System.out.println(getFullName() + " "+action+" by " + by.getFullName());
    }

    public void action(String action)
    {
        System.out.println(getFullName() + " "+action);
    }

    public boolean canHit()
    {
        return getPower() > 0;
    }
}
