package com.example.course_work.WorkWithFile;

import com.example.course_work.Model.User;
import org.hibernate.dialect.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public static void UseScanner() throws IOException {
        // открываем файл
        String file_path = "C:\\Users\\Sofia\\IdeaProjects\\CourseWork\\test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file_path));

        // считываем построчно
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<User> empList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            User user = new User();
            scanner = new Scanner(line);
            scanner.useDelimiter(","); //указываем чем разделяются данные в файле

            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (index){
                    case 0:
                        user.setFirstName(data);
                        break;
                    case 1:
                        user.setLastName(data);
                        break;
                    case 2:
                        user.setProfession(data);
                        break;
                    default:
                        System.out.println("Некорректные данные::" + data);
                        break;
                }
                index++;
            }
            index = 0;
            empList.add(user);
        }
        //закрываем ридер
        reader.close();
    }
}
