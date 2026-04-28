package multiplegenerictype;

public class PairUse {
	public static void main(String[] args){
		Pair<String, Integer> pSI = new Pair<>("shiv", 10);
		System.out.println(pSI.getFirst() + " " + pSI.getSecond()); // shiv 10
	}
}