import java.util.*;
import java.lang.*;
import java.io.*;

class SeatFinder{
    public static void main(String args[]) throws Exception{

        File file = new File(args[0]); 
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Double> arr = new ArrayList<Double>(); 
        double highestID = 0, temp = 0;
        String st; 
        while ((st = br.readLine()) != null){
            temp = findID(st);
            if(temp > highestID){
                highestID = temp;
            }
            arr.add(temp);
        } 
        System.out.println(highestID);
        System.out.println(findSeat(arr));

        return;
    }

    public static double findSeat(ArrayList<Double> arr){
        for(int i = 0; i < arr.size(); i++){
            if(arr.contains(arr.get(i) + 2) && !arr.contains(arr.get(i) + 1)){
                return (arr.get(i) + 1);
            }
            else if(arr.contains(arr.get(i) - 2) && !arr.contains(arr.get(i) - 1)){
                return (arr.get(i) - 1);
            }
        }
        return 0;
    }

    public static double findID(String s){
                //iterate through every character
                double lowRow = 0, maxRow = 127, lowCol = 0, maxCol = 7;
                double row = 0;
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    //go to lowerbound range
                    if(c == 'F'){
                        maxRow = maxRow - Math.floor((maxRow - lowRow) / 2) - 1;
                    }
                    else if(c == 'B'){
                        lowRow = lowRow + Math.floor((maxRow - lowRow) / 2) + 1;
                    }
                    else if(c == 'L'){
                        if(s.charAt(i - 1) == 'F'){
                            row = lowRow;
                        }
                        else if(s.charAt(i - 1) == 'B'){
                            row = maxRow;
                        }
                        maxCol = maxCol - Math.ceil((maxCol - lowCol) / 2);
                    }
                    else if(c == 'R'){
                        if(s.charAt(i - 1) == 'F'){
                            row = lowRow;
                        }
                        else if(s.charAt(i - 1) == 'B'){
                            row = maxRow;
                        }                        
                        lowCol = lowCol + Math.ceil((maxCol - lowCol) / 2);
                    }
                }
                double col = 0;
                if(s.charAt(s.length() - 1) == 'R'){
                    
                    col = maxCol;
                }
                else{
                    col = lowCol;
                }

                double id = (row * 8) + col;

                return id;
    }


}

