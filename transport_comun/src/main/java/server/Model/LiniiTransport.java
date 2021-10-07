package server.Model;

public class LiniiTransport {
    int nrLinie;
    String numeStatie;

    @Override
    public String toString() {
        return
                " nrLinie=" + nrLinie +
                ", numeStatie='" + numeStatie + '\'';
    }


    public LiniiTransport(String numeStatie,int nrLinie) {
        this.numeStatie=numeStatie;
        this.nrLinie=nrLinie;
    }
    public LiniiTransport(){}
    public LiniiTransport(String numeStatie){
        this.numeStatie=numeStatie;
    }
    public String getNumeStatie() {
        return numeStatie;
    }

    public void setNumeStatie(String numeStatie) {
        this.numeStatie = numeStatie;
    }

    public int getNrLinie() {
        System.out.println("Numarul de linii este:");
        return nrLinie;
    }

    public void setNrLinie(int nrLinie) {
        this.nrLinie = nrLinie;
    }



}
