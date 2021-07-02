
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Laze {

    public static void main(String []args) throws IOException {

        // we are going to store the scores here
        // declaring a float list of size
        float[] scores = new float[7];

        // this part here is used to read from the console 7 times
        // if you know of a different way to read from the console use that way
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < scores.length; i++){
            // the Float.parseFloat will convert the string you read from the console to a float
            // not that the program will crash if you provide something that is not a number/float
          scores[i] = Float.parseFloat(reader.readLine());
        }

        // read and store the degree of difficulty
        float degreeOfDifficulty = Float.parseFloat(reader.readLine());

        // now that we have the have all the scores we need to find the min and max score
        // and ignore them because they are thrown out

        // we init a variable to the lowest possible value for floats
        float min = Float.MIN_VALUE;
        // here we will store the position of the minimum (where the min is in the list)
        int minPosition = -1;

        for(int i = 0; i < scores.length; i++){
            if(min < scores[i]){
                minPosition = i;
            }
        }

        // do the same but this time for the maximum
        float max = Float.MIN_VALUE;
        // here we will store the position of the minimum (where the min is in the list)
        int maxPosition = -1;

        for(int i = 0; i < scores.length; i++){
            if(scores[i] > max){
                maxPosition = i;
            }
        }

        // now we have to find the total by ignoring the min and max and multiplying it with the degree of difficulty
        // we will store the total here
        float result = 0;

        for(int i = 0; i < scores.length; i++){
            // if we are processing the min or max, simple ignore them and go to the next element in the list
            if(i == maxPosition || i == minPosition){
                continue;
            }

            //otherwise add the scores
            // result += scores[i]; is the same as writing result = result + scores[i]
            result += scores[i];
        }

        //finally we have to multiply the added points with the degree of difficulty and preint the result

        float toPrintResult = result * degreeOfDifficulty;
        System.out.println(String.format(Locale.US, "Total: %f", toPrintResult));
    }
}
