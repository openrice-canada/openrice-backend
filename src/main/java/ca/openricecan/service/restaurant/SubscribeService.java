package ca.openricecan.service.restaurant;

import ca.openricecan.data.entity.restaurant.SubscribeEntity;
import ca.openricecan.repository.restaurant.SubscribeRepository;
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
