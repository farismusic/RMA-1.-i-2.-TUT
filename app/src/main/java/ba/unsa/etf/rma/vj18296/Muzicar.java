package ba.unsa.etf.rma.vj18296;

public class Muzicar {

    private String ime;
    private String prezime;
    private String zanr;
    private String webStranica;
    private String biografija;

    public Muzicar(String name, String surname, String zanr, String web, String biografija){
        ime = name;
        prezime = surname;
        this.zanr = zanr;
        webStranica = web;
        this.biografija = biografija;
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

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

}
