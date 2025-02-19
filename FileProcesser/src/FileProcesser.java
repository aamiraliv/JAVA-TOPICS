import jdk.jfr.SettingControl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ThreadReader extends Thread{
    private String inputFile;
    private List<String> names;
    public ThreadReader(String inputFile ,List<String > names){
        this.inputFile = inputFile;
        this.names = names;
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine())!=null){
                synchronized (names){

                    names.add(line.trim());
                    System.out.println("read line : " + line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadProcesser extends Thread{
    private List<String> names;
    public ThreadProcesser(List<String > names){
        this.names = names;
    }
    @Override
    public void run() {
        synchronized (names){
            List<String > ProcessedNames = (List<String>) names.stream()
                    .map(String::toUpperCase)
                    .distinct()
                    .sorted()
                    .toList();
            names.clear();
            names.addAll(ProcessedNames);
        }
    }
}

class ThreadWriter extends Thread{
    private String outputFile;
    List<String > names;
    public ThreadWriter(String outputFile,List<String > names){
        this.names = names;
        this.outputFile = outputFile;
    }
    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            System.out.println("Names to be written: " + names);
            for (String name : names){
                System.out.println("wrting to file: "+ name);
                bw.write(name);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class FileProcesser {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the input file name - including the file type: ");
        String inputFileName = s.nextLine();
        String outputFileName = "output.txt";
        List<String > names = Collections.synchronizedList(new ArrayList<>());

        Thread rThread = new ThreadReader(inputFileName,names);
        Thread pThread = new ThreadProcesser(names);
        Thread wThread = new ThreadWriter(outputFileName,names);

        rThread.start();
        try {
            rThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ReadThread finished.");


        pThread.start();
        try {
            pThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Process finished.");



        wThread.start();
        try {
            wThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("writing finished.");


        System.out.println("\n processed names writed to the output.txt file");
    }
}
