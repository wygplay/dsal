package com.datastructure.tree;

/**
 * n个结点的二叉树，会有n + 1个空指针，空左指针指向前继结点，右指针指向后继结点，根据执行线索化方式（前序、中序、后序）的不同，会生成不同线索化方案
 * 两个问题：
 *     线索化结点与普通结点需要作区分，标记出此节点左右子结点是否是线索化结点
 *     记录前继结点，用于指向前继this.left = preNode，以及指向后继preNode.right =this
 * @author wyg
 * @version 1.0
 * @date 2021/5/10 7:51
 */
public class ThreadedBinaryTree {
    public ThreadedBinaryTreeNode root;
    public ThreadedBinaryTreeNode preNode;
    public ThreadedBinaryTree(ThreadedBinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 注意此方法不能放在node结点中，因为需要一个全局变量来标记preNode
     */
    public void infixOrderThreading(ThreadedBinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            infixOrderThreading(node.left);
        }
        //这里其实可以放开preNode的判断，便于遍历
        if (node.left == null && preNode != null) {
            node.left = preNode;
            node.threadLeftFlag = 1;
        }
        //后继结点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.threadRightFlag = 1;
        }
        System.out.println(node);
        preNode = node;
        if (node.right != null) {
            infixOrderThreading(node.right);
        }
    }

    /**
     * 因为在线索化时，选择了第一个结点left不指向preNode，所以选择此方法实现
     */
    public void threadedInfixOrder() {
        ThreadedBinaryTreeNode node = root;
        boolean right = false;
        while (node != null) {
            //可以while循环
            if(node.threadRightFlag == 0 && node.threadLeftFlag == 1) {
                System.out.println(node);
                break;
            }
            if(right) {
                System.out.println(node);
                node = node.right;
                right = false;
                continue;
            }
            if (node.threadRightFlag == 0) {
                node = node.left;
                right = false;
            } else {
                System.out.println(node);
                node = node.right;
                right = true;
            }
        }
    }

    public void infixOrderThreading2(ThreadedBinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            infixOrderThreading2(node.left);
        }
        //这里放开preNode的判断，便于遍历
        if (node.left == null) {
            node.left = preNode;
            node.threadLeftFlag = 1;
        }
        //后继结点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.threadRightFlag = 1;
        }
        System.out.println(node);
        preNode = node;
        if (node.right != null) {
            infixOrderThreading2(node.right);
        }
    }

    public void threadedInfixOrder2() {
        ThreadedBinaryTreeNode node = root;
        while (node != null) {
            while(node.threadLeftFlag == 0) {
                node = node.left;
            }
            System.out.println(node);
            while(node.threadRightFlag == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }
}

class ThreadedBinaryTreeNode {
    public int id;
    public String name;
    public int threadLeftFlag;
    public int threadRightFlag;
    public ThreadedBinaryTreeNode left;
    public ThreadedBinaryTreeNode right;

    public ThreadedBinaryTreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * 注意此写法不正确，原因在于preNode是以局部变量的方式使用，两次递归无法进行值传递
     * @param preNode
     */
    public void infixOrderThreadingWrong(ThreadedBinaryTreeNode preNode) {
        if (left != null) {
            left.infixOrderThreadingWrong(preNode);
        } else if (left == null && preNode != null){
            this.threadLeftFlag = 1;
            this.left = preNode;
        }
        if (preNode != null && preNode.right == null) {
            preNode.right = this;
            preNode.right.threadRightFlag = 1;
        }
        preNode = this;
        System.out.println(this);
        if (right != null) {
            right.infixOrderThreadingWrong(preNode);
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

    public ThreadedBinaryTreeNode preOrderSearch(int id) {
        System.out.println(this);
        if (this.id == id) {
            return this;
        }
        ThreadedBinaryTreeNode node = null;
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

    public ThreadedBinaryTreeNode infixOrderSearch(int id) {
        ThreadedBinaryTreeNode node = null;
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

    public ThreadedBinaryTreeNode postOrderSearch(int id) {
        ThreadedBinaryTreeNode node = null;
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
        return "ThreadedBinaryTreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", threadLeftFlag=" + threadLeftFlag +
                ", threadRightFlag=" + threadRightFlag +
                '}';
    }
}