package org.example;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

@JsonAutoDetect
public class Client {
    private ClientPhoneNumber clientPhoneNumber;
    private ClientPersonalInfo clientPersonalInfo;
    private int client_id;
    private long createdClientDate;
    private long deletedClientDate;

    public Client(){}

    public ClientPhoneNumber getClientPhoneNumber() {
        return clientPhoneNumber;
    }
    public void setClientPhoneNumber(ClientPhoneNumber clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
    public ClientPersonalInfo getClientPersonalInfo() {
        return clientPersonalInfo;
    }
    public void setClientPersonalInfo(ClientPersonalInfo clientPersonalInfo) {
        this.clientPersonalInfo = clientPersonalInfo;
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public long getCreatedClientDate() {
        return createdClientDate;
    }
    public void setCreatedClientDate(long createdClientDate) {
        this.createdClientDate = createdClientDate;
    }
    public long getDeletedClientDate() {
        return deletedClientDate;
    }
    public void setDeletedClientDate(long deletedClientDate) {
        this.deletedClientDate = deletedClientDate;
    }
}
