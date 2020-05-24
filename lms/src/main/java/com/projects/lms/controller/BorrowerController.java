package com.projects.lms.controller;

import com.projects.lms.service.BorrowerService;
import com.projects.lms.vo.BorrowerVO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class BorrowerController {
    private final BorrowerService borrowerService;

    @GetMapping(path = "/api/v1/borrowers")
    public List<BorrowerVO> getAllBorrowers()
    {
        return borrowerService.getAllBorrowers();
    }

    @PostMapping(path = "/api/v1/borrower/")
    public BorrowerVO addNewBorrower(@RequestBody BorrowerVO borrowerVO)
    {
        return borrowerService.insertBorrower(borrowerVO);
    }

}
