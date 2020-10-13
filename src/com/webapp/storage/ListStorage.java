package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * ListStorage for Resumes
 */
public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    @Override
    protected void updateResume(Resume resume, Integer index) {
        list.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Integer index) {
        list.add(resume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return list.get(index);
    }

    @Override
    protected void deleteResume(Integer index) {
        list.remove(index.intValue());
    }

    @Override
    protected List<Resume> copyResumeList() {
        return new ArrayList<>(list);
    }

    public int size() {
        return list.size();
    }

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }
}
