package ru.itvitality.sbrf.cu.library;

import ru.itvitality.sbrf.cu.library.dao.ClientDao;
import ru.itvitality.sbrf.cu.library.dao.impl.ClientDaoImpl;
import ru.itvitality.sbrf.cu.library.entities.Client;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Starter {
    private static final Map<Integer, String> dataStore = new HashMap<>();
    public static void main( String args[] ) throws IOException {
        ClientDao clientDao = new ClientDaoImpl();

        Client client = new Client();
        client.setName( "Test1" );
        clientDao.insert( client );
        dataStore.put(client.getId(), client.getName());

        client = new Client();
        client.setName( "test2" );
        clientDao.insert( client );
        dataStore.put(client.getId(), client.getName());
        System.out.println("Список пользователей в библиотеке: " + dataStore);
        saveToFile(dataStore);

        clientDao.list().forEach( c -> System.out.println( c ) );
    }

    public static String path = "library/file.md";
    private static void saveToFile(Map<Integer, String> dataStore) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        Gson gson = new Gson();
        String data = gson.toJson(dataStore);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
            writer.flush();
        }
    }
}
