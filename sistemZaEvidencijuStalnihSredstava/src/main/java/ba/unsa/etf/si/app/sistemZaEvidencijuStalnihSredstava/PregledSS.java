package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PregledSS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Session session;
	private JLabel lblPretrai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					PregledSS frame = new PregledSS(sesija);
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
	private void RefreshList(String tekst){
		DefaultTableModel t = new DefaultTableModel(
				new String[]{
					"Naziv","Lokacija","Nabavna vrijednost","Datum nabavke","Tip","U upotrebi",
					"Datum stavljanja u upotrebu","Stopa","Prodano","Datum prodaje","Cijena prodaje",
					"Otpisano","datum otpisivanja"	
				}, 0
				);
		List<StalnoSredstvo> sredstva = SvaSredstva();
		for(int i=0; i<sredstva.size();i++){
			StalnoSredstvo s = sredstva.get(i);
			String[] podaci = new String[13];
			podaci[0] = s.getNaziv();
			podaci[1] = s.getLokacija();
			podaci[2] = String.valueOf(s.getNabavnaVrijednost());
			podaci[3] = datumString(s.getDatumNabavke());
			podaci[4] = s.getTip().toString();
			if(s.isuUpotrebi())
			{
				podaci[5] = "Da";
				podaci[6] = datumString(s.getDatumStavljanjaUUpotrebu());
				podaci[7] = String.valueOf(s.getStopaAmortizacije());
			}else{
				podaci[5] = "Ne";
				podaci[6] = "";
				podaci[7] = "";
			}
			if(s.isProdano()){
				podaci[8] = "Da";
				podaci[9] = datumString(s.getDatumProdaje());
				podaci[10] = String.valueOf(s.getProdajnaCijena());
			}
			else{
				podaci[8] = "Ne";
				podaci[9] = "";
				podaci[10] = "";
			}
			if(s.isOtpisano()){
				podaci[11] = "Da";
				podaci[12]= datumString(s.getDatumOtpisivanja());
			}
			else {
				podaci[11] = "Ne";
				podaci[12]= "";
			}
			if(podaci[0].contains(tekst)||
					podaci[1].contains(tekst))
				t.addRow(podaci);
		}
		table.setModel(t);
	}
	private List<StalnoSredstvo> SvaSredstva(){
		Query query = session.createQuery("from StalnoSredstvo");
		List<StalnoSredstvo> result = (List<StalnoSredstvo>)query.list();
		return result;
	}
	private String datumString (Date date){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(date);
	}
	public PregledSS(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Pregled stalnh sredstava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 862, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RefreshList(textField.getText());
			}
		});
		textField.setBounds(78, 11, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);;
		scrollPane.setBounds(10, 42, 834, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		RefreshList("");
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		JButton btnIzai = new JButton("Iza\u0111i");
		btnIzai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzai.setBounds(755, 240, 89, 23);
		contentPane.add(btnIzai);
		
		lblPretrai = new JLabel("Pretraži:");
		lblPretrai.setBounds(23, 14, 65, 14);
		contentPane.add(lblPretrai);
	}
}
