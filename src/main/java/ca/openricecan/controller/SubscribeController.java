package ca.openricecan.controller;

import ca.openricecan.model.entity.subscribe.SubscribeEntity;
import ca.openricecan.service.subscribe.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/subscribe")
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

    @GetMapping(path = "{id}")
    public SubscribeEntity getSubscribeById(@PathVariable UUID id){
        return subscribeService.getSubscribeById(id);
    }

    @PostMapping
    public SubscribeEntity addSubscribe(@RequestBody SubscribeEntity subscribeEntity) {
        return subscribeService.addSubscribe(subscribeEntity);
    }

    @PutMapping(path = "{id}")
    public SubscribeEntity editSubscribe(@PathVariable UUID id, @RequestBody SubscribeEntity subscribeEntity) {
        return subscribeService.editSubscribe(id, subscribeEntity);
    }

    @DeleteMapping(path = "{id}")
    public SubscribeEntity deleteSubscribe(@PathVariable UUID id) {
        return subscribeService.deleteSubscribe(id);
    }
}
