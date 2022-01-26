package org.example;

import java.util.Date;

public class ClientPhoneNumber {
    private int client_id;
    private String phoneNumber;
    private String type_id; //(1 - основной, 2 - дополнительный)
    private Date createdClientPhoneNumber;
    private Date deletedClientPhoneNumber;

    public ClientPhoneNumber(){}
}
