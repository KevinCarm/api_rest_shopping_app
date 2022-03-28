package com.example.demo.service;

import com.example.demo.model.RecentlyView;

public interface RecentlyViewService {
    RecentlyView saveRecently(long id_user, long id_product);

}
