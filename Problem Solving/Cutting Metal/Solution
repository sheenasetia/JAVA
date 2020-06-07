import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER costPerCut
     *  2. INTEGER salePrice
     *  3. INTEGER_ARRAY lengths
     */

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
    // Write your code here
  
        int maxLength = 0;
        for (int i=0;i<lengths.size();i++) {
            if (lengths.get(i) > maxLength) {
                maxLength = lengths.get(i);
            }
        }
        
        int maxProfit = 0;
        
        for (int i = 1; i < maxLength; i++) {
            
            int sumOfLengths = 0;
            int sumOfCutCounts = 0;
            int sumOfCutWastes = 0;
            
            for (int j=0;j<lengths.size();j++) {
                
                sumOfLengths += lengths.get(j);
                
                if (lengths.get(j) % i == 0) {
                    sumOfCutCounts += (lengths.get(j)/i - 1);
                } else {
                    sumOfCutCounts += (lengths.get(j)/i);
                }
                
                sumOfCutWastes += (lengths.get(j)%i);
            }
            
            int profit = sumOfLengths*salePrice - sumOfCutCounts*costPerCut - sumOfCutWastes*salePrice;
            
            if (profit > maxProfit) {
                maxProfit  = profit;
            }
        }
        
        return maxProfit;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int costPerCut = Integer.parseInt(bufferedReader.readLine().trim());

        int salePrice = Integer.parseInt(bufferedReader.readLine().trim());

        int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lengths = IntStream.range(0, lengthsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maxProfit(costPerCut, salePrice, lengths);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
