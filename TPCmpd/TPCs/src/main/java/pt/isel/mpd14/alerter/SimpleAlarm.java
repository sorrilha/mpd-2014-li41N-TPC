/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

import java.util.Iterator;

/**
 *
 * @author sorrilha
 */
public class SimpleAlarm implements Action {

    @Override
    public void go() {
        System.out.println("Triiiim");
    }
}