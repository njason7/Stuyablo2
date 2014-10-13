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
	setSTR(7);
	setRage(0);
    }
    public String warcry(){
	return "CHAAARGGEEEEEE";
    }
    public void setRage(int rage){
	this.rage=rage;
    }
    public int getRage(){
	return rage;
    }
    public void attack(Adventurer other){
	System.out.println(this+" charges at "+other);
    }
    public void special(Adventurer other){
	System.out.println(this+" crushes "+other);
    }
}
