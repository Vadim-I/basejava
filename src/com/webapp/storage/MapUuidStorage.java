package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.*;

/**
 * MapStorage for Resumes < uuid, resume >
 */
public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> map = new HashMap<>();

    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected void saveResume(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void deleteResume(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected List<Resume> copyResumeList() {
        return new ArrayList<>(map.values());
    }

    public int size() {
        return map.size();
    }

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }
}
