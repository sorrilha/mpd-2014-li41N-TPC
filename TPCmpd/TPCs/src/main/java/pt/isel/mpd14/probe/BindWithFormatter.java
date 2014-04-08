/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.probe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        Class c = target.getClass();
        Format f = null;
           
        try {
             Field field = c.getField(name);
            if (field!= null ) {
                f = field.getAnnotation(Format.class);
                if (f!=null)
                    v = f.formatter().newInstance().format(v);
            }
            else
            {
                String mName = "setName";
                Method m = c.getMethod(mName, String.class);
                if (m!=null)
                    f = m.getAnnotation(Format.class);
                if (f!=null)
                    v = f.formatter().newInstance().format(v);
               
            }
            
            
            
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(BindWithFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BindWithFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BindWithFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BindWithFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BindWithFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return bindMember.bind(target, name, v);
    }
}
