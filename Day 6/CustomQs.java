import java.util.*;
import java.lang.*;
import java.io.*;

class CustomsQs{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> arr = new ArrayList<String>(); 
        int count = 0;
        String st; 
        while ((st = br.readLine()) != null){
            
            //if newline then test the string array
            if(st.trim().isEmpty()){
                count += countAllYes(arr);

                arr.clear();
            }
            else{
                arr.add(st);
                System.out.println(st);
            }
        }
        count += countAllYes(arr);
        System.out.println(count);
        return;
    }

    public static int countAllYes(ArrayList<String> arr){

        HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
        for(int i = 0; i < arr.get(0).length(); i++){
            h1.add(arr.get(0).charAt(i));
        }


        for(int i = 0; i < arr.size(); i++){

            for(int j = 0; j < arr.get(i).length(); j++){
                h2.add(arr.get(i).charAt(j));
            }
            h1.retainAll(h2);
            h2.clear();
        }

        return h1.size();
    }



    public static int countYes(ArrayList<String> arr){

        ArrayList<Character> ch = new ArrayList<Character>();

        //iterate through all strings in the group
        for(int i = 0; i < arr.size(); i++){
            //go through each char in the string
            for(char c: arr.get(i).toCharArray()){
                if(!ch.contains(c)){
                    ch.add(c);
                }
            }
        }

        return ch.size();
    }


}

