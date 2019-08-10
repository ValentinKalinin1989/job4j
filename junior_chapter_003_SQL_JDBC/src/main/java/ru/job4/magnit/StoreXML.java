package ru.job4.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * convert List<Entry> to xml file
 */
public class StoreXML {
    private final String path;
    /**
     * constructor
     * @param path path to save fale
     */
    public StoreXML(final String path) {
        this.path = path;
    }
    /**
     * convert List<Entry> to xml file
     * @param list
     */
    public void save(List<StoreSQLite.Entry> list) {
        List<Field> listF = new ArrayList<>(list.size());
        for (StoreSQLite.Entry element: list) {
            listF.add(new Field(element.getValue()));
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new User(listF),
                    new FileWriter(this.path));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
    @XmlRootElement
    public static class User {
        private List<Field> values;

        public User() {
        }

        public User(List<Field> values) {
            this.values = values;
        }

        public List<Field> getValues() {
            return values;
        }

        public void setValues(List<Field> values) {
            this.values = values;
        }
    }
    @XmlRootElement
    public static class Field {
        private int value;

        public Field() {
        }

        public Field(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
