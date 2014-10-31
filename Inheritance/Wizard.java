import java.util.Random;
public class Wizard extends Adventurer{
    private int mana;
    public Wizard(){
	this("Tim",20);
    }
    public Wizard(String s){
	this(s,20);
    }
    public Wizard(String s, int startHP){
	super(s,startHP);
	setMana(20);
	setINT(13);
    }
    public void setMana(int mana){
	this.mana = mana;
    }
    public int getMana(){
	return mana;
    }
    public void attack(Adventurer other){
	Random hitc = new Random();
	Random hitdmg = new Random();
	int dmg;
	if (this.getDEX() > other.getDEX()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 9;
	    if (dmg < 0){
		dmg = 0;
	    }
	    System.out.println(this+" poked "+other+" and did "+dmg+" damage.");
	}else if ((this.getDEX() / other.getDEX()) < hitc.nextDouble()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 9;
	    if (dmg < 0){
		dmg = 0;
	    }
	    System.out.println(this+" poked "+other+" and did "+dmg+" damage.");
	}else{
	    System.out.println(this+" tried to poke "+other+" and missed.");
	    dmg = 0;
	}
	other.setHP(other.getHP() - dmg);
	dmg = 0;
    }
    public void specialAttack(Adventurer other){
	Random hitc = new Random();
	Random sphitdmg = new Random();
	int spdmg;
	if (mana >= 5){
	    if (this.getINT() > other.getDEX()-2){
		spdmg = sphitdmg.nextInt(3) + this.getINT() - 4;
		if (spdmg < 0){
		    spdmg = 0;
		}
		System.out.println(this+" casted Fire against "+other+" and did "+spdmg+" damage.");
	    }else if ((this.getINT() / (other.getDEX()-2)) < hitc.nextDouble()){
		spdmg = sphitdmg.nextInt(3) + this.getINT() - 4;
		if (spdmg < 0){
		    spdmg = 0;
		}
		System.out.println(this+" casted Fire against "+other+" and did "+spdmg+" damage.");
	    }else{
		System.out.println(this+" attempted to cast Fire against "+other+" and missed.");
		spdmg = 0;
	    }
	    other.setHP(other.getHP() - spdmg);
	    spdmg = 0;
	    setMana(mana - 5);
	}else{
	    System.out.println("Not enough mana. Performing a regular attack.");
	    attack(other);
	}
    }
    public String getStats(){
	return super.getStats()+" Mana: "+getMana();
    }
}
