public class demo{
    public static void main(String[]args){
	PersonalGreeter Bob,Mary,Juan;
	Bob = new PersonalGreeter();
	Mary = new PersonalGreeter("Mary");
	Juan = new PersonalGreeter("Juan","Hola");
	System.out.println(Bob.greet());
	System.out.println(Mary.greet());
	System.out.println(Juan.greet());}}
