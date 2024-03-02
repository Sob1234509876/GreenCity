package Main.threads;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class cmdKeyListener implements KeyListener {
    public void keyPressed(KeyEvent k) {
        if (k.getKeyChar() == '\n') {
            Main.Main.outArea.setText(Main.Main.command(Main.Main.cmdArea.getText()) + '\n');
            Main.Main.pressedKey = '\0';
            Main.Main.cmdArea.setText(null);
        }
    }

    public void keyTyped(KeyEvent k) {
    }

    public void keyReleased(KeyEvent k) {
    }
}
