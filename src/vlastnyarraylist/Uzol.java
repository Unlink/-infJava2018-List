/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlastnyarraylist;

/**
 *
 * @author duracik2
 */
public class Uzol<TValue> {
    
    private TValue prvok;
    private Uzol nasledovnik;

    public Uzol(TValue prvok) {
        this.prvok = prvok;
        this.nasledovnik = null;
    }

    public TValue getPrvok() {
        return prvok;
    }

    public Uzol getNasledovnik() {
        return nasledovnik;
    }

    public void setNasledovnik(Uzol nasledovnik) {
        this.nasledovnik = nasledovnik;
    }
}
