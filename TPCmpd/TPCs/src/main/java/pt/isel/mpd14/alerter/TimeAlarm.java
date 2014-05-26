/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.alerter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author sorrilha
 */
public class TimeAlarm implements Action{

    @Override
    public void go() {
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	System.out.println( sdf.format(cal.getTime()) );
    }
    
}
