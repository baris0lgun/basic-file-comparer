package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    public List<String> readFilesFromFolder(){
        List<String> filePathList = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get("C:\\textFiles"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> filePathList.add(path.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePathList;

    }
}
