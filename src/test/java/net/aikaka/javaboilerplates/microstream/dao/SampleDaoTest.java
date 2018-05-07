package net.aikaka.javaboilerplates.microstream.dao;

import net.aikaka.javaboilerplates.core.entity.SampleEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SampleDaoTest {

    private SampleDao sampleDao;

    @Before
    public void before() {
        List<SampleEntity> list = new ArrayList<>();
        list.add(new SampleEntity());
        sampleDao = new SampleDao(list);
    }

    @Test
    public void testGetSamples() {
        assertNotNull(sampleDao);
        assertNotNull(sampleDao.getSamples());
        assertTrue(sampleDao.getSamples().size() > 0);
    }
}
