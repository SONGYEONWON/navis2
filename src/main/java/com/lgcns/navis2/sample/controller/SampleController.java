package com.lgcns.navis2.sample.controller;

import com.lgcns.navis2.common.CustomCollectionValidator;
import com.lgcns.navis2.sample.dto.SampleDTO;
import com.lgcns.navis2.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SampleController {

    private final SampleService sampleService;
    private final CustomCollectionValidator customCollectionValidator;

    @GetMapping("/api/dbtest")
    public List<SampleDTO> retrieveSample() throws Exception {
        List<SampleDTO> list = sampleService.getList();
        return list;
    }

    @PutMapping("/api/dbtest")
    public List<SampleDTO> saveSample(@RequestBody @Valid List<SampleDTO> sampleDTOList, BindingResult bindingResult) throws Exception {


        for(SampleDTO curr : sampleDTOList){
            System.out.println(curr.getCurrency());
        }

        sampleService.saveSample(sampleDTOList);
        List<SampleDTO> list = sampleService.getList();

        return list;
    }

    @PostMapping("/api/dbtest")
    public List<SampleDTO> createSample(@RequestBody @Valid List<SampleDTO> sampleDTOs, BindingResult bindingResult) throws Exception {

        customCollectionValidator.validate(sampleDTOs, bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println("ERROR !!!");
            throw new BindException(bindingResult);
        }
        sampleService.createSample(sampleDTOs);
        List<SampleDTO> list = sampleService.getList();

        return list;
    }

//    @PostMapping("/api/dbtest")
//    public List<SampleDTO> createSample(@RequestBody @Valid SampleDTO sampleDTOList, Errors errors) throws Exception {
//        if(errors.hasErrors()){
//            System.out.println("ERROR");
//        }
//        List<SampleDTO> list = sampleService.getList();
//
//        return list;
//    }


}