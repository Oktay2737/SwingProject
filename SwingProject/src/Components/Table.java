package Components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnGetTableValue;
	private JLabel lblTableValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(123), "ikinci sutun", Boolean.FALSE},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Header1", "Header 2", "Header 3"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(127, 116, 171, 134);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 228, 91);
		contentPane.add(scrollPane);
		
		btnGetTableValue = new JButton(" Get Value");
		
		btnGetTableValue.setBounds(10, 111, 89, 23);
		contentPane.add(btnGetTableValue);
		
		lblTableValue = new JLabel("Value");		
		lblTableValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableValue.setBounds(10, 161, 89, 14);
		contentPane.add(lblTableValue);
		
		btnGetTableValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = table.getModel().getValueAt(0, 0).toString();
				lblTableValue.setText(s);
			}
		});
		lblTableValue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
				System.out.println(s);
				lblTableValue.setText(s);
			}
		});
	}
}
