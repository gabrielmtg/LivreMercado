package test;
import models.*;
/**

 @author Professor Cancian
 */
public /*
		 static
		 */ class TestIndentation {
	private static int indent = 0;
	private static int indentSpaces = 4;

	/**
	 <p>
	 */
	public static void Inc() {
		indent++;
	}

	/**
	 <p>
	 */
	public static void Dec() {
		if (--indent < 0)
			indent = 0;
	}

	/**

	 @param value
	 */
	public static void Set(int value) {
		if (value >= 0)
			indent = value;
		else
			indent = 0;
	}

	/**

	 @return
	 */
	public static int Get() {
		return indent;
	}

	/**

	 @param text
	 */
	public static void Println(String text) {
		System.out.println(Indent() + text);
	}

	/**

	 @param text
	 */
	public static void Print(String text) {
		System.out.print(Indent() + text);
	}

	/**

	 @return
	 */
	public static String Indent() {
		String totalSpaces = "";
		for (int indents = 0; indents < indent; indents++) {
			totalSpaces += "|";
			for (int spaces = 1; spaces < indentSpaces; spaces++)
				totalSpaces += " ";
		}
		return totalSpaces;
	}

	/**

	 @return
	 */
	public static String PreInc() {
		Inc();
		return Indent();
	}

	/**

	 @return
	 */
	public static String PreDec() {
		Dec();
		return Indent();
	}

	/**

	 @return
	 */
	public static String PosInc() {
		String str = Indent();
		Inc();
		return str;
	}

	/**

	 @return
	 */
	public static String PosDec() {
		String str = Indent();
		Dec();
		return str;
	}

	/**
	 @return the indentSpaces
	 */
	public static int GetSpaces() {
		return indentSpaces;
	}

	/**
	 @param numSpaces
	 */
	public static void SetSpaces(int numSpaces) {
		indentSpaces = numSpaces;
	}

}
