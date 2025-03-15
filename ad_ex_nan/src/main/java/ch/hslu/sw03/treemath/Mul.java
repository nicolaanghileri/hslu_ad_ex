package ch.hslu.sw03.treemath;

public class Mul implements ExpressionNode{

    private final ExpressionNode left;

    private final ExpressionNode right;

    public Mul(ExpressionNode left, ExpressionNode right){
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
        return left.getValue() * right.getValue();
    }

    @Override
    public String toString(){
        return "[" + this.left.toString()+ " * " + this.right.toString() +"]";
    }
    
}
