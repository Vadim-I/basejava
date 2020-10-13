package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.*;

/**
 * MapStorage for Resumes < uuid, resume >
 */
public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> map = new HashMap<>();

    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, Resume resumeKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Resume resumeKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume resumeKey) {
        return resumeKey;
    }

    @Override
    protected void deleteResume(Resume resumeKey) {
        map.remove((resumeKey).getUuid());
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
    protected boolean isExist(Resume resumeKey) {
        return map.containsValue(resumeKey);
    }
}
