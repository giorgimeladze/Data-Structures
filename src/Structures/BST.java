package Structures;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements Iterable<E> {

    private int size;
    private TreeNode root;

    public BST() {

    }

    /**
     * create a binary search tree from the array of objects
     * */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    private class TreeNode {
        E element;
        TreeNode left;
        TreeNode right;

        public TreeNode(E e) {
            element = e;
        }
    }

    /**
     * @return true if the element is in the binary tree
     * */
    public boolean search(E e) {
        TreeNode current = root;

        while(current != null) {
            if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Insert element e into the binary search tree
     * @param E e
     * @return true if element is inserted successfully
     * @return false if element already exists in binary tree
     * */
    public boolean insert(E e) {
        if (isEmpty()) {
            root = new TreeNode(e);
            size++;
            return true;
        } else {
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // no duplicates
                }
            }

            if (e.compareTo(parent.element) < 0)
                parent.left = new TreeNode(e);
            else
                parent.right = new TreeNode(e);

            size++;
            return true;
        }
    }

    /**
     * Delete the specified element from the tree
     * @return truen if element is successfully deleted
     * @param E e
     * */
    public boolean delete(E e) {    //FIX ME, when you have both left and right subtrees
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null)
            return false;

        // Case 1
        // checking for the case when the element which is to be removed has no right nor left child
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
                size--;
                return true;
            } else if (current.element.compareTo(parent.element) < 0) {
                parent.left = null;
                size--;
                return true;
            } else {
                parent.right = null;
                size--;
                return true;
            }
        }
        // Case 2
        // checking for the case when the element to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = root.left;
                size--;
                return true;
            } else if(current.element.compareTo(parent.element) < 0) {
                parent.left = current.left;
                size--;
                return true;
            } else {
                parent.right = current.left;
                size--;
                return true;
            }

        } else if (current.left == null) {
            if (current == root) {
                root = root.right;
                size--;
                return true;
            } else if (current.element.compareTo(parent.element) < 0) {
                parent.left = current.right;
                size--;
                return true;
            } else {
                parent.right = current.right;
                size--;
                return true;
            }
        }
        // Case 3
        // checking for the case when current has both the left and the right
        else if (current.left != null && current.right != null) {
            // then we need to find minimal element of right sub tree part
            TreeNode parentOfNewCurrent = current;
            TreeNode newCurrent = current.right;
            while (newCurrent.left != null) {
                parentOfNewCurrent = newCurrent;
                newCurrent = newCurrent.left;
            }

            if (newCurrent.right == null) {
                parentOfNewCurrent.left = null;
            } else {
                parentOfNewCurrent.left = newCurrent.right;
            }

            newCurrent.left = current.left;
            newCurrent.right = current.right;
            current = newCurrent;
            parent.right = current;
            size--;
            return true;
        }

        return false;


    }

    public E getRoot() {
        return root.element;
    }


    public E getLeastElement() {
        if (size == 0)
            return null;
        else if (size == 1)
            return root.element;
        else {
            TreeNode current = root;
            while(current.left != null) {
                current = current.left;
            }
            return current.element;
        }
    }

    public E getGreatestElement() {
        if (size == 0)
            return null;
        else if (size == 1)
            return root.element;
        else {
            TreeNode current = root;
            while(current.right != null)
                current = current.right;
            return current.element;
        }
    }

    /**
     * Inorder traversal from the root
     * */
    public void inorder() {
        System.out.print("[");
        inorder(root);
        System.out.println("]");
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        if (root.element.compareTo(getGreatestElement()) != 0)
            System.out.print(root.element + ",");
        else
            System.out.print(root.element);
        inorder(root.right);
    }

    /**
     * postorder traversal from the root
     * */
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.element + ", ");
        postorder(root.left);
        postorder(root.right);
    }

    /**
     * preorder traversal from the root
     * */
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + ", ");
    }

    /**
     * Get the number of nodes in the tree
     * @return int
     * */
    public int getSize() {
        return size;
    }

    /**
     * @return true if the tree is empty
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * clear the whole tree
     * */
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<E>{

        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public BSTIterator() {
            inorder(root);
        }

        private void inorder(TreeNode root) {
            if(root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }


        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current);
        }

        public void remove() {
            throw new UnsupportedOperationException("Removing an element from iteration is not supported");
        }

    }
}