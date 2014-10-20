import java.util.Random;
public class MartialArtist extends Adventurer{
    private int qi;
    public MartialArtist(){
	this("Ryu");
    }
    public MartialArtist(String s){
	this(s,20);
    }
    public MartialArtist(String s, int startHP){
	super(s,startHP);
	setSTR(12);
	setDEX(11);
	setQi(20);
    }
    public void setQi(int qi){
	this.qi=qi;
    }
    public int getQi(){
	return qi;
    }
    public void attack(Adventurer other){
	Random hitc = new Random();
	Random hitdmg = new Random();
	int dmg;
	if (this.getDEX() > other.getDEX()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 6;
	    System.out.println(this+" punches "+other+" and did "+dmg+" damage.");
	}else if ((this.getDEX() / other.getDEX()) < hitc.nextDouble()){
	    dmg = hitdmg.nextInt(3) + this.getSTR() - 6;
	    System.out.println(this+" punches "+other+" and did "+dmg+" damage.");
	}else{
	    System.out.println(this+" attempted to punch "+other+" and missed.");
	    dmg = 0;
	}
	other.setHP(other.getHP() - dmg);
	dmg = 0;
    } 
    public void specialAttack(Adventurer other){
	Random hitc = new Random();
	Random sphitdmg = new Random();
	int spdmg;
	if (qi >= 5){
	    if (this.getDEX() > other.getDEX()-2){
		spdmg = sphitdmg.nextInt(3) + this.getSTR() - 4;
		System.out.println(this+" beats up "+other+" and did "+spdmg+" damage.");
	    }else if ((this.getDEX() / (other.getDEX()-2)) < hitc.nextDouble()){
		spdmg = sphitdmg.nextInt(3) + this.getSTR() - 4;
		System.out.println(this+" beats up "+other+" and did "+spdmg+" damage.");
	    }else{
		System.out.println(this+" attempted to beat up "+other+" and missed.");
		spdmg = 0;
	    }
	    other.setHP(other.getHP() - spdmg);
	    spdmg = 0;
	    setQi(qi - 5);
	}else{
	    System.out.println("Not enough Qi. Performing a regular attack.");
	    attack(other);
	}
    }
    public String getStats(){
	return super.getStats()+" Qi: "+getQi();
    }
}
