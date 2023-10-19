package ca.openricecan.service.subscribe;

import ca.openricecan.model.entity.subscribe.SubscribeEntity;
import ca.openricecan.repository.subscribe.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public Iterable<SubscribeEntity> getAllSubscribes() {
        return this.subscribeRepository.findAll();
    }
}
