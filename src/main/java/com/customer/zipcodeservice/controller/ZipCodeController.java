package com.customer.zipcodeservice.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customer.zipcodeservice.exception.ZipCodeException;
import com.customer.zipcodeservice.model.BadStatus;
import com.customer.zipcodeservice.model.ZipCode;
import com.customer.zipcodeservice.service.ZipCodeService;
import com.customer.zipcodeservice.util.ZipCodeValidation;

@Controller
@RequestMapping("/")
public class ZipCodeController {
   
   private static final int MAX_RETRY_QUANTITY = 8;
   private static final String ZERO = "0";
   
   @Autowired
   private ZipCodeService zipCodeService;

   @RequestMapping(method = RequestMethod.POST)
   public @ResponseBody ZipCode getCep(@RequestBody ZipCode zipCode) throws ZipCodeException {
      
      ZipCodeValidation.validateCEP(zipCode);

      return getCepWithRetry(zipCode.getZipCodeNumber(), 1);
   }

   private ZipCode getCepWithRetry(String zipCodeNumber, int tentative) {

      ZipCode zipCode = null;

      try {
         zipCode = getLocalCep(zipCodeNumber);
      }
      catch (ZipCodeException e) {

         if (tentative <= MAX_RETRY_QUANTITY) {
            zipCodeNumber = StringUtils.reverse(StringUtils.reverse(zipCodeNumber).substring(tentative)) + replaceLeftZero(tentative);
            zipCode = getCepWithRetry(zipCodeNumber, ++tentative);
         }
      }

      return zipCode;
   }
   
   private String replaceLeftZero(int quantity) {

      String zero = "";
      int i = 0;

      while (i < quantity) {
         zero = zero + ZERO;
         i++;
      }

      return zero;
   }

   private ZipCode getLocalCep(String desc) throws ZipCodeException {
      return zipCodeService.getZipCodeByDesc(desc);
   }

   @ExceptionHandler(ZipCodeException.class)
   public @ResponseBody BadStatus exceptionHandler() {
      return new BadStatus("zip code is invalid");
   }

}
