package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class UcinakForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfKolicina;
	private JComboBox cbZaposleni, cbArtikal;
	private int idArtikla,idZaposlenog;
	private JComboBox cbDanOd;
	private JComboBox cbMesecOd;
	private JComboBox cbGodOd;
	private JComboBox cbDanDo;
	private JComboBox cbMesecDo;
	private JComboBox cbGodinaDo;
	private String datumOd, datumDo;
	private String danOd,danDo,mesecOd,mesecDo, godOd,godDo;
	private JTextField tfFormatd;
	private JTextField tfDatumdo;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UcinakForma frame = new UcinakForma();
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
	public UcinakForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfKolicina = new JTextField();
		tfKolicina.setBounds(127, 100, 131, 20);
		contentPane.add(tfKolicina);
		tfKolicina.setColumns(10);
		
		 cbArtikal = new JComboBox();
		 cbArtikal.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		String naziv=cbArtikal.getSelectedItem().toString();
		 		for(domen.Artikal a:Kontroler.getInstanca().vratiArtikal()){
		 			
		 			if(naziv.equals(a.getNaziv())){
		 				
		 				idArtikla=a.getId();
		 			}
		 		}
		 	
		 	}
		 });
		cbArtikal.setBounds(127, 46, 131, 20);
		contentPane.add(cbArtikal);
		
		cbZaposleni = new JComboBox();
		cbZaposleni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nazivZaposlenog=cbZaposleni.getSelectedItem().toString();
				for(domen.Zaposleni z:Kontroler.getInstanca().vratiZaposlene()){
					String ime_prezime=z.getIme()+"-"+z.getPrezime();
					if(ime_prezime.equals(nazivZaposlenog)){
						
						idZaposlenog=z.getId();
						System.out.println(idZaposlenog);
					}
					
				}
				
				
			}
		});
		cbZaposleni.setBounds(127, 11, 131, 20);
		contentPane.add(cbZaposleni);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String kolicina=tfKolicina.getText().toString();
			int kol=Integer.valueOf(kolicina);
			datumOd=godOd+"/"+mesecOd+"/"+danOd;
			datumDo=godDo+"/"+mesecDo+"/"+danDo;
			//String datum_do=tfDatum_DO.getText().toString();
			//DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
			
				//Date dateod = (Date) format.parse(datum_od);
				//Date datedo = (Date) format.parse(datum_do);
				Kontroler.getInstanca().upisiUcinak(idArtikla,idZaposlenog,kol,datumOd,datumDo);
			
			
			
			}
		});
		btnUnesi.setBounds(127, 229, 131, 23);
		contentPane.add(btnUnesi);
		
		cbDanOd = new JComboBox();
		cbDanOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			danOd=cbDanOd.getSelectedItem().toString();
			}
		});
		cbDanOd.setBounds(125, 169, 46, 20);
		contentPane.add(cbDanOd);
		
		cbMesecOd = new JComboBox();
		cbMesecOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mesecOd=cbMesecOd.getSelectedItem().toString();
			}
		});
		cbMesecOd.setBounds(194, 169, 99, 20);
		contentPane.add(cbMesecOd);
		
		cbGodOd = new JComboBox();
		cbGodOd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			godOd=cbGodOd.getSelectedItem().toString();
			tfFormatd.setText(danOd+"/"+mesecOd+"/"+godOd);
			}
		});
		cbGodOd.setBounds(316, 169, 108, 20);
		contentPane.add(cbGodOd);
		
		cbDanDo = new JComboBox();
		cbDanDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			danDo=cbDanDo.getSelectedItem().toString();
			}
		});
		cbDanDo.setBounds(125, 198, 46, 20);
		contentPane.add(cbDanDo);
		
		cbMesecDo = new JComboBox();
		cbMesecDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mesecDo=cbMesecDo.getSelectedItem().toString();
			}
		});
		cbMesecDo.setBounds(194, 200, 99, 20);
		contentPane.add(cbMesecDo);
		
		cbGodinaDo = new JComboBox();
		cbGodinaDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			godDo=cbGodinaDo.getSelectedItem().toString();
			tfDatumdo.setText(danDo+"/"+mesecDo+"/"+godDo);
			
			}
		});
		cbGodinaDo.setBounds(316, 200, 108, 20);
		contentPane.add(cbGodinaDo);
		
		tfFormatd = new JTextField();
		tfFormatd.setBounds(451, 169, 86, 20);
		contentPane.add(tfFormatd);
		tfFormatd.setColumns(10);
		
		tfDatumdo = new JTextField();
		tfDatumdo.setBounds(451, 198, 86, 20);
		contentPane.add(tfDatumdo);
		tfDatumdo.setColumns(10);
		ucitajPodatkeArtikal();
		ucitajPodatkeZaposleni();
		popuniDatume();
		
		
	}

	private void popuniDatume() {
		
		for(int i=1;i<32;i++){
			
			cbDanDo.addItem(i);
			cbDanOd.addItem(i);
		}
		for(int i=1;i<13;i++){
			
			cbMesecOd.addItem(i);
			cbMesecDo.addItem(i);
		}
		for(int i=1950;i<2100;i++){
			
			cbGodOd.addItem(i);
			cbGodinaDo.addItem(i);
		}
		// TODO Auto-generated method stub
		
	}

	private void ucitajPodatkeZaposleni() {
		// TODO Auto-generated method stub
		for(domen.Zaposleni z:Kontroler.getInstanca().vratiZaposlene()){
			
			cbZaposleni.addItem(z.getIme()+"-"+z.getPrezime());
		}
		
	}

	private void ucitajPodatkeArtikal() {
		//TODO Auto-generated method stub
		for(domen.Artikal a:Kontroler.getInstanca().vratiArtikal()){
			
			cbArtikal.addItem(a.getNaziv());
		}
		
		
	}
}
