package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based sorted storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void recordResume(Resume resume, int index) {
        int savedIndex = -index - 1;
        System.arraycopy(storage, savedIndex, storage, savedIndex + 1, size - savedIndex);
        storage[savedIndex] = resume;
    }

    @Override
    protected void fillDeletedResume(int index) {
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
