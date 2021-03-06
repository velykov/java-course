package net.azib.java.students.t104607;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 104607 IASM
 */
public class CalculatorApplication {
	private JButton but_1;
	private JButton but_2;
	private JButton but_4;
	private JButton but_5;
	private JPanel mainPanel;
	private JLabel display;
	private JButton but_3;
	private JButton but_6;
	private JButton but_7;
	private JButton but_8;
	private JButton but_9;
	private JButton but_0;
	private JButton but_div;
	private JButton but_minus;
	private JButton but_mult;
	private JButton but_result;
	private JButton but_plus;
	private JButton but_off;
	private JPanel displayPanel;
	private JPanel buttonsPanel;
	private JButton but_clear;

	int previousNumber = 0;
	int currentNumber = 0;
	boolean clearDisplay = true;
	char operation = ' ';

	public CalculatorApplication() {
		but_off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		but_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(1);
			}
		});
		but_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(2);
			}
		});
		but_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(3);
			}
		});
		but_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(4);
			}
		});
		but_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(5);
			}
		});
		but_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(6);
			}
		});
		but_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(7);
			}
		});
		but_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(8);
			}
		});
		but_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(9);
			}
		});
		but_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				addNumber(0);
			}
		});
		but_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				display.setText(" 00000000");
				previousNumber = 0;
				operation = ' ';
			}
		});
		but_plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				doOperation('+');
			}
		});
		but_minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				doOperation('-');
			}
		});
		but_mult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				doOperation('*');
			}
		});
		but_div.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				doOperation('/');
			}
		});
		but_result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				doOperation(' ');
			}
		});
	}

	void doOperation(char op) {
		try {
			currentNumber = new Integer(display.getText().trim());
		} catch (NumberFormatException e) {
			return;
		}
		if (!clearDisplay) {
			switch (operation) {
				case '+':
					currentNumber = previousNumber + currentNumber;
					break;
				case '-':
					currentNumber = previousNumber - currentNumber;
					break;
				case '*':
					currentNumber = previousNumber * currentNumber;
					break;
				case '/':
					currentNumber = previousNumber / currentNumber;
					break;
			}
		}
		if ((currentNumber > 99999999) | (currentNumber < -99999999)) {
			display.setText("# error!");
		} else {
			clearDisplay = true;
			operation = op;
			display.setText(String.format("% 09d", currentNumber));
		}
		System.out.println(operation + " " + op + " " + previousNumber + " " + currentNumber);
	}

	void addNumber(int number) {
		try {
			currentNumber = new Integer(display.getText().trim());
		} catch (NumberFormatException e) {
			return;
		}
		if (clearDisplay) {
			previousNumber = currentNumber;
			currentNumber = 0;
			clearDisplay = false;
		}
		if (currentNumber < 10000000) {
			currentNumber = currentNumber * 10 + number;
			display.setText(String.format("% 09d", currentNumber));
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CalculatorApplication");
		frame.setContentPane(new CalculatorApplication().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		mainPanel.add(buttonsPanel, gbc);
		but_1 = new JButton();
		but_1.setFont(new Font("Casual", but_1.getFont().getStyle(), 72));
		but_1.setText("1");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_1, gbc);
		but_2 = new JButton();
		but_2.setFont(new Font("Casual", but_2.getFont().getStyle(), 72));
		but_2.setText("2");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_2, gbc);
		but_4 = new JButton();
		but_4.setFont(new Font("Casual", but_4.getFont().getStyle(), 72));
		but_4.setText("4");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_4, gbc);
		but_5 = new JButton();
		but_5.setFont(new Font("Casual", but_5.getFont().getStyle(), 72));
		but_5.setText("5");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_5, gbc);
		but_3 = new JButton();
		but_3.setFont(new Font("Casual", but_3.getFont().getStyle(), 72));
		but_3.setText("3");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_3, gbc);
		but_6 = new JButton();
		but_6.setFont(new Font("Casual", but_6.getFont().getStyle(), 72));
		but_6.setText("6");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_6, gbc);
		but_7 = new JButton();
		but_7.setFont(new Font("Casual", but_7.getFont().getStyle(), 72));
		but_7.setText("7");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_7, gbc);
		but_8 = new JButton();
		but_8.setFont(new Font("Casual", but_8.getFont().getStyle(), 72));
		but_8.setText("8");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_8, gbc);
		but_9 = new JButton();
		but_9.setFont(new Font("Casual", but_9.getFont().getStyle(), 72));
		but_9.setText("9");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_9, gbc);
		but_div = new JButton();
		but_div.setFont(new Font("Casual", but_div.getFont().getStyle(), 72));
		but_div.setText("/");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_div, gbc);
		but_0 = new JButton();
		but_0.setEnabled(true);
		but_0.setFont(new Font("Casual", but_0.getFont().getStyle(), 72));
		but_0.setHorizontalAlignment(0);
		but_0.setHorizontalTextPosition(0);
		but_0.setText("0");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		buttonsPanel.add(but_0, gbc);
		but_minus = new JButton();
		but_minus.setFont(new Font("Casual", but_minus.getFont().getStyle(), 72));
		but_minus.setText("-");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_minus, gbc);
		but_mult = new JButton();
		but_mult.setFont(new Font("Casual", but_mult.getFont().getStyle(), 72));
		but_mult.setText("*");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_mult, gbc);
		but_result = new JButton();
		but_result.setFont(new Font("Casual", but_result.getFont().getStyle(), 72));
		but_result.setText("=");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_result, gbc);
		but_plus = new JButton();
		but_plus.setFont(new Font("Casual", but_plus.getFont().getStyle(), 72));
		but_plus.setText("+");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_plus, gbc);
		but_off = new JButton();
		but_off.setBackground(new Color(-3342388));
		but_off.setFont(new Font("Casual", but_off.getFont().getStyle(), 36));
		but_off.setText("off");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		buttonsPanel.add(but_off, gbc);
		but_clear = new JButton();
		but_clear.setFont(new Font("Casual", but_clear.getFont().getStyle(), 72));
		but_clear.setText("C");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		buttonsPanel.add(but_clear, gbc);
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		displayPanel.setBackground(new Color(-13159));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		mainPanel.add(displayPanel, gbc);
		display = new JLabel();
		display.setBackground(new Color(-6684775));
		display.setFont(new Font("Casual", display.getFont().getStyle(), 72));
		display.setForeground(new Color(-16737895));
		display.setHorizontalAlignment(0);
		display.setHorizontalTextPosition(0);
		display.setText(" 00000000");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		displayPanel.add(display, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}
}
