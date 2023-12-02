import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class part1 {
    public static void main(String[] args) throws Exception {
        List<String> input = Files.readAllLines(Path.of("input.txt"));
        int sum = 0;

        List<int[]> games = input.stream().map((s) -> {
            String[] a = s.split(": ")[1].split("; ");

            int maxRed = -1;
            int maxGreen = -1;
            int maxBlue = -1;
            for(String str : a) {
                for(String color : str.split(", ")) {
                    int number = Integer.parseInt(color.split(" ")[0]);
                    if(color.contains("red") && maxRed < number) {
                        maxRed = number;
                    } else if(color.contains("green") && maxGreen < number) {
                        maxGreen = number;
                    } else if(color.contains("blue") && maxBlue < number) {
                        maxBlue = number;
                    }
                }
            }

            return new int[]{maxRed, maxGreen, maxBlue};
        }).toList();

        for(int i = 0; i < games.size(); i++) {
            int[] s = games.get(i);
            if(s[0] < 13 && s[1] < 14 && s[2] < 15) {
                sum = sum + i + 1;
            }
        }

        System.out.println(sum);
    }
}