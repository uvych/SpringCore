package com.gb.vtb.springcore;

import com.gb.vtb.springcore.config.PrepareDataApp;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class App {
        public static void main(String[] args) throws Exception {
            PrepareDataApp.forcePrepareData();
            Server server = new Server(8080);

            ProtectionDomain domain = App.class.getProtectionDomain();
            URL location = domain.getCodeSource().getLocation();

            WebAppContext webAppContext = new WebAppContext();
            webAppContext.setContextPath("/app");
            webAppContext.setWar(location.toExternalForm());

            server.setHandler(webAppContext);
            server.start();
            server.join();
        }
}
