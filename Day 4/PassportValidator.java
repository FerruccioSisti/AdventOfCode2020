import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PassportValidator{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> grouped = new ArrayList<String>();
        int count = 0;
        String st, test = ""; 
        while ((st = br.readLine()) != null){
            // System.out.println(st);
            arr.add(st);
            //if on an empty line then check if passport is valid
            if(st.trim().isEmpty()){
                //do manipulation
                Pattern p = Pattern.compile("/^byr:[0-9]{4}");
                Matcher m = p.matcher("byr:4400");
                Matcher m1 = p.matcher("byr4");
                if(m.find())
                {
                    System.out.println("test1");
                }

                if(m1.find())
                {
                        System.out.println("test2");
                }

                // if(test.contains("byr") && test.contains("iyr") && test.contains("eyr") && test.contains("hgt") && test.contains("hcl") && test.contains("ecl") && test.contains("pid")){
                //     if(Integer.parseInt(test.split("byr")[1].split(":")[1].split(" ")[0]) <= 2003 && Integer.parseInt(test.split("byr")[1].split(":")[1].split(" ")[0]) <= 1920){
                //         if(Integer.parseInt(test.split("iyr")[1].split(":")[1].split(" ")[0]) <= 2020 && Integer.parseInt(test.split("iyr")[1].split(":")[1].split(" ")[0]) >= 2010){
                //             if(Integer.parseInt(test.split("eyr")[1].split(":")[1].split(" ")[0]) <= 2030 && Integer.parseInt(test.split("eyr")[1].split(":")[1].split(" ")[0]) >= 2020){
                //                 if(test.split("hgt")[1].split(":")[1].split(" ")[0].contains("cm") || test.split("hgt")[1].split(":")[1].split(" ")[0].contains("in")){

                //                 }
                //             }
                //         }
                //     }
                    
                //     count++;                    
                // }
                test = "";
                
            }
            else{
                //System.out.println(test + " blank " + st);
                test += " " + st;
            }
        } 

        // Need to check last line after reading input has finished
        if(test.contains("byr") && test.contains("iyr") && test.contains("eyr") && test.contains("hgt") && test.contains("hcl") && test.contains("ecl") && test.contains("pid")){
            count++;
        }

        // String temp = "";
        // for(int i = 0; i < arr.size(); i++){
            
        //     if(arr.get(i).trim().isEmpty()){
        //         grouped.add(temp);
        //         temp = "";
        //     }
        //     else{
        //         temp += arr.get(i);
        //     }
            
        // }

        // for(int i = 0; i < grouped.size(); i++){
        //     System.out.println(grouped.get(i) + "\n\n");
        // }

        // for(int i = 0; i < grouped.size(); i++){
        //     if(grouped.get(i).contains("byr") && grouped.get(i).contains("iyr") && grouped.get(i).contains("eyr") && grouped.get(i).contains("hgt") && grouped.get(i).contains("hcl") && grouped.get(i).contains("ecl") && grouped.get(i).contains("pid")){
        //         count++;
        //         System.out.println(grouped.get(i) + "\n\n");
        //     }
        // }

        System.out.println(count);
        return;
    }


}

