package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.Client;

import java.io.File;

public class JAXBParser {

    private static final Logger logger = LogManager.getLogger(JAXBParser.class);

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Client.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Client client = (Client) unmarshaller.unmarshal(new File("src/main/resources/company_JAXB.xml"));

            logger.info("Client parsed: {}", client.getName());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(client, new File("src/main/resources/output.xml"));

            logger.info("XML written to output.xml");

        } catch (JAXBException e) {
            logger.error("Error during JAXB parsing: ", e);
        }
    }
}
