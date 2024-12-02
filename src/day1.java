import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day1 implements Solution{

    public void solve(String[] args) {
        BufferedReader inStream;
        String fileName = "./src/files/day1Input.txt";
        String line;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        String[] tempStrings;

        int similarityScore = 0;
        int totalDistance = 0;

        try {
            inStream = new BufferedReader(new FileReader(fileName));
            //line = inStream.readLine();
            while ((line = inStream.readLine())  != null) {
                tempStrings = line.split(" {3}");
                left.add(Integer.parseInt(tempStrings[0]));
                right.add(Integer.parseInt(tempStrings[1]));
            }
        } catch (IOException err) {
            System.out.println(err.getCause());
        }

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        for(int x = 0; x < left.size(); x++) {
            totalDistance += Math.abs(left.get(x) - right.get(x));
            similarityScore += left.get(x) * Collections.frequency(right, left.get(x));
        }

        System.out.println("\tTotal Distance: " + totalDistance);
        System.out.println("\tSimilarity Score: " + similarityScore);
    }
}