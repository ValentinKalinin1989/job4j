package bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        boolean check;
        do {
            out.println("Hello oracle");
            String str;
            while (true) {
                str = in.readLine();
                if (str.isEmpty()) {
                    break;
                }
                if ("exit".equals(str)) {
                    break;
                }
                out.println(str);
            }
        } while (out.toString().equals("exit"));
    }

    public static void main(String[] args) {
        try (final Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1130)) {
            new Client(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}