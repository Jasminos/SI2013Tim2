package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.text.DateFormat;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date; 
import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.Administrator;
import ba.unsa.etf.si.klase.Korisnik;
import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import ba.unsa.etf.si.klase.*;

import javax.swing.JComboBox;

public class TabelarniPrikazAmortizacije extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnIzai;
	private Session session;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					TabelarniPrikazAmortizacije frame = new TabelarniPrikazAmortizacije(sesija);
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
	private static boolean prestupnaGodina(int year) {
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR, year);
		  return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
		}
	
	private Calendar getZadnjiDanUMjesecu(Calendar datum)
	{
		Calendar rezultat = datum;
		int m = rezultat.MONTH;
		int d = 31;
		
		if(m == 4 || m == 6 || m == 9 || m == 11)
			 d=30;
			 
		if(m == 2 )
		{
			if(prestupnaGodina(datum.YEAR+1900))
				d=28;
			else
				d=29;
		}

		rezultat.set(rezultat.YEAR, rezultat.MONTH, d);
		
		return rezultat;
	}
	
	public TabelarniPrikazAmortizacije(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Tabelarni prikaz amortizacije");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 467);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(112, 14, 56, 14);
		contentPane.add(lblNaziv);
		
		JLabel lblNabavnaVrijednost = new JLabel("Nabavna vrijednost:");
		lblNabavnaVrijednost.setBounds(41, 39, 118, 14);
		contentPane.add(lblNabavnaVrijednost);
		
		JLabel lblStopaAmortizacije = new JLabel("Stopa amortizacije:");
		lblStopaAmortizacije.setBounds(50, 64, 118, 14);
		contentPane.add(lblStopaAmortizacije);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(178, 36, 150, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(178, 61, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 395, 302);
		contentPane.add(scrollPane);
		
		comboBox = new JComboBox();
		comboBox.setBounds(178, 11, 150, 20);
		contentPane.add(comboBox);
				
		Query query = session.createQuery("from StalnoSredstvo where uupotrebi=1");
		List<StalnoSredstvo> rezultat = (List<StalnoSredstvo>) query.list();
		for(int i=0; i<rezultat.size(); i++)
			comboBox.addItem(rezultat.get(i));
				
		comboBox.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
				
				long ajdi = ((StalnoSredstvo)comboBox.getSelectedItem()).getId();
				StalnoSredstvo ss = (StalnoSredstvo)session.get(StalnoSredstvo.class, ajdi);

				textField_1.setText(String.valueOf(ss.getNabavnaVrijednost()));
				textField_2.setText(String.valueOf(ss.getStopaAmortizacije()));
				
				DefaultTableModel model = new DefaultTableModel(new String[]{"Vrijednost", "Vrijednost %", "Datum amortizacije"}, 0);
				
				Date datum = ss.getDatumNabavke();
				int dan = datum.getDate();
				int mjesec = datum.getMonth()+1;
				int godina = datum.getYear()+1900;
				
				if(ss.isGodisnjaAmort())
				{
					dan=31;
					mjesec=12;
				}
				else
				{
					dan=31;
					if(mjesec == 2)
					{
						if(prestupnaGodina(godina))
							dan=29;
						else
							dan=28;
					}
					if(mjesec == 4 || mjesec == 6 || mjesec == 8 || mjesec == 10)
						dan = 30;
				}
				
				double postotak=100;
						
				for(double vrijednost=ss.getNabavnaVrijednost(); vrijednost>=0; vrijednost-=ss.getNabavnaVrijednost()*ss.getStopaAmortizacije())
				{
					String[] podaci = new String[4];
					podaci[0] = String.valueOf(vrijednost);
					podaci[1] = String.valueOf(postotak) + "%";
					
					String datumString = String.valueOf(dan + "." + mjesec + "." + godina);
					//String datumString = String.valueOf(datum.getDay()) + "." + String.valueOf(datum.getMonth()) + "." +String.valueOf(datum.getYear() + 1900);
					podaci[2] = String.valueOf(datumString);
					
					if(ss.isGodisnjaAmort())
					{
						godina++;
					}
					else
					{
						mjesec++;
						if(mjesec==13)
							{mjesec = 1;godina++;}
						
						dan=31;
						if(mjesec == 4 || mjesec == 6 || mjesec == 8 || mjesec == 10)
							dan = 30;
						if(mjesec == 2)
						{
							if(prestupnaGodina(godina))
								dan=29;
							else
								dan=28;
						}
					}
					postotak -= ss.getStopaAmortizacije()*100;
					
					model.addRow(podaci);
				}
				table.setModel(model);
				
		    }
		});
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Vrijednost", "Vrijednost %", "Datum amortizacije"
			}
		));
		scrollPane.setViewportView(table);
		
		btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(316, 405, 89, 23);
		contentPane.add(btnIzai);
		
		
	}
}
