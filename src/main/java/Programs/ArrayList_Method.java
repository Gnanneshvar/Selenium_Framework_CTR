package Programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList_Method {
    public static void main(String args[])
    {
        List<Integer> listArr = new ArrayList<>();
        listArr.add(10);
        listArr.add(20);
        listArr.add(40);
        listArr.add(25);
        listArr.add(38);
        listArr.add(15);
        listArr.add(null);
        Iterator<Integer> it = listArr.iterator();
        System.out.println("Using Iterator::");
        while(it.hasNext())
            System.out.print(it.next() +"  ");

        System.out.println("Using For Each");
        //for(int val:listArr)
        for(int i=0;i<listArr.size();i++)
        {
            //System.out.print(val+" ");
            System.out.print(listArr.get(i)+" ");
        }
    }
}
