package com.sinalvee.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sinalvee.listener.MyCalculatorListener;

public class MyCalculatorUI extends JFrame {
	//计算器的显示区域
	public static JTextField showArea;
	//窗体的内容面板，默认的是边界布局
	private Container con;
	//按钮
	private JButton[] numsButton = new JButton[10];
	private JButton[] operatorButton = new JButton[6];
	private String operButtonText[] = {"+", "-", "*", "/", ".", "="};
	private JButton[] funButton = new JButton[4];
	private String funButtonText[] = {"sqrt", "+/-", "CE","C"};
	//放按钮的面板
	private JPanel buttonPanel;
	
	
	//事件监听器
	MyCalculatorListener lsr = new MyCalculatorListener();
	
	public MyCalculatorUI() {
		super("计算器");
		init();
	}
	
	//界面初始化
	private void init() {
		con = this.getContentPane();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(260, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		buttonPanel = new JPanel();
		showArea = new JTextField("0");
		showArea.setFont(new Font("宋体", 1, 20));
		showArea.setForeground(Color.black);
		//设置右对齐
		showArea.setHorizontalAlignment(JTextField.RIGHT);
		//设置显示区域的初始大小
		showArea.setPreferredSize(new Dimension(260, 45));
		showArea.setEditable(false);
		buttonPanel.setLayout(new GridLayout(5, 4));
		//添加四个功能按钮
		//添加"sqrt"
		funButton[0] = new JButton(funButtonText[0]);
		funButton[0].setFont(new Font("宋体", 1, 12));
		funButton[0].setForeground(Color.blue);
		//注册事件监听
		funButton[0].addActionListener(lsr);
		buttonPanel.add(funButton[0]);
		//添加"+/-", "CE", "C"
		for(int i = 1; i < 4; i++) {
			funButton[i] = new JButton(funButtonText[i]);
			funButton[i].setFont(new Font("宋体", 1, 15));
			funButton[i].setForeground(Color.blue);
			//注册事件监听
			funButton[i].addActionListener(lsr);
			buttonPanel.add(funButton[i]);
		}
		con.add(buttonPanel, BorderLayout.CENTER);
		con.add(showArea, BorderLayout.NORTH);
		//添加数字7-9按钮
		for(int i = 7; i < 10; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("宋体", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//注册事件监听
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//添加"+"按钮
		operatorButton[0] = new JButton(operButtonText[0]);
		operatorButton[0].setFont(new Font("宋体", 1, 18));
		operatorButton[0].setForeground(Color.blue);
		//注册事件监听
		operatorButton[0].addActionListener(lsr);
		buttonPanel.add(operatorButton[0]);
		//添加数字4-6按钮
		for(int i = 4; i < 7; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("宋体", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//注册事件监听
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//添加"-"按钮
		operatorButton[1] = new JButton(operButtonText[1]);
		operatorButton[1].setFont(new Font("宋体", 1, 18));
		operatorButton[1].setForeground(Color.blue);
		//注册事件监听
		operatorButton[1].addActionListener(lsr);
		buttonPanel.add(operatorButton[1]);
		//添加数字1-3按钮
		for(int i = 1; i < 4; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("宋体", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//注册事件监听
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//添加"*"按钮
		operatorButton[2] = new JButton(operButtonText[2]);
		operatorButton[2].setFont(new Font("宋体", 1, 18));
		operatorButton[2].setForeground(Color.blue);
		//注册事件监听
		operatorButton[2].addActionListener(lsr);
		buttonPanel.add(operatorButton[2]);
		//添加数字0
		numsButton[0] = new JButton(0 + "");
		numsButton[0].setFont(new Font("宋体", 1, 18));
		numsButton[0].setForeground(Color.blue);
		//注册事件监听
		numsButton[0].addActionListener(lsr);
		buttonPanel.add(numsButton[0]);
		//添加".", "="按钮
		for(int i = 4; i < 6; i++) {
			operatorButton[i] = new JButton(operButtonText[i]);
			operatorButton[i].setFont(new Font("宋体", 1, 18));
			operatorButton[i].setForeground(Color.blue);
			//注册事件监听
			operatorButton[i].addActionListener(lsr);
			buttonPanel.add(operatorButton[i]);
		}
		//添加"/"按钮
		operatorButton[3] = new JButton(operButtonText[3]);
		operatorButton[3].setFont(new Font("宋体", 1, 18));
		operatorButton[3].setForeground(Color.blue);
		//注册事件监听
		operatorButton[3].addActionListener(lsr);
		buttonPanel.add(operatorButton[3]);
	}
}
