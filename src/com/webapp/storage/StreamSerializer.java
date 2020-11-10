package com.webapp.storage;

import com.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public interface StreamSerializer {

    void doWrite(Resume resume, OutputStream os) throws IOException;

    Resume doRead(InputStream is) throws IOException;
}
