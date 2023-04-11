package com.example.storage.service.impl;

import com.example.storage.dao.StorageDao;
import com.example.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(long productId, int count) {
        storageDao.update(productId,count);
    }
}
