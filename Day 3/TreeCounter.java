import java.util.*;
import java.lang.*;
import java.io.*;

class TreeCounter{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> arr = new ArrayList<String>();
        
        String st; 
        while ((st = br.readLine()) != null){
            // System.out.println(st);
            arr.add(st);
        } 

        int a1 = treeCollisionCounter(arr, 1, 1);
        int a2 = treeCollisionCounter(arr, 3, 1);
        int a3 = treeCollisionCounter(arr, 5, 1);
        int a4 = treeCollisionCounter(arr, 7, 1);
        int a5 = treeCollisionCounter(arr, 1, 2);
        
        //for some reason this gives the wrong number? If you multiply each one on a calculator you get the right answer so not sure why this is overflowing
        long ans = a1 * a2 * a3 * a4 * a5;
        System.out.println(a1 + " " + a2 + " "  + a3 + " " + a4 + " " + a5 + " " + ans);
        
        return;
    }

    public static int treeCollisionCounter(ArrayList<String> arr, int right, int down){
        int rows = arr.size(), columns = arr.get(0).length(); //each string is a row in our map
        int position = right, count = 0;
        for(int i = down; i < rows; i+=down){
            if(arr.get(i).charAt(position) == '#'){
                count++;
                System.out.println(count + " " + i + " " + position);
            }
            position += right;
            position %= columns;
        }

        return count;
    }

}

