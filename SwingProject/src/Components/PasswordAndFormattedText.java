package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PasswordAndFormattedText extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordAndFormattedText frame = new PasswordAndFormattedText();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public PasswordAndFormattedText() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 11, 73, 20);
		contentPane.add(passwordField);
		
		JButton GetPasswordBtn = new JButton("GetPasswordBtn");
		GetPasswordBtn.setBounds(107, 10, 123, 23);
		contentPane.add(GetPasswordBtn);
		
		JLabel PasswordLbl = new JLabel("PasswordLbl");
		PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLbl.setBounds(256, 11, 115, 20);
		contentPane.add(PasswordLbl);
		
		MaskFormatter mf = new MaskFormatter("(0###) AAA LL UU");//# mutlaka rakam A all herhangibir karakter, L lowercase, U uppercase
		
		JFormattedTextField formattedText = new JFormattedTextField(mf);
		formattedText.setBounds(10, 72, 123, 20);
		contentPane.add(formattedText);
		
		JButton getFormattedTextBtn = new JButton("getFormattedTextBtn");
		getFormattedTextBtn.setBounds(10, 104, 147, 23);
		contentPane.add(getFormattedTextBtn);
		
		JLabel formattedTextLbl = new JLabel("formattedTextLbl");
		formattedTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextLbl.setBounds(10, 138, 123, 28);
		contentPane.add(formattedTextLbl);
		
		GetPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passText = new String(passwordField.getPassword());
				PasswordLbl.setText(passText);  //passwordField.getPassword() başka birşey döndürüyor. bunun için string nesnesi oluşturuyoruz.
				
				System.out.println(passText);
			}
		});
		
		getFormattedTextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formattedTextLbl.setText(formattedText.getText());
			}
		});
	}
}
