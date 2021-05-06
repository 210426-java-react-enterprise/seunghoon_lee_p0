package com.revature.seunghoon_lee_p0.util;

public interface Queue<T> extends Collection<T> {

    T poll();
    T peek();

}
