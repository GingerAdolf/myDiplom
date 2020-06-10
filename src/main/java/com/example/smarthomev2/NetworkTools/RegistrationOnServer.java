package com.example.smarthomev2.NetworkTools;






import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationOnServer {
    private URL url;
    private String login;
    private String password;

    public RegistrationOnServer() { }
    public RegistrationOnServer(String login, String password) throws MalformedURLException {
        this.url = new URL(new UrlsDataBase().urlRegistration);
        this.login = login;
        this.password = password;
    }
    public String inputMessage() throws IOException {
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return "ok";
    }


}
