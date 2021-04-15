public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChildren;
        private AVLNode rightChildren;

        public AVLNode(int value) {
            this.value = value;
        }

        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            insert(root.leftChildren, value);
        else
            insert(root.rightChildren, value);

        root.height = Math.max(
                height(root.leftChildren),
                height(root.rightChildren),
                );

        var balanceFactor = balanceFactor(root);

        if (isLeftNodeHeavy(root)) {
            System.out.println("tree is left heavy");
        } else if (isRightNodeHeavy(root)) {
            System.out.println("tree is right heavy");
        }

        return root;
    }

    private void balance(AVLNode root) {
        var balanceFactor = balanceFactor(root);

        if (isLeftNodeHeavy(root)) {
            if (balanceFactor(root.rightChildren) > 0) {
                System.out.println("Left Rotate" + root.leftChildren.value);
            }
            System.out.println("Right Rotate" + root.value);
        } else if (isRightNodeHeavy(root)) {
            if (balanceFactor(root.rightChildren) > 0) {
                System.out.println("Right Rotate" + root.rightChildren.value);
            }
            System.out.println("Left Rotate" + root.value);
        }

    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChildren) - height(node.rightChildren);
    }

    private boolean isRightNodeHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftNodeHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private int height(AVLNode node) {
        return node != null ? node.height : -1;
    }
}
