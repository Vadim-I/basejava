package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume " + resume.getUuid() + " is not present");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > 0) {
            System.out.println("Resume " + resume.getUuid() + " is present already");
        } else if (size > STORAGE_LIMIT) {
            System.out.println("Resume storage is full");
        } else {
            saveResume(resume, index);
        }
    }

    protected abstract void saveResume(Resume resume, int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.print("Resume " + uuid + " is not present: ");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " is not present");
        } else {
            deleteResume(index);
        }
    }

    protected abstract void deleteResume(int index);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
