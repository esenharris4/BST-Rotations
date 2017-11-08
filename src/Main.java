
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        ArrayList<Integer> intElements = new ArrayList<>(Arrays.asList(3,1,4,1,5,9,2,6));
        ArrayList<String> strElements = new ArrayList<>(Arrays.asList("Hi","Aardvark","Buy","me"));
        ArrayList<Integer> testElements = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1));
        ArrayList<Integer> targetElements = new ArrayList<>(Arrays.asList(2,1,3,5,8,6,7,9,4));
        BST<Integer> intTest = new BST<>(intElements);
        BST<String> strTest = new BST<>(strElements);
        BST<Integer> Elements = new myBST<>(testElements);
        BST<Integer> target =  new myBST<>(targetElements);
        ArrayList<BstRotation> rot;// = new ArrayList<>();

        System.out.println("Your int BST is:\n"+intTest);
        System.out.println("... right subtree:\n"+intTest.getRight());
        System.out.println("Your string BST is:\n"+strTest);
        System.out.println("One rotation: "+new BstRotation(3, BstRotation.RotationType.ZAG));

        System.out.println(  Elements);
        System.out.println( target);
        System.out.println("elements" + target.getKey());
        rot = Elements.transformTo(target);
        System.out.println(rot);



    }
}
