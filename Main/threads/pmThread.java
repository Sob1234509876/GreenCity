package Main.threads;

import Main.Main;

public class pmThread implements Runnable {
    public void run() {
        while (true) {
            Main.pmA += (Main.INDUSTRY - Main.deltaP)
                    / (Main.pmA > 800 ? 2 : 1)
                    / (Main.temperature < -78 ? Math.abs(Main.temperature + 74) : 1);
            // Why these two facters?
            // Because :
            // 1.With a high pm, the CO2 will spread to other places
            // 2.CO2`s boiling point is at -78.5 degrees, below that then it`s a solid and
            // is not count as pollution.

            Main.pm.setText(String.format("%.2f", Main.pmA));

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
