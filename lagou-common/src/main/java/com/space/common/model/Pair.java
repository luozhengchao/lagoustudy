package com.space.common.model;

import lombok.Data;

/**
 * designed by PENGJIAWEI039
 *
 * @author: PENGJIAWEI039
 * @DATE: 2018-12-11 11:08
 */
@Data
public class Pair<L, R> {

    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public Pair() {
    }

    /**
     * 根据等号左边的泛型，自动构造合适的Pair
     */
    public static <L, R> Pair<L, R> buildEmpty() {
        return new Pair<>(null, null);
    }

    /**
     * 根据等号左边的泛型，自动构造合适的Pair
     */
    public static <L, R> Pair<L, R> build(L left, R right) {
        return new Pair<>(left, right);
    }

    public boolean isAllNull(){
        return this.left==null && this.right==null;
    }
}
