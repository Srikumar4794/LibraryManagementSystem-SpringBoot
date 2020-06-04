package com.projects.lms.controller;

import com.projects.lms.dto.BookLoanDTO;
import com.projects.lms.service.FineService;
import com.projects.lms.vo.FineVO;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class FineController {
    private final FineService fineService;

    @GetMapping(path = "/api/v1/fines/{cardId}")
    public List<FineVO> getFinesForBorrower(@PathVariable Long cardId)
    {
        return fineService.getFinesByCardId(cardId);
    }

    @GetMapping(path = "/api/v1/refresh-fines")
    public void refreshAllFines()
    {
        fineService.updateFines();
    }

    @PutMapping(path = "/api/v1/pay-fine/{loanId}")
    public FineVO payFine(@PathVariable Long loanId, @RequestBody BookLoanDTO bookLoanDTO)
    {
        return fineService.updateFine(loanId, bookLoanDTO);
    }
}
