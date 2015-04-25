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
        setTrayIcon(Base.path + "/assets/img/icon.png");
    }

    private static void startServer() {
        new Server("0.0.0.0", 9999);
    }

    private static void setTrayIcon(String imagePath) {
        if (SystemTray.isSupported()) {
            MenuItem defaultItem = new MenuItem();
            defaultItem.setLabel("Exit");
            defaultItem.addActionListener(e -> System.exit(0));

            PopupMenu popup = new PopupMenu();
            popup.add(defaultItem);

            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(imagePath), "Control Panel", popup);
            trayIcon.addActionListener(e -> startServer());

            try {
                SystemTray tray = SystemTray.getSystemTray();
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
    
}