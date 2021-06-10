package Org;

import java.util.ArrayList;
import java.util.List;

//堆溢出demo
public class Heap {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        while (true) {
            list.add(new Heap());
        }
    }
}
