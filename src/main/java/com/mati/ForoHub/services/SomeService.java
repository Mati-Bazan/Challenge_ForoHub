package com.mati.ForoHub.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class SomeService {

    public List<String> getSomeData(String username) {
        return Arrays.asList("Data1", "Data2", "Data3");
    }
}
