package kontroler;

import java.util.ArrayList;
import java.util.Date;

import broker.Broker;
import domen.Artikal;
import domen.TipArtikla;
import domen.TipRadnogMesta;
import sun.security.pkcs11.Secmod.DbMode;

public class Kontroler {
	
	public static Kontroler instanca=null;
	
	public static  Kontroler getInstanca(){
		
		if(instanca==null){
			
			instanca=new Kontroler();
		}
		
		return instanca;
		
		
	}

	public void upisiArtikal(String ime, String barkod, String sifra, int tip) {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		Broker.getBroker().upisiArtikal(ime, barkod,sifra, tip);
		Broker.getBroker().zatvoriKonekciju();
		
	}

	public ArrayList<TipArtikla> vratitipArtikla() {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		ArrayList<TipArtikla>al=Broker.getBroker().vratiTip();
		Broker.getBroker().zatvoriKonekciju();
		return al;
		
	}

	public ArrayList<domen.Artikal> vratiArtikal() {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		ArrayList<domen.Artikal>al=Broker.getBroker().vratiArtikal();
		Broker.getBroker().zatvoriKonekciju();
		return al;
	}

	public void promeniPodatke(String ime, String barkod, String sifra, int id, String idArtikla) {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		Broker.getBroker().promeniPodatke(ime, barkod,sifra, id,idArtikla);
		Broker.getBroker().zatvoriKonekciju();
		
	}

	public ArrayList<domen.Zaposleni> vratiZaposlene() {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		ArrayList<domen.Zaposleni>al=Broker.getBroker().vratiZaposlene();
		Broker.getBroker().zatvoriKonekciju();
		return al;
	}

	public void upisiUcinak(int idArtikla, int idZaposlenog, int kol, String datumOd, String datumDo) {
		// TODO Auto-generated method stub
		Broker.getBroker().otvoriKonekciju();
		Broker.getBroker().upisiUcinak( idArtikla,  idZaposlenog,  kol,  datumOd,  datumDo);
		Broker.getBroker().zatvoriKonekciju();
		
		
	}
	
	public void upisiTipRadnogMesta(String naziv){
		Broker.getBroker().otvoriKonekciju();
		Broker.getBroker().upisiTipradnogMesta( naziv);
		Broker.getBroker().zatvoriKonekciju();
	}
	
	public ArrayList<domen.TipRadnogMesta>vratiTipRadnogMesta(){
		Broker.getBroker().otvoriKonekciju();
		ArrayList<domen.TipRadnogMesta>al=Broker.getBroker().vratiTipRadnogMesta();
		Broker.getBroker().zatvoriKonekciju();
		return al;
	}

	
}
