package ch.hslu.sw03.treemath;

public class Add implements ExpressionNode {

    private final ExpressionNode left;

    private final ExpressionNode right;

    public Add(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return left.getValue() + right.getValue();
    }

    @Override
    public String toString() {
        return "(" + this.left.toString() + " + " + this.right.toString() + ")";
    }

}
