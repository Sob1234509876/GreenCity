package Main.threads;

import Main.Main;

/* *
 * A peice of sh*t
 */

public class weatherThread implements Runnable {
    public void run() {
        while (true) {
            try {

                switch (Main.weatherType) {
                    case Main.SUNNY:
                        Main.weatherIcon.setIcon(Main.sunny);
                        Main.weather.setText(String.format("%s %d℃", "sunny", Main.temperature));
                        break;

                    case Main.CLOUDY:
                        Main.weatherIcon.setIcon(Main.cloudy);
                        Main.weather.setText(String.format("%s %d℃", "cloudy", Main.temperature));
                        Thread.sleep(3000 + Main.globalRandom.nextInt(2000));

                    case Main.WET:
                        if (Main.temperature > 0) {
                            Main.weatherIcon.setIcon(Main.rainy);
                            Main.weather.setText(String.format("%s %d℃", "rainy", Main.temperature));
                        } else {
                            Main.weatherIcon.setIcon(Main.snowy);
                            Main.weather.setText(String.format("%s %d℃", "snowy", Main.temperature));
                        }
                        Thread.sleep(1000 + Main.globalRandom.nextInt(1000));
                        break;

                    default:
                        Main.weatherIcon.setIcon(Main.sunny);
                        Main.weather.setText(String.format("%s %d℃", "sunny", Main.temperature));
                        break;
                }

                Thread.sleep(1000 + Main.globalRandom.nextInt(500));
                Main.weatherType = Main.globalRandom.nextInt(50);
            } catch (Exception e) {
            }
        }
    }
}
