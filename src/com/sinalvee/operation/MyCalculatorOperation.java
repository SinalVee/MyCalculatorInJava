package com.sinalvee.operation;

public class MyCalculatorOperation {
	//ֱ�ӷ��ؼ��������ַ�����ʾ������ֱ����ʾ����ʾ����
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
