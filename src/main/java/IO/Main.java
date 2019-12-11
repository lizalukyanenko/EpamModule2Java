package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File originalFile = new File("D:/Преддипломная практика/!Характеристика.docx");
        try(FileWriter fileWriter = new FileWriter("tree.txt", false))
        {
            if (originalFile.isFile()) {
                File folder = originalFile.getParentFile();
                System.out.println(readWriteFiles(folder, fileWriter));
            }
            if (originalFile.isDirectory()) {
                readWriteFiles(originalFile, fileWriter);
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String readWriteFiles(File baseDirectory, FileWriter fileWriter) throws IOException {
        int countFile = 0;
        int countFolder = 0;
        int lenFiles = 0;
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles()) {
                if(file.isFile()){
                    countFile++;
                    fileWriter.append('\n');
                    fileWriter.write("|   " + file.getName());
                    lenFiles += file.getName().length();
                }else {
                    countFolder++;
                    fileWriter.append('\n');
                    fileWriter.write("|---" + file.getName());
                    readWriteFiles(file, fileWriter);
                }
            }
        }
        return "Количество каталогов: " + countFolder + "\nКоличество файлов: " + countFile + "\nСредняя длина имени файла: " + lenFiles/countFile;
    }
}
