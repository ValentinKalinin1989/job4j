package search;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Search {
    private BiPredicate<File, List<String>> predicate = new BiPredicate<File, List<String>>() {
        @Override
        public boolean test(File file, List<String> strings) {
            boolean result = false;
            for (String string : strings) {
                if (file.toString().endsWith(string)) {
                    result = true;
                    break;
                }
            }
            return result;
        }
    };
    public List<File> files(String parent, List<String> exts) {

        List<File> allFiles = findAllFilesDirect(parent);

        return getFileWithExt(allFiles, exts);
    }
    /**
     * поиск всех файлов в каталогах и подкаталогах, которые не являюся директориями
     * @param parent путь к каталогу , в котором надо произвести поиск
     * @return список файлов не являющихся директориями
     */
    public List<File> findAllFilesDirect(String parent) {
        List<File> filesList = new ArrayList<>();
        List<File> allFiles = new ArrayList<>();
        allFiles.add(new File(parent));
        while (!allFiles.isEmpty()) {
            List<File> whileList = new ArrayList<>();
            for (File file: allFiles) {
                File[] forList = file.listFiles();
                if (forList != null) {
                    for (File fileFor : forList) {
                        if (fileFor.isDirectory()) {
                            whileList.add(fileFor);
                        } else {
                            filesList.add(fileFor);
                        }
                    }
                }
            }
            allFiles.clear();
            allFiles = whileList;
        }
        return filesList;
    }

    public List<File> getFileWithExt(List<File> files, List<String> exts) {
        return files.stream().filter(file -> predicate.test(file, exts)).collect(Collectors.toList());
    }

    public List<File> getFileWithOutExt(List<File> files, List<String> exts) {
        return files.stream().filter(file -> predicate.negate().test(file, exts)).collect(Collectors.toList());
    }
}