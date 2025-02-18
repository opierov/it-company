package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JacksonParser {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        RootData data = mapper.readValue(new File("src/main/resources/data.json"), RootData.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
        //System.out.println(data);
    }
}
