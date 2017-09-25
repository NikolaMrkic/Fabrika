package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPreduzeca = new JButton("Preduzece");
		btnPreduzeca.setBounds(38, 54, 89, 23);
		contentPane.add(btnPreduzeca);
		
		JButton btnOrgJed = new JButton("Organizaciona Jedinica");
		btnOrgJed.setBounds(152, 54, 89, 23);
		contentPane.add(btnOrgJed);
		
		JButton btnTipRadnog = new JButton("Tip Radnog Mesta");
		btnTipRadnog.setBounds(260, 54, 89, 23);
		contentPane.add(btnTipRadnog);
		
		JButton btnZaposleni = new JButton("Zaposleni");
		btnZaposleni.setBounds(38, 137, 89, 23);
		contentPane.add(btnZaposleni);
		
		JButton btnArtikal = new JButton("Artikal");
		btnArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Artikal a=new Artikal();
			a.setVisible(true);
			}
		});
		btnArtikal.setBounds(152, 137, 89, 23);
		contentPane.add(btnArtikal);
		
		JButton btnTipArtikla = new JButton("TipArtikla");
		btnTipArtikla.setBounds(260, 137, 89, 23);
		contentPane.add(btnTipArtikla);
		
		JButton btnUcinak = new JButton("Ucinak");
		btnUcinak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				UcinakForma uf=new UcinakForma();
				uf.setVisible(true);
			
			}
		});
		btnUcinak.setBounds(38, 196, 89, 23);
		contentPane.add(btnUcinak);
	}
}
