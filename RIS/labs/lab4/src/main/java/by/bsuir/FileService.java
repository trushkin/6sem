package by.bsuir;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    private String fileName;

    public FileService(String fileName) {
        this.fileName = System.getProperty("my.jms.filefolder") + fileName;
    }

    public void writeToFile(String message) throws IOException {
        writeToFile(message, true);
    }

    public void writeToFile(String message, boolean appendFlag) throws IOException {
        Path path = Paths.get(fileName);
        System.out.println("Path: " + path.toAbsolutePath());
        System.out.println(message);
        PrintWriter printWriter = new PrintWriter(new FileWriter(path.toFile(), appendFlag));
        printWriter.write(message + "\n");
        printWriter.close();
    }

    public void deleteMessageFromFile(String messageToDelete) {
        List<String> messages;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            messages = stream
                    .filter(line -> !line.equals(messageToDelete))
                    .collect(Collectors.toList());
            writeToFile(String.join("\n", messages), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllMessages(){
        List<String> messages = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            messages = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
