package StackAndQueue;

public class BalancedParetheses {
	
	// Function for checking the rationality of 
	public static boolean isValid(String expression) {
		
		ArrayStack<Character> stack = new ArrayStack<Character>();
		
		// Only consider paretheses, not consider number 
		for (int i=0; i<expression.length(); i++) {
			char character = expression.charAt(i);	
			if (character == '(') {
				stack.push(character);
			}
			else if (!stack.isEmpty() && character == ')' && stack.top() == '(') {
				stack.pop();
			}
			else if (character == ')' ) {
				stack.push(character);
			}
			else {
				continue;
			}
		}

		// Expression is reasonable if stack that contains all paretheses is empty
		if (stack.isEmpty()) return true;
		return false;
	}
	
	public static double calculate(String exp) {
		// Stack values to save number, value that are calculated in progress 
		ArrayStack<Double> values = new ArrayStack<>();
		// Stack operator to save +, -, *, / or (, ) in progress
		ArrayStack<Character> operator = new ArrayStack<>();
		
		for (int i=0; i<exp.length(); i++) {
			// Consider number in expression
			if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
				// In case, the next character is also number ( Example: 856,...). We need save them 
				// in stack look like 865 (not 8, 6, 5)
				String number = "";
				while (i < exp.length() && exp.charAt(i) >= '0' && exp.charAt(i) <= '9') number += exp.charAt(i++);
				values.push(Double.parseDouble(number));
				// Go back character i-th 
				i--;
			} 
			// Calculate in paretheses
			else if (exp.charAt(i) == '(') operator.push(exp.charAt(i));
			else if (exp.charAt(i) == ')') {
				while (operator.top() != '(') {
					values.push(oper2calculate(operator.pop(), values.pop(), values.pop()));
				}
				operator.pop();
			}
			// Calculation out of parentheses
			else if(exp.charAt(i)=='+'|| exp.charAt(i)=='-'|| exp.charAt(i)=='*'|| exp.charAt(i)=='/')
			{
				while(!operator.isEmpty() && isPriority(exp.charAt(i), operator.top()))
					values.push(oper2calculate(operator.pop(),values.pop(),values.pop()));
				operator.push(exp.charAt(i));
			}
		}
		
		while (!operator.isEmpty()) 
            values.push(oper2calculate(operator.pop(), values.pop(), values.pop())); 
        return values.pop();
	}
	
	public static double oper2calculate(char operator, double number2, double number1) {
		switch (operator) {
		case '+':
			return number1 + number2;
		case '-':
			return number1 - number2;
		case '*':
			return number1 * number2;
		case '/':
			if (number2 == 0) throw new UnsupportedOperationException("Cannot divide by zero"); 
			return number1 / number2; 
		default:
			return 0;
		}
	}
	
	// Determine the order of priority of expression include +, -, *, \
	public static boolean isPriority(char op1,char op2) {
		if (op2 == '(' || op2 == ')') 
            return false; 
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
		return true;
	}
	
	public static void main (String[] args) {
		String exp = "(1+((2+3)*(8*5)))";
//		String exp = "(5-(8-4)*(2+3))+(8/2)";
		System.out.println("Expression " + exp);
		if (isValid(exp)) {
			System.out.println("Result: " + calculate(exp));
		} else {
			throw new UnsupportedOperationException("Expression is not valid");
		}
	}
}
