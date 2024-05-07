import java.util.List;
import java.util.Random;

public abstract class Pokemon {
    private String name;
    private List<Attack> attacks;
    private int maxAttackPoints;
    private int maxLifePoints;
    private int attackPoints;
    private int lifePoints;
    private int attackPower;
    private int level;
    private int maxLevel;

    public Pokemon(String name,int maxAttackPoints,int maxLifePoints,int maxLevel,List<Attack>attackList){
        this.maxAttackPoints=maxAttackPoints;
        this.maxLifePoints=maxLifePoints;
        this.lifePoints = maxLifePoints;
        this.attackPoints=(maxAttackPoints*75)/100;
        this.name= name;
        this.attackPower=1;
        this.level = 1;
        this.maxLevel = maxLevel;
        this.attacks=attackList;

    }
    protected boolean checkPercentOfLifePoints(){
        int percent = (this.maxLifePoints*this.lifePoints)/100;
        return percent<20;
    }
    public String  printPokemonsState(){
       return (this.name+" "+"life points: "+this.lifePoints+"/"+this.maxLifePoints+" attack points: "+this.attackPoints+"/"+this.maxAttackPoints);
    }
    public String printAttack(){
       String result =  "The Attack: \n" ;
        for (int i = 0; i < this.attacks.size(); i++) {
            result+=Integer.toString((i+1))+this.attacks.get(i)+"\n";
        }
        return result;
    }
    public int getAmountOfAttack(){
        return this.attacks.size();
    }
    protected void subStructLifePoints(int selfDamage ){
        this.lifePoints-=selfDamage;
    }
public boolean isAlive(){
        return this.lifePoints>0;
}
public void subPointLife(int userChoice){
   this.lifePoints-=this.attacks.get(userChoice).damageToOpponent();
}
public void subAttackPoint(int userChoice){
       this.attackPoints-=this.attacks.get(userChoice).getCost();
}
    public boolean hasEnoughAttackPoint(int userChoice) {
        return this.attacks.get(userChoice).getCost()<=this.attackPoints;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void nextTurn() {
        Random random = new Random();
        this.lifePoints+= random.nextInt(0,5); //TODO
        this.attackPoints+= random.nextInt(0,5); //TODO
    }
}
