package com.projects.lms.service;

import com.projects.lms.dao.IBorrowerDao;
import com.projects.lms.entity.BorrowerEntity;
import com.projects.lms.translator.IBorrowerTranslator;
import com.projects.lms.vo.BorrowerVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BorrowerService {
    private final IBorrowerDao borrowerDao;

    @Autowired
    private IBorrowerTranslator borrowerTranslator;

    public List<BorrowerVO> getAllBorrowers()
    {
        return borrowerTranslator.toBorrowerVOList(borrowerDao.findAll());
    }

    public BorrowerVO insertBorrower(BorrowerVO borrowerVO)
    {
        if(isSsnPresent(borrowerVO))
        {
            throw new IllegalArgumentException("Invalid Ssn. Borrower exists with same ssn");
        }

        BorrowerEntity borrowerEntity = borrowerTranslator.toBorrowerEntity(borrowerVO);
        return borrowerTranslator.toBorrowerVO(borrowerDao.save(borrowerEntity));
    }

    private Boolean isSsnPresent(BorrowerVO borrowerVO) {
        BorrowerEntity existingBorrower = borrowerDao.findById(borrowerVO.getCardId()).orElse(null);

        if(existingBorrower == null)
            return false;

        return borrowerVO.getSsn().equals(existingBorrower.getSsn());
    }

}

