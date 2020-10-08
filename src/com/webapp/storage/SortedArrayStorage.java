package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based sorted storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

//    private static class ResumeComparator implements Comparator<Resume> {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    }

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected void recordNewResume(Resume resume, int index) {
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
    protected Integer getKey(String uuid) {
        Resume key = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, key, RESUME_COMPARATOR);
    }
}
