package com.datastructure.tree;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/5 19:25
 */
public class BinaryTree {
    public BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    public void remove(int id) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        if (root.id == id) {
            this.root = null;
            return;
        }
        if (!root.remove(id)) {
            throw new RuntimeException("执行出错");
        }
    }

    public void removeByRule(int id) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        if (root.id == id) {
            this.root = this.root.left != null ? this.root.left : this.root.right;
            return;
        }
        if (!root.removeByRule(id)) {
            throw new RuntimeException("未找到待删除结点");
        }
    }
}

class BinaryTreeNode {
    public int id;
    public String name;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (right != null) {
            right.infixOrder();
        }
    }

    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.println(this);
    }

    public BinaryTreeNode preOrderSearch(int id) {
        System.out.println(this);
        if (this.id == id) {
            return this;
        }
        BinaryTreeNode node = null;
        if (left != null) {
            node = left.preOrderSearch(id);
        }
        //很关键，如果是null也直接返回，那么右边就不会遍历
        if (node != null) {
            return node;
        }
        if (right != null) {
            node = right.preOrderSearch(id);
        }
        return node;
    }

    public BinaryTreeNode infixOrderSearch(int id) {
        BinaryTreeNode node = null;
        if (left != null) {
            node = left.infixOrderSearch(id);
        }
        //很关键，如果是null也直接返回，那么右边就不会遍历
        if (node != null) {
            return node;
        }
        System.out.println(this);
        if (this.id == id) {
            return this;
        }

        if (right != null) {
            node = right.infixOrderSearch(id);
        }
        return node;
    }

    public BinaryTreeNode postOrderSearch(int id) {
        BinaryTreeNode node = null;
        if (left != null) {
            node = left.postOrderSearch(id);
        }
        //很关键，如果是null也直接返回，那么右边就不会遍历
        if (node != null) {
            return node;
        }
        if (right != null) {
            node = right.postOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        System.out.println(this);
        if (this.id == id) {
            return this;
        }
        return null;
    }

    public boolean remove(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return true;
        }
        boolean flag = false;
        if (this.left != null) {
            flag = this.left.remove(id);
        }
        if (flag) {
            return true;
        }
        if (this.right != null) {
            flag = this.right.remove(id);
        }
        return flag;
    }

    /**
     * 删除结点时，若左子结点不为空，则替换为左子结点，否则替换为右子结点
     * @param id
     * @return
     */
    public boolean removeByRule(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = this.left.left != null ? this.left.left : this.left.right;
            return true;
        }
        if (this.right != null && this.right.id == id) {
            this.right = this.right.left != null ? this.right.left : this.right.right;
            return true;
        }
        boolean flag = false;
        if (this.left != null) {
            flag = this.left.removeByRule(id);
        }
        if (flag) {
            return true;
        }
        if (this.right != null) {
            flag = this.right.removeByRule(id);
        }
        return flag;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
