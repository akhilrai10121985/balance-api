package com.casestudy.balance.service;

import com.casestudy.balance.error.MemberNotFoundExcepion;
import com.casestudy.balance.model.Holding;
import com.casestudy.balance.repository.HoldingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class HoldingServiceImplTest {

    @InjectMocks
    HoldingServiceImpl holdingService;
    @Mock
    private HoldingRepository holdingRepository;

    @Test
    void testGetMemberHoldings() {
        List<Holding> holdings = new ArrayList<>();
        createHoldings(holdings);
        String memberCode = "m1";
        when(holdingRepository.findByMemberCode(memberCode)).thenReturn(holdings);
        assertEquals(holdings, holdingService.getMemberHoldings(memberCode));
        verify(holdingRepository, times(1)).findByMemberCode(memberCode);
    }

    @Test
    void testErrorScenario() {
        RuntimeException runtimeException = assertThrows(MemberNotFoundExcepion.class, () -> {
                    holdingService.getMemberHoldings("m1@");
                }

        );
        String expectedMessage = "Member not found";
        String actualMessage = runtimeException.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    private void createHoldings(List<Holding> holdings)
    {
        Holding holding = new Holding();
        holding.setId(1);
        holding.setMemberCode("m1");
        holding.setFundCode("f1");
        holding.setUnits(100);
        holdings.add(holding);
    }
}
