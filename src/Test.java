import Utils.P;

public class Test {
	public static void main(String[] args) {
		String c = "Ç";
		P.rintln(c.codePointAt(0));
		P.rintln(c.codePointAt(1));
		P.rintln(c.charAt(1));
	}
}
