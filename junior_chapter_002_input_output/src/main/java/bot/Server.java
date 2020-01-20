package bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!"exit".equals(ask)) {
                out.println("Undestand command.");
                out.println();
            }
        } while (!"exit".equals(ask));
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(1130).accept()) {
            new Server(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
