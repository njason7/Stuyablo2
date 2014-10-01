public class Stars{
    public static String rect(int len, int wid){
	int countl=0;
	String fin ="";
	while (countl < len){
	    int countw=0;
	    while (countw < wid){
		fin+="*";
		countw++;
	    }
	    countl++;
	    fin+="\n";
	}
	return fin;
    }
    public static String tri(int s){
	int count=0;
	String str="";
	while (count<s){
	    int count2=0;
	    while (count2<=count){
		str+="*";
		count2++;
	    }
	    str+="\n";
	    count++;
	}
	return str;
    }
    public static void main (String[]args){
	System.out.println(rect(2,3));
	System.out.println(tri(3));
    }
}
