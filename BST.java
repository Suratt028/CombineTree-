class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    // เมธอด combineTree เพื่อรวมสองต้นไม้เป็นต้นไม้เดียว
    public static TreeNode combineTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        // รวมค่าของโหนดที่ตำแหน่งเดียวกัน
        t1.val += t2.val;

        // รวมซ้ายและขวาแบบ recursive
        t1.left = combineTree(t1.left, t2.left);
        t1.right = combineTree(t1.right, t2.right);

        return t1;
    }

    // เมธอดเพื่อแสดงผลต้นไม้ในรูปแบบ Inorder
    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        // สร้าง tree t1
        TreeNode t1 = new TreeNode(9);
        t1.left = new TreeNode(6);
        t1.right = new TreeNode(14);
        t1.left.left = new TreeNode(9);
        t1.left.right = new TreeNode(2);
        t1.left.right.left = new TreeNode(4);
        t1.right.left = new TreeNode(11);

        // สร้าง tree t2
        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(-3);
        t2.right = new TreeNode(8);
        t2.left.left = new TreeNode(8);
        t2.left.right = new TreeNode(5);
        t2.left.right.left = new TreeNode(1);
        t2.right.left = new TreeNode(6);

        // เรียกใช้งานเมธอด combineTree
        TreeNode combinedTree = combineTree(t1, t2);

        // แสดงผลต้นไม้รวมที่ได้ในรูปแบบ Inorder
        System.out.print("Inorder traversal of combined tree: ");
        printInorder(combinedTree);
    }
}
