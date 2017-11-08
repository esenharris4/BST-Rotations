
import java.util.ArrayList;

public class myBST<keyType extends Comparable<keyType> > extends BST<keyType> {
    public ArrayList<BstRotation> pathrotations = new ArrayList<>();
    public ArrayList<BstRotation> rotations = new ArrayList<>();
    public myBST(Iterable<keyType> keys){
        super(keys);
    }

    @Override
    public ArrayList<BstRotation> transformTo(BST<keyType> otherTree) {
        BST<keyType> root = this;
        root = newTree(root, otherTree);
        return this.rotations;
    }

    private BST<keyType> newTree(BST<keyType> root, BST<keyType> otherTree){
        ArrayList<BstRotation> path;
        if (root.key == null){
            System.out.println("null");
            return root;
        }
        else {
            pathrotations = search(root,otherTree);
            root = rotate(root,this.pathrotations);
            this.rotations.addAll(pathrotations);
            this.pathrotations.clear();
            if (root.right != null) {
                return newTree(root.right,otherTree.right);
            } else if (root.left != null) {
                return newTree(root.left,otherTree.left);
            }
            else{
                return root;

            }
        }
    }

    private ArrayList<BstRotation> search(BST<keyType> original, BST<keyType> target) {

        if(original.key.compareTo(target.key)==0) {
            return this.pathrotations;//nodeRotations;
        }
        else if(original.key.compareTo(target.key) > 0){//nodekey > target key
            if(original.left == null){
                System.out.println("null");
                return null;
            }
            else {
                this.pathrotations.add(new BstRotation(original.nodeId, BstRotation.RotationType.ZIG));
                return search(original.left, target);
            }
        }
        else if(original.key.compareTo(target.key) < 0) {
            if (original.right == null) {
                System.out.println("null");
                return null;
            }
            else {
                this.pathrotations.add(new BstRotation(original.nodeId, BstRotation.RotationType.ZAG));
                return search(original.right, target);
            }
        }
        return null;
    }


    public BST<keyType> rotate(BST<keyType> root, ArrayList<BstRotation> rotations ){

        for(BstRotation x: rotations){
            String rot =x.toString();
            rot = rot.substring(0,3);
            if (rot.equals("ZIG")){
                root = zig(root);
            }
            else {
                root = zag(root);
            }
        }
        return root;
    }

    private BST<keyType> zig(BST<keyType> node){

        BST<keyType> x;
        BST<keyType> y;
        BST<keyType> lambda;
        BST<keyType> beta;
        BST<keyType> alpha;
        y = node;
        x = node.left;
        alpha = node.left.getLeft();//left subtree of x
        beta = node.left.getRight();//right subtree of x
        lambda = node.getRight();//right subtree of y
        x.right = y;
        x.left = alpha;
        y.left = beta;
        y.right = lambda;
        //res-assign node
        return x;
    }

    private BST<keyType> zag(BST<keyType> node){

        BST<keyType> x;
        BST<keyType> y;
        BST<keyType> lambda;
        BST<keyType> beta;
        BST<keyType> alpha;
        y = node.right;
        x = node;
        alpha = node.getLeft();//left subtree of x
        beta = node.right.getLeft();//left subtree of y
        lambda = node.right.getRight();//right subtree of y
        y.right = lambda;
        y.left = x;
        x.left = alpha;
        x.right = beta;
        //res-assign node
        return y;
    }
}
