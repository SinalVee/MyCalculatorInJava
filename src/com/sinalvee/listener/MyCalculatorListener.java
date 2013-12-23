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
	private double oper_1 = 0;//左操作数
	private double oper_2 = 0;//右操作数
	private String opera = "";//运算符
	private boolean isOperator = false;//防止连续按下运算符
	private boolean isSeriesOperation = false;//判断是否连续运算
	private boolean isEqules = false;//判断是否按下等号
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//得到按钮中的字符串
		String command = e.getActionCommand();
		//0-9是在输入数据
		if (isNum(command)) {
			//限制输入的数据长度不能大于18
			if (showNum.length() >= 18) {
				return;
			}
			isOperator = true;
			showNum += command;
			//如果输入的数据的最高位是0，但是不包括小数点，则去除最高位的0
			if (showNum.charAt(0) == '0' && !showNum.contains(".")) {
				showNum = showNum.substring(1, showNum.length());
				MyCalculatorUI.showArea.setText(showNum);
			}
			//如果输入的数据最高位是"-"，第二位是0，但是不包括小数点，则去掉第二位的0
			else if (showNum.charAt(0) == '-' && showNum.charAt(1) == '0' && !showNum.contains(".")) {
				showNum = showNum.substring(2,showNum.length());
				showNum = "-" + showNum;
				MyCalculatorUI.showArea.setText(showNum);
			}
			//其他情况正常输入
			else {
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
		//"CE" 清屏，并将所有的变量恢复到初始值
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
		//"C" 删除最后一位
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
		//"+", "-", "*", "/" 进行四则运算
		else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
			if (isOperator) {
				//非连续运算
				if (!isSeriesOperation && answer.equals("")) {
					opera = command;
					oper_1 = parseToDouble(showNum);
					showNum = "0";
					isSeriesOperation = true;
				}
				//连续运算
				else {
					//如果之前按下等号，则等待用户输入下一个运算符
					if (isEqules) {
						opera = command;
						showNum = "0";
						isEqules = false;
					}
					//如果没按下等号，或者按下等号后接收了用户输入的下一个运算符
					else {
						//opera = command;
						//如果answer为空，说明还没运算过，由用户输入oper_2
						if (answer.equals("")) {
							oper_2 = parseToDouble(showNum);
						}
						//否则oper1就是上次运算的结果answer，由用户输入oper_2
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
							//把计算结果赋给oper_1，以实现连续计算
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
		//"sqrt" 显示上次计算结果
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
		//"." 小数点
		else if (command.equals(".")) {
			if (showNum.contains(".")) {
				return;
			}
			else {
				showNum = showNum + command;
				MyCalculatorUI.showArea.setText(showNum);
			}
		}
		//"=" 等于
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
		//"+/-" 正负号切换
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
	
	//用正则表达式判断输入是否为数字
	private boolean isNum(String command) {
		//匹配0-9的模式
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(command);
		
		return m.matches();
	}
	
	private double parseToDouble(String num) {
		return Double.valueOf(num).doubleValue();
	}
}
