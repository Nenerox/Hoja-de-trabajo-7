public class BST<E extends Comparable<E>> {
    private BinaryTree<E> root;  

    public BST() {
        this.root = null;
    }

    // Insertion operation
    public void insert(E key) {
        root = insertRec(root, key);
    }

    private BinaryTree<E> insertRec(BinaryTree<E> root, E key) {
        if (root == null) {
            return new BinaryTree<>(key);
        }
        if (key.compareTo(root.value()) < 0){
            root.setLeft(insertRec(root.left(), key));
        }else if (key.compareTo(root.value()) > 0) {
            root.setRight(insertRec(root.right(), key));
        }
        return root;
    }

    // Deletion operation
    public void delete(E key) {
        root = deleteRec(root, key);
    }

    private BinaryTree<E> deleteRec(BinaryTree<E> root, E key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.value()) < 0) {
            root.setLeft(deleteRec(root.left(), key));
        } else if (key.compareTo(root.value()) > 0) {
            root.setRight(deleteRec(root.right(), key));
        } else {
            if (root.left() == null) {
                return root.right();
            } else if (root.right() == null) {
                return root.left();
            }
            root.setValue(minValue(root.right()));
            root.setRight(deleteRec(root.right(), root.value()));
        }
        return root;
    }

    private E minValue(BinaryTree<E> root) {
        E minv = root.value();
        while (root.left() != null) {
            minv = root.left().value();
            root = root.left();
        }
        return minv;
    }

    // Search operation
    public BinaryTree<E> search(E key) {
        return searchRec(root, key);
    }

    private BinaryTree<E> searchRec(BinaryTree<E> root, E key) {
        if (root == null) {
            return null;
        }
        if (root.value().equals(key)) { 
            return root;
        }
        if (root.value().compareTo(key) < 0) {
            return searchRec(root.right(), key);
        }
        return searchRec(root.left(), key);
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BinaryTree<E> root) {
        if (root != null) {
            inorderRec(root.left());
            System.out.print(root.value() + " ");
            inorderRec(root.right());
        }
    }
}