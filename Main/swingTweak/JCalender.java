package Main.swingTweak;

import java.time.LocalDateTime;

import javax.swing.JTextArea;

public class JCalender extends JTextArea {

    public JCalender(LocalDateTime time) {

        int t = 0;
        int year = time.getYear();
        int month = time.getMonthValue();
        int dayOfWeekOfMonth = LocalDateTime.of(year, month, 1, 0, 0).getDayOfWeek().getValue();
        boolean isLeep = (year % 4 == 0) || ((year % 100 != 0) && (year % 400 == 0));

        this.setText(String.format("%s %s %s\n", time.getYear(), time.getMonth().toString(), time.getDayOfMonth()));
        this.append("Mon Tue Wed Thu Fri Sat Sun\n");
        for (int i = 1; i < dayOfWeekOfMonth; i++) {
            this.append("   ");
            t++;
            Main.Main.log(i);
        }
        this.append("   ");
        for (int i = 1; i <= time.getMonth().length(isLeep); i++) {
            this.append(String.format("%3d%s", i, (t == 6) ? ('\n') : (" ")));
            t += 1;
            t %= 7;
        }
    }

}
