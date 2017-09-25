package broker;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import domen.Artikal;
import domen.TipArtikla;
import domen.TipRadnogMesta;
import domen.Zaposleni;

public class Broker {
	
	public static Broker broker;
	
	private java.sql.Connection con = null; // class za vezu sa bazom
	
	public Broker() { // konstruktor default

		ucitajDrajver();

	}
	public void ucitajDrajver() { // metoda

		try {
			Class.forName("com.mysql.jdbc.Driver"); // classa koja u sebi ima
													// metodu u njoj se nalazi
													// jdbc drivera
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void otvoriKonekciju() {

		try {/// konectioni string
			con = DriverManager.getConnection("jdbc:mysql://localhost/fabrika", "root", "");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static Broker getBroker(){
		
		if(broker==null){
			
			broker =new Broker();
		}
		return broker;
		
		
	}
	public void zatvoriKonekciju() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void upisiArtikal(String ime, String barkod, String sifra, int tip) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO artikl (naziv,barkod,id_tip_artikla,sifra ) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ime);
			ps.setString(2, barkod);
			ps.setInt(3, tip);
			ps.setString(4, sifra);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<TipArtikla> vratiTip() {
		
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<TipArtikla> al = new ArrayList<>();
		String upit = "SELECT  idTipArtikla,naziv from tipartikla";

		try {
			st = con.createStatement();

			rs = st.executeQuery(upit);

			while (rs.next()) {

				TipArtikla tp = new TipArtikla();
				tp.setId(rs.getInt("idTipArtikla"));
				tp.setNazivTipaArtikla(rs.getString("naziv"));
				
				al.add(tp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}
	public ArrayList<domen.Artikal> vratiArtikal() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<domen.Artikal> al = new ArrayList<>();
		String upit = "SELECT  idArtikla,naziv,barkod,id_tip_artikla, 	sifra  from artikl";

		try {
			st = con.createStatement();

			rs = st.executeQuery(upit);

			while (rs.next()) {

				Artikal tp = new Artikal();
				tp.setId(rs.getInt("idArtikla"));
				tp.setNaziv(rs.getString("naziv"));
				tp.setBarkod(rs.getString("barkod"));
				tp.setIdtip(rs.getInt("id_tip_artikla"));
				tp.setSifra(rs.getString("sifra"));
				
				
				al.add(tp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}
	public void promeniPodatke(String ime, String barkod, String sifra, int id, String idArtikla) {
		// TODO Auto-generated method stub
		int idART=Integer.valueOf(idArtikla);
		String izmena = "UPDATE Artikl SET naziv='" + ime + "' where IDArtikla='" + idART+
				"'";

		try {

			PreparedStatement ps = con.prepareStatement(izmena);
			System.out.print(izmena);
			ps.execute();
			// JOptionPane.showMessageDialog(null, "Obrisana stavka");

			// Update_table();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska nije obrisana stavka");
		}

		
	}
	
	public ArrayList<domen.Zaposleni> vratiZaposlene() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<domen.Zaposleni> al = new ArrayList<>();
		String upit = "SELECT  id_org_jed,ime,prezime,jmbg, id  from zaposleni order by id";

		try {
			st = con.createStatement();

			rs = st.executeQuery(upit);

			while (rs.next()) {

				Zaposleni za = new Zaposleni();
				za.setId_org_jed(rs.getInt("id_org_jed"));
				za.setIme(rs.getString("ime"));
				za.setPrezime(rs.getString("prezime"));
				za.setJmbg(rs.getString("jmbg"));
				za.setId(rs.getInt("id"));
				
				
				al.add(za);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}
	public void upisiUcinak(int idArtikla, int idZaposlenog, int kol, String datumOd, String datumDo) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO ucinak (idZaposlenog,idArtikla,kolicina,datumOd, datumDo) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idZaposlenog);
			ps.setInt(2, idArtikla);
			ps.setInt(3, kol);
			ps.setString(4, datumOd);
			ps.setString(5,  datumDo);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void upisiTipradnogMesta(String naziv) {
		String sql = "INSERT INTO tipradnogmesta (Naziv) VALUES (?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, naziv);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<domen.TipRadnogMesta> vratiTipRadnogMesta(){
		ResultSet rs = null;
		java.sql.Statement st = null;
		ArrayList<domen.TipRadnogMesta>al = new ArrayList<>();
		String upit = "SELECT idRadnogMesta,Naziv from tipradnogmesta order by idRadnogMesta";
		
		try 
		{
			st = con.createStatement();
			rs = st.executeQuery(upit);
			while(rs.next()){
				TipRadnogMesta t = new TipRadnogMesta();
				t.setIdTipRadnogMesta(rs.getInt("idRadnogMesta"));
				t.setNaziv(rs.getString("Naziv"));
				al.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
}
