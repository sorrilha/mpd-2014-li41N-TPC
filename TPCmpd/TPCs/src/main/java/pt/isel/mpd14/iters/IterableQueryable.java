/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.iters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class IterableQueryable<T> implements Queryable<T> {

    Iterable<T> filtered;
    final Iterable<T> src;

    public IterableQueryable(Iterable<T> src) {
        this.src = src;

    }

    @Override
    public Queryable<T> filter(Predicate<T> p) {
        Iterator<T> iter = src.iterator();
        filtered = new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    T aux = null;

                    @Override
                    public boolean hasNext() {
                        while (iter.hasNext()) {
                            aux = iter.next();
                            if (p.test(aux)) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override
                    public T next() {
                        T t = null;
                        if (hasNext()) {
                            t = aux;
                        }
                        return t;

                    }
                };
            }
        };

        return new IterableQueryable<>(filtered);

    }

    @Override
    public <R> Queryable<R> map(Function<T, R> mapper) {

        Iterable<R> iter = new Iterable<R>() {

            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>() {
                    T aux;
                    Iterator<T> x = src.iterator();

                    @Override
                    public boolean hasNext() {
                        if (x.hasNext()) {
                            aux = x.next();
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public R next() {
                        R apply = null;
                        while (hasNext()) {
                            System.out.println("aux-"+aux);
                            apply = mapper.apply(aux);
                            System.out.println(apply);
                        }
                        return apply;
                    }
                };
            }

        };

        return new IterableQueryable(iter);

    }

    @Override
    public Queryable<T> skip(int n) {
         Iterable<T> iter = src;
         Iterator iterator = iter.iterator();
         while (iterator.hasNext())
         {
            if(n>0)
                iterator.next();
             --n;
         }
   
       
         return new IterableQueryable<>(iter);

    }

    @Override
    public Iterator<T> iterator() {
        return src.iterator();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
