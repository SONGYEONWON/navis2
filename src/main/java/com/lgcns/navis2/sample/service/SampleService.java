package com.lgcns.navis2.sample.service;

import com.lgcns.navis2.sample.mapper.SampleMapper;
import com.lgcns.navis2.sample.dto.SampleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleMapper sampleMapper;

    public List<SampleDTO> getList() throws Exception{
        return sampleMapper.getList();
    }

    public void saveSample(@Valid List<SampleDTO> sampleDTOList) throws Exception{
        for(SampleDTO curr : sampleDTOList){
            sampleMapper.saveSample(curr);
        }

    }

    public void createSample(List<SampleDTO> sampleDTOList) {
        for(SampleDTO curr : sampleDTOList){
            sampleMapper.createSample(curr);
        }
    }
}