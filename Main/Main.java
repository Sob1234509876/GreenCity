package Main;

import Main.threads.*;
import javax.swing.*;
import Main.swingTweak.JCalender;

import java.awt.Color;
import java.awt.Font;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;
import java.util.Random;

/*
 * TODO : News(up) & 特效(down) & database
 */

public class Main {
    public static Path gamePath = Paths.get("").toAbsolutePath();
    public static Path assetPath = Paths.get(gamePath.toString(), "asset");
    public static Path deathLogPath = Paths.get(gamePath.toString(), "deathLog");

    public static final String __version__ = "0.2.4";
    public static final int siz = 24;
    public static final double INDUSTRY = 1;
    public static final int SUNNY = 0;
    public static final int CLOUDY = 1;
    public static final int WET = 2;
    public static final Icon sunny = new ImageIcon(Paths.get(assetPath.toString(), "sun.png").toString());
    public static final Icon cloudy = new ImageIcon(Paths.get(assetPath.toString(), "cloud.png").toString());
    public static final Icon rainy = new ImageIcon(Paths.get(assetPath.toString(), "rain.png").toString());
    public static final Icon snowy = new ImageIcon(Paths.get(assetPath.toString(), "snow.png").toString());
    private static final ImageIcon icon = new ImageIcon(Paths.get(assetPath.toString(), "icon.png").toString());
    public static final ImageIcon joke = new ImageIcon(Paths.get(assetPath.toString(), "Joke.gif").toString());

    // Constansts

    public static volatile char pressedKey = '\0';
    public static volatile int weatherType = 0;
    public static volatile int temperature = 0;
    public static volatile int deltaT = 0;
    public static volatile double pmA = 114;
    public static volatile double deltaP = 0;
    public static volatile Random globalRandom = new Random();
    public static AudioPlay sirenAudio = new AudioPlay(
            Paths.get(assetPath.toString(), "siren.wav").toString());
    public static AudioPlay evacAudio = new AudioPlay(
            Paths.get(assetPath.toString(), "evacuate.wav").toString());
    public static AudioPlay explosionAudio = new AudioPlay(
            Paths.get(assetPath.toString(), "explosion.wav").toString());
    public static AudioPlay bgmAudio;

    // Thread-shared

    public static JWindow overWindow = new JWindow();
    public static JWindow jokeFrame = new JWindow();

    public static JFrame rootFrame = new JFrame(String.format("SMART CITY Terminal %s", __version__));
    public static JPanel cmdPanel = new JPanel(null);

    public static JTextArea outArea = new JTextArea(String.format(
            "SMART CITY Terminal [v%s]\n" +
                    "© Gigaware Co.,Ltd. all rights reserved.",
            __version__));
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

    public static JTextField weaTitle = new JTextField("Weather");
    public static JPanel weaPanel = new JPanel(null);
    public static JLabel weatherIcon = new JLabel();
    public static JTextField weather = new JTextField();

    public static JTextField over = new JTextField();

    public static JTextField pmTitle = new JTextField("P.m. 2.5");
    public static JPanel pmPanel = new JPanel(null);
    public static JTextField pm = new JTextField("114");

    public static JTextField idTitle = new JTextField("SMART CITY™ terminal id");
    public static JPanel idPanel = new JPanel(null);
    public static JTextArea id = new JTextArea(
            String.format("Simulation create time :\n" +
                    "%s\n" +
                    "===================================\n" +
                    "IP : 1145:1419:1916:9:ffff:cccc:\n" +
                    "12ce:97da\n" +
                    "L-L : 43°52\'43\" 23°11\'5\"\n" +
                    "===================================\n" +
                    "SMART CITY Terminal [v%s]\n" +
                    "© Gigaware Co.,Ltd. all rights\n" +
                    "reserved.\n" +
                    "===================================\n" +
                    "GIGAWARE OS [v0.1]\n" +
                    "© Gigaware Co.,Ltd. all rights\n" +
                    "reserved.\n" +
                    "===================================\n" +
                    "Command set : QGIGA(R)x64\n" +
                    "APU : QGIGA(R) i64T1F @ 64 QPB\n" +
                    "Screen : IBM QuantumLCD\n" +
                    "Screen drive : IBM QuantumLCD SC\n" +
                    "v 1.3.4\n" +
                    "RAM : GIGAWARE(R) QuantumRAM\n" +
                    "FTB web IP : 1145:1419:1916:9:fe1f:\n" +
                    "c00c:12ce:97da\n" +
                    "===================================\n" +
                    "Simulation ID : 13", LocalDateTime.now().toString(), __version__));

    // JComponents

    public static void main(String[] args) throws Exception {

        // Init

        init();

        // CrappyFakeLogger.main(null);

        log("");
        log("Initilizing frame");

        ///////////////////////////////////////// threadings////////////////////////////////////

        Thread passiveThread = new Thread(new passiveThread(), "passive thread");
        Thread weatherThread = new Thread(new weatherThread(), "weather thread");
        Thread clockThread = new Thread(new clockThread(), "clock thread");
        Thread pmThread = new Thread(new pmThread(), "pm thread");

        passiveThread.start();
        weatherThread.start();
        clockThread.start();
        pmThread.start();

        /////////////////////////////////////////// weather/////////////////////////////////////

        weaTitle.setEditable(false);
        weaTitle.setBounds(0, 15 * siz + 16, 450, siz);
        weaTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        weaTitle.setBackground(new Color(192, 255, 255));
        weaTitle.setForeground(Color.BLACK);

        weaPanel.setBounds(0, 16 * siz + 16, 450, 933 - 16 * siz);
        weaPanel.setBackground(Color.BLACK);
        weaPanel.setForeground(new Color(192, 255, 255));
        weaPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));

        weatherIcon.setBounds(161, 156 - siz / 2, 128, 128);
        weatherIcon.setIcon(sunny);

        weather.setText(String.format("sunny %d℃", temperature));
        weather.setEditable(false);
        weather.setBounds(161, 284 - siz / 2, 128, siz);
        weather.setFont(new Font("coure", Font.PLAIN, siz));
        weather.setBackground(Color.BLACK);
        weather.setForeground(new Color(192, 255, 255));
        weather.setBorder(null);

        /////////////////////////////////////////// clock///////////////////////////////////////

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

        //////////////////////////////////////////// cmd////////////////////////////////////////

        cmdTitle.setEditable(false);
        cmdTitle.setBounds(450, 200, 1100, siz);
        cmdTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        cmdTitle.setBackground(new Color(192, 255, 255));
        cmdTitle.setForeground(Color.BLACK);
        cmdTitle.setBorder(null);

        cmdPanel.setOpaque(true);
        cmdPanel.setBounds(450, 200, 1100, 600);
        cmdPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));
        cmdPanel.setBackground(Color.BLACK);

        outArea.setEditable(false);
        outArea.setBounds(50, 50, 1000, 500 - siz);
        outArea.setFont(new Font("宋体", Font.PLAIN, siz));
        outArea.setForeground(new Color(192, 255, 255));
        outArea.setBackground(Color.BLACK);

        point.setEditable(false);
        point.setBounds(50, 550 - siz, 3 * siz, siz);
        point.setFont(new Font("宋体", Font.PLAIN, siz));
        point.setForeground(new Color(192, 255, 255));
        point.setBackground(Color.BLACK);
        point.setBorder(null);

        cmdArea.setBounds(50 + 3 * siz, 550 - siz, 500 - 3 * siz, siz);
        cmdArea.setFont(new Font("宋体", Font.PLAIN, siz));
        cmdArea.setForeground(new Color(192, 255, 255));
        cmdArea.setBackground(Color.BLACK);
        cmdArea.setBorder(null);
        cmdArea.addKeyListener(new cmdKeyListener());

        ////////////////////////////////////////// over////////////////////////////////////

        over.setEditable(false);
        over.setBounds(0, 453, 95 * over.getText().length(), 95);
        over.setFont(new Font("宋体", Font.PLAIN, 95));
        over.setBackground(null);
        over.setBorder(null);
        over.setVisible(true);

        overWindow.setVisible(true);
        overWindow.setAlwaysOnTop(true);

        Thread overThread = new Thread(new overThread(), "over thread");
        overThread.start();

        /////////////////////////////////////////// pm//////////////////////////////////////

        pmTitle.setEditable(false);
        pmTitle.setBounds(1550, 0, 450, siz);
        pmTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        pmTitle.setBackground(new Color(192, 255, 255));
        pmTitle.setForeground(Color.BLACK);
        pmTitle.setBorder(null);

        pmPanel.setBounds(1550, siz, 450, 200 - siz);
        pmPanel.setBackground(Color.BLACK);
        pmPanel.setForeground(new Color(192, 255, 255));
        pmPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));

        pm.setEditable(false);
        pm.setBounds(
                225 - pm.getText().length() * 3 * siz / 4,
                (100 - siz / 2) - 3 * siz / 2,
                pm.getText().length() * 3 * siz,
                3 * siz);
        pm.setFont(new Font("宋体", Font.PLAIN, 3 * siz));
        pm.setBackground(Color.BLACK);
        pm.setForeground(new Color(192, 255, 255));
        pm.setBorder(null);

        /////////////////////////////////////////// id//////////////////////////////////////

        idTitle.setEditable(false);
        idTitle.setBounds(1550, 200, 450, siz);
        idTitle.setFont(new Font("宋体", Font.PLAIN, siz));
        idTitle.setBackground(new Color(192, 255, 255));
        idTitle.setForeground(Color.BLACK);
        idTitle.setBorder(null);

        idPanel.setBounds(1550, 200 + siz, 450, 749 - siz);
        idPanel.setBackground(Color.BLACK);
        idPanel.setForeground(new Color(192, 255, 255));
        idPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(192, 255, 255)));

        id.setEditable(false);
        id.setBounds(5, 0, 440, 743 - siz);
        id.setFont(new Font("宋体", Font.PLAIN, siz));
        id.setBackground(Color.BLACK);
        id.setForeground(new Color(192, 255, 255));
        id.setBorder(null);

        ////////////////////////////////////////////////////////////////////////////////////

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

                return "abcdefghijklmnopqrstuvwxyz";

            } else if (com.equals("dataBs")) {

                if (txt.equals("Jacob Zhang")) {
                    return "It is the author of this terminal, duh.";
                } else if (txt.equals("Shirax19")) {
                    return "A character of Jacob Zhang`s GT:NH novel.";
                } else if (txt.equals("Shirax21")) {
                    return "Shirax19`s brother.";
                } else if (txt.equals("Gigaware")) {
                    return "A hardware/software/system company, nearly an omni software company.";
                } else if (txt.equals("SMART CITY")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else if (txt.equals("")) {
                    return "";
                } else {
                    return String.format("Error 404 : \"%s\" not in data base", txt);
                }

            } else if (com.equals("heat")) {

                deltaT = Integer.parseInt(txt);
                return String.format("SMART CITY™ city heater %s: %d%c", (deltaT > 2) ? ("(Overclocked) ") : (""),
                        50 * deltaT, '%');

            } else if (com.equals("cool")) {

                deltaT = -Integer.parseInt(txt);
                return String.format("SMART CITY™ city cooler %s: %d%c", (deltaT < -2) ? ("(Overclocked) ") : (""),
                        -50 * deltaT, '%');

            } else if (com.equals("cmd")) {

                return String.format("SMART CITY Terminal [v%s]\n" +
                        "© Gigaware Co.,Ltd. all rights reserved.", __version__);
            } else if (com.equals("clean")) {

                deltaP = Integer.parseInt(txt);

                return String.format("SMART CITY™ city air cleaner %s: %.2f%c",
                        (deltaP > 2) ? ("(Overclocked) ") : (""),
                        50 * deltaP, '%');

            } else if (com.equals("song")) {

                if (txt.equals("0")) {
                    bgmAudio.stop();
                    return "BGM stopped";
                } else if (txt.equals("1")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "1.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("2")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "2.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("3")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "3.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("4")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "4.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("5")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "5.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("6")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "6.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("7")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "7.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else if (txt.equals("8")) {
                    bgmAudio = new AudioPlay(Paths.get(assetPath.toString(), "song", "8.wav").toString());
                    bgmAudio.start();
                    return "Now playing";
                } else {
                    return "Unknown song, try song\\1~8";
                }

            } else {
                return String.format("Unknown command \"%s\"", com);
            }

        } catch (Exception e) {
            return e.toString();
        }

    }

    // char转byte

    public static byte[] getBytes(char[] chars) {
        Charset cs = Charset.forName("UTF-8");
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);

        return bb.array();

    }

    public static void init() {
        // init.

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

        rootFrame.add(weaTitle);
        rootFrame.add(weaPanel);
        weaPanel.add(weather);
        weaPanel.add(weatherIcon);

        overWindow.setBounds(500, 0, 2000, 95);
        overWindow.setOpacity(0.5F);
        overWindow.add(over);

        rootFrame.add(pmTitle);
        rootFrame.add(pmPanel);
        pmPanel.add(pm);

        cmdPanel.add(outArea);
        cmdPanel.add(point);
        cmdPanel.add(cmdArea);

        rootFrame.add(idTitle);
        rootFrame.add(idPanel);
        idPanel.add(id);

        jokeFrame.setSize(490, 260);
        jokeFrame.setLayout(null);
        jokeFrame.setLocationRelativeTo(null);
    }

}
