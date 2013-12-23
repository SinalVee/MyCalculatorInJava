package com.sinalvee.operation;

public class MyCalculatorOperation {
	//直接返回计算结果的字符串表示，可以直接显示在显示区域
	public static String opera(double oper_1, double oper_2, String operator) {
		if (operator.equals("+")) {
			return oper_1 + oper_2 + "";
		}
		else if (operator.equals("-")) {
			return oper_1 - oper_2 + "";
		}
		else if (operator.equals("*")) {
			return oper_1 * oper_2 + "";
		}
		else if (operator.equals("/")) {
			if (oper_2 != 0) {
				return oper_1 / oper_2 + "";
			}
			else {
				return "error";
			}
		}
		else if (operator.equals("")) {
			return oper_2 + "";
		}
		return "error";
	}
}
