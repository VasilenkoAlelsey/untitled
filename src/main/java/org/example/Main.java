package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Date currentDate = new Date();
        Client client = new Client();
        client.setClient_id(15);
        client.setCreatedClientDate(currentDate.getTime());
        client.setDeletedClientDate(currentDate.getTime());

        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(stringWriter, client);

        String result = stringWriter.toString();
        System.out.println(result);
    }
}
