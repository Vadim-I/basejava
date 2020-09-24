package com.webapp.storage;

import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object key = getKey(resume.getUuid());
        if (!isExist(key)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        updateResume(resume, key);
    }

    protected abstract void updateResume(Resume resume, Object key);

    public void save(Resume resume) {
        Object key = getKey(resume.getUuid());
        if (isExist(key)) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume, key);
    }

    protected abstract void saveResume(Resume resume, Object key);

    public Resume get(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(key);
    }

    protected abstract Resume getResume(Object key);

    public void delete(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(key);
    }

    protected abstract void deleteResume(Object key);

    protected abstract Object getKey(String uuid);

    protected abstract boolean isExist(Object key);
}
