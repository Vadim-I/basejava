package com.webapp.storage;

import com.webapp.exception.StorageException;
import com.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateResume(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    protected void saveResume(Resume resume, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Resume storage is full", resume.getUuid());
        } else {
            recordNewResume(resume, index);
            size++;
        }
    }

    protected abstract void recordNewResume(Resume resume, int index);

    @Override
    protected Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected void deleteResume(Integer index) {
        fillDeletedResume(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void fillDeletedResume(int index);

    @Override
    protected List<Resume> copyResumeList() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    public int size() {
        return size;
    }

    protected abstract Integer getKey(String uuid);

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }
}
