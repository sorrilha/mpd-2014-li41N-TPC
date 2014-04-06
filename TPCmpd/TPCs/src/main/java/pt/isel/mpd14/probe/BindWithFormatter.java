/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.probe;

import java.lang.annotation.Annotation;
import java.text.Format;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sorrilha
 */
public class BindWithFormatter<T> implements BindMember<T> {

    private final BindMember bindMember;

    public BindWithFormatter(BindMember bindMember) {
        if (bindMember instanceof BindWithFormatter) {
            throw new IllegalArgumentException("BindMember cannot be an instance of BindWithFormatter");
        }
        this.bindMember = bindMember;
    }

    @Override
    public boolean bind(T target, String name, Object v) {

        Annotation[] a = target.getClass().getAnnotations();
        for (Annotation x : a) {
            if (x.getClass().isAssignableFrom(Format.class)) {

                Format f;
                f = (Format) x;
                if (f != null) {
                    v = f.format(v);

                }

            }
        }
        return bindMember.bind(target, name, v);
    }

}
