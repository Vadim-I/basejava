package com.webapp.storage;

import com.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        updateResume(resume);
    }

    protected abstract void updateResume(Resume resume);

    public void save(Resume resume) {
        saveResume(resume);
    }

    protected abstract void saveResume(Resume resume);

    public Resume get(String uuid) {
        return getResume(uuid);
    }

    protected abstract Resume getResume(String uuid);

    public void delete(String uuid) {
        deleteResume(uuid);
    }

    protected abstract void deleteResume(String uuid);
}
