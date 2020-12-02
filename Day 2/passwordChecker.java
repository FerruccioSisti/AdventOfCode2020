import java.util.*;
import java.lang.*;
import java.io.*;

class PasswordChecker{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        int totalValid = 0;
        
        String st; 
        while ((st = br.readLine()) != null){
            if(isValid2(st)){
                totalValid ++;
            }
        } 

        System.out.println(totalValid);
        return;
    }

    public static boolean isValid(String s){
                //get the min and max
                int min = Integer.parseInt(s.split("-")[0]);
                int max = Integer.parseInt(s.split("-")[1].split(" ")[0]);
                int counter = 0;
                char policyLetter = s.split(" ")[1].split(":")[0].charAt(0);
                
                //go through each character in the string
                for(char c: s.split(" ")[2].toCharArray()){
                    if(c == policyLetter){
                        counter++;
                    }
                    if(counter > max){
                        return false;
                    }
                }

                if(counter < min){
                    return false;
                }

                return true;
    }


    public static boolean isValid2(String s){
        //get the pos 1 and pos 2
        int pos1 = Integer.parseInt(s.split("-")[0]);
        int pos2 = Integer.parseInt(s.split("-")[1].split(" ")[0]);

        char policyLetter = s.split(" ")[1].split(":")[0].charAt(0);
        String message = s.split(" ")[2];

        if((message.charAt(pos1 - 1) == policyLetter && message.charAt(pos2 - 1) != policyLetter) ^ (message.charAt(pos1 - 1) != policyLetter && message.charAt(pos2 - 1) == policyLetter)){
            return true;
        }
        else{
            return false;
        }
    }
}

