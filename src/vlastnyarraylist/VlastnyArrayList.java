/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlastnyarraylist;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author duracik2
 */
public class VlastnyArrayList {

    public static void main(String[] args) {
        
        /*Zoznam<Integer> cisla = new Zoznam<>();
        cisla.pridaj(1);
        cisla.pridaj(new Integer(8));
        //vytvorOsoby(cisla);
        
        for (Object integer : cisla) {
            System.out.println(integer);
        }*/
        
//        Zoznam<Osoba> osoby = new Zoznam<>(new TovarenNaOsoby());
        
//        Zoznam<Osoba> osoby = new Zoznam<>(new ITovaren<Osoba>() {
//            @Override
//            public Osoba vyrob() {
//                return new Osoba();
//            }
//        });
        Zoznam<Osoba> osoby = new Zoznam<>(() -> new Osoba());
        //vytvorOsoby(osoby);
        
        //System.out.println(osoby.toString());
        
        /*try {
            osoby.uloz("zoznamOsob.bin");
        } catch (IOException ex) {
            System.err.println("Nepodarilo sa ulozit zoznam do suboru");
        }*/
        
        try {
            osoby.napln("zoznamOsob.bin");
        } catch (Exception e) {
        }
        for (Osoba osoba : osoby) {
            
            System.out.println(osoba);
        }
    }
    
    private static void vytvorOsoby(Zoznam<Osoba> zoznam) {
        zoznam.pridaj(new Osoba("Janko", "Hasko", 20));
        zoznam.pridaj(new Osoba("Ferko", "Mrkvicka", 22));
    }
    
}
