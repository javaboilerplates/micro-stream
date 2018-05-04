package net.aikaka.javaboilerplates.microstream.service;

import net.aikaka.javaboilerplates.microstream.dao.SampleDao;
import reactor.core.publisher.Flux;

public interface GetSamplesService {
    Flux<SampleDao> all();
    Flux<SampleDao> allByName(String keyword);
}
