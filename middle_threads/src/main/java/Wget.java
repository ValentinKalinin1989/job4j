import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;

public class Wget implements Runnable {
    private final String fileURL;
    private final String fileName;
    private final int size;

    public Wget(final String fileURL, final String fileName, final int size) {
        this.fileURL = fileURL;
        this.fileName = fileName;
        this.size = size;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream out = new FileOutputStream(fileName);) {
            final byte[] data = new byte[size];
            LocalDateTime dateStrat;
            LocalDateTime dateEnd;
            int waitTime;
            int secCount = 0;
            while (in.read(data, 0, size) !=  -1) {
                dateStrat = LocalDateTime.now();
                out.write(data, 0, size);
                dateEnd = LocalDateTime.now();
                waitTime = 1000 - (dateEnd.getNano() - dateStrat.getNano());
                secCount++;
                try {
                    Thread.sleep(waitTime > 0 ? waitTime : 0);
                    System.out.println(secCount + " секунда загрузки");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}