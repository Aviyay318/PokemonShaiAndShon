import java.util.List;

public class ElectricPokemon extends Pokemon{
    private int percentOfElectricity;
    private int specialMove;

    public ElectricPokemon(int maxAttackPoints, int maxLifePoints, String name, int maxLevel, List<Attack> attackList) {
        super(name,maxAttackPoints, maxLifePoints, maxLevel,attackList);
        this.percentOfElectricity=0;
        this.specialMove=0;
    }
    public String printPokemonsState(){
        return super.printPokemonsState()+("charge: "+this.percentOfElectricity);
    }
    private void chargingElectricity(){
        this.percentOfElectricity+=(this.percentOfElectricity*5)/100;
    }
    private void checkLifePoints(){
        if (this.checkPercentOfLifePoints()){
            this.percentOfElectricity=0;
        }
    }
    public void nextTurn() {
        super.nextTurn();
        chargingElectricity();
    }
}
