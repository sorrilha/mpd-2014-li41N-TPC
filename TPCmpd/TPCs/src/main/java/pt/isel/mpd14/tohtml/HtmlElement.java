/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.tohtml;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlElement implements HtmlNode {

    final String name;
    final List<HtmlNode> children;
    static int count = 0;
    boolean closeable;
    public HtmlElement(String name, boolean closeable) {
        this.name = name;
        children = new LinkedList<>();
        this.closeable=closeable;
    }

    public HtmlElement(String name, String content,boolean closeable) {
        this.name = name;
        children = new LinkedList<>();
        children.add(new TextNode(content));
        this.closeable=closeable;
    }

    public void add(HtmlNode elem) {
        children.add(elem);
    }

    public String print() {

        String res = "<" + name + ">\n";
        String ident ="";
        count++;
        
        for (int i = 0; i < count; i++) {
            ident += "    ";
        }

        for (HtmlNode n : children) {
            res+=ident;
            res += n.print();
            if (closeable)
                res += "\n";
        }
        count--;
        ident="";
        for (int i = 0; i < count; i++) {
            ident += "    ";
        }
        if (closeable)
            res += ident+"</" + name + ">";
        return res;
    }
}
