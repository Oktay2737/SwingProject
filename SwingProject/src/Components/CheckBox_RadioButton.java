package Components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class CheckBox_RadioButton extends JFrame {

	private JPanel contentPane;
	String selectedLessons="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBox_RadioButton frame = new CheckBox_RadioButton();
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
	public CheckBox_RadioButton() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox Kimya = new JCheckBox("Kimya");
		Kimya.setBounds(18, 26, 97, 23);
		contentPane.add(Kimya);		
		
		JCheckBox Matematik = new JCheckBox("Matematik");
		Matematik.setBounds(18, 68, 97, 23);
		contentPane.add(Matematik);
		
		JButton selectButton_Ders = new JButton("ClickToSelect");
		
		selectButton_Ders.setBounds(18, 115, 126, 23);
		contentPane.add(selectButton_Ders);
		
		JLabel selectedLabel = new JLabel("Selected Lessons");
		selectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectedLabel.setBounds(28, 149, 126, 14);
		contentPane.add(selectedLabel);
		
		JRadioButton rbErkek = new JRadioButton("Erkek");
		rbErkek.setBounds(293, 26, 63, 23);
		contentPane.add(rbErkek);
		
		JRadioButton rbBayan = new JRadioButton("Bayan");
		rbBayan.setBounds(293, 52, 69, 23);
		contentPane.add(rbBayan);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbBayan);
		bg.add(rbErkek);
		
		JButton selectButton_Cinsiyet = new JButton("ClickToSelect");
		selectButton_Cinsiyet.setBounds(298, 115, 126, 23);
		contentPane.add(selectButton_Cinsiyet);
		
		JLabel selectedSex = new JLabel("Selected Sex");
		selectedSex.setBounds(308, 149, 117, 14);
		contentPane.add(selectedSex);
		
		selectButton_Ders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedLessons="";
				if(Kimya.isSelected()) {
					selectedLessons+=Kimya.getText();
				}
				if(Matematik.isSelected()) {
					selectedLessons+=" "+Matematik.getText();
				}
				selectedLabel.setText(selectedLessons);
			}
		});
		selectButton_Cinsiyet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbErkek.isSelected()) {selectedSex.setText(rbErkek.getText());}else
					if(rbBayan.isSelected()) {
						selectedSex.setText(rbBayan.getText());
					}
			}
		});
		
	}
}
