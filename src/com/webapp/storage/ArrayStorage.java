package com.webapp.storage;

import com.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void recordNewResume(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeletedResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
