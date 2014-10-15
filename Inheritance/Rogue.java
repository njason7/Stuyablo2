import java.util.Random;
public class Rogue extends Adventurer{
    private int stamina;
    public Rogue(){
	this("Gaius",20);
    }
    public Rogue(String s){
	this(s,20);
    }
    public Rogue(String s, int startHP){
	super(s,startHP);
	setStamina(15);
	setDEX(13);
    }
    public void setStamina(int stamina){
	this.stamina = stamina;
    }
    public int getStamina(){
	return stamina;
    }
    public void attack(Adventurer other){
	Random hitc = new Random();
	Random hitdmg = new Random();
	int dmg;
	if (this.getDEX() > other.getDEX()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 5;
	    System.out.println(this+" slashed at "+other+" and did "+dmg+" damage.");
	}else if ((this.getDEX() / other.getDEX()) > hitc.nextDouble()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 5;
	    System.out.println(this+" slashed at "+other+" and did "+dmg+" damage.");
	}else{
	    System.out.println(this+" tried to slash "+other+" and missed.");
	    dmg = 0;
	}
	other.setHP(other.getHP() - dmg);
	dmg = 0;
    }
    public void special(Adventurer other){
	Random hitc = new Random();
	Random sphitdmg = new Random();
	int spdmg;
	if (this.getDEX() > other.getDEX()-2){
	    spdmg = sphitdmg.nextInt(3) + this.getDEX() + 1;
	    System.out.println(this+" backstabbed "+other+" and did "+spdmg+" damage.");
	}else if ((this.getDEX() / (other.getDEX()-2)) > hitc.nextDouble()){
	    spdmg = sphitdmg.nextInt(3) + this.getDEX() + 1;
	    System.out.println(this+" backstabbed "+other+" and did "+spdmg+" damage.");
	}else{
	    System.out.println(this+" attempted to backstab "+other+" and missed.");
	    spdmg = 0;
	}
	other.setHP(other.getHP() - spdmg);
	spdmg = 0;
	setStamina(stamina - 3);
    }
}
