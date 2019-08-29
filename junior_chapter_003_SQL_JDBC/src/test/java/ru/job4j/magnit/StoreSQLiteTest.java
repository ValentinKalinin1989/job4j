package ru.job4j.magnit;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreSQLiteTest {

    @Test
    public void checkConnectionGenerateLoad() {
        ConfigSQLite configSQLite = new ConfigSQLite();
        configSQLite.init();
        StoreSQLite sql = new StoreSQLite(configSQLite);
        sql.generate(100);
        List<StoreSQLite.Entry> list = sql.load();
        try {
            sql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StoreXML storeXML = new StoreXML("file.xml");
        storeXML.save(list);
        ConvertXSQT.convert(new File("file.xml"), new File("result.xml"), new File("scheme.xslt"));
        assertThat(list.get(0).getValue(), is(1));
        assertThat(list.get(50).getValue(), is(51));
        assertThat(list.get(99).getValue(), is(100));
        try {
            sql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
