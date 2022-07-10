package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DynamicTable extends JFrame {

	private JPanel contentPane;
	private JTextField txtRow;
	private JTextField txtColumn;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	private JSpinner spnrRow;
	private JSpinner spnrCol;
	int row=1, col=1;
	private JTextField txtSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicTable frame = new DynamicTable();
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
	public DynamicTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRow = new JTextField();
		txtRow.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRow.setText("1");
		txtRow.setBounds(25, 23, 86, 20);
		contentPane.add(txtRow);
		txtRow.setColumns(10);
		
		txtColumn = new JTextField();
		txtColumn.setText("1");
		txtColumn.setHorizontalAlignment(SwingConstants.RIGHT);
		txtColumn.setBounds(150, 23, 86, 20);
		contentPane.add(txtColumn);
		txtColumn.setColumns(10);
		
		JButton btnCreate = new JButton("  Create");		
		btnCreate.setBounds(285, 22, 89, 23);
		contentPane.add(btnCreate);
		
		table = new JTable();		
		table.setBounds(127, 116, 171, 134);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 94, 349, 105);
		contentPane.add(scrollPane);
		
		spnrRow = new JSpinner();
		spnrRow.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spnrRow.setBounds(25, 63, 86, 20);
		contentPane.add(spnrRow);
		
		spnrCol = new JSpinner();
		spnrCol.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spnrCol.setBounds(150, 63, 86, 20);
		contentPane.add(spnrCol);
		
		txtSelected = new JTextField();
		txtSelected.setBounds(288, 210, 86, 20);
		contentPane.add(txtSelected);
		txtSelected.setColumns(10);
		
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				row = Integer.parseInt(txtRow.getText());
				col = Integer.parseInt(txtColumn.getText());
				modelim.setRowCount(row);
				modelim.setColumnCount(col);
				
				table.setModel(modelim);
			}
		});
		
		spnrRow.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				row= Integer.parseInt(spnrRow.getValue().toString());
				modelim.setRowCount(row);
				modelim.setColumnCount(col);
				table.setModel(modelim);
			}
		});
		
		spnrCol.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				col= Integer.parseInt(spnrCol.getValue().toString());
				modelim.setRowCount(row);
				modelim.setColumnCount(col);
				table.setModel(modelim);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String val="****";
				try {
					val= modelim.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
					System.out.println(val);
					txtSelected.setText(val);
				} catch (Exception e2) {
					txtSelected.setText(val);
				}
				
			}
		});
		
	}

}
