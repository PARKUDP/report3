package jp.ac.uryukyu.ie.e225752;

public class Enemy extends LivingThing{

    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }
    
    @Override
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
}