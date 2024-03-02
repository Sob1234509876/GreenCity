package Main.threads;

import Main.Main;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

/* *
 * Not so passive (neutral) thread, the terminal death causer, The grim reaper of the SMART CITY™ Terminal.
 */

public class passiveThread implements Runnable {

    public static boolean deathFlag = false;
    public static String DEATH_CAUSE;

    public void run() {
        while (true) {
            Main.log("passive thread run");
            Main.temperature += Main.deltaT > 0 ? 1 : -1;
            try {
                Thread.sleep(
                        (1000 + Main.globalRandom.nextInt(1000))
                                / (int) (Math.pow((double) (Main.deltaT), 2.0) + 1)
                                * (Math.abs(Main.temperature) + 1));
                // Sleep time : (3000 + R)/(dT^2 + 1)*(|T| + 1)
                // * R is a random int in [0, 1000]
                // * d stands for the difference in cauculas
                // * T stands for Main.Main.temperature
            } catch (Exception e) {
            }

            if ((Main.temperature > 100) || (Main.temperature < -273) || (Main.pmA > 1000)) {

                if ((Main.temperature > 100) || (Main.temperature < -273))
                    DEATH_CAUSE = "Death by temperature.";
                else if (Main.pmA > 1000)
                    DEATH_CAUSE = "Death by short circuit.";

                deathFlag = true;
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }

                Main.rootFrame.setVisible(false);
                Main.overWindow.setVisible(false);

                Main.sirenAudio.pause();
                Main.evacAudio.pause();
                Main.explosionAudio.recommence();

                try {
                    OutputStream fOut = new FileOutputStream(
                            Paths.get(Main.deathLogPath.toString(), "death log.log").toString());
                    fOut.write(Main.getBytes(String.format(
                            "Gigaware death logger[v0.1]\n" +
                                    "©Gigaware co., Ltd. all rights reserved.\n\n" +
                                    "-----Death information------\n\n" +
                                    "%s\n" +
                                    "Death temperature : %d℃\n" +
                                    "----Software Information----\n\n" +
                                    "SMART CITY Terminal [v0.2.3]\n" +
                                    "© Gigaware Co.,Ltd. all rights reserved.\n\n" +
                                    "-----System Information-----\n\n" +
                                    "GIGAWARE OS [v0.1]\n" +
                                    "© Gigaware Co.,Ltd. all rights reserved.\n\n" +
                                    "----Hardware Information----\n\n" +
                                    "Command set : QGIGA(R)x64\n" +
                                    "APU : QGIGA(R) i64T1F @ 64 QPB\n" +
                                    "Screen : IBM QuantumLCD\n" +
                                    "Screen drive : IBM QuantumLCD SC v 1.3.4\n" +
                                    "RAM : GIGAWARE(R) QuantumRAM\n" +
                                    "FTB web IP : 1145:1419:1916:9:fe1f:c00c:12ce:97da\n\n" +
                                    "----------------------------\n",
                            DEATH_CAUSE,
                            Main.temperature)
                            .toCharArray()));
                    /*
                     * It should look something like this :
                     * """
                     * Gigaware death logger[v0.1]
                     * ©Gigaware co., Ltd. all rights reserved.
                     * 
                     * -----Death information------
                     * 
                     * Terminal computer death by temperature.
                     * Death temperature : ***
                     * 
                     * ----Software Information----
                     * 
                     * SMART CITY Terminal [v0.2.3]
                     * © Gigaware Co.,Ltd. all rights reserved.
                     * 
                     * -----System Information-----
                     * 
                     * GIGAWARE OS [v0.1]
                     * © Gigaware Co.,Ltd. all rights reserved.
                     * 
                     * ----Hardware Information----
                     * 
                     * Command set : QGIGA(R)x64
                     * APU : QGIGA(R) i64T1F @ 64 QPB
                     * Screen : IBM QuantumLCD
                     * Screen drive : IBM QuantumLCD SC v 1.3.4
                     * RAM : GIGAWARE(R) QuantumRAM
                     * FTB web IP : 59.57.245.166
                     * 
                     * ----------------------------
                     * """
                     * This thing is a quantum computer you know.
                     */
                    fOut.close();
                    Thread.sleep(10000);
                    Main.explosionAudio.pause();
                } catch (Exception e) {
                }
                System.exit(0);
            }
        }
    }

}
