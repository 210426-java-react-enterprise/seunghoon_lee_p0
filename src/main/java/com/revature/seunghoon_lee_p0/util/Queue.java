package com.revature.seunghoon_lee_p0.util;

/**
 * Custom Queue
 * @param <T>
 */
public interface Queue<T> extends Collection<T> {

    T peek();
    T poll();

}
