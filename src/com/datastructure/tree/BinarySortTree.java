package com.datastructure.tree;

/**
 * 添加
 * 值小于当前结点时，在左子树递归插值，否则在当前结点右子树递归插值
 * 删除
 * 1、删除叶子结点
 * 找到其父节点parent，此节点是父节点的左或右结点直接置空
 * 2、待删除结点deletedNode存在一个结点
 *     2、1 deletedNode是parent左结点
 *          deletedNode有左子结点 parent.left = deletedNode.left
 *          deletedNode有右子结点 parent.left = deletedNode.right
 *     2、2 deletedNode是parent右结点
 *          deletedNode有左子结点 parent.right = deletedNode.left
 *  *       deletedNode有右子结点 parent.right = deletedNode.right
 *
 * 3、待删除结点deletedNode存在两个结点
 *     在右子树寻找最小结点替换当前结点
 *
 *
 * @author wyg
 * @version 1.0
 * @date 2021/5/22 11:27
 */
public class BinarySortTree {
    private Node root;

    public void add(int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            this.root.add(value);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.infixOrder();
    }

    /**
     * 删除结点
     * @param value
     */
    public boolean remove(int value) {
        if (root == null) {
            System.out.println("二叉树为空");
            return false;
        }
        //查找到待删除结点
        Node deletedNode = this.root.search(value);
        if (deletedNode == null) {
            return false;
        }
        Node parent = this.root.searchParent(deletedNode);
        if (parent == null) {
            if (root.left != null && root.right == null) {
                this.root = this.root.left;
            } else if (root.right != null && root.left == null ) {
                this.root = this.root.right;
            } else if (root.left != null && root.right != null){
                Node minNode = deletedNode.right.searchMinValue();
                Node minNodeParent = this.root.searchParent(minNode);
                int temp = minNode.value;
                //待删除结点的值替换为最小结点值，最小结点删除
                //删除结点需要找到最小结点的父节点
                removeNode(minNode, minNodeParent, minNodeParent.left == minNode, minNodeParent.right == minNode);
                deletedNode.value = temp;
            } else {
                root = null;
            }
        } else {
            removeNode(deletedNode, parent, parent.left == deletedNode, parent.right == deletedNode);
        }
        return true;
    }

    public int getRootValue() {
        return this.root.value;
    }

    public void removeNode(Node node, Node parent, boolean isLeftNode, boolean isRightNode) {
        if(node.left == null && node.right == null) {
            if(isLeftNode) {
                parent.left = null;
            }
            if(isRightNode) {
                parent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            //找到右子树最小结点
            Node minNode = node.right.searchMinValue();
            Node minNodeParent = this.root.searchParent(minNode);
            int temp = minNode.value;
            //待删除结点的值替换为最小结点值，最小结点删除
            //删除结点需要找到最小结点的父节点
            removeNode(minNode, minNodeParent, minNodeParent.left == minNode, minNodeParent.right == minNode);
            node.value = temp;
        } else if (node.left != null) {
            if(isLeftNode) {
                parent.left = node.left;
            }
            if(isRightNode) {
                parent.right = node.left;
            }
        } else if (node.right != null) {
            if(isLeftNode) {
                parent.left = node.right;
            }
            if(isRightNode) {
                parent.right = node.right;
            }
        }
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






        public Node search(int value) {
            if (this.value == value) {
                return this;
            }
            if(this.value > value) {
                if(this.left == null) {
                    return null;
                }
                return this.left.search(value);
            } else {
                if(this.right == null) {
                    return null;
                }
                return this.right.search(value);
            }
        }

        public Node searchParent(Node node) {
            if (this.left == node || this.right == node) {
                return this;
            }
            if (node.value < this.value && this.left != null) {
                return this.left.searchParent(node);
            } else if (node.value >= this.value && this.right != null) {
                return this.right.searchParent(node);
            }
            return null;
        }

        public Node searchMinValue() {
            if (this.left != null) {
                return this.left.searchMinValue();
            }
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}

