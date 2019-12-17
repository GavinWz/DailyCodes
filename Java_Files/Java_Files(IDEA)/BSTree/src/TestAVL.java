public class TestAVL {
    public static void main(String[] args){
//        Integer[] list = {7,5,8,6,4,9,3,2};
        AVLTree<Integer> tree = new AVLTree<>(new Integer[] {7,5,8,6,4,9,3,2});
        tree.inorder();
    }

    public static void printTree(BST tree){

    }
}
