package ca.openricecan.service.subscribe;

import ca.openricecan.model.entity.subscribe.SubscribeEntity;
import ca.openricecan.repository.subscribe.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public SubscribeEntity getSubscribeById(UUID id) {
        return subscribeRepository.findById(id).orElse(null);
    }

    public SubscribeEntity addSubscribe(SubscribeEntity subscribeEntity) {
        return subscribeRepository.save(subscribeEntity);
    }

    public SubscribeEntity editSubscribe(UUID id, SubscribeEntity subscribeEntity) {
        return subscribeRepository.findById(id).map(subscribe -> {
            subscribeEntity.setSubscribeId(id);
            return subscribeRepository.save(subscribeEntity);
        }).orElse(null);
    }

    public SubscribeEntity deleteSubscribe(UUID id) {
        return subscribeRepository.findById(id).map(subscribe -> {
            subscribe.setActive(false);
            return subscribeRepository.save(subscribe);
        }).orElse(null);
    }
}
