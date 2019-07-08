package bot;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private static final String LN = System.getProperty("line.separator");


    public void testClient(String input, String output) throws IOException {

        Socket socket = mock(Socket.class);
        Client client = new Client(socket);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        client.start();
        assertThat(out.toString(), is(output));
    }

    /**
     * Остановка клиента без ответа сервера
     * @throws IOException
     */
    @Test
    public void whenTestServerExit() throws IOException {
        testClient(String.format("exit"), String.format("Hello oracle%s", LN, LN));
    }

    @Test
    public void whenTestServerSendLnAndExit() throws IOException {
        testClient(String.format("Word%sexit", LN), String.format("Hello oracle%sWord%s", LN, LN));
    }


}