/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.probe;

/**
 *
 * @author sorrilha
 */
public class BindToUpperCase<T> implements BindMember<T> {

    private final BindMember bindMember;

    public BindToUpperCase(BindMember bindMember) {
        
        this.bindMember = bindMember;
    }

    @Override
    public boolean bind(T target, String name, Object v) {
        if (v instanceof String) 
            v = v.toString().toUpperCase();
        return bindMember.bind(target, name, v);
    }
}
