package HomeWork;

    enum Color {
        RED,
        BLACK
    }
    class SimpleNode {
        int value;
        Color color;
        SimpleNode left;
        SimpleNode right;

        SimpleNode(int value, Color color) {
            this.value = value;
            this.color = color;
            this.left = null;
            this.right = null;
        }
    }

    public class homeWork_2 {

        public static void printTree(SimpleNode node, String prefix) {
            if (node != null) {
                System.out.println(prefix + node.value + "(" + node.color + ")");
                printTree(node.left, prefix + "-");
                printTree(node.right, prefix + "-");
            }
        }

        public static SimpleNode add(SimpleNode root, int value) {
            root = addRecursive(root, value);
            root.color = Color.BLACK; // Корень дерева
            return root;
        }

        private static SimpleNode addRecursive(SimpleNode node, int value) {
            if (node == null) {
                return new SimpleNode(value, Color.RED); // Вставляем новый красный узел (ноду)
            }

            if (value < node.value) {
                node.left = addRecursive(node.left, value);
            } else if (value > node.value) {
                node.right = addRecursive(node.right, value);
            }

            // Выполняем операции балансировки
            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }
            if (isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
            }
            if (isRed(node.left) && isRed(node.right)) {
                flipColors(node);
            }

            return node;
        }

        private static boolean isRed(SimpleNode node) {
            return node != null && node.color == Color.RED;
        }

        private static SimpleNode rotateLeft(SimpleNode parent) {
            SimpleNode rightChild = parent.right;
            parent.right = rightChild.left;
            rightChild.left = parent;
            rightChild.color = parent.color;
            parent.color = Color.RED;
            return rightChild;
        }

        private static SimpleNode rotateRight(SimpleNode parent) {
            SimpleNode leftChild = parent.left;
            parent.left = leftChild.right;
            leftChild.right = parent;
            leftChild.color = parent.color;
            parent.color = Color.RED;
            return leftChild;
        }

        private static void flipColors(SimpleNode node) {
            node.color = Color.RED;
            node.left.color = Color.BLACK;
            node.right.color = Color.BLACK;
        }

        public static void main(String[] args) {
            SimpleNode root = null;

            root = add(root, 10);
            root = add(root, 5);
            root = add(root, 15);
            root = add(root, 3);
            root = add(root, 7);
            root = add(root, 13);
            root = add(root, 17);
            root = add(root, 1);
            root = add(root, 9);
            root = add(root, 12);
            root = add(root, 14);

            printTree(root, "");
        }
    }

// Результат вывода:

//           10(B)
//        /        \
//      5(B)        15(B)
//     /   \        /   \
//   3(B)   9(B)   13(R)  17(B)
//  /       /      /   \
// 1(R)   7(R)  12(B)  14(B)

