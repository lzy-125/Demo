package Org;
//栈溢出demo
public class Stack{
    public static void OverStack(){
        OverStack();
    }

    public static void main(String[] args) {
        OverStack();
    }
}
