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
	setINT(7);
    }
    public void setMana(int mana){
	this.mana = mana;
    }
    public int getMana(){
	return mana;
    }
    public void attack(Adventurer other){
	System.out.println(this+" fires a bolt against "+other);
    }
    public void special(Adventurer other){
	System.out.println(this+" casts Ultima against "+other);
    }
}
