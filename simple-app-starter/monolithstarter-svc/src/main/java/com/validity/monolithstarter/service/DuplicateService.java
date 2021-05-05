package com.validity.monolithstarter.service;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;



import org.springframework.stereotype.Service;

@Service
public class DuplicateService{
    //"simple-app-starter/test-files/normal.csv"
    public int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
    
        for (int i = 0; i <= x.length(); i++) {
          for (int j = 0; j <= y.length(); j++) {
            if (i == 0) {
              dp[i][j] = j;
            }
            else if (j == 0) {
              dp[i][j] = i;
            }
            else {
              dp[i][j] = min(dp[i - 1][j - 1]
                              + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                      dp[i - 1][j] + 1,
                      dp[i][j - 1] + 1);
            }
          }
        }
    
        return dp[x.length()][y.length()];
      }
    
    public int costOfSubstitution(char a, char b){
        return a == b ? 0 : 1;
    }
    
    public int min(int... numbers){
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
    
    public String getDuplicates(){
        List<String> data = new ArrayList<>();
    
        JSONObject json = new JSONObject();
        try{
          Scanner scanner = new Scanner(new File("simple-app-starter/test-files/normal.csv"));
    
          while(scanner.hasNextLine()){
            String d = scanner.nextLine();
    
            d = d.replace(",", " ");
            data.add(d);
          }
          for(int x = 0; x < data.size() - 1; x++){
                for(int y = x+1; y < data.size() - 1; y++){
                int difference = calculate(data.get(x).substring(2), data.get(y).substring(2));
                    if(difference < 30){
        
                    System.out.println("LITTLE DIFFERENCE: " + difference+ " \n\t" + data.get(x).substring(2) + "\n\t" + data.get(y).substring(2));
                    json.put("Input 1", data.get(x).substring(2));
                    json.put("Input 2", data.get(y).substring(2));
                    }
                }
    
            }
    
        }catch(Exception e){
            e.getStackTrace();
        }
        System.out.println(json.toString());
        return json.toString();
    }
}
