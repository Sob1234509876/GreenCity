package Main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    public static JFrame rootFrame = new JFrame("Green City Terminal 0.2.2");
    public static JPanel cmdPanel = new JPanel(null);

    public static JTextArea outArea = new JTextArea("SMART CITY 0.2.2\n");
    public static JTextField point = new JTextField(">>>>>>");
    public static JTextField cmdArea = new JTextField("size\\20");
    public static JTextField cmdTitle = new JTextField("Command terminal");

    public static JTextField calTitle = new JTextField("Calender");
    public static JPanel calPanel = new JPanel(null);
    public static JCalender calender = new JCalender(LocalDateTime.now());

    public static JTextField cloTitle = new JTextField("Clock");
    public static JPanel cloPanel = new JPanel(null);
    public static volatile JTextField bigClock = new JTextField(String.format("%02d:%02d:%02d",
            LocalDateTime.now().getHour(),
            LocalDateTime.now().getMinute(),
            LocalDateTime.now().getSecond()));

    public static void main(String[] args) throws Exception {

        Path gamePath = Paths.get("").toAbsolutePath();
        Path assetPath = Paths.get(gamePath.toString(), "asset");

        ImageIcon icon = new ImageIcon(Paths.get(assetPath.toString(), "icon.png").toString());
        ImageIcon joke = new ImageIcon(Paths.get(assetPath.toString(), "Joke.gif").toString());

        // rootFrame init.

        rootFrame.setVisible(true);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rootFrame.setIconImage(icon.getImage());
        rootFrame.setSize(2000, 1000);
        rootFrame.setLayout(null);
        rootFrame.setResizable(false);
        rootFrame.getContentPane().setBackground(Color.BLACK);

        rootFrame.add(cmdPanel);
        rootFrame.add(cmdTitle);

        rootFrame.add(calTitle);
        rootFrame.add(calPanel);
        calPanel.add(calender);

        rootFrame.add(cloTitle);
        rootFrame.add(cloPanel);
        cloPanel.add(bigClock);

        // cmdPanel init.

        cmdPanel.setOpaque(true);
        cmdPanel.setBounds(450, 200, 1100, 600);
        cmdPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));
        cmdPanel.setBackground(Color.BLACK);

        cmdPanel.add(outArea);
        cmdPanel.add(point);
        cmdPanel.add(cmdArea);

        JFrame jokeFrame = new JFrame("Downloading data ...");
        jokeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jokeFrame.setSize(515, 330);
        jokeFrame.setLayout(null);
        jokeFrame.setResizable(false);

        // Init

        log("智慧城市启动");
        log("");
        log("  __________________");
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

        thread1.start(); // crappy
        thread2.start(); // fake
        thread3.start(); // logs

        log("");
        log("Initilizing frame");

        int siz = 24;

        /////////////////////////////////////////// clock///////////////////////////////////////

        Thread clockThread = new Thread(new Runnable() {

            private LocalDateTime n;

            public void run() {
                while (true) {
                    n = LocalDateTime.now();
                    bigClock.setText(String.format("%02d:%02d:%02d", n.getHour(), n.getMinute(), n.getSecond()));
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }

        }, "clock thread");

        cloTitle.setEditable(false);
        cloTitle.setBounds(0, 11 * siz + 6, 450, siz);
        cloTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        cloTitle.setBackground(new Color(192, 255, 255));
        cloTitle.setForeground(Color.BLACK);

        cloPanel.setBounds(0, 12 * siz + 6, 450, 3 * siz + 10);
        cloPanel.setBackground(Color.BLACK);
        cloPanel.setForeground(new Color(192, 255, 255));
        cloPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));

        bigClock.setEditable(false);
        bigClock.setBounds(225 - 6 * siz, 5, 12 * siz, 3 * siz);
        bigClock.setFont(new Font("coure", Font.PLAIN, 3 * siz));
        bigClock.setBackground(Color.BLACK);
        bigClock.setForeground(new Color(192, 255, 255));
        bigClock.setBorder(null);

        clockThread.start();

        ///////////////////////////////////////// calender//////////////////////////////////////

        calTitle.setEditable(false);
        calTitle.setBounds(0, 0, 450, siz);
        calTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        calTitle.setBackground(new Color(192, 255, 255));
        calTitle.setForeground(Color.BLACK);

        calPanel.setBounds(0, siz, 450, 10 * siz + 6);
        calPanel.setBackground(Color.BLACK);
        calPanel.setForeground(new Color(192, 255, 255));
        calPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));

        calender.setEditable(false);
        calender.setBounds(65, 5, siz * 14, 10 * siz);
        calender.setFont(new Font("宋体", Font.PLAIN, siz));
        calender.setBackground(Color.BLACK);
        calender.setForeground(new Color(192, 255, 255));
        calender.setBorder(null);

        log(LocalDateTime.now().getMonth().getValue());

        //////////////////////////////////////////// cmd////////////////////////////////////////

        // cmdTitle init.
        cmdTitle.setEditable(false);
        cmdTitle.setBounds(450, 200, 1100, siz);
        cmdTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        /*
         * cmdTitle.setForeground(new Color(192, 255, 255));
         * cmdTitle.setBackground(Color.BLACK);
         * cmdTitle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(192,
         * 255, 255)));
         */
        cmdTitle.setBackground(new Color(192, 255, 255));
        cmdTitle.setForeground(Color.BLACK);
        cmdTitle.setBorder(null);

        // outArea init.
        outArea.setEditable(false);
        outArea.setBounds(50, 50, 1000, siz);
        outArea.setFont(new Font("宋体", Font.PLAIN, siz));
        outArea.setForeground(new Color(192, 255, 255));
        outArea.setBackground(Color.BLACK);

        // point init.
        point.setEditable(false);
        point.setBounds(50, 550 - siz, 3 * siz, siz);
        point.setFont(new Font("宋体", Font.PLAIN, siz));
        point.setForeground(new Color(192, 255, 255));
        point.setBackground(Color.BLACK);
        point.setBorder(null);

        // cmdArea init.
        cmdArea.setBounds(50 + 3 * siz, 550 - siz, 500 - 3 * siz, siz);
        cmdArea.setFont(new Font("宋体", Font.PLAIN, siz));
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

        ////////////////////////////////////////////////////////////////////////////////////////

    }

    public static void log(Object txt) {
        System.out.println(String.format("[%s] %s", LocalDateTime.now().toString(), txt.toString()));
    }

    public static String command(String cmd) {

        try {

            String com = cmd.split("\\\\")[0];
            String txt = cmd.split("\\\\")[1];

            if (com.equals("echo")) {
                return txt;

            } else if (com.equals("size")) {

                int siz = Integer.parseInt(txt);

                outArea.setBounds(50, 50, 1000, siz);
                outArea.setFont(new Font("宋体", Font.PLAIN, siz));
                point.setBounds(50, 550 - siz, 3 * siz, siz);
                point.setFont(new Font("宋体", Font.PLAIN, siz));
                cmdArea.setBounds(50 + 3 * siz, 550 - siz, 500 - 3 * siz, siz);
                cmdArea.setFont(new Font("宋体", Font.PLAIN, siz));
                // cmdTitle.setBounds(450, 200, 1100, siz);
                // cmdTitle.setFont(new Font("宋体", Font.PLAIN, siz));

                // log(cmdTitle.getBackground());

                return "";
            } else {
                return String.format("Unknown command \"%s\"", com);
            }

        } catch (Exception e) {
            return e.toString();
        }

    }

}
