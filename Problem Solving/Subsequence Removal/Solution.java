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
     * Complete the 'findSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> findSubsequence(List<Integer> arr) {
    // Write your code here
        int prev=Integer.MIN_VALUE;
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> al=new ArrayList<>();
        int i=0;
        for(i=0;i<arr.size();i++)
        {
            if(al.contains(arr.get(i)))
            {
                if(arr.get(i)>=prev)
                {
                    res.add(arr.get(i));
                    prev=arr.get(i);    
                }
                else
                {
                    res.clear();
                    break;
                }
                
            }
            else
            {
                al.add(arr.get(i));
            }

        }

        if(res.size()==0 && i!=arr.size())
        res.add(-1);
        return res;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.findSubsequence(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
