package ch.hslu.sw03.treemath;

public class Number implements ExpressionNode{

    private final int value;

    public Number(){
        this.value = 0;
    }

    public Number(int value){
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString(){
        return Integer.toString(this.value);
    }
    
}
