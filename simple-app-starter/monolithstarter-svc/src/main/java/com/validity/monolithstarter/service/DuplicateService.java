package com.validity.monolithstarter.service;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;



import org.springframework.stereotype.Service;

@Service
public class DuplicateService{
    public static int calculate(String x, String y){
        if(x.isEmpty()){
            return y.length();
        }
        if(y.isEmpty()){
            return x.length();
        }
        int substitution = calculate(x.substring(1), y.substring(1)) + costOfSubstitution(x.charAt(0), y.charAt(0));

        int insertion = calculate(x, y.substring(1)) + 1;
        int deletion = calculate(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    public static int costOfSubstitution(char a, char b){
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers){
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    public static String getDuplicates(){
        List<String> data = new ArrayList<>();
        try{
             
            Scanner scanner = new Scanner(new File("simple-app-starter/test-files/normal.csv"));

            while(scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
            System.out.println(data);

            for(int x = 0; x < data.size() - 1; x++){
                
                System.out.println(calculate(data.get(x), data.get(x+1)));
            }
            
        }catch(Exception e){
          e.getStackTrace();
        }
        return data.toString();
    }
}
