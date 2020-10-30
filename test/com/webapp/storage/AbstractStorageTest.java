package com.webapp.storage;

import com.webapp.ResumeTestData;
import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {

    final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = ResumeTestData.createResume(UUID_1, "fullName1");
    private static final Resume RESUME_2 = ResumeTestData.createResume(UUID_2, "fullName2");
    private static final Resume RESUME_3 = ResumeTestData.createResume(UUID_3, "fullName3");
    private static final Resume RESUME_4 = ResumeTestData.createResume(UUID_4, "fullName4");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume newResume = new Resume(UUID_1, "fullName1");
        storage.update(newResume);
        Assert.assertSame(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        List<Resume> resumes = storage.getAllSorted();
        try {
            Assert.assertEquals(3, resumes.size());
            Assert.assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), resumes);
        } catch (Exception e) {
            Assert.fail("Resume lists are not equal");
        }
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}