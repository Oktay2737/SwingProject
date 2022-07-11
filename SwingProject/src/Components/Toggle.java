package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Toggle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Toggle frame = new Toggle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Toggle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton ToggleBtn = new JToggleButton("ToggleBtnOff");
		ToggleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ToggleBtn.isSelected()) {
					ToggleBtn.setBackground(Color.GREEN);
					ToggleBtn.setText("ToggleBtnOn");
					ToggleBtn.setBackground(Color.GREEN);
				}else {
					ToggleBtn.setText("ToggleBtnOff");
					ToggleBtn.setBackground(Color.RED);
				}
			}
		});
		ToggleBtn.setBounds(43, 11, 121, 23);
		contentPane.add(ToggleBtn);
	}
}
