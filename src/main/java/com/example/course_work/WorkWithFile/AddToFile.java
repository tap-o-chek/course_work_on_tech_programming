package com.example.course_work.WorkWithFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddToFile {

    // пишем в файл с помощью BufferedWriter
    public static void WriteToFile(String data) {
        File file = new File("C:\\Users\\Sofia\\IdeaProjects\\Course_Work\\made.txt");

        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        try{
            int noOfLines=1;
            file_writer = new FileWriter(file, true);
            buffered_writer = new BufferedWriter(file_writer);
            buffered_writer.append("ID, FirstName, LastName, Profession");

            for(int i = noOfLines; i > 0; i--)
            {
                buffered_writer.newLine(); //перенос строки
                buffered_writer.write(data); //запись строки в файл
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                buffered_writer.close();
                file_writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}