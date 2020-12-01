import java.util.*;
import java.lang.*;
import java.io.*;

class ProductFinder{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        
        String st; 
        while ((st = br.readLine()) != null){
            // System.out.println(st);
            arr.add(Integer.parseInt(st));
        } 

        twoProduct(arr);
        threeProduct(arr);
        return;
    }

    public static int twoProduct(ArrayList<Integer> arr){
                for(int i = 0; i < arr.size(); i++){
                    for(int j = 1; j < arr.size(); j++){
                        if(arr.get(i) + arr.get(j) == 2020){
                            int product = arr.get(i) * arr.get(j);
                            System.out.println(product);
                            return product;
                        }
                    }
                }
                return 0;
    }

    public static int threeProduct(ArrayList<Integer> arr){
                for(int i = 0; i < arr.size(); i++){
                    for(int j = 1; j < arr.size(); j++){
                        for(int k = 2; k < arr.size(); k++){
                            if(arr.get(i) + arr.get(j) + arr.get(k) == 2020){
                                int product = arr.get(i) * arr.get(j) * arr.get(k);
                                System.out.println(product);
                                return product;
                            }
                        }
                    }
                }
                return 0;
    }
}

