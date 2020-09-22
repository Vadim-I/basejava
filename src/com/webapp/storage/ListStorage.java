package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * ListStorage for Resumes
 */
public abstract class ListStorage extends AbstractStorage {

    private final List<Resume> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        list.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        list.add(resume);
    }

    @Override
    protected Resume getResume(int index) {
        return list.get(index);
    }

    @Override
    protected void deleteResume(int index) {
        list.remove(index);
    }

    public Resume[] getAll() {
        return (Resume[]) list.toArray();
    }

    public int size() {
        return list.size();
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
