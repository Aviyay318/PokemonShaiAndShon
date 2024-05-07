import java.util.Random;

public class Attack {
    private String name;
    private int cost;
    private int minDamageToOpponent;
    private int maxDamageToOpponent;

    public Attack(String name, int cost, int minDamageToOpponent,int maxDamageToOpponent) {
        this.name = name;
        this.cost = cost;
        this.minDamageToOpponent=minDamageToOpponent;
        this.maxDamageToOpponent=maxDamageToOpponent;
    }

    public int damageToOpponent(){
        Random random = new Random();
        return random.nextInt(this.maxDamageToOpponent,this.maxDamageToOpponent+1);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", minDamageToOpponent=" + minDamageToOpponent +
                ", maxDamageToOpponent=" + maxDamageToOpponent +
                '}';
    }
}
