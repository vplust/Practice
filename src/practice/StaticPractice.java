package practice;

class StaticData{
	static String s = "trivik";
	static String modifyStatic(){
		return s.toUpperCase();
	}
	
	static void intQuestion(Object a){
		System.out.println("in 2");
	}
	
	static void intQuestion(String a){
		System.out.println("in 1");
	}
	
	
}

public class StaticPractice extends StaticData {
	static{
		s = "vikas";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(modifyStatic());
		intQuestion((Object) new String());
	}

}
