package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pregled extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pregled frame = new pregled();
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
	public pregled() {
		setTitle("Pregled korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 511, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Ime", "Prezime", "JMBG", "Telefon", "Username", "Password", "Datum", "Vrijeme"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		Label label = new Label("Sortiraj:");
		label.setBounds(24, 62, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Pretra\u017Ei:");
		label_1.setBounds(24, 26, 62, 22);
		contentPane.add(label_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(81, 64, 154, 20);
		contentPane.add(choice_1);
		
		Button button = new Button("Iza\u0111i");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(432, 310, 70, 22);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(85, 28, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
