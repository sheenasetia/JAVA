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
     //Solution Approach
    /*
           N(0)
           |
           |
   W(3)---------- E(1)
           |
           |
           S(2) 


    Approach :
    initial dir=0 && pos=(0,0)

                G       L       R
    if(dir==0)  y+1     dir=3   dir=1
    if(dir==1)  x+1     dir=0   dir=2
    if(dir==2)  y-1     dir=1   dir=3
    if(dir==3)  x-1     dir=2   dir=0

    */
    public static List<String> doesCircleExist(List<String> commands) {
    // Write your code here
    List<String> res=new ArrayList<>();
    for(int i=0;i<commands.size();i++)
    {
        int x = 0, y = 0; 
        int dir = 0;
        int flag=0;

        //runs infinitely
        while(true)
        {
            for(int j=0;j<commands.get(i).length();j++)
            {
                char move=commands.get(i).charAt(j);

                if (move == 'R') 
                    dir = (dir + 1)%4; 
                else if (move == 'L') 
                    dir = (4 + dir - 1) % 4; 
                else
                { 
                    if (dir == 0) 
                        y++; 
                    else if (dir == 1) 
                        x++; 
                    else if (dir == 2) 
                        y--; 
                    else 
                        x--; 
                } 

            }

            
            if(x==0 && y==0)        //caught back to origin
            {
                flag=1;
                break;
            }
            else if(dir==0 && !(x==0 && y==0))      //caught back to north direction again but not to origin that is, now we are never gonna meet the origin again i.e no circle
            {
                break;
            }   
        }
            if(flag==1)
            res.add("YES");
            else 
            res.add("NO");
        }

    return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> commands = IntStream.range(0, commandsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.doesCircleExist(commands);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
