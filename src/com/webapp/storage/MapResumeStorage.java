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

    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
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
