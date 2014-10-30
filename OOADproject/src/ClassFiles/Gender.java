package ClassFiles;

class Gender {
	boolean g;
	// true if male
	// false if female
	Gender(boolean f){
		g=f;
	}
	String get(){
		if(g) return "male";
		else return "female";
	}
}
