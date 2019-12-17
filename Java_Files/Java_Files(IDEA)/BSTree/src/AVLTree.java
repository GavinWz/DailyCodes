import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>> extends BST<E>{
    public AVLTree(){}

    public AVLTree(E[] objects){
        super(objects);
    }

    private void updateHeight(AVLTreeNode<E> node){
        if(node.left == null && node.right == null)
            node.height = 0;
        else if(node.left == null)
            node.height = ((AVLTreeNode)node.right).height + 1;
        else if(node.right == null)
            node.height = ((AVLTreeNode)node.left).height + 1;
        else
            node.height = Math.max(((AVLTreeNode)node.right).height,
                    ((AVLTreeNode)node.left).height);
    }

    @Override
    public boolean insert(E e){
        boolean successful = super.insert(e);
        if(!successful)
            return false;
        else
            balancePath(e);
        return true;
    }

    private void balancePath(E e){
        ArrayList<TreeNode<E>> path = path(e);
        for(int i = path.size() - 1; i >= 0; i--){
            AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i));
            updateHeight(A);
            AVLTreeNode<E> parentOfA = (A == root) ? null : (AVLTreeNode<E>)path.get(i-1);

            switch(balanceFactor(A)){
                case -2:
                    if(balanceFactor((AVLTreeNode<E>)A.left) <= 0)
                        balanceLL(A, parentOfA);
                    else
                        balanceLR(A, parentOfA);
                    break;
                case 2:
                    if(balanceFactor((AVLTreeNode<E>)A.right) >= 0)
                        balanceRR(A, parentOfA);
                    else
                        balanceRL(A, parentOfA);
            }
        }
    }

    private void balanceLL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
        TreeNode<E> B = A.left;
        if(A == root)
            root = B;
        else{
            if(parentOfA.left == A)
                parentOfA.left = B;
            else if(parentOfA.right == A)
                parentOfA.right = B;
        }
        A.left = B.right;
        B.right = A;
        updateHeight(A);
        updateHeight((AVLTreeNode<E>)B);
    }

    private void balanceLR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
        TreeNode<E> B = A.left;
        TreeNode<E> C = B.right;
        if(A == root)
            root = C;
        else
            if(parentOfA.left == A)
                parentOfA.left = C;
            else
                parentOfA.right = C;
        A.left = C.right;
        B.right = C.left;
        C.left = B;
        C.right = A;
        updateHeight(A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }

    private void balanceRR(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
        TreeNode<E> B = A.right;
        if(A == root)
            root = B;
        else
            if(parentOfA.left == A)
                parentOfA.left = B;
            else
                parentOfA.right = B;
        A.right = B.left;
        B.left = A;
        updateHeight(A);
        updateHeight((AVLTreeNode<E>)B);
    }

    private void balanceRL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
        TreeNode<E> B = A.right;
        TreeNode<E> C = B.left;
        if(A == root)
            root = C;
        else
            if(parentOfA.left == A)
                parentOfA.left = C;
            else
                parentOfA.right = C;
        A.right = C.left;
        B.left = C.right;
        C.left = A;
        C.right = B;
        updateHeight(A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }

    private int balanceFactor(AVLTreeNode<E> node){
        if(node.left == null)
            return node.height;
        else if(node.right == null)
            return -node.height;
        else
            return ((AVLTreeNode)node.right).height - ((AVLTreeNode)node.left).height;
    }

    @Override
    public boolean delete(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current != null){
            if(current.element.compareTo(e) > 0){
                parent = current;
                current = current.left;
            }
            else if(current.element.compareTo(e) < 0){
                parent = current;
                current = current.right;
            }
            else
                break;
        }
        if(current == null)
            return false;

        if(current.left == null){
            if(parent.left == current)
                parent.left = current.right;
            else
                parent.right = current.right;
            balancePath(parent.element);
        }

        else{
            TreeNode<E> rightMost = current.left;
            TreeNode<E> parentOfRightMost = current;
            while(rightMost != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if(parentOfRightMost == current)
                parentOfRightMost.left = rightMost.left;
            else
                parentOfRightMost.right = rightMost.left;
        }
        size--;
        return true;
    }

    protected class AVLTreeNode<E extends Comparable<E>> extends TreeNode<E> {
        protected int height;
        public AVLTreeNode(E e) {
            super(e);
        }
    }

}




