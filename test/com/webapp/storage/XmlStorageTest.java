package com.webapp.storage;

import com.webapp.storage.serializer.XmlStreamSerializer;

public class XmlStorageTest extends AbstractStorageTest {

    public XmlStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}