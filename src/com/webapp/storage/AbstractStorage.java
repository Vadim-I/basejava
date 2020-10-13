package com.webapp.storage;

import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    public void update(Resume resume) {
        SK key = getExistedKey(resume.getUuid());
        updateResume(resume, key);
    }

    protected abstract void updateResume(Resume resume, SK key);

    public void save(Resume resume) {
        SK key = getNotExistedKey(resume.getUuid());
        saveResume(resume, key);
    }

    protected abstract void saveResume(Resume resume, SK key);

    public Resume get(String uuid) {
        SK key = getExistedKey(uuid);
        return getResume(key);
    }

    protected abstract Resume getResume(SK key);

    public void delete(String uuid) {
        SK key = getExistedKey(uuid);
        deleteResume(key);
    }

    protected abstract void deleteResume(SK key);

    public List<Resume> getAllSorted() {
        List<Resume> list = copyResumeList();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> copyResumeList();

    private SK getExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract SK getKey(String uuid);

    protected abstract boolean isExist(SK key);
}
