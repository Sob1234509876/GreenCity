package Main;

import javax.swing.JLabel;

public class CrappyFakeLogger {
    public static void main(boolean debug) {

        Main.log("智慧城市启动");
        Main.log("");
        Main.log("  __________________");
        Main.log(" /  ________________|");
        Main.log("|  |________________");
        Main.log(" \\________________  \\");
        Main.log(" _________________| |");
        Main.log("|___________________/");
        Main.log("");
        Main.log("     __       __");
        Main.log("    /  \\     /  \\");
        Main.log("   /    \\   /    \\");
        Main.log("  /  /\\  \\_/  /\\  \\");
        Main.log(" /  /  \\     /  \\  \\");
        Main.log("/__/    \\___/    \\__\\");
        Main.log("");
        Main.log("     ___________");
        Main.log("    /  _______  \\");
        Main.log("   /  /_______\\  \\");
        Main.log("  /  ___________  \\");
        Main.log(" /  /           \\  \\");
        Main.log("/__/             \\__\\");
        Main.log("");
        Main.log(" _________________");
        Main.log("|   ____________  \\");
        Main.log("|  |____________| |");
        Main.log("|   ____________  \\");
        Main.log("|  |            \\  \\");
        Main.log("|__|             \\__\\");
        Main.log("");
        Main.log(" ___________________");
        Main.log("|________    _______|");
        Main.log("         |  |");
        Main.log("         |  |");
        Main.log("         |  |");
        Main.log("         |__|");
        Main.log("");
        Main.log("");
        Main.log("");
        Main.log("");
        Main.log("");
        Main.log("");
        Main.log("");
        Main.log(" ____________________");
        Main.log("|   _________________|");
        Main.log("|  |");
        Main.log("|  |");
        Main.log("|  |_________________");
        Main.log("|____________________|");
        Main.log("");
        Main.log(" ___________________");
        Main.log("|________    _______|");
        Main.log("         |  |");
        Main.log("         |  |");
        Main.log("_________|  |_______");
        Main.log("|___________________|");
        Main.log("");
        Main.log(" ___________________");
        Main.log("|________    _______|");
        Main.log("         |  |");
        Main.log("         |  |");
        Main.log("         |  |");
        Main.log("         |__|");
        Main.log("");
        Main.log(" ________    ________");
        Main.log(" \\       \\  /       /");
        Main.log("  \\       \\/       /");
        Main.log("   \\              /");
        Main.log("    |            |");
        Main.log("    |____________|");
        Main.log("");
        Main.log("Reading URL.txt");

        JLabel joking = new JLabel(Main.joke);
        joking.setBounds(0, 0, 490, 260);

        Main.jokeFrame.add(joking);

        Main.jokeFrame.setVisible(true);

        Main.log("Thread URL : Requesting 114.5.1.4:1919 ... [1]");

        try {

            if (!debug)
                Thread.sleep(20000);
        } catch (Exception e) {
        }

        Main.log("Thread URL : Timeout");

        Main.jokeFrame.setVisible(false);

        Main.log("Thread URL : Requesting 114.5.1.4:1919 ... [2]");
        Main.log("Thread URL : Receiving Data ...");

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                Main.log("Thread thread1 : HTML soup : getting HTML.head");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.data");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.icon");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.102F6ABD");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.23CDE7A0");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.59730E24");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.BD76DD25");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.4A36C0AF");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.$B02F6ABD");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.$ACCDE7A0");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.$BC730E24");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.$BD70DD25");
                Main.log("Thread thread1 : HTML soup : getting HTML.body.pollution.$0036C0AF");
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                Main.log("Thread thread2 : HTML soup : getting HTML.head");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.data");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.icon");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.102F6ABD");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.23CDE7A0");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.59730E24");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.BD76DD25");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.4A36C0AF");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.$B02F6ABD");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.$ACCDE7A0");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.$BC730E24");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.$BD70DD25");
                Main.log("Thread thread2 : HTML soup : getting HTML.body.weather.$0036C0AF");
            }
        }, "thread2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                Main.log("Thread thread3 : HTML soup : getting HTML.head");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.data");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.icon");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.102F6ABD");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.23CDE7A0");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.59730E24");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.BD76DD25");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.4A36C0AF");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.$B02F6ABD");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.$ACCDE7A0");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.$BC730E24");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.$BD70DD25");
                Main.log("Thread thread3 : HTML soup : getting HTML.body.other.$0036C0AF");
            }
        }, "thread3");

        thread1.start(); // crappy
        thread2.start(); // fake
        thread3.start(); // logs
    }
}
