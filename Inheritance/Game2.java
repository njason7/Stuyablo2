import java.util.Random;
import java.util.Scanner;
public class Game2{
    public static void combat(Adventurer[] player, Adventurer opp){
	Scanner in = new Scanner(System.in);
	for (int i=0;i<(player.length);i++){
	    while (true){
		System.out.println("Choose an action: \n A: attack \n S: special attack");
		String act2 = in.next();
		if (act2.equals("A")){
		    player[i].attack(opp);
		    break;
		}else if (act2.equals("S")){
		    player[i].specialAttack(opp);
		    break;
		}else{
		    System.out.println("Please input choice again.");
		}
	    }
	    if (opp.getHP() <= 0){
		break;
	    }
	}
	Random rand = new Random();
	Random rand2 = new Random();
	int target = rand2.nextInt(3);
	while (opp.getHP() > 0){
	    if (player[target].getHP() > 0){
		if (rand.nextDouble() < .3){
		    opp.specialAttack(player[target]);
		    System.out.println();
		    break;
		}else{
		    opp.attack(player[target]);
		    System.out.println();
		    break;
		}
	    }else{
		target = rand2.nextInt(3);
	    }
	}
    }
    public static void main(String[]args){
	Adventurer opp;
	Adventurer[] player;
	player = new Adventurer [3];
	Scanner in = new Scanner(System.in);
	player[0] = new Warrior("Barrett");
	player[1] = new Wizard("Terra");
	player[2] = new Rogue("Zidane");
	/*while (true){
   	    System.out.println("Choose a class: \n A: Warrior \n B: Wizard \n C: Rogue");
	    String charselect = in.next();
	    if (charselect.equals("A")){
		player = new Warrior("Player");
		break;
	    }else if (charselect.equals("B")){
		player = new Wizard("Player");
		break;
	    }else if (charselect.equals("C")){
		player = new Rogue("Player");
		break;
	    }else{
		System.out.println("Please input choice again.");
	    }
	}
	int statpts = 30;
	while (true){
	    Scanner inSTR = new Scanner(System.in);
	    System.out.println("Enter how many points in STR:");
	    int STRpts = inSTR.nextInt();
	    Scanner inINT = new Scanner(System.in);
	    System.out.println("Enter how many points in INT:");
	    int INTpts = inINT.nextInt();
	    Scanner inDEX = new Scanner(System.in);
	    System.out.println("Enter how many points in DEX:");
	    int DEXpts = inDEX.nextInt();
	    if (STRpts+INTpts+DEXpts <= 30){
		player.setSTR(STRpts);
		player.setINT(INTpts);
		player.setDEX(DEXpts);
		break;
	    }else{
		System.out.println("Total points exceed 30. Go back and enter values so the sum is less than 30.");
	    }
	    }*/
	Random comp = new Random();
	int comp2 = comp.nextInt(3);
	if (comp2 == 1){
	    opp = new Warrior("Opponent");
	}else if (comp2 == 2){
	    opp = new Wizard("Opponent");
	}else{
	    opp = new Rogue("Opponent");
	}
	while (player[0].getHP() > 0 && player[1].getHP() >0 && player[2].getHP() > 0 && opp.getHP() > 0){
	    for(int i=0;i<3;i++){
		System.out.println(player[i].getStats());
	    }
	    System.out.println();
	    System.out.println(opp.getStats());
	    System.out.println();
	    combat(player,opp);
	    }
	   
	if (opp.getHP() < 1){
	    System.out.println("Victory! *cue victory music*");
	    System.out.println();
	    for(int i=0;i<3;i++){
		System.out.println(player[i].getStats());}
	    System.out.println();
	    System.out.println(opp.getStats());
	}else{
	    System.out.println("Defeat. Better luck next time.");
	    System.out.println();
	    for(int i=0;i<3;i++){
		System.out.println(player[i].getStats());}
	    System.out.println();
	    System.out.println(opp.getStats());
	}
    }
}
