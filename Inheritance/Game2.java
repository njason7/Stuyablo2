import java.util.Random;
import java.util.Scanner;
public class Game2{

    public static void combat(Adventurer[] player, Adventurer opp){
	Scanner in =  new Scanner(System.in);
	for (int i=0;i<(player.length);i++){
	    while (opp.getHP() > 0){
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
	}
	Random rand = new Random();
	Random rand2 = new Random();
	int target = rand2.nextInt(4);
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
		target = rand2.nextInt(4);
	    }
	}
    }

    public static int getUserInt(int min,int max){
	Scanner in = new Scanner(System.in);
	int result;
	do{
	    System.out.println("Enter a non-negative integer less than "+(max+1));
	    result = in.nextInt();
	}while(result < min || result > max);
	return result;
    }


    public static void charcreation(Adventurer[] party){
	for (int i=0;i<party.length;i++){
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter a name:");
	    String nam = in.nextLine();
	    while (true){
		System.out.println("Choose a class: \n A: Warrior \n B: Wizard \n C: Rogue \n D: Martial Artist");
		String charselect = in.next();
		if (charselect.equals("A")){
		    party[i] = new Warrior(nam);
		    break;
		}else if (charselect.equals("B")){
		    party[i] = new Wizard(nam);
		    break;
		}else if (charselect.equals("C")){
		    party[i] = new Rogue(nam);
		    break;
		}else if (charselect.equals("D")){
		    party[i] = new MartialArtist(nam);
		    break;
		}else{
		    System.out.println("Please input choice again.");
		}
	    }
	    bonusstats(party[i],27);
	}
    }
    public static void bonusstats(Adventurer player, int statpts){
	System.out.println("Enter how many points in STR:");
	int STRpts = getUserInt(0,statpts);
	player.setSTR(STRpts+1);
	statpts = statpts- STRpts;
	System.out.println("Enter how many points in INT:");
	int INTpts = getUserInt(0,statpts);
	player.setINT(INTpts+1);
	player.setDEX(statpts-INTpts+1);
	System.out.println("These are the stats\n STR: "+player.getSTR()+"\n INT: "+player.getINT()+"\n DEX: "+player.getDEX());
    }

    public static void main(String[]args){
	Adventurer opp;
	Adventurer[] player;
	player = new Adventurer [4];
	charcreation(player);
	boolean done = false;
	do{
	Random comp = new Random();
	int comp2 = comp.nextInt(4);
	if (comp2 == 1){
	    opp = new Warrior("Opponent");
	}else if (comp2 == 2){
	    opp = new Wizard("Opponent");
	}else if (comp2 == 3){
	    opp = new Rogue("Opponent");
	}else{
	    opp = new MartialArtist("Opponent");
	}
	while (player[0].getHP() > 0 && player[1].getHP() >0 && player[2].getHP() > 0 && player[3].getHP() > 0 && opp.getHP() > 0){
	    for(int i=0;i<player.length;i++){
		System.out.println(player[i].getStats());
	    }
	    System.out.println();
	    System.out.println(opp.getStats());
	    System.out.println();
	    combat(player,opp);
	    
	}
	if (opp.getHP() < 1){
	    System.out.println("\n Victory! *cue victory music*");
	    System.out.println();
	    for(int i=0;i<player.length;i++){
		System.out.println(player[i].getStats());}
	    System.out.println();
	    System.out.println(opp.getStats());
	}else{
	    System.out.println("\n Defeat. Better luck next time.");
	    System.out.println();
	    for(int i=0;i<player.length;i++){
		System.out.println(player[i].getStats());}
	    System.out.println();
	    System.out.println(opp.getStats());
	    break;
	}
	while(true){
	    Scanner choice = new Scanner(System.in);
	    System.out.println("Do you wish to continue? \n Y: Yes \n N: No");
	    String choice1 = choice.nextLine();
	    if (choice1.equals("Y")){
		for (int i=0;i<player.length;i++){
		    player[i].setHP(20);
		    if (player[i].getClass() == Warrior.class){
			((Warrior)player[i]).setRage(0);
		    }else if (player[i].getClass() == Wizard.class){
			((Wizard)player[i]).setMana(20);
		    }else if (player[i].getClass() == Rogue.class){
			((Rogue)player[i]).setStamina(15);
		    }else{
			((MartialArtist)player[i]).setQi(20);
		    }
		}
		break;
	    }else if (choice1.equals("N")){
		done = true;
		break;
	    }else{
		System.out.println("Please input a valid response.");
	    }
	}
	}while(!done);
	
	
    }
}
