package Main.threads;

import java.io.*;
import java.nio.file.Paths;

import Main.Main;

public class effectThread implements Runnable {

    private int lines = 0;
    private int buf = 0;
    private byte[] tmp = new byte[1];

    public void run() {

        while (true) {
            buf = 0;

            if (passiveThread.deathFlag)
                break;

            try {
                InputStream FIS = new FileInputStream(Paths
                        .get(Main.assetPath.toString(),
                                "rand",
                                String.valueOf(Main.globalRandom.nextInt(4)) + ".txt")
                        .toString());

                while (buf != -1) {

                    buf = FIS.read();
                    tmp[0] = (byte) (buf);
                    Main.effect.append(new String(tmp));

                    if (tmp[0] == '\n')
                        lines++;
                    if (lines > 4) {
                        Main.effect.setText("");
                        lines = 0;
                    }

                    Thread.sleep(20);
                }

                FIS.close();

            } catch (Exception e) {
            }
        }

    }
}
