import Utils.P;

public class Test {
	public static void main(String[] args) {
		String c = "Ç";
		P.rint(c.codePointAt(0));
		P.rint(c.codePointAt(1));
		P.rint(c.charAt(1));
	}
}
