import java.util.List;
import java.util.Random;

public class FirePokemon extends Pokemon{
    public FirePokemon(String name,int maxAttackPoints, int maxLifePoints, int maxLevel, List<Attack> attackList) {
        super(name,maxAttackPoints, maxLifePoints, maxLevel,attackList);
    }



    public void randomForSelfDamage(){
        Random random = new Random();
        if (random.nextInt(1, Constants.PROBABILITY_OF_SELF_DAMAGE+1)== Constants.PROBABILITY_OF_SELF_DAMAGE){
            int selfDamage = random.nextInt(Constants.MIN_DAMAGE, Constants.MAX_DAMAGE);
            this.subStructLifePoints(selfDamage);
        }
    }
}
