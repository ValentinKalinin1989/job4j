package bot;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LN = System.getProperty("line.separator");


    public void testServer(String input, String output) throws IOException {
        Socket socket = mock(Socket.class);
        Server server = new Server(socket);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        server.start();
        assertThat(out.toString(), is(output));
    }

    @Test
    public void whenTestServerExit() throws IOException {
        testServer("exit", "");
    }

    @Test
    public void whenTestHello() throws IOException {
        testServer(String.format("hello%sexit", LN), String.format("Hello, dear friend, I'm a oracle.%s", LN + LN));
    }


}
