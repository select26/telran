package app;

public class BracketsApp {
	public static void main(String[] args) {
//		private typeBrackets = char;
		String strOriginal = "((({12+14dd})))/[sdfsd]()()()()() {}[]";

		if (testStr(strOriginal)) System.out.println("Строка правильная!");
		else System.out.println("Строка HEправильная!");
	}

	public static int findOpenBrackets(String str) {
		int numBrakets = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == '[') || (str.charAt(i) == '{') || (str.charAt(i) == '('))
				numBrakets++;
		}
		return numBrakets;
	}

	public static boolean testStr(String strOriginal) {

		// если пустая строка - она точно правильная!
		if (strOriginal.isEmpty())
			return true;

		// Найдем сколько всего ОТКРЫТЫХ скобок
		int numOpenBrackets = findOpenBrackets(strOriginal);
		char[] stack = new char[numOpenBrackets]; // стек открытых скобок
		int stackIndex = 0; // указатель на вершину стека

		for (int i = 0; i < strOriginal.length(); i++) {
			char currChar = strOriginal.charAt(i);
			// если скобки открываются
			if ((currChar == '[') || (currChar == '{') || (currChar == '(')) {
				stack[stackIndex] = currChar; // добавим в стек новые открытые скобки
				stackIndex++;
			}
			// если скобки закрываются
			if ((currChar == ']')) {
				if ( stackIndex >0 && (stack[stackIndex - 1] == '[') ){ // закрылись правильные скобки
					stackIndex--;
				} else
					return false; // иначе - неверные скобки!!!
			}

			if ((currChar == '}')) {
				if ( stackIndex >0 && (stack[stackIndex - 1] == '{') ) { // закрылись правильные скобки
					stackIndex--;
				} else
					return false; // иначе - неверные скобки!!!
			}

			if ((currChar == ')')) {
				if (stackIndex >0 && (stack[stackIndex - 1] == '(') ) { // закрылись правильные скобки
					stackIndex--;
				} else
					return false; // иначе - неверные скобки!!!
			}

		}
		// если стек весь разобрался - выражение правильное!!
		if (stackIndex == 0)
			return true;
		else
			return false;
	}
}
