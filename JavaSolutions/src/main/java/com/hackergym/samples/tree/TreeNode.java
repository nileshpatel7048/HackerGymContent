package com.hackergym.samples.tree;

import com.hackergym.samples.model.Element;

/**
 * Created by Fathalian on 9/9/14.
 * HackerGym.com
 */
public class TreeNode {
    public Element value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Element value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getValue();
    }
}
