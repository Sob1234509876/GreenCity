package Main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;

public class Main {

    public static volatile char pressedKey = '\0';
    public static volatile int fontSize = 16;

    public static JTextArea outArea = new JTextArea();
    public static JTextField point = new JTextField(">>>");
    public static JTextField cmdArea = new JTextField("⁰");

    public static void main(String[] args) throws Exception {

        Path gamePath = Paths.get("").toAbsolutePath();
        Path assetPath = Paths.get(gamePath.toString(), "asset");

        ImageIcon icon = new ImageIcon(Paths.get(assetPath.toString(), "icon.png").toString());
        ImageIcon joke = new ImageIcon(Paths.get(assetPath.toString(), "Joke.gif").toString());

        JFrame rootFrame = new JFrame("Green City Terminal 0.2");
        rootFrame.setVisible(true);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootFrame.setIconImage(icon.getImage());
        rootFrame.setSize(2000, 1000);
        rootFrame.setLayout(null);
        rootFrame.setResizable(false);
        rootFrame.getContentPane().setBackground(Color.BLACK);

        rootFrame.add(outArea);
        rootFrame.add(point);
        rootFrame.add(cmdArea);

        JFrame jokeFrame = new JFrame("Downloading data ...");
        jokeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jokeFrame.setSize(515, 330);
        jokeFrame.setLayout(null);
        jokeFrame.setResizable(false);

        // Init

        log("智慧城市启动");
        log("");
        log(" __________________");
        log(" /  ________________|");
        log("|  |________________");
        log(" \\________________  \\");
        log(" _________________| |");
        log("|___________________/");
        log("");
        log("     __       __");
        log("    /  \\     /  \\");
        log("   /    \\   /    \\");
        log("  /  /\\  \\_/  /\\  \\");
        log(" /  /  \\     /  \\  \\");
        log("/__/    \\___/    \\__\\");
        log("");
        log("     ___________");
        log("    /  _______  \\");
        log("   /  /_______\\  \\");
        log("  /  ___________  \\");
        log(" /  /           \\  \\");
        log("/__/             \\__\\");
        log("");
        log(" _________________");
        log("|   ____________  \\");
        log("|  |____________| |");
        log("|   ____________  \\");
        log("|  |            \\  \\");
        log("|__|             \\__\\");
        log("");
        log(" ___________________");
        log("|________    _______|");
        log("         |  |");
        log("         |  |");
        log("         |  |");
        log("         |__|");
        log("");
        log("");
        log("");
        log("");
        log("");
        log("");
        log("");
        log(" ____________________");
        log("|   _________________|");
        log("|  |");
        log("|  |");
        log("|  |_________________");
        log("|____________________|");
        log("");
        log(" ___________________");
        log("|________    _______|");
        log("         |  |");
        log("         |  |");
        log("_________|  |_______");
        log("|___________________|");
        log("");
        log(" ___________________");
        log("|________    _______|");
        log("         |  |");
        log("         |  |");
        log("         |  |");
        log("         |__|");
        log("");
        log(" ________    ________");
        log(" \\       \\  /       /");
        log("  \\       \\/       /");
        log("   \\              /");
        log("    |            |");
        log("    |____________|");
        log("");
        log("Reading URL.txt");

        JLabel joking = new JLabel(joke);
        joking.setBounds(0, 0, 490, 260);

        jokeFrame.add(joking);

        jokeFrame.setVisible(true);

        log("Thread URL : Requesting 114.5.1.4:1919 ... [1]");

        // Thread.sleep(20000);

        log("Thread URL : Timeout");

        jokeFrame.setVisible(false);

        log("Thread URL : Requesting 114.5.1.4:1919 ... [2]");
        log("Thread URL : Receiving Data ...");

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                log("Thread thread1 : HTML soup : getting HTML.head");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.data");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.icon");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.102F6ABD");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.23CDE7A0");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.59730E24");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.BD76DD25");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.4A36C0AF");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.$B02F6ABD");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.$ACCDE7A0");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.$BC730E24");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.$BD70DD25");
                log("Thread thread1 : HTML soup : getting HTML.body.pollution.$0036C0AF");
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                log("Thread thread2 : HTML soup : getting HTML.head");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.data");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.icon");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.102F6ABD");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.23CDE7A0");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.59730E24");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.BD76DD25");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.4A36C0AF");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.$B02F6ABD");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.$ACCDE7A0");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.$BC730E24");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.$BD70DD25");
                log("Thread thread2 : HTML soup : getting HTML.body.weather.$0036C0AF");
            }
        }, "thread2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                log("Thread thread3 : HTML soup : getting HTML.head");
                log("Thread thread3 : HTML soup : getting HTML.body.other.data");
                log("Thread thread3 : HTML soup : getting HTML.body.other.icon");
                log("Thread thread3 : HTML soup : getting HTML.body.other.102F6ABD");
                log("Thread thread3 : HTML soup : getting HTML.body.other.23CDE7A0");
                log("Thread thread3 : HTML soup : getting HTML.body.other.59730E24");
                log("Thread thread3 : HTML soup : getting HTML.body.other.BD76DD25");
                log("Thread thread3 : HTML soup : getting HTML.body.other.4A36C0AF");
                log("Thread thread3 : HTML soup : getting HTML.body.other.$B02F6ABD");
                log("Thread thread3 : HTML soup : getting HTML.body.other.$ACCDE7A0");
                log("Thread thread3 : HTML soup : getting HTML.body.other.$BC730E24");
                log("Thread thread3 : HTML soup : getting HTML.body.other.$BD70DD25");
                log("Thread thread3 : HTML soup : getting HTML.body.other.$0036C0AF");
            }
        }, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        log("");
        log("Initilizing frame");

        outArea.setEditable(false);
        outArea.setBounds(500, 250, 1000, 484);
        outArea.setFont(new Font("宋体", Font.PLAIN, 16));
        outArea.setForeground(new Color(192, 255, 255));
        outArea.setBackground(Color.BLACK);

        point.setEditable(false);
        point.setBounds(500, 734, 32, 16);
        point.setFont(new Font("宋体", Font.PLAIN, 16));
        point.setForeground(new Color(192, 255, 255));
        point.setBackground(Color.BLACK);
        point.setBorder(null);

        cmdArea.setBounds(532, 734, 968, 16);
        cmdArea.setFont(new Font("宋体", Font.PLAIN, 16));
        cmdArea.setForeground(new Color(192, 255, 255));
        cmdArea.setBackground(Color.BLACK);
        cmdArea.setBorder(null);

        cmdArea.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent k) {
                if (k.getKeyChar() == '\n') {
                    pressedKey = k.getKeyChar();
                }
            }

            public void keyTyped(KeyEvent k) {
            }

            public void keyReleased(KeyEvent k) {
            }
        });

        Thread threadCMD = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (pressedKey == '\n') {
                        outArea.setText(command(cmdArea.getText()) + '\n');
                        pressedKey = '\0';
                        cmdArea.setText(null);
                    }
                }
            }
        }, "CMD");

        threadCMD.start();

    }

    public static void log(String txt) {
        System.out.println(String.format("[%s] %s", LocalDateTime.now().toString(), txt));
    }

    public static String command(String cmd) {

        try {

            String com = cmd.split("\\\\")[0];
            String txt = cmd.split("\\\\")[1];

            if (com.equals("echo")) {
                return txt;

            } else if (com.equals("size")) {

                int siz = Integer.parseInt(txt);

                outArea.setBounds(500, 250, 1000, siz);
                outArea.setFont(new Font("宋体", Font.PLAIN, siz));
                point.setBounds(500, 750 - siz, 3 * siz, siz);
                point.setFont(new Font("宋体", Font.PLAIN, siz));
                cmdArea.setBounds(500 + 3 * siz, 750 - siz, 500 - 3 * siz, siz);
                cmdArea.setFont(new Font("宋体", Font.PLAIN, siz));

                return "";
            } else {
                return String.format("Unknown command \"%s\"", com);
            }

        } catch (Exception e) {
            return e.toString();
        }

    }

}
