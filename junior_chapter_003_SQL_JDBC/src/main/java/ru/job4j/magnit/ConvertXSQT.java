package ru.job4j.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ConvertXSQT {
    public static void convert(File source, File dest, File scheme) {
        try {
            String stringSource = Files.readString(source.toPath(), StandardCharsets.US_ASCII);
            String stringScheme = Files.readString(scheme.toPath(), StandardCharsets.US_ASCII);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(
                            new ByteArrayInputStream(stringScheme.getBytes()))
            );
            transformer.transform(new StreamSource(
                            new ByteArrayInputStream(stringSource.getBytes())),
                    new StreamResult(new FileWriter(dest))
            );
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}
