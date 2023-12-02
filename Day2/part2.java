import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class part2 {
    public static void main(String[] args) throws Exception {
        List<String> input = Files.readAllLines(Path.of("input.txt"));
        int sum = input.stream().map((s) -> {
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

            return maxRed * maxGreen * maxBlue;
        }).mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
