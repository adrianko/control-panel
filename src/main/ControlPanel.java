package main;

import main.app.controllers.Sleep;
import main.core.Base;
import main.core.Server;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

/**
 * TODO Add mustache for views
 */
public class ControlPanel {
    
    public static void main(String[] args) {
        new ControlPanel();
    }

    public ControlPanel() {
        setTrayIcon(Base.path + "/assets/img/icon.png");
        new Server("0.0.0.0", 9999);
    }

    private void setTrayIcon(String imagePath) {
        if (SystemTray.isSupported()) {
            MenuItem sleep = new MenuItem();
            sleep.setLabel("Sleep");
            sleep.addActionListener(e -> Sleep.execute());
            
            MenuItem exit = new MenuItem();
            exit.setLabel("Exit");
            exit.addActionListener(e -> System.exit(0));

            PopupMenu popup = new PopupMenu();
            popup.add(exit);
            
            try {
                SystemTray tray = SystemTray.getSystemTray();
                tray.add(new TrayIcon(Toolkit.getDefaultToolkit().getImage(imagePath), "Control Panel", popup));
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
    
}