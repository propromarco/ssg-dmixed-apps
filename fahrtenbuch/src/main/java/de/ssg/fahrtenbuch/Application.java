package de.ssg.fahrtenbuch;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false);
		ConfigurableApplicationContext ctx = builder.run(args);
		// ApplicationContext ctx = SpringApplication.run(Application.class, args);

		final URL icoPath = Application.class.getResource("/kalender.png");

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		if (SystemTray.isSupported()) {
			final SystemTray systemTray = SystemTray.getSystemTray();
			final ImageIcon imageIcon = new ImageIcon(icoPath, "omt");
			final TrayIcon trayIcon = new TrayIcon(imageIcon.getImage(), "Java App");
			trayIcon.setImageAutoSize(true);

			final PopupMenu popup = new PopupMenu();
			// Create a popup menu components
			// MenuItem startItem = new MenuItem("Start");
			// MenuItem stopItem = new MenuItem("Stop");
			MenuItem exitItem = new MenuItem("Exit");

			// Add components to popup menu
			// popup.add(startItem);
			// popup.add(stopItem);
			popup.add(exitItem);
			trayIcon.setPopupMenu(popup);

			exitItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					systemTray.remove(trayIcon);
					SpringApplication.exit(ctx);
					System.exit(0);

				}
			});

			try {
				systemTray.add(trayIcon);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// String[] beanNames = ctx.getBeanDefinitionNames();
		// Arrays.sort(beanNames);
		// for (String beanName : beanNames) {
		// System.out.println(beanName);
		// }
	}

}
