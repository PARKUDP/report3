package jp.ac.uryukyu.ie.e225752;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * private String Nameを取得するメソッド
     */
    public String getName(){
        return this.name;
    }

    /**
     * private int hitPointを取得するメソッド
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * private int attackを取得するメソッド
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * private boolean deadを取得するメソッド
     */
    public boolean Dead_status(){
        return this.dead;
    }
    
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    
    public Hero (String _name, int _maximumHP, int _attack) {
        this.setName(_name);
        this.setHitPoint(_maximumHP);
        this.setAttack(_attack);
        this.dead = false;
        System.out.printf("q%sのHPは%d。攻撃力は%dです。\n", _name, _maximumHP, _attack);
    }
    /**
     * private String nameを代入するメソッド
     */
    public void setName(String _name){
        this.name = _name;
    }

    /**
     * private int hitPointを代入するメソッド
     */
    public void setHitPoint(int _maximumHP){
        this.hitPoint = _maximumHP;
    }

    /**
     * private int attackを代入するメソッド
     */
    public void setAttack(int _attack){
        this.attack = _attack;
    }
    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * this.getAttack());
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.hitPoint -= damage;   
        if( this.hitPoint <= 0 ) {
            this.dead = true;
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}