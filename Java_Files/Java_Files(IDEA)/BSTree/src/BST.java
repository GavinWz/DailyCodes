import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    public BST(){}
    public BST(E[] objects){
        for(int i = 0; i < objects.length; i++){
            insert(objects[i]);
        }
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while(current != null){
            if(e.compareTo(current.element) < 0)
                current = current.left;
            if(e.compareTo(current.element) > 0)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean insert(E e){
        if(root == null)
            root = new TreeNode<E>(e);
        else{
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while(current != null){
                if(e.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }
                else if(e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }
                else
                    return false;
            }
             if(e.compareTo(parent.element) < 0)
                 parent.left = new TreeNode<>(e);
             else
                 parent.right = new TreeNode<>(e);

        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break;
        }
        if(current == null)
            return false;

        if(current.left == null){
            if(parent == null)
                root = current.right;
            else{
                if(e.compareTo(parent.element) > 0)
                    parent.right = current.right;
                else
                    parent.left = current.right;
            }
        }

        else{
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while(rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if(parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }

    public void inorder(TreeNode<E> root) {
        if(root != null){
            inorder(root.left);
            System.out.println(root.element);
            inorder(root.right);
        }
    }
    @Override
    public void inorder() {
        inorder(root);
    }

    public void postorder(TreeNode<E> root) {
        if(root != null){
            postorder((root.left));
            postorder((root.right));
            System.out.println(root.element);
        }
    }
    @Override
    public void postorder() {
        postorder(root);
    }

    public void preorder(TreeNode<E> root) {
        if(root != null){
            System.out.println(root.element);
            preorder(root.left);
            preorder(root.right);
        }
    }
    @Override
    public void preorder() {
        preorder(root);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(root == null)
            return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public InorderIterator(){
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode<E> root){
            if(root != null){
                inorder(root.left);
                System.out.println(root.element);
                inorder(root.right);
            }
        }

        @Override
        public boolean hasNext() {
            if(current < list.size())
                return true;
            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove(){
            delete(list.get(current));
            list.clear(); //Clear the list
            inorder();  //Rebuild the list
        }

    }

    public ArrayList<TreeNode<E>> path (E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode current = root;
        while(current != null){
            list.add(current);
            if(e.compareTo((E) current.element) < 0){
                current = current.left;
            }

            else if(e.compareTo((E)current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    public class TreeNode<E extends Comparable<E>> {
        protected  E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e){
            element = e;
        }
    }

}


