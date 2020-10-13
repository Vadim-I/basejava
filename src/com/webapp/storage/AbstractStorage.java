package com.webapp.storage;

import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

//    protected final Logger log = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK key = getExistedKey(resume.getUuid());
        updateResume(resume, key);
    }

    protected abstract void updateResume(Resume resume, SK key);

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK key = getNotExistedKey(resume.getUuid());
        saveResume(resume, key);
    }

    protected abstract void saveResume(Resume resume, SK key);

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK key = getExistedKey(uuid);
        return getResume(key);
    }

    protected abstract Resume getResume(SK key);

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK key = getExistedKey(uuid);
        deleteResume(key);
    }

    protected abstract void deleteResume(SK key);

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = copyResumeList();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> copyResumeList();

    private SK getExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " is not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " is exist already");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract SK getKey(String uuid);

    protected abstract boolean isExist(SK key);
}
