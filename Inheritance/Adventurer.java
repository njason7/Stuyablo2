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
	STR = 5;
	INT = 5;
	DEX = 5;
    }
    public String getName(){
	return name;
    }
    public void setName(String s){
	name = s;
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
	System.out.println(this+" attacks "+other);
    }
    public void special(Adventurer other){
	System.out.println(this+" unleashes a barrage of attacks against "+other);
    }
}
