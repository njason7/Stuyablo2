import java.util.Random;
public class Warrior extends Adventurer{
    private int rage;
    public Warrior(){
	this("Carrot Ironfounderson");
    }
    public Warrior(String s){
	this(s,20);
    }
    public Warrior(String s, int startHP){
	super(s,startHP);
	setSTR(13);
	setRage(0);
    }
    public void setRage(int rage){
	this.rage=rage;
    }
    public int getRage(){
	return rage;
    }
    public void attack(Adventurer other){
	Random hitc = new Random();
	Random hitdmg = new Random();
	int dmg;
	if (this.getDEX() > other.getDEX()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 6;
	    if (dmg < 0){
		dmg = 0;
	    }
	    System.out.println(this+" charges at "+other+" and did "+dmg+" damage.");
	}else if ((this.getDEX() / other.getDEX()) < hitc.nextDouble()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 6;	
	    if (dmg < 0){
		dmg = 0;
	    }
	    System.out.println(this+" charges at "+other+" and did "+dmg+" damage.");
	}else{
	    System.out.println(this+" charges at "+other+" and missed.");
	    dmg = 0;
	}
	other.setHP(other.getHP() - dmg);
	dmg = 0;
	rage += 2;
    } 
    public void specialAttack(Adventurer other){
	Random hitc = new Random();
	Random sphitdmg = new Random();
	int spdmg;
	if (rage >= 5){
	    if (this.getDEX() > other.getDEX()-2){
		spdmg = sphitdmg.nextInt(3) + this.getSTR() - 4;
		if (spdmg < 0){
		    spdmg = 0;
		}
		System.out.println(this+" crushes "+other+" and did "+spdmg+" damage.");
	    }else if ((this.getDEX() / (other.getDEX()-2)) < hitc.nextDouble()){
		spdmg = sphitdmg.nextInt(3) + this.getSTR() - 4;
		System.out.println(this+" crushes "+other+" and did "+spdmg+" damage.");
		if (spdmg < 0){
		    spdmg = 0;
		}
	    }else{
		System.out.println(this+" attempted to crush "+other+" and missed.");
		spdmg = 0;
	    }
	    other.setHP(other.getHP() - spdmg);
	    spdmg = 0;
	    setRage(rage - 5);
	}else{
	    System.out.println("Not enough rage. Performing a regular attack.");
	    attack(other);
	}
    }
    public String getStats(){
	return super.getStats()+" Rage: "+getRage();
    }
}
