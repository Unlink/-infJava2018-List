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
public class TovarenNaOsoby implements ITovaren<Osoba>{

    @Override
    public Osoba vyrob() {
        return new Osoba();
    }
    
}
