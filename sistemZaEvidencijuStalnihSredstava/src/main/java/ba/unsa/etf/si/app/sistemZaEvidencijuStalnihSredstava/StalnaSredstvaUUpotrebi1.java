package ba.unsa.etf.si.app.sistemZaEvidencijuStalnihSredstava;


import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import ba.unsa.etf.si.klase.StalnoSredstvo;
import ba.unsa.etf.si.util.HibernateUtil;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.TitledBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.hibernate.Query;
import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class StalnaSredstvaUUpotrebi1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Session session;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser_2;
	private JDateChooser dateChooser_3;
	private JDateChooser dateChooser_4;
	private JDateChooser dateChooser_5;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JComboBox comboBox;

	private String getPath() {
		JFileChooser chooser;
		String path = "";
		
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Izbor putanje");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    chooser.setAcceptAllFileFilterUsed(false);
	        
	    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 	      
	    	path = chooser.getSelectedFile().toString();
	      }
    
		return path;
	
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();
					StalnaSredstvaUUpotrebi1 frame = new StalnaSredstvaUUpotrebi1(sesija);
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
	public StalnaSredstvaUUpotrebi1(Session sesija) {
		setResizable(false);
		session = sesija;
		setTitle("Stalna sredstva stavljena u upotrebu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Uredu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int x = rand.nextInt(1000);
				
				final String FILE = getPath() + File.separator + "SredstvaUUpotrebi_" + x +".pdf"; 
			    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
			    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			    
			    try{
			    	Document document = new Document(); 
			        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
			        document.open();
			        Image To_be_Added = Image.getInstance("images.jpg");
			        To_be_Added.setAlignment(Image.RIGHT | Image.TEXTWRAP);
		            document.add(To_be_Added);

					// addMetaData(document);
					document.addTitle("Izvjestaj o stalnim sredstvima u upotrebi");
					Paragraph preface = new Paragraph(); 
			        preface.add(new Paragraph(" ")); 
			        Paragraph nesto1=new Paragraph("Trgovina d.o.o");
			        nesto1.setAlignment(Element.ALIGN_LEFT);
			        nesto1.setFont(smallBold);
			        document.add(nesto1);
			      
			       
			        Paragraph nesto2=new Paragraph("Sarajevo");
			        nesto2.setAlignment(Element.ALIGN_LEFT);
			        nesto2.setFont(smallBold);
			        document.add(nesto2);
			       
			        Paragraph nesto3=new Paragraph("Tel/fax: 033/123-456");
			        nesto3.setAlignment(Element.ALIGN_LEFT);
			        nesto3.setFont(smallBold);
			        document.add(nesto3);
			        

		            document.add( Chunk.NEWLINE );
		            document.add( Chunk.NEWLINE );
		            document.add( Chunk.NEWLINE );
			       
			        Date d = new Date();
			        preface.add(new Paragraph(" "));
			        String s = Integer.toString(d.getDay())+"." + Integer.toString(d.getMonth())+".20"+Integer.toString(d.getYear()-100) + ".";
			        preface.add(new Paragraph("Datum: " + s, smallBold));
			        preface.add(new Paragraph(" "));
			        preface.add(new Paragraph(" "));
			        document.add(preface);
			        Paragraph nesto=new Paragraph("Izvještaj o stalnim sredstvima u upotrebi");
			        nesto.setAlignment(Element.ALIGN_CENTER);
			        document.add(nesto);
					preface = new Paragraph();
					Query query = session.createQuery("from StalnoSredstvo where UUPOTREBI=true");
					List<StalnoSredstvo> result = (List<StalnoSredstvo>) query
							.list();
					List<StalnoSredstvo> pravi = new ArrayList<StalnoSredstvo>();
					for (StalnoSredstvo k : result) {
						pravi.add(k);						
						preface.add(new Paragraph(" "));
					    preface.add(new Paragraph(" "));
						preface.add(new Paragraph("Broj stalnih sredstava u uptrebi:  " + Integer.toString(pravi.size()), smallBold));
						preface.add(new Paragraph(" "));
						preface.add(new Paragraph(" "));
				        document.add(preface); 
				        PdfPTable table = new PdfPTable(7); 
					      
				        PdfPCell c1 = new PdfPCell(new Phrase("Naziv")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1); 
				      				      
				        c1 = new PdfPCell(new Phrase("Tip")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1); 
				          
				        c1 = new PdfPCell(new Phrase("Trenutna vrijednost")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1); 
				        
				        c1 = new PdfPCell(new Phrase("Stopa")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1);
				        
				        c1 = new PdfPCell(new Phrase("Mjesecno ili godisnje")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1);
				        
				        c1 = new PdfPCell(new Phrase("Datum stavljanja u upotrebu")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1);
				        
				        c1 = new PdfPCell(new Phrase("Datum otpisivanja")); 
				        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
				        table.addCell(c1);
				        
				        table.setHeaderRows(1); 
				        for(int i=0; i<pravi.size(); i++)
				        {
				        	table.addCell(pravi.get(i).getNaziv());
				        	table.addCell(pravi.get(i).getTip().toString());
				        	table.addCell(Double.toString(pravi.get(i).getTrenutnaVrijednost())+" KM");  
				        	table.addCell(Double.toString(pravi.get(i).getStopaAmortizacije())+" KM");  
				        	if(pravi.get(i).isGodisnjaAmort())
				        		table.addCell("G");
				        	else table.addCell("M");
				        	table.addCell(Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getDay())+"." + Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getMonth())+".20"+Integer.toString(pravi.get(i).getDatumStavljanjaUUpotrebu().getYear()-100)+".");
				        	table.addCell("");
				        }
				        
				        document.add(table); 

				        document.close(); 
				        if (Desktop.isDesktopSupported()) { 
				              try { 
				                  File myFile = new File(FILE); 
				                  Desktop.getDesktop().open(myFile); 
				              } catch (IOException ex) { 
				                  // no application registered for PDFs 
				              } 
				       } 
					}
			    }catch(Exception ex){
			    	ex.printStackTrace(); 
			    }
			}
		});
		button.setBounds(397, 440, 89, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Datum nabavke");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 318, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGornjaGranica = new JLabel("Gornja granica: ");
		lblGornjaGranica.setBounds(27, 34, 97, 14);
		panel.add(lblGornjaGranica);
		
		JLabel lblDonjaGranica = new JLabel("Donja granica: ");
		lblDonjaGranica.setBounds(27, 65, 97, 14);
		panel.add(lblDonjaGranica);
		
		JDateChooser dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(134, 28, 153, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser(new Date());
		dateChooser_1.setBounds(134, 59, 153, 20);
		panel.add(dateChooser_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Vrijednost stalnog sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(361, 22, 257, 244);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 36, 246, 101);
		panel_3.add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Na datum nabavke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(148, 31, 60, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(148, 56, 60, 20);
		panel_1.add(spinner_1);
		
		JLabel label = new JLabel("Gornja granica: ");
		label.setBounds(41, 31, 97, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Donja granica: ");
		label_1.setBounds(41, 59, 97, 14);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 138, 246, 99);
		panel_3.add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Trenutna vrijednost ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("Gornja granica: ");
		label_2.setBounds(44, 32, 97, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Donja granica: ");
		label_3.setBounds(44, 60, 97, 14);
		panel_2.add(label_3);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(151, 32, 60, 20);
		panel_2.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(151, 57, 60, 20);
		panel_2.add(spinner_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum stavljanja sredstva u upotrebu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 134, 318, 101);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Gornja granica: ");
		label_4.setBounds(20, 33, 97, 14);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Donja granica: ");
		label_5.setBounds(20, 64, 97, 14);
		panel_4.add(label_5);
		
		JDateChooser dateChooser_2 = new JDateChooser(new Date());
		dateChooser_2.setBounds(127, 58, 160, 20);
		panel_4.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser(new Date());
		dateChooser_3.setBounds(127, 27, 160, 20);
		panel_4.add(dateChooser_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Stopa amortizacije sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(371, 277, 241, 101);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_6 = new JLabel("Gornja granica: ");
		label_6.setBounds(31, 32, 97, 14);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Donja granica: ");
		label_7.setBounds(31, 60, 97, 14);
		panel_5.add(label_7);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(138, 32, 60, 20);
		panel_5.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(138, 57, 60, 20);
		panel_5.add(spinner_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datum otpisivanja sredstva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 249, 318, 95);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_8 = new JLabel("Gornja granica: ");
		label_8.setBounds(20, 33, 97, 14);
		panel_6.add(label_8);
		
		JLabel label_9 = new JLabel("Donja granica: ");
		label_9.setBounds(20, 64, 97, 14);
		panel_6.add(label_9);
		
		JDateChooser dateChooser_4 = new JDateChooser(new Date());
		dateChooser_4.setBounds(127, 27, 163, 20);
		panel_6.add(dateChooser_4);
		
		JDateChooser dateChooser_5 = new JDateChooser(new Date());
		dateChooser_5.setBounds(127, 58, 163, 20);
		panel_6.add(dateChooser_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodatno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 355, 241, 111);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_10 = new JLabel("Lokacija:");
		label_10.setBounds(26, 35, 68, 14);
		panel_7.add(label_10);
		
		textField = new JTextField();
		textField.setBounds(114, 29, 91, 20);
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel label_12 = new JLabel("Grupa:");
		label_12.setBounds(36, 63, 47, 14);
		panel_7.add(label_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 60, 91, 20);
		panel_7.add(comboBox);
		
		JButton button_1 = new JButton("Iza\u0111i");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(496, 440, 89, 23);
		contentPane.add(button_1);
	}
}
