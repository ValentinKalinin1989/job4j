package chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Chat {
    private List<String> answers = new ArrayList<>();
    private List<String> log = new ArrayList<>();
    private boolean ask = true;


    public static void main(String[] args) {
        Chat chat = new Chat("Answer.txt");
        chat.chat();
    }

    /**
     * конструктор
     *
     * @param path путь к файлу с ответами
     */
    public Chat(String path) {
        loadtxt(path);
    }

    /**
     * загрузка ответов в буфер обмена
     *
     * @param path путь к файлу с ответами
     */
    public void loadtxt(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(this.answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * сохранение строки в лог сообщений
     *
     * @param string
     */
    public void safeStringInLog(String string) {
        log.add(string);
    }

    /**
     * получение случайного ответа из листа ответов
     *
     * @return строка
     */
    public String getAnswer() {
        Random rnd = new Random();
        String answer = this.answers.get(rnd.nextInt((int) this.answers.stream().count()));
        safeStringInLog(answer);
        return answer;
    }

    /**
     * анализ сообщений пользователя
     *
     * @param request
     * @return
     */
    public boolean analyziRequest(String request) {
        boolean result = true; // продолжение работы
        safeStringInLog(request);
        if (request.equals("стоп")) {
            this.ask = false;
        } else if (request.equals("продолжить")) {
            this.ask = true;
        } else if (request.equals("закончить")) {
            this.ask = false;
            safeLog();
            result = false;
        }
        if (this.ask) {
            String answer = getAnswer();
            System.out.println(answer);
        }
        return result;
    }

    /**
     * Сохранение лога сообщений
     */
    public void safeLog() {
        try (BufferedWriter write = new BufferedWriter(new FileWriter("logExample.txt"))) {
            for (String string : this.log) {
                write.write(string + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * запуск чата
     */
    public void chat() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean end;
        String request = null;
        do {
            System.out.println("Введите сообщение:");
            try {
                request = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            end = analyziRequest(request);
        } while (end);
    }

    /**
     * запуск чата для теста
     *
     * @param strings ввод пользователя
     * @return содержимое лога
     */
    public List<String> chatT(List<String> strings) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean end = true;
        String request = null;
        do {
            for (String string : strings) {

                System.out.println("Введите сообщение:");
                request = string;
                end = analyziRequest(request);
                if (!end) {
                    break;
                }
            }
        } while (end);
        return log;
    }
}
