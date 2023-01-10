package KataCalc;

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		System.out.print(Main.calc(null));
	}
}

class Main {
	public static String calc(String input){
		int value1;
		int value2;
		
		System.out.println("Enter your expression : ");
		Scanner task = new Scanner(System.in);
		String str = task.nextLine();
		task.close();
		String[] operands = str.split("[+\\-*/]");
		if (operands.length !=2) {
			return "throws Exception";
		}
		String str1 = operands[0].trim();	
		String operator = getOperation(str);
		String str2 = operands[1].trim();
		
			if (IsPresent.isPresent(str1) && (IsPresent.isPresent(str2))) {
				Rome rome1 = Rome.valueOf(str1);
				Rome rome2 = Rome.valueOf(str2);
				value1 = rome1.getNum();
				value2 = rome2.getNum();
				if((value1 > 0 && value1 <= 10) && (value2 > 0 && value2 <= 10)) {
					if (Integer.parseInt(getSolution(value1,value2,operator)) > 0) {
						System.out.println(IntegerConverter.intToRoman(Integer.parseInt(getSolution(value1,value2,operator))));
					}else {
						return "throws Exception";
					}
				
				} else {
					return "your number should not be 0 or more than 10";
				}
			} else if (IsNumeric.isNumeric(str1) && (IsNumeric.isNumeric(str2))){
				value1 = Integer.parseInt(str1);
				value2 = Integer.parseInt(str2);
				if((value1 > 0 && value1 <= 10) && (value2 > 0 && value2 <= 10)) {
					System.out.println(getSolution(value1,value2,operator));
				} else {
					return "your number should not be 0 or more than 10";
				}
			}else {
				try {
					throw new NumberFormatException();
				}	catch(NumberFormatException e){
					System.out.println("throws Exception");		
				}
			}
		return "";
		
		
	}
	static String getSolution(int value1, int value2, String operator) {
		int solution;	
		switch(operator) {
				case "+":
					solution = value1 + value2;
					return "" + solution;
				case "-":
					solution = value1 - value2;
					return "" + solution;
				case "*":
					solution = value1 * value2;
					return "" + solution;
				case "/":
					solution = value1 / value2;
					return "" + solution;
				default:
					return null;
		}
	}
	static String getOperation(String str) {
		if (str.contains("+")) return "+";
		else if (str.contains("-")) return "-";
		else if (str.contains("*")) return "*";
		else if (str.contains("/")) return "/";
		else return null;
	}
}

class IsPresent {
	public static boolean isPresent(String str) {
		try {
		      Enum.valueOf(Rome.class, str);
		      return true;
		    } catch (IllegalArgumentException e) {
		      return false;
		    }
	}
}

class IsNumeric{
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}	catch(NumberFormatException e){
			return false;		
		}
	}
}