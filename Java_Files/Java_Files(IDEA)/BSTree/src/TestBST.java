
import java.util.ArrayList;


public class TestBST {
    public static void main(String[] args){
        BST<String> tree = new BST<>();
        tree.insert("Gavin");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        System.out.println("Inorder:");
        tree.inorder();
        System.out.println("Postorder:");
        tree.postorder();
        System.out.println("Preorder:");
        tree.preorder();
        System.out.print("Is Peter in the tree?    ");
        System.out.println(tree.search("Peter"));
        System.out.println("\nA path from the root to Peter is: ");

        ArrayList<BST<String>.TreeNode<String>> path = tree.path(("Peter"));
        for(int i = 0; i < path.size() && path != null; i++){
            System.out.print(path.get(i).element + " ");
        }
        System.out.println("Delete Peter");
        tree.delete("Peter");
        tree.preorder();
    }
}
