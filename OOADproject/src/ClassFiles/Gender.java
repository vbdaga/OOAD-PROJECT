package ClassFiles;

public class Gender {
	public boolean g;
	// true if male
	// false if female
	public Gender(boolean f){
		g=f;
	}
	String get(){
		if(g) return "male";
		else return "female";
	}
}
