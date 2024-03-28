package com.casestudy.balance.service;

import com.casestudy.balance.error.MemberNotFoundExcepion;
import com.casestudy.balance.model.Holding;
import com.casestudy.balance.repository.HoldingRepository;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
public class HoldingServiceImplGaugeTest {

    @Step("Invoke member holdings api with valid member code as <memberCode>")
    public void testGetMemberHoldings(String memberCode) {
        // invoke balance api over https for valid memberCodes

        // validate response

        // assert expected success response with actual response
        assertThat(1).isEqualTo(1);
    }

    @Step("Invoke member holdings api with invalid member code as <memberCode>")
    public void testErrorScenario(String memberCode) {
        // invoke balance api over https for in-valid memberCodes

        // validate response

        // assert expected error response with actual response
        assertThat(1).isEqualTo(1);
    }
}
