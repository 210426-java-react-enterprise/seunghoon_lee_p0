package com.revature.seunghoon_lee_p0.util;


/**
 * Custom Collection
 *
 * @param <T>
 */
public interface Collection<T> {

    int size();
    void add(T data);
    boolean contains(T data);
    T remove(T data);

}
