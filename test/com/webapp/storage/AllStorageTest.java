package com.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ArrayStorageTest.class,
    SortedArrayStorageTest.class,
    ListStorageTest.class,
    MapUuidStorageTest.class,
    MapResumeStorageTest.class,
    PathStorageTest.class,
    FileStorageTest.class,
    XmlStorageTest.class,
    JsonStorageTest.class,
    DataStorageTest.class,
    SqlStorageTest.class
})
public class AllStorageTest {
}
