package org.ioc.controller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileHandler {
    public static String login;
    public static String pass;
    public static String dek_name;
    public static String ID_user;
    public static void main() {
        try {
            File myObj = new File("src/main/resources/org/ioc/property/Creds.txt");
            Scanner myReader = new Scanner(myObj);
            login = myReader.nextLine();
            pass = myReader.nextLine();
            dek_name = myReader.nextLine();
            ID_user = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void NewLogin(String OldData, String NewData) throws IOException {
        //Instantiating the File class
        String filePath = "src/main/resources/org/ioc/settings/Config.xml";
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        String oldLine = OldData;
        String newLine = NewData;
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }
    public static void NewCreds(String Newfile) throws IOException {
        //Instantiating the File class
        String filePath = Newfile;
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        //closing the Scanner object
        sc.close();
        try {
            FileWriter writer = new FileWriter("src/main/resources/org/ioc/property/Creds.txt", false);
            writer.write(fileContents);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
