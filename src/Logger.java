//gera log de batalha em txt

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static PrintWriter writer;

    static {

        try {

            writer = new PrintWriter(
                    new FileWriter(
                            "battle_log.txt"));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void log(String text) {

        System.out.println(text);

        writer.println(text);

        writer.flush();
    }

    public static void logEmptyLine() {
        log("");
    }

    public static void logSeparator() {
        log("========================================");
    }

    public static void logHeader(String header) {
        logEmptyLine();
        logSeparator();
        log(header);
        logSeparator();
        logEmptyLine();
    }

    public static void close() {

        if (writer != null) {
            writer.close();
        }
    }
}
