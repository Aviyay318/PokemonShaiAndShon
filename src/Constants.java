public class Constants {
    public static final int  PROBABILITY_OF_SELF_DAMAGE=4;
    public static final int MIN_DAMAGE =3;
    public static final int MAX_DAMAGE =9;
    public static final  String[] POKEMON_NAMES = new String[]{"Charmander","Salandit","Moltres","Pikachu","Blitzle","Electabuzz"};
    public static final String CHARMANDER = "Charmander";
    public static final String SALANDIT = "Salandit";
    public static final String MOLTRES = "Moltres";
    public static final String PIKACHU = "Pikachu";
    public static final String BLITZLE = "Blitzle";
    public static final String ELECTABUZZ = "Electabuzz";

    public static final int ATTACK = 1;
    public static final int WAITING = 2;
    public static final Attack KICK = new Attack("Kick",0,2,2);
    public static final Attack SCRATCH  =new Attack("Scratch",15,25,30);
    public static final Attack LIVE_COAL = new Attack("Live Coal",10,0,25);
    public static final Attack ASSISTING_HEATER =  new Attack("Assisting Heater",30,10,60);
    public static final Attack FIRE_WING = new Attack("Fire Wing",30,30,30);
    public static final Attack QUICK_ATTACK = new Attack("Quick Attack",5,10,10);
    public static final Attack FLOP = new Attack("Flop",20,20,25);
    public static final Attack THUNDER = new Attack("Thunder",60,40,50);
    public static final Attack THUNDER_PUNCH = new Attack("Thunder Punch",80,50,120);
    public static final Attack FIRE_CLAWS = new Attack("Fire Claws",25,0,50);
    public static final Attack ELECTRO_BALL = new Attack("Electro Ball",10,30,40);
    public static final Attack ELECTRIC_SURFER = new Attack("Electric Surfer",60,20,120);
    public static final Attack ZAP_KICK = new Attack("Zap Kick",30,30,35);
    public static final Attack FLAME_TAIL = new Attack("flame tail",40,30,50);
    public static final Attack FIERY_TAIL = new Attack("fiery tail",40,30,50);

}
