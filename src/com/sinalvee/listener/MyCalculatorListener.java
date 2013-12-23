package com.sinalvee.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sinalvee.operation.MyCalculatorOperation;
import com.sinalvee.ui.MyCalculatorUI;

public class MyCalculatorListener implements ActionListener{
	
	private String showNum = "0";
	private String answer = "";
	private double oper_1 = 0;//�������
	private double oper_2 = 0;//�Ҳ�����
	private String opera = "";//�����
	private boolean isOperator = false;//��ֹ�������������
	private boolean isSeriesOperation = false;//�ж��Ƿ���������
	private boolean isEqules = false;//�ж��Ƿ��µȺ�
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�õ���ť�е��ַ���
		String command = e.getActionCommand();
		//0-9������������
		if (isNum(command)) {
			//������������ݳ��Ȳ��ܴ���18
			if (showNum.length() >= 18) {
				return;
			}
			isOperator = true;
			showNum += command;
			//�����������ݵ����λ��0�����ǲ�����С���㣬��ȥ�����λ��0
			if (showNum.charAt(0) == '0' && !showNum.contains(".")) {
				showNum = showNum.substring(1, showNum.length());
				MyCalculatorUI.showArea.setText(showNum);
			}
			//���������������λ��"-"���ڶ�λ��0�����ǲ�����С���㣬��ȥ���ڶ�λ��0
			else if (showNum.charAt(0) == '-' && showNum.charAt(1) == '0' && !showNum.contains(".")) {
				showNum = showNum.substring(2,showNum.length());
				showNum = "-" + showNum;
				MyCalculatorUI.showArea.setText(showNum);
			}
			//���������������
			else {
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
		//"CE" �������������еı����ָ�����ʼֵ
		else if (command.equals("CE")) {
			showNum = "0";
			answer = "";
			oper_1 = 0;
			oper_2 = 0;
			opera = "";
			isOperator = false;
			isSeriesOperation = false;
			isEqules = false;
			MyCalculatorUI.showArea.setText(showNum);
		}
		//"C" ɾ�����һλ
		else if (command.equals("C")) {
			if (showNum.length() > 1) {
				showNum = showNum.substring(0, showNum.length() - 1);
				MyCalculatorUI.showArea.setText(showNum);
			}
			else if (showNum.length() == 1) {
				showNum = "0";
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
		//"+", "-", "*", "/" ������������
		else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
			if (isOperator) {
				//����������
				if (!isSeriesOperation && answer.equals("")) {
					opera = command;
					oper_1 = parseToDouble(showNum);
					showNum = "0";
					isSeriesOperation = true;
				}
				//��������
				else {
					//���֮ǰ���µȺţ���ȴ��û�������һ�������
					if (isEqules) {
						opera = command;
						showNum = "0";
						isEqules = false;
					}
					//���û���µȺţ����߰��µȺź�������û��������һ�������
					else {
						//opera = command;
						//���answerΪ�գ�˵����û����������û�����oper_2
						if (answer.equals("")) {
							oper_2 = parseToDouble(showNum);
						}
						//����oper1�����ϴ�����Ľ��answer�����û�����oper_2
						else {
							if (!answer.equals("error")) {
								oper_1 = parseToDouble(answer);
							}
							else {
								MyCalculatorUI.showArea.setText("error");
								answer = "0";
								oper_1 = parseToDouble(answer);
							}
							oper_2 = parseToDouble(showNum);
						}
						answer = MyCalculatorOperation.opera(oper_1, oper_2, opera);
						if (!answer.equals("error")) {
							MyCalculatorUI.showArea.setText(answer);
							//�Ѽ���������oper_1����ʵ����������
							oper_1 = parseToDouble(answer);
							showNum = "0";
						}
						else {
							MyCalculatorUI.showArea.setText("error");
							answer = "0";
							oper_1 = parseToDouble(answer);
						}
						opera=command;
					}
				}
				isOperator = false;
			}
		}
		//"sqrt" ��ʾ�ϴμ�����
		else if (command.equals("sqrt")) {
			if (!showNum.equals("0")) {
				answer = Math.sqrt(parseToDouble(showNum)) + "";
				showNum = answer + "";
				oper_1 = parseToDouble(answer);
				MyCalculatorUI.showArea.setText(answer);
			}
			else {
				answer = Math.sqrt(parseToDouble(answer)) + "";
				oper_1 = parseToDouble(answer);
				MyCalculatorUI.showArea.setText(answer);
			}
		}
		//"." С����
		else if (command.equals(".")) {
			if (showNum.contains(".")) {
				return;
			}
			else {
				showNum = showNum + command;
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
		//"=" ����
		else if (command.equals("=")) {
			oper_2 = parseToDouble(showNum);
			showNum = "0";
			answer = MyCalculatorOperation.opera(oper_1, oper_2, opera);
			MyCalculatorUI.showArea.setText(answer);
			if (!answer.equals("error")) {
				oper_1 = parseToDouble(answer);
			}
			else {
				MyCalculatorUI.showArea.setText("error");
				answer = "0";
			}
			oper_1 = parseToDouble(answer);
			isEqules = true;
		}
		//"+/-" �������л�
		else if (command.equals("+/-")) {
			if (showNum.contains("-")) {
				showNum = showNum.substring(1, showNum.length());
				MyCalculatorUI.showArea.setText(showNum);
			}
			else {
				showNum = "-" + showNum;
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
	}
	
	//��������ʽ�ж������Ƿ�Ϊ����
	private boolean isNum(String command) {
		//ƥ��0-9��ģʽ
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(command);
		
		return m.matches();
	}
	
	private double parseToDouble(String num) {
		return Double.valueOf(num).doubleValue();
	}
}
