package domen;

public class Zaposleni {
	private int id_org_jed,id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String jmbg,ime, prezime;
	public Zaposleni() {
		super();
	}
	public int getId_org_jed() {
		return id_org_jed;
	}
	public void setId_org_jed(int id_org_jed) {
		this.id_org_jed = id_org_jed;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	

}
