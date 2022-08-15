package org.ioc.controller;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.ioc.models.XmlParser;

import org.ioc.settings.Hash;
import org.ioc.settings.Settings;

//import org.ioc.DB;


public class ControllerApp {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox login_box;

    @FXML
    private Button login_button;

    @FXML
    private VBox update_box;

    @FXML
    private Button update_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    public static String LoginName;
    public static String HashCodOld;

    @FXML
    void initialize() throws IOException, InterruptedException {
        System.out.println("ooooooo");

        System.out.println(Hash.getHashText());


        downloadFile(Settings.update, "Update.zip");

        unpackZip(Settings.zipPath, Settings.zipFile);



        Thread thread1 = Thread.currentThread();



        Thread thread = new XmlReader();
        thread.start();
        //thread1.join();
        thread.join();

        System.out.println(LoginName);
        login_field.setText(String.valueOf(LoginName));

        String hash = "fail";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(Settings.HashFile))) {
           hash = reader.readLine();
        } catch (IOException e) {
            System.out.println("test2");
        }

        System.out.println(hash);
        System.out.println(HashCodOld);
        if (!Objects.equals(hash, HashCodOld)){
            update_box.setVisible(true);
            login_box.setVisible(false);
        }



//





        //XmlParser xml = new XmlParser();








        login_button.setOnAction(actionEvent -> {
//            login_box.setVisible(false);
//            update_box.setVisible(true);
//            try {
//                DB.Open_DB();
//            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//
//            if (DB.True_connection){
//                //////////////////////////////////////////////////////////////////////////
//                boolean Connection_dekanat = false;
//                DB dataBaseHandler = new DB();//Створюємо нову змінну на основі створеного нами класу
//                ResultSet Log_pass = dataBaseHandler.Connection_Dekanat();//Викликаємо функцію з іншого класу
//                List<String> var_1_List = new LinkedList<>();
//                List<String> var_2_List = new LinkedList<>();//Створюємо список
//                List<String> var_3_List = new LinkedList<>();//Створюємо список
//                while (true) {//Запускаємо цикл на обробку даних отриманих з бази даних
//                    try {
//                        if (!Log_pass.next()) break;
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                    String Login_string = null;
//                    String Password_string = null;
//                    String Login_ID = null;
//                    try {
//                        Login_string = Log_pass.getString("Login");
//                        Password_string = Log_pass.getString("password");
//                        Login_ID = Log_pass.getString("ID_Faculty");
//                    } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                    }
//                    var_1_List.add(Login_string);//додаємо отримані результати у список
//                    var_2_List.add(Password_string);
//                    var_3_List.add(Login_ID);
//                }
//                for (int i = 0; i < var_1_List.size(); i++) {
//                    if(Objects.equals(login_field.getText(), var_1_List.get(i))){
//                        Connection_dekanat = Objects.equals(pass_field.getText(), var_2_List.get(i));
//
//                        System.out.println(var_1_List.get(i));
//                        System.out.println(var_3_List.get(i));
//                    }
//                }
//
//                if (Connection_dekanat) {
//                    System.out.println("to new class");
//                }
//                else {
//                    System.out.println("Connection failed...");
//                }
//            } else System.out.println("Connection failed...");


//            try {
//                URL url = new URL("https://github.com/DarkPoul/vers_date/archive/refs/heads/main.zip");
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
            //Path path = Paths.get("https://github.com/DarkPoul/vers_date/archive/refs/heads/main.zip").hashCode();
            //System.out.println(Paths.get("github.com/DarkPoul/vers_date/blob/main/18.08.2022").getFileName());
            //Path of = Path.of("github.com/DarkPoul/vers_date/archive/refs/heads/main.zip");
            //System.out.println(Paths.get("github.com/DarkPoul/vers_date/archive/refs/heads/main.zip").hashCode());
            //System.out.println(of.hashCode());
            //int hesh = of.hashCode();
            LinkedList<String> property = new LinkedList<>();
//            try{
//                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//                Document document = documentBuilder.parse("src/main/resources/org/ioc/settings/Config.xml");
//                Node root = document.getDocumentElement();
//                NodeList books = root.getChildNodes();
//
//                for (int i = 0; i < books.getLength(); i++) {
//                    Node book = books.item(i);
//                    // Если нода не текст, то это книга - заходим внутрь
//                    if (book.getNodeType() != Node.TEXT_NODE) {
//                        NodeList bookProps = book.getChildNodes();
//                        for(int j = 0; j < bookProps.getLength(); j++) {
//                            Node bookProp = bookProps.item(j);
//                            // Если нода не текст, то это один из параметров книги - печатаем
//                            if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                property.add(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                            }
//                        }
//                        System.out.println("===========>>>>");
//                    }
//                }
//            } catch (ParserConfigurationException ex) {
//                ex.printStackTrace();
//            } catch (IOException | SAXException e) {
//                throw new RuntimeException(e);
//            }
            //int hesh_old = Integer.parseInt(property.get(1).split(":")[1]);
            //login_field.setText(property.get(0).split(":")[1]);
            //if (hesh_old != of.hashCode()){
                login_box.setVisible(false);
                update_box.setVisible(true);
            //}

















        });
        update_button.setOnAction(actionEvent -> {
            login_box.setVisible(true);
            update_box.setVisible(false);
        });
    }


    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    private void unpackZip(String path, String zipname)
    {
        InputStream is;
        ZipInputStream zis;
        try
        {
            is = new FileInputStream(path + zipname);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;

            while((ze = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                String filename = ze.getName();
                String substring = zipname.substring(0, zipname.length() - 4);
                String s = path + substring + "\\" + filename;
                if(ze.isDirectory()) {
                    File directPath = new File(s);
                    directPath.mkdirs();
                } else {
                    File directPath = new File(path + substring + "\\");
                    directPath.mkdir();
                    FileOutputStream fout = new FileOutputStream(s);

                    // reading and writing
                    while((count = zis.read(buffer)) != -1)
                    {
                        baos.write(buffer, 0, count);
                        byte[] bytes = baos.toByteArray();
                        fout.write(bytes);
                        baos.reset();
                    }

                    fout.close();
                    zis.closeEntry();
                }
            }

            zis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return;
        }

        System.out.println(true);
    }

}


