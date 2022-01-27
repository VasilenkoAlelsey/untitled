package org.example;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;
import java.util.Date;

@JsonAutoDetect
public class Client {
    private String fullName;
    private String phoneType;

    public Client(){}

    public String getFullName() {
        return fullName;
    }
    public String getPhoneType() {
        return phoneType;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}
