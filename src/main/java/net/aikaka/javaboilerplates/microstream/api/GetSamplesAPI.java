package net.aikaka.javaboilerplates.microstream.api;

import net.aikaka.javaboilerplates.microstream.dao.SampleDao;
import net.aikaka.javaboilerplates.microstream.service.GetSamplesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class GetSamplesAPI {

    private final GetSamplesService getSamplesService;

    public GetSamplesAPI(GetSamplesService getSamplesService) {
        this.getSamplesService = getSamplesService;
    }


    @GetMapping(value = "/samples", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<SampleDao> all() {
        return getSamplesService.all();
    }

    @GetMapping(value = "/samples/name/{keyword}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<SampleDao> allByName(@PathVariable String keyword) {
        return getSamplesService.allByName(keyword);
    }
}
