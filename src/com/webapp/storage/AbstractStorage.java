package com.webapp.storage;

import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object key = getExistedKey(resume.getUuid());
        updateResume(resume, key);
    }

    protected abstract void updateResume(Resume resume, Object key);

    public void save(Resume resume) {
        Object key = getNotExistedKey(resume.getUuid());
        saveResume(resume, key);
    }

    protected abstract void saveResume(Resume resume, Object key);

    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return getResume(key);
    }

    protected abstract Resume getResume(Object key);

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        deleteResume(key);
    }

    protected abstract void deleteResume(Object key);

    public List<Resume> getAllSorted() {
        List<Resume> list = copyResumeList();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> copyResumeList();

    private Object getExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistedKey(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract Object getKey(String uuid);

    protected abstract boolean isExist(Object key);
}
