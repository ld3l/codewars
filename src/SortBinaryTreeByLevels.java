import java.util.ArrayList;
import java.util.List;
//
// ###TASK###
// Your task is to return the list with elements from tree sorted by levels, which means the root element goes first, then root children (from left to right) are second and third, and so on.
// Comment. The best solutions use a similar approach, but more correct collections for storing intermediate results, such as ArrayDeque


class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(Node l, Node r, int v) {
        left = l;
        right = r;
        value = v;
    }
}

public class SortBinaryTreeByLevels {
    public static List<Integer> treeByLevels(Node node) {
        List<Integer> result = new ArrayList<>();
        List<Node> threeAsList = new ArrayList<>();
        if (node != null) {
            threeAsList.add(node);

            for (int i = 0; i < threeAsList.size(); i++) {

                Node n = threeAsList.get(i);
                result.add(n.value);
                if (n.left != null) {
                    threeAsList.add(n.left);
                }
                if (n.right != null) {
                    threeAsList.add(n.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)).forEach(System.out::print);
    }
}