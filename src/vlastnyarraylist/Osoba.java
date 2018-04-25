/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlastnyarraylist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author duracik2
 */
public class Osoba implements IZapisatelny {

    private String meno;
    private String priezvisko;
    private int vek;

    public Osoba(String meno, String priezvisko, int vek) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
    }

    public Osoba() {
        
    }

    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public int getVek() {
        return vek;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    @Override
    public String toString() {
        return "Osoba{" + "meno=" + meno + ", priezvisko=" + priezvisko + ", vek=" + vek + '}';
    }
    
    @Override
    public void zapis(DataOutputStream zapisovac) throws IOException {
        zapisovac.writeInt(this.vek);
        zapisovac.writeUTF(this.meno);
        zapisovac.writeUTF(this.priezvisko);
    }

    @Override
    public void nacitaj(DataInputStream citac) throws IOException {
        this.vek = citac.readInt();
        this.meno = citac.readUTF();
        this.priezvisko = citac.readUTF();
    }
}
