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
	setDEX(7);
    }
    public void setStamina(int stamina){
	this.stamina = stamina;
    }
    public int getStamina(){
	return stamina;
    }
    public void attack(Adventurer other){
	System.out.println(this+" slashes at "+other);
    }
    public void special(Adventurer other){
	System.out.println(this+" backstabs "+other);
    }
}
