package com.webapp.storage;

import com.webapp.exception.NotExistStorageException;
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
    protected void updateResume(Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void deleteResume(String uuid) {
        if (!(map.containsKey(uuid))) {
            throw new NotExistStorageException(uuid);
        } else {
            map.remove(uuid);
        }
    }

    public Resume[] getAll() {
        String[] uuids = new String[map.size()];
        Resume[] values = new Resume[map.size()];
        int index = 0;
        for (Resume resume : map.values()) {
            uuids[index] = resume.getUuid();
            index++;
        }
        Arrays.sort(uuids);
        index = 0;
        for (String uuid : uuids) {
            values[index] = map.get(uuid);
            index++;
        }
        return values;
    }

    public int size() {
        return map.size();
    }
}
