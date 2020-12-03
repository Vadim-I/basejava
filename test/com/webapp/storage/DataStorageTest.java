package com.webapp.storage;

import com.webapp.storage.serializer.DataStreamSerializer;

public class DataStorageTest extends AbstractStorageTest {

    public DataStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}
