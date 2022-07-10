package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DinamikTableOluşturma extends JFrame {

	private JPanel contentPane;
	private JTextField txtSatır;
	private JTextField txtSutun;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DinamikTableOluşturma frame = new DinamikTableOluşturma();
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
	public DinamikTableOluşturma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Satır");
		lblNewLabel.setBounds(10, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtSatır = new JTextField();
		txtSatır.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSatır.setText("1");
		txtSatır.setBounds(38, 22, 51, 20);
		contentPane.add(txtSatır);
		
		
		JLabel lblNewLabel_1 = new JLabel(" Sütun");
		lblNewLabel_1.setBounds(99, 28, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSutun = new JTextField();
		txtSutun.setText("1");
		txtSutun.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSutun.setToolTipText("");
		txtSutun.setBounds(138, 25, 51, 20);
		contentPane.add(txtSutun);
		
		
		
		
		table = new JTable();
		table.setBounds(127, 116, 171, 134);
		
		JButton btnCreate = new JButton(" Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row, column;
				row = Integer.parseInt(txtSatır.getText());
				column = Integer.parseInt(txtSutun.getText());
				modelim.setRowCount(row);
				modelim.setColumnCount(column);
				table.setModel(modelim);
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23, 66, 282, 103);
		contentPane.add(scrollPane);
		btnCreate.setBounds(216, 21, 89, 23);
		contentPane.add(btnCreate);
	}
}
