package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import kontroler.Kontroler;

public class TipRadnogMesta extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private JComboBox<String> cbIdTipRadnogMesta;
	private ArrayList<domen.TipRadnogMesta>al;
	private int idTipRadnogMesta;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipRadnogMesta frame = new TipRadnogMesta();
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
	public TipRadnogMesta() {
		setTitle("TIP RADNOG MESTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(122, 80, 121, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		JButton btnDodajTipRadnogMesta = new JButton("Dodaj");
		btnDodajTipRadnogMesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String naziv = tfNaziv.getText().toString();
				Kontroler.getInstanca().upisiTipRadnogMesta( naziv);
				srediFormu();
				JOptionPane.showMessageDialog(null, "Podaci o TIPU RADNOG MESTA su uneseni!");
			}

			private void srediFormu() {
				tfNaziv.setText("");
			}
		});
		btnDodajTipRadnogMesta.setBounds(57, 137, 111, 23);
		contentPane.add(btnDodajTipRadnogMesta);
		
		cbIdTipRadnogMesta = new JComboBox();
		cbIdTipRadnogMesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String naziv=cbIdTipRadnogMesta.getSelectedItem().toString();
				
					for(domen.TipRadnogMesta t : Kontroler.getInstanca().vratiTipRadnogMesta()){
						if(t.getNaziv().equalsIgnoreCase(naziv)){
							idTipRadnogMesta = t.getIdTipRadnogMesta();
						}
					}
					
				
			}
		});
		cbIdTipRadnogMesta.setBounds(122, 21, 186, 20);
		contentPane.add(cbIdTipRadnogMesta);
		
		JLabel lblNewLabel = new JLabel("Naziv : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(38, 83, 73, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnGlavnaForma = new JButton("Glavna forma");
		btnGlavnaForma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main m = new Main();
				m.setVisible(true);
				
			}
		});
		btnGlavnaForma.setBounds(241, 137, 111, 23);
		contentPane.add(btnGlavnaForma);
		popuniComboTipRadnogMesta();
	}

	private void popuniComboTipRadnogMesta() {
		cbIdTipRadnogMesta.addItem("Tip radnog mesta");
		for(domen.TipRadnogMesta t : Kontroler.getInstanca().vratiTipRadnogMesta()){
		cbIdTipRadnogMesta.addItem(t.getNaziv());	
	
		}
		}
}
