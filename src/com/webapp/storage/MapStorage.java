package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * MapStorage for Resumes < uuid, resume >
 */
public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, Object uuid) {
        map.put(String.valueOf(uuid), resume);
    }

    @Override
    protected void saveResume(Resume resume, Object uuid) {
        map.put(String.valueOf(uuid), resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return map.get(String.valueOf(uuid));
    }

    @Override
    protected void deleteResume(Object uuid) {
        map.remove(String.valueOf(uuid));
    }

    public Resume[] getAll() {
        String[] uuids = map.keySet().toArray(new String[0]);
        Arrays.sort(uuids);
        Resume[] values = new Resume[map.size()];
        for (int i = 0; i < map.size(); i++) {
            values[i] = map.get(uuids[i]);
        }
        return values;
    }

    public int size() {
        return map.size();
    }

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey(String.valueOf(uuid));
    }
}
