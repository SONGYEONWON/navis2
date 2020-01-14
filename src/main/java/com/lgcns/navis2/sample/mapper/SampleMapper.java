package com.lgcns.navis2.sample.mapper;

import com.lgcns.navis2.sample.dto.SampleDTO;

import javax.validation.Valid;
import java.util.List;

public interface SampleMapper {
    public List<SampleDTO> getList() throws Exception;

    public void saveSample(SampleDTO sampleDTO) throws Exception;

    public void createSample(SampleDTO sampleDTO);
}

