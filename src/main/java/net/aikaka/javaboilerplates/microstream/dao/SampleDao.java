package net.aikaka.javaboilerplates.microstream.dao;

import net.aikaka.javaboilerplates.core.entity.SampleEntity;

import java.io.Serializable;
import java.util.List;

public class SampleDao implements Serializable {

    private final List<SampleEntity> samples;

    public SampleDao(List<SampleEntity> samples) {
        this.samples = samples;
    }

    public List<SampleEntity> getSamples() {
        return samples;
    }
}
