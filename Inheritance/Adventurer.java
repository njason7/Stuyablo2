import java.util.Random;
public class Adventurer{
    private String name;
    private int HP, XP, STR, INT, DEX;
    public Adventurer(){
	this("Lester",20);
    }
    public Adventurer(String s){
	this(s,20);
    }
    public Adventurer(String s, int startHP){
	setName(s);
	HP = startHP;
	STR = 10;
	INT = 10;
	DEX = 10;
    }
    public String getName(){
	return name;
    }
    public void setName(String s){
	name = s;
    }
    public void setHP(int HP){
	this.HP = HP;
    }
    public void setSTR(int STR){
	this.STR = STR;
    }
    public void setINT(int INT){
	this.INT = INT;
    }
    public void setDEX(int DEX){
	this.DEX = DEX;
    }
    public int getHP(){
	return HP;
    }
    public int getSTR(){
	return STR;
    }
    public int getINT(){
	return INT;
    }
    public int getDEX(){
	return DEX;
    }
    public String toString(){
	return getName();
    }
    public void attack(Adventurer other){
	Random hitc = new Random();
	Random hitdmg = new Random();
	int dmg;
	if (this.getDEX() > other.getDEX()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 4;
	    System.out.println(this+" attacks "+other+" and did "+dmg+" damage.");
	}else if ((this.getDEX() / other.getDEX()) > hitc.nextDouble()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 4;
	    System.out.println(this+" attacks "+other+" and did "+dmg+" damage.");
	}else{
	    System.out.println(this+" attacks "+other+" and missed.");
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
	    spdmg = sphitdmg.nextInt(3) + this.getSTR() + 2;
	    System.out.println(this+" unleashes a barrage of attacks against "+other+" and did "+spdmg+" damage.");
	}else if ((this.getDEX() / (other.getDEX()-2)) > hitc.nextDouble()){
	    spdmg = sphitdmg.nextInt(3) + this.getSTR() + 2;
	    System.out.println(this+" unleashes a barrage of attacks against "+other+" and did "+spdmg+" damage.");
	}else{
	    System.out.println(this+" unleashes a barrage of attacks against "+other+" and missed.");
	    spdmg = 0;
	}
	other.setHP(other.getHP() - spdmg);
	spdmg = 0;
    }
}
