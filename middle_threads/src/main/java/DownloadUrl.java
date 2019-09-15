public class DownloadUrl {
    public static void main(String[] args) {
        Wget wget = new Wget(args[0], args[1], Integer.parseInt(args[2]));
        new Thread(wget).start();
    }
}
