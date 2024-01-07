package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Record;
import com.example.backend.repository.RecordRepository;

import jakarta.transaction.Transactional;

@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Transactional
    public void registerRecord(Record record) {
        recordRepository.saveAndFlush(record);
    }

}
