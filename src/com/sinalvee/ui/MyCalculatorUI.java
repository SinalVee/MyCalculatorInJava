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
	//����������ʾ����
	public static JTextField showArea;
	//�����������壬Ĭ�ϵ��Ǳ߽粼��
	private Container con;
	//��ť
	private JButton[] numsButton = new JButton[10];
	private JButton[] operatorButton = new JButton[6];
	private String operButtonText[] = {"+", "-", "*", "/", ".", "="};
	private JButton[] funButton = new JButton[4];
	private String funButtonText[] = {"sqrt", "+/-", "CE","C"};
	//�Ű�ť�����
	private JPanel buttonPanel;
	
	
	//�¼�������
	MyCalculatorListener lsr = new MyCalculatorListener();
	
	public MyCalculatorUI() {
		super("������");
		init();
	}
	
	//�����ʼ��
	private void init() {
		con = this.getContentPane();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(260, 320);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		buttonPanel = new JPanel();
		showArea = new JTextField("0");
		showArea.setFont(new Font("����", 1, 20));
		showArea.setForeground(Color.black);
		//�����Ҷ���
		showArea.setHorizontalAlignment(JTextField.RIGHT);
		//������ʾ����ĳ�ʼ��С
		showArea.setPreferredSize(new Dimension(260, 45));
		showArea.setEditable(false);
		buttonPanel.setLayout(new GridLayout(5, 4));
		//����ĸ����ܰ�ť
		//���"sqrt"
		funButton[0] = new JButton(funButtonText[0]);
		funButton[0].setFont(new Font("����", 1, 12));
		funButton[0].setForeground(Color.blue);
		//ע���¼�����
		funButton[0].addActionListener(lsr);
		buttonPanel.add(funButton[0]);
		//���"+/-", "CE", "C"
		for(int i = 1; i < 4; i++) {
			funButton[i] = new JButton(funButtonText[i]);
			funButton[i].setFont(new Font("����", 1, 15));
			funButton[i].setForeground(Color.blue);
			//ע���¼�����
			funButton[i].addActionListener(lsr);
			buttonPanel.add(funButton[i]);
		}
		con.add(buttonPanel, BorderLayout.CENTER);
		con.add(showArea, BorderLayout.NORTH);
		//�������7-9��ť
		for(int i = 7; i < 10; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("����", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//ע���¼�����
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//���"+"��ť
		operatorButton[0] = new JButton(operButtonText[0]);
		operatorButton[0].setFont(new Font("����", 1, 18));
		operatorButton[0].setForeground(Color.blue);
		//ע���¼�����
		operatorButton[0].addActionListener(lsr);
		buttonPanel.add(operatorButton[0]);
		//�������4-6��ť
		for(int i = 4; i < 7; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("����", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//ע���¼�����
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//���"-"��ť
		operatorButton[1] = new JButton(operButtonText[1]);
		operatorButton[1].setFont(new Font("����", 1, 18));
		operatorButton[1].setForeground(Color.blue);
		//ע���¼�����
		operatorButton[1].addActionListener(lsr);
		buttonPanel.add(operatorButton[1]);
		//�������1-3��ť
		for(int i = 1; i < 4; i++) {
			numsButton[i] = new JButton(i + "");
			numsButton[i].setFont(new Font("����", 1, 18));
			numsButton[i].setForeground(Color.blue);
			//ע���¼�����
			numsButton[i].addActionListener(lsr);
			buttonPanel.add(numsButton[i]);
		}
		//���"*"��ť
		operatorButton[2] = new JButton(operButtonText[2]);
		operatorButton[2].setFont(new Font("����", 1, 18));
		operatorButton[2].setForeground(Color.blue);
		//ע���¼�����
		operatorButton[2].addActionListener(lsr);
		buttonPanel.add(operatorButton[2]);
		//�������0
		numsButton[0] = new JButton(0 + "");
		numsButton[0].setFont(new Font("����", 1, 18));
		numsButton[0].setForeground(Color.blue);
		//ע���¼�����
		numsButton[0].addActionListener(lsr);
		buttonPanel.add(numsButton[0]);
		//���".", "="��ť
		for(int i = 4; i < 6; i++) {
			operatorButton[i] = new JButton(operButtonText[i]);
			operatorButton[i].setFont(new Font("����", 1, 18));
			operatorButton[i].setForeground(Color.blue);
			//ע���¼�����
			operatorButton[i].addActionListener(lsr);
			buttonPanel.add(operatorButton[i]);
		}
		//���"/"��ť
		operatorButton[3] = new JButton(operButtonText[3]);
		operatorButton[3].setFont(new Font("����", 1, 18));
		operatorButton[3].setForeground(Color.blue);
		//ע���¼�����
		operatorButton[3].addActionListener(lsr);
		buttonPanel.add(operatorButton[3]);
	}
}
