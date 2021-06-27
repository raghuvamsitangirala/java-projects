package javaProgramming;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TicTacToeDesign extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer1;
	private JTextField txtPlayer2;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	TicTacToeCondition ticTacToeCondition = new TicTacToeCondition();
	private JLabel lblWinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeDesign frame = new TicTacToeDesign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setButtonEnable(boolean isEnable)
	{
		btn1.setEnabled(isEnable);
		btn2.setEnabled(isEnable);
		btn3.setEnabled(isEnable);
		btn4.setEnabled(isEnable);
		btn5.setEnabled(isEnable);
		btn6.setEnabled(isEnable);
		btn7.setEnabled(isEnable);
		btn8.setEnabled(isEnable);
		btn9.setEnabled(isEnable);
	}
	
	public void resetButton(){
		ticTacToeCondition.resetToggleValues();
		ticTacToeCondition.resetGameValue();
		
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
		lblWinner.setText("");
		
		setButtonEnable(true);
	}
	
	public void checkWinner(TicTacToeCondition.arrayValues value)
	{
		int result = ticTacToeCondition.checkCondition(value);
		switch(result)
		{
			case 0:
				lblWinner.setText("Tie");
				setButtonEnable(false);
				break;
			case 1:
				lblWinner.setText(txtPlayer1.getText() + " Wins");
				setButtonEnable(false);
				break;
			case 2:
				lblWinner.setText(txtPlayer2.getText() + " Wins");
				setButtonEnable(false);
				break;
			default:
				break;
		}
	}

	/**
	 * Create the frame.
	 */
	public TicTacToeDesign() {
		setTitle("TicTacToe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPlayer1 = new JTextField();
		txtPlayer1.setText("Player1");
		txtPlayer1.setColumns(10);
		
		txtPlayer2 = new JTextField();
		txtPlayer2.setText("Player2");
		txtPlayer2.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblO = new JLabel("O");
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWinner = new JLabel("");
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPlayer2, 0, 0, Short.MAX_VALUE)
								.addComponent(txtPlayer1, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblO, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblWinner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 167, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPlayer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPlayer2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblO, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWinner)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(0, 0, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(1, 0, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(2, 0, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(0, 1, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(1, 1, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(2, 1, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(2, 2, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(1, 2, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setText(ticTacToeCondition.getToggleValues().toString());
				ticTacToeCondition.setGameValue(0, 2, ticTacToeCondition.getToggleValues());
				checkWinner(ticTacToeCondition.getToggleValues());
				ticTacToeCondition.setToggleValue();
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
