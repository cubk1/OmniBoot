package org.union4dev.omni.struct;

import lombok.Getter;

import java.util.Objects;

public class Pair<A, B> {
    @Getter
    private final A first;
    @Getter
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <T, K> Pair<T, K> of(T a, K b) {
        return new Pair<T, K>(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair b = (Pair) o;
        return Objects.equals(this.first, b.first) && Objects.equals(this.second, b.second);
    }
}