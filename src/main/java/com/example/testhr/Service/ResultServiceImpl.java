package com.example.testhr.Service;

import com.example.testhr.Repository.ResultRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService{
    private ResultRepository resultRepository;


}
