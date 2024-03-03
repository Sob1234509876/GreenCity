package Main.threads;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

import Main.Main;

public class newsThread implements Runnable {

    private static final int DEFAULT_NEWS = 0;
    private static final int WEATHER_NEWS = 1;
    private static final int AI_RUNAWAY_NEWS = 2;

    public void run() {

        Properties news = new Properties();
        try {
            InputStream FIS = new FileInputStream(
                    Paths.get(
                            Main.assetPath.toString(), "news.properties").toString());
            news.load(FIS);
        } catch (Exception e) {
        }

        while (true) {
            if (passiveThread.deathFlag) {
                break;
            }

            switch (Main.globalRandom.nextInt(3)) {
                case DEFAULT_NEWS:
                    Main.news.setText(news.getProperty(String.valueOf(Main.globalRandom.nextInt(8))));
                    break;

                case WEATHER_NEWS:
                    if (Main.temperature >= 60)
                        Main.news.setText(news.getProperty("Heat1"));
                    else if (Main.temperature >= 40)
                        Main.news.setText(news.getProperty("Heat0"));
                    else if (Main.temperature <= -20)
                        Main.news.setText(news.getProperty("Cold0"));
                    else if (Main.temperature <= -40)
                        Main.news.setText(news.getProperty("Cold1"));
                    else if (Main.temperature <= -130)
                        Main.news.setText(news.getProperty("Cold2"));
                    else if (Main.pmA >= 500)
                        Main.news.setText(news.getProperty("PM0"));
                    else
                        Main.news.setText(news.getProperty("AIRunaway" + String.valueOf(Main.globalRandom.nextInt(1))));

                    break;

                case AI_RUNAWAY_NEWS:
                    Main.news.setText(news.getProperty("AIRunaway" + String.valueOf(Main.globalRandom.nextInt(1))));

                    break;
            }

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }

        }
    }
}
