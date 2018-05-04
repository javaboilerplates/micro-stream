package net.aikaka.javaboilerplates.microstream.service;

import net.aikaka.javaboilerplates.core.interactor.GetSamplesInteractor;
import net.aikaka.javaboilerplates.core.interactor.GetSamplesInteractorImpl;
import net.aikaka.javaboilerplates.microstream.dao.SampleDao;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class GetSamplesServiceImpl implements GetSamplesService {

    private final GetSamplesInteractor getSamplesInteractor;

    public GetSamplesServiceImpl() {
        getSamplesInteractor = new GetSamplesInteractorImpl();
    }

    @Override
    public Flux<SampleDao> all() {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(800));
        Flux<SampleDao> stockTransactionFlux = Flux.fromStream(
            Stream.generate(() -> new SampleDao(getSamplesInteractor.all()))
        );
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }

    @Override
    public Flux<SampleDao> allByName(String keyword) {
        Flux<Long> interval = Flux.interval(Duration.ofMillis(800));
        Flux<SampleDao> stockTransactionFlux = Flux.fromStream(
            Stream.generate(() -> new SampleDao(getSamplesInteractor.allByName(keyword)))
        );
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }
}
