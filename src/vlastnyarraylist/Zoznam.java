/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlastnyarraylist;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.FileObject;

/**
 *
 * @author duracik2
 */
public class Zoznam<E extends IZapisatelny> implements Iterable<E> {
    
    private int pocet;
    private Uzol<E> prvy;
    private Uzol<E> posledny;
    private static final int MAGIC_NUMBER = 1000;
    private ITovaren<E> tovaren;

    public Zoznam(ITovaren<E> tovaren) {
        this.pocet = 0;
        this.prvy = null;
        this.posledny = null;
        this.tovaren = tovaren;
    }
    
    public void pridaj(E element) {
        this.pocet++;
        Uzol novy = new Uzol(element);
        if (this.prvy == null) {
            this.prvy = this.posledny = novy;
        }
        else {
            this.posledny.setNasledovnik(novy);
            this.posledny = novy;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            
            private Uzol<E> aktualny = Zoznam.this.prvy;
            
            @Override
            public boolean hasNext() {
                return this.aktualny != null;
            }

            @Override
            public E next() {
                E prvok = this.aktualny.getPrvok();
                this.aktualny = this.aktualny.getNasledovnik();
                return prvok;
            }
        };
    }
    
    public void uloz(String nazovSuboru) throws IOException {        
        try (DataOutputStream zapisovac = new DataOutputStream(
                new FileOutputStream(nazovSuboru)
        )) {
            zapisovac.writeInt(MAGIC_NUMBER);
            zapisovac.writeInt(pocet);
            for (E prvok : this) {
                prvok.zapis(zapisovac);
            }
        } catch (IOException ex) {
            //
            throw ex;
        }
    }
    
    /**
     *
     * @param nazovSuboru
     */
    public void napln(String nazovSuboru) throws IOException, WrongFileFormatException {
        try (DataInputStream citac = new DataInputStream(
                new FileInputStream(nazovSuboru))
        ) {
            int magic = citac.readInt();
            if (magic != MAGIC_NUMBER) {
                throw new WrongFileFormatException("Subor "+nazovSuboru+" nema spravny format");
            }
            int pocet = citac.readInt();
            
            for (int i = 0; i < pocet; i++) {
                
                //vytvor prvok
                E prvok = tovaren.vyrob();
                prvok.nacitaj(citac);
                this.pridaj(prvok);
            }
        }
    }
    
}
