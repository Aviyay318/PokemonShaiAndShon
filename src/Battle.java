import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon playerOne;
    private Pokemon playerTwo;
    private   boolean isPlayerOne;
    private Scanner scanner ;

    public Battle(){
     this.playerOne=getRandomPokemon();
     this.playerTwo=getRandomPokemon();
     this.isPlayerOne = true;
     this.scanner = new Scanner(System.in);
    }

    public void startGame(){
        boolean toNextTurn = false;
        while (this.playerOne.isAlive()&&this.playerTwo.isAlive()){
           printPokemonState();
           int userChoice = getUserChoice();
           switch (userChoice){
               case Constants.ATTACK -> toNextTurn = creatAttack();
           }
           if (toNextTurn){
               this.isPlayerOne  = !this.isPlayerOne;
               if (this.isPlayerOne){
                   this.playerOne.nextTurn();
               }else {
                   this.playerTwo.nextTurn();
               }

               //TODO
           }

       }

    }

    private boolean creatAttack() {
        boolean hasEnoughAttackPoint = true;
        int userChoice= -1;
        if (this.isPlayerOne){
            userChoice = getUserAttack(this.playerOne);
            hasEnoughAttackPoint = makeAttack(this.playerOne,this.playerTwo,userChoice);
        }else {
            userChoice = getUserAttack(this.playerTwo);
            hasEnoughAttackPoint = makeAttack(this.playerTwo,this.playerOne,userChoice);
        }
        return hasEnoughAttackPoint;
    }
    private boolean makeAttack(Pokemon playerOne, Pokemon playerTwo,int userChoice){
        boolean hasEnoughAttackPoint = true;
        if ( this.playerOne.hasEnoughAttackPoint(userChoice-1)){
            this.playerOne.subAttackPoint(userChoice);
            this.playerTwo.subPointLife(userChoice);
            if (this.playerOne instanceof FirePokemon){
                ((FirePokemon) this.playerOne).randomForSelfDamage();
            }
            checkWinner();
        }else {
            hasEnoughAttackPoint=false;
            System.out.println("not enough.. attack points");
        }
        return hasEnoughAttackPoint;
    }

    private void checkWinner() {
        if (!this.playerTwo.isAlive()){
            if (this.playerOne.isAlive()){
                System.out.println("The winner is: ");
                this.playerOne.printName();
                System.out.println("The losser is: ");
                this.playerTwo.printName();
            }else {
                System.out.println("drew");
            }

        }else {
            if (!this.playerOne.isAlive()){
                System.out.println("The winner is: ");
                this.playerTwo.printName();
                System.out.println("The losser is: ");
                this.playerOne.printName();
            }
        }
    }

    private int getUserAttack(Pokemon player) {
        int userChoice = -1;
        do {
            System.out.println("choose one attack: "+player.printAttack());
            userChoice = this.scanner.nextInt();
            if (userChoice<1||userChoice>player.getAmountOfAttack()){
                System.out.println("try again...");
            }

        }while (userChoice<1||userChoice>player.getAmountOfAttack());
        return userChoice;
    }


    private int getUserChoice() {
        int userChoice = -1;
        do {
            System.out.println("enter...print menu /n"); //TODO
            userChoice = scanner.nextInt();
            if (userChoice<1||userChoice>4){
                System.out.println("it... try again");
            }
        }while (userChoice<1||userChoice>4);
        return userChoice;
    }

    private void printPokemonState(){
        System.out.println("State: ");
        System.out.println(this.playerOne.printPokemonsState());
        System.out.println(this.playerTwo.printPokemonsState());
    }

private Pokemon getRandomPokemon(){
    Random random = new Random();
    int indexOfRandom = random.nextInt(Constants.POKEMON_NAMES.length);
    String pokemonName = Constants.POKEMON_NAMES[indexOfRandom];
    Pokemon randomPokemon=null;
    switch (pokemonName){
                case Constants.CHARMANDER -> randomPokemon=new
               FirePokemon("Charmander",80,40,3,new ArrayList<>(Arrays.asList(Constants.KICK, Constants.SCRATCH)));
//                case Constants.SALANDIT -> randomPokemon=
//                case Constants.MOLTRES -> randomPokemon=
//                case Constants.PIKACHU -> randomPokemon=
//                case Constants.BLITZLE -> randomPokemon=
//                case Constants.ELECTABUZZ -> randomPokemon=
            }
            return randomPokemon;
        }

}
