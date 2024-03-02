package Main.threads;

import Main.Main;

import java.time.LocalDateTime;

public class clockThread implements Runnable {

    private LocalDateTime n;

    public void run() {
        while (true) {
            n = LocalDateTime.now();
            Main.bigClock.setText(String.format("%02d:%02d:%02d", n.getHour(), n.getMinute(), n.getSecond()));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
