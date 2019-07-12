package zip;

import args.Args;
import search.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void pack(File source, File target, String ext) {
        List<String> exts = new ArrayList<>(1);
        exts.add(ext);
        Search search = new Search();
        List<File> listofFile = search.getFileWithOutExt(search.findAllFilesDirect(source.toString()), exts);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: listofFile) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Args argsF = new Args(args);
        new Zip().pack(new File(argsF.directory()), new File(argsF.output()), argsF.excule());
    }
}