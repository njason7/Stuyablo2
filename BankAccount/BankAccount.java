public class BankAccount{
    private int balance,account,pin;
    private String user,pass,all;
    public BankAccount(int balance, int account, String user, String pass, int pin){
	setbalance(balance);
	setaccount(account);
	setuser(user);
	setpass(pass);
	setpin(pin);}
    public void setbalance(int balance){
	this.balance = balance;}
    public void setaccount(int account){
	this.account = account;}
    public void setpin(int pin){
	this.pin = pin;}
    public void setuser(int user){
	this.user = user;}
    public void setpass(int pass){
	this.pass = pass;}
    public void deposit(int dep){
	balance = balance + dep;}
    public void withdraw(int with){
	if (balance >= with){
	    balance = balance - with;
	    return true}
	else {
	    return false}}
    public String print(){
	return balance+" "+account+" "+user+" "+pass+" "+pin;}
    public String toString(){
	return balance+"
    
}
