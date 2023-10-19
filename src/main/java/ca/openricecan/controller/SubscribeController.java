package ca.openricecan.controller;

import ca.openricecan.model.entity.subscribe.SubscribeEntity;
import ca.openricecan.service.subscribe.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "subscribe")
public class SubscribeController {
    private final SubscribeService subscribeService;

    @Autowired
    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @GetMapping
    public Iterable<SubscribeEntity> getSubscribeList() {
        return subscribeService.getAllSubscribes();
    }
}
