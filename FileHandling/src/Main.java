import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("settings.txt"));
        bw.write("name = amir\n");
        bw.write("age = 22\n");
        bw.close();
        System.out.println("successfully writed in to the file named settings.txt");

        BufferedReader br = new BufferedReader(new FileReader("settings.txt"));
        String lines ;
        while((lines = br.readLine())!= null){
            System.out.println(lines);
        }
    }
}
