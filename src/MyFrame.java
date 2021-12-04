import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    Panel background;

    MyFrame() throws InterruptedException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CLOCK");
        this.setSize(350, 200);
        this.setResizable(false);

        background = new Panel();
        background.setSize(350, 200);
        background.setBackground(Color.yellow);
        background.setLayout(new FlowLayout());

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 50));
        timeLabel.setForeground(Color.yellow);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
        dayLabel.setForeground(Color.yellow);
        dayLabel.setBackground(Color.black);
        dayLabel.setOpaque(true);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        dateLabel.setForeground(Color.yellow);
        dateLabel.setBackground(Color.black);
        dateLabel.setOpaque(true);

        background.add(dayLabel);
        background.add(timeLabel);
        background.add(dateLabel);
        this.add(background);
        this.setVisible(true);

        setTime();
    }

    public void setTime() throws InterruptedException {
        while (true) {
            time = timeFormat.format(calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(calendar.getInstance().getTime());
            dateLabel.setText(date);

            Thread.sleep(1000);
        }
    }
}
