/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlastnyarraylist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author duracik2
 */
public interface IZapisatelny {

    void zapis(DataOutputStream zapisovac) throws IOException;
    void nacitaj(DataInputStream citac) throws IOException;
}
