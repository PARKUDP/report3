package jp.ac.uryukyu.ie.e225752;

public class Warrior extends Hero{
    public Warrior(String name, int hitPoint, int attack){
        super(name, hitPoint, attack);
    }
    
    @Override
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("戦士%sは道半ばで力尽きてしまった。\n", name);
        }
    }
    
    public void attackWithWeponSkill(LivingThing opponent){
        if (this.dead == false){
            int damage = (int)(attack * 1.5);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
}