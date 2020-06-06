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
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
    // Write your code here
    int c=0;
    Collections.sort(stocksProfit);
    int i=0;
    while(i<stocksProfit.size()-1)
    {
        if(stocksProfit.get(i)>target)
        break;
        
        if(i!=0 && stocksProfit.get(i)==stocksProfit.get(i-1))
        {
            i++;
            continue;
        }

        long other=target-stocksProfit.get(i);
        System.out.println(other);
        int l=i+1;
        int r=stocksProfit.size()-1;
        int flag=0;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(stocksProfit.get(mid)==other)
            {
                flag=1;
                break;
            }

            if(stocksProfit.get(mid)<other)
            l=mid+1;
            else
            r=mid-1;
        }

        if(flag==1 || stocksProfit.get(l)==other)
        c+=1;
        System.out.println(c);

        i++;
    }
        return c;
    }


}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long target = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
