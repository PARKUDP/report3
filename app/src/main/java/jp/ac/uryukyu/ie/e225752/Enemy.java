package jp.ac.uryukyu.ie.e225752;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */

    /*
     * private String Nameを取得するメソッド
     */
    public String getName(){
        return this.name;
    }

    /**
     * @retrun private int hitPointを取得するメソッド
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * @retrun private int attackを取得するメソッド
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * @retrun private boolean deadを取得するメソッド
     */
    public boolean Dead_status(){
        return this.dead;
    }
    
    public Enemy (String _name, int _maximumHP, int _attack) {
        this.setName(_name);
        this.setHitPoint(_maximumHP);
        this.setAttack(_attack);
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", _name, _maximumHP, _attack);
    }
    /**
     * @param _name String型変数nameに代入する値
     */
    public void setName(String _name){
        this.name = _name;
    }
    
    /**
     * @param _maximumHP int型変数hitPointに代入する値
     */
    public void setHitPoint(int _maximumHP){
        this.hitPoint = _maximumHP;
    }                                                                               
    /**
     * @param _attack int型変数attackに代入する値
     */
    public void setAttack(int _attack){
        this.attack = _attack;
    }
    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if (this.dead == false){
            int damage = (int)(Math.random() * this.getAttack());
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), hero.getName(), damage);
            hero.wounded(damage);
            }
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
            System.out.printf("モンスター%sは倒れた。\n", this.getName());
        }
    }

}