package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.*;

/**
 * MapStorage for Resumes < uuid, resume >
 */
public class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, Object resumeKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Object resumeKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object resumeKey) {
        return (Resume) resumeKey;
    }

    @Override
    protected void deleteResume(Object resumeKey) {
        map.remove(((Resume) resumeKey).getUuid());
    }

    @Override
    protected List<Resume> copyResumeList() {
        return new ArrayList<>(map.values());
    }

    public int size() {
        return map.size();
    }

    @Override
    protected Resume getKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object resumeKey) {
        return map.containsValue((Resume) resumeKey);
    }
}
