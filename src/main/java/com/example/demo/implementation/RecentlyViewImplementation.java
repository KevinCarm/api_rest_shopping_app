package com.example.demo.implementation;

import com.example.demo.model.RecentlyView;
import com.example.demo.repository.RecentlyViewRepository;
import com.example.demo.service.RecentlyViewService;
import org.springframework.stereotype.Service;

@Service
public class RecentlyViewImplementation implements RecentlyViewService {
    private final RecentlyViewRepository repository;

    public RecentlyViewImplementation(RecentlyViewRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public RecentlyView saveRecently(long id_user, long id_product) {
        return repository.saveRecently(id_user, id_product);
    }


}
