/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author sorrilha
 */
public class MessageBox implements Action {

    @Override
    public void go() {
        JOptionPane.showMessageDialog(null, "Ding Dong", "MessageBox Alert", JOptionPane.WARNING_MESSAGE);
    }
}
