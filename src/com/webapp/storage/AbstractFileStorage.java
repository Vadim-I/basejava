package com.webapp.storage;

import com.webapp.exception.StorageException;
import com.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteResume(file);
            }
        }
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        if (files == null) {
            return 0;
        }
        return files.length;
    }

    @Override
    protected void updateResume(Resume resume, File file) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("Update error", file.getName(), e);
        }
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            if (file.createNewFile()) {
                doWrite(resume, file);
            }
        } catch (IOException e) {
            throw new StorageException("Save error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    @Override
    protected Resume getResume(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("Read error", file.getName(), e);
        }
    }

    protected abstract Resume doRead(File file) throws IOException;

    @Override
    protected void deleteResume(File file) {
        if (!file.delete()) {
            throw new StorageException("Delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> copyResumeList() {
        File[] files = directory.listFiles();
        if (files == null) {
            return null;
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(getResume(file));
        }
        return list;
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }
}
