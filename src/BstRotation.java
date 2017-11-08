/**
 * Represents one rotation (ZIG or ZAG) around one key in a Binary Search Tree
 */
public class BstRotation {
    public enum RotationType {ZIG, ZAG}

    public BstRotation(Integer myRotRootID, RotationType myRotType) {
        rotRootID = myRotRootID;
        rotType = myRotType;
    }

    /**
     * @return A human-readable description of the rotation
     */
    public String toString() {
        String result = "";
        switch (rotType) {
            case ZIG:
                result = "ZIG";
                break;
            case ZAG:
                result = "ZAG";
                break;
        }
        result += " on node ID "+ rotRootID;
        return result;
    }

    private final Integer rotRootID;           // the ID of the root of the rotation being performed
    private final RotationType rotType;      // the type of rotation being performed
}
