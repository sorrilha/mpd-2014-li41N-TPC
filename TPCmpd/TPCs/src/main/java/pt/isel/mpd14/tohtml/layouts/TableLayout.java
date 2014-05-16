/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.layouts;

import java.util.Map;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.tohtml.AbstractHtmlLayout;
import pt.isel.mpd14.tohtml.HtmlElement;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class TableLayout extends AbstractHtmlLayout{

    @Override
    protected HtmlElement buildHeadContent(Object o) {
        /*
        String res = "       <title>";
        res += o.getClass();
        res += "</title>\n";
        return res;
        */
        HtmlElement title =  new HtmlElement("title", o.getClass().toString(),true);
        return title;
    }

    @Override
    protected HtmlElement buildBodyContent(Object o) {
            HtmlElement table = new HtmlElement("table", true);
            
            //String res = "      <table>\n";
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                HtmlElement trow = new HtmlElement("tr",true);
                
                HtmlElement tdata = new HtmlElement("td",k, true);
                trow.add(tdata);
                tdata = new HtmlElement("td",v.toString(), true);
                trow.add(tdata);
                table.add(trow);
               /* res += "          <tr>";
                res += "<td>" + k + "</td><td>" + v + "</td>";
                res += "</tr>\n";
                */
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
       // res += "       </table>\n";
       // return res;
        return table;
    }
    
}
