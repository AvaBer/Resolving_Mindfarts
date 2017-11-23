import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a {
    public a() {
        mockMain();
    }

    public void mockMain() {
        String pathString = "./src/filedir/";
//        sbTest();
//        System.out.printf("wawa: %s gaga: %d\n", "stuff", 1);
//        System.out.println("ay nooo!");
//        createABunchOfFiles(10, pathString);
//        filesInDir(pathString);

//        System.out.println(1505826011124L - 1505826011123L);
        dump();
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(1505907348728L);
//        System.out.println(cal.getTime());
//        Date date = new Date();
//        date.setTime(1505907348728L);
//        System.out.println(date.toString());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//        System.out.println(sdf.format(date));

    }

    private static void sbTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        sb.append("2");
        sb.append("3");
        sb.append("4");
        sb.append("5");
        sb.append("6");
        System.out.println(sb.toString());

    }

    private static void dump() {
        List<Long> pluginsLastModified = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        try {
            Files.newDirectoryStream(Paths.get("./src/filedir/"))
                    .forEach(file -> {
                        if (file.toFile().isFile()) {
                            pluginsLastModified.add(file.toFile().lastModified());
                            fileList.add(file.toFile());
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        long lastMod = 0;
        fileList.sort(Comparator.comparing(File::lastModified).reversed());
        fileList.forEach(file -> System.out.println(file.getName() + " " + file.lastModified()));

//        File testFile = fileList.get(0);
//        BasicFileAttributes attr;
//
//        long instanceStart = 1505907348728L;
//        for (File file : fileList) {
//            try {
//                attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
//                System.out.println(attr.creationTime().toMillis() - instanceStart > 0 ? "true":"false");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static void filesInDir(String pathString) {
        Path path = Paths.get(pathString);
        DirectoryStream<Path> directory = null;
        try {
            directory = Files.newDirectoryStream(path);

            List<Path> listOfFiles = new ArrayList<>();
            List<Long> modifiedDateList = new ArrayList<>();

            directory.forEach(listOfFiles::add);
            listOfFiles.forEach(file -> modifiedDateList.add(file.toFile().lastModified()));
            modifiedDateList.forEach(date ->
                    System.out.println(generateTimeSinceModifiedString(date))
            );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateTimeSinceModifiedString(long date) {
        long diff = System.currentTimeMillis() - date;
        return String.format("T:%d.%d.%d",
                TimeUnit.MILLISECONDS.toHours(diff) % 24,
                TimeUnit.MILLISECONDS.toMinutes(diff) % 60,
                TimeUnit.MILLISECONDS.toSeconds(diff) % 60
        );
    }


    private static void createABunchOfFiles(int howMany, String pathString) {

        boolean pathExists = Files.exists(Paths.get(pathString));
        boolean isDirectory = Files.isDirectory(Paths.get(pathString));
        if (pathExists && isDirectory) {
            String name = "";
            for (int i = 0; i < howMany; i++) {
                name = "fileNr" + i;
                if (Files.exists(Paths.get(pathString + name))) {
                    System.out.printf("File: %s already exists in path: %s\n", name, pathString);
                } else {
                    try {
                        Files.createFile(Paths.get(pathString + name));
                        System.out.printf("File: %s was created in path: %s\n", name, pathString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.printf("path exists: %b\nis directory: %b\n ", pathExists, isDirectory);
        }
    }

}
