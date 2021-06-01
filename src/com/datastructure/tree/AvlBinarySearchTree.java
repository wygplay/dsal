package com.datastructure.tree;

/**
 * 平衡二叉树
 * 当左右子树高度相差大于1时，进行旋转，从而使高度差保持在1以内
 * @author wyg
 * @version 1.0
 * @date 2021/5/24 22:05
 */
public class AvlBinarySearchTree {
    private Node root;
    public void add(int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            this.root.add(value);
        }
        height();
    }

    public void height() {
        System.out.println("tree height: " + this.root.height());
        System.out.println("right tree height: " + this.root.rightHeight());
        System.out.println("left tree height: " + this.root.leftHeight());
    }

    public int getRootValue() {
        return this.root.value;
    }

    private class Node {
        public int value;
        public Node left;
        public Node right;
        public Node (int value) {
            this.value = value;
        }
        public void add(int value) {
            //左结点遍历
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.add(value);
                }
            } else {
                //右结点遍历
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.add(value);
                }
            }

            if(rightHeight() - leftHeight() > 1) {
                if (right.leftHeight() > right.rightHeight()) {
                    right.rightRotate();
                }
                leftRotate();
            } else if (leftHeight() - rightHeight() > 1) {
                if (left.rightHeight() > left.leftHeight()) {
                    left.leftRotate();
                }
                rightRotate();
            }
        }

        private void leftRotate() {
            //以根节点（当前结点）值创建一个新结点
            //新结点左子结点指向当前结点的左子树
            //新结点的右子树指向当前结点的右子树的左子树
            //当前结点右子树的值赋给当前结点，右子结点指向当前结点的右子树的右子结点
            //当前结点的左子结点指向新创建结点
            Node newNode = new Node(this.value);
            newNode.left = this.left;
            newNode.right = this.right.left;
            this.value = this.right.value;
            this.right = this.right.right;
            this.left = newNode;
        }

        private void rightRotate() {
            //以根结点值新创建结点
            //新结点左子结点指向当前结点左子结点的右子结点
            //新结点右子结点指向当前结点的右子结点
            //当前结点左子结点的值赋给当前结点
            //当前结点的左子结点指向当前结点的左子节点的左子结点
            //当前结点的右子结点指向新创建结点
            Node newNode = new Node(this.value);
            newNode.left = this.left.right;
            newNode.right = this.right;
            this.value = this.left.value;
            this.left = this.left.left;
            this.right = newNode;
        }

        public int rightHeight() {
            if (this.right == null) {
                return 0;
            }
            return this.right.height();
        }

        public int leftHeight() {
            if (this.left == null) {
                return 0;
            }
            return this.left.height();
        }

        public int height() {
            return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

    }
}
