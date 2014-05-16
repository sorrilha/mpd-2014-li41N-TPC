/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class AbstractHtmlLayout {
    
    public String buildPage(Object o){
        
        
        HtmlElement html =  new HtmlElement("html");
        HtmlElement head = new HtmlElement("head");
        HtmlElement headContent= buildHeadContent(o);
        HtmlElement body = new HtmlElement("body");
        HtmlElement bodyContent = buildBodyContent(o);
        
        head.add(headContent);
        html.add(head);
        body.add(bodyContent);
        html.add(body);
        
        return html.print();
        
        //String res = "<html>\n";
        //res += "   <head>\n";
       // res += buildHeadContent(o);
        //res += "   </head>\n";
        //res += "   <body>\n";
        //res += buildBodyContent(o);
        //res += "   </body>\n";
        //res += "</html>\n";
        //return res;
        
    }
    
    protected abstract HtmlElement buildHeadContent(Object o);
    protected abstract HtmlElement buildBodyContent(Object o);   
}
