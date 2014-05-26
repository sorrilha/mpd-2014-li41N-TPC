/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

import java.awt.Toolkit;

/**
 *
 * @author sorrilha
 */
public class BeepAlarm implements Action{

    @Override
    public void go() {
        Toolkit.getDefaultToolkit().beep();
    }
    
}
