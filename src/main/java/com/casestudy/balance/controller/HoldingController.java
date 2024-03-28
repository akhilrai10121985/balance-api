package com.casestudy.balance.controller;

import com.casestudy.balance.error.MemberNotFoundExcepion;
import com.casestudy.balance.model.Holding;
import com.casestudy.balance.service.HoldingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/holding")
@Slf4j
public class HoldingController {

    @Autowired
    HoldingService holdingService;

    @Operation(summary = "Retrieve member holdings", description = "retrieves member holdings in all funds from data source")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "503", description = "Internal server error")})
    @GetMapping("/{memberCode}")
    public ResponseEntity<List<Holding>> getHoldings(@PathVariable("memberCode") String memberCode)
            throws MemberNotFoundExcepion {
        log.info("getHoldings for member : {}", memberCode);
        List<Holding> holdings = holdingService.getMemberHoldings(memberCode);
        log.info("member holdings : {}", holdings);
        return ResponseEntity.ok(holdings);
    }

}
