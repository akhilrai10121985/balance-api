package com.casestudy.balance.service;

import com.casestudy.balance.model.Holding;

import java.util.List;

public interface HoldingService {
    List<Holding> getMemberHoldings(String memberCode);
}
