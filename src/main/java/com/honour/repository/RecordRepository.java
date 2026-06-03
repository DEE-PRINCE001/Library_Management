package com.honour.repository;

import java.util.List;

public class RecordRepository {
    private List<Record> records;

    public void addRecord(Record record){
        records.add(record);
    }

    public List<Record> getRecords(){
        return records;
    }
}
