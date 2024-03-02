package Main.threads;

import Main.Main;

import java.awt.Color;

public class overThread implements Runnable {
    public void run() {

        while (true) {
            if (passiveThread.deathFlag)
                break;
            if (Main.pmA < 2)
                Main.pmA = 2;
            if (Main.temperature >= 40) {

                Main.over.setForeground(Color.RED);
                Main.over.setText("////////!///////OVER HEAT///////!////////");
                Main.overWindow.setVisible(true);

                if (!(Main.sirenAudio.isPlay))
                    Main.sirenAudio.recommence();
                if ((Main.temperature >= 60) && !(Main.evacAudio.isPlay))
                    Main.evacAudio.recommence();

            } else if (Main.temperature <= -20) {

                Main.over.setForeground(Color.BLUE);
                Main.over.setText("///////!///////OVER COOLED///////!///////");
                Main.overWindow.setVisible(true);

                if (!(Main.sirenAudio.isPlay))
                    Main.sirenAudio.recommence();
                if ((Main.temperature <= -130) && !(Main.evacAudio.isPlay))
                    Main.evacAudio.recommence();

            } else if (Main.pmA >= 500) {

                Main.over.setForeground(Color.GRAY);
                Main.over.setText("////////!////////HIGH PM////////!////////");
                Main.overWindow.setVisible(true);

                if (!(Main.sirenAudio.isPlay))
                    Main.sirenAudio.recommence();
                if ((Main.pmA >= 800) && !(Main.evacAudio.isPlay))
                    Main.evacAudio.recommence();
            }

            if (!(Main.pmA >= 500) && !(Main.temperature >= 40) && !(Main.temperature <= -20)) {

                Main.overWindow.setVisible(false);
                if (Main.sirenAudio.isPlay)
                    Main.sirenAudio.pause();
                if (Main.evacAudio.isPlay)
                    Main.evacAudio.pause();

            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}
