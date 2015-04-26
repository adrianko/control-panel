package main;

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
    }

    private void setTrayIcon(String imagePath) {
        if (SystemTray.isSupported()) {
            MenuItem defaultItem = new MenuItem();
            defaultItem.setLabel("Exit");
            defaultItem.addActionListener(e -> System.exit(0));

            PopupMenu popup = new PopupMenu();
            popup.add(defaultItem);

            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(imagePath), "Control Panel", popup);

            try {
                SystemTray tray = SystemTray.getSystemTray();
                tray.add(trayIcon);
                new Server("0.0.0.0", 9999);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
    
}