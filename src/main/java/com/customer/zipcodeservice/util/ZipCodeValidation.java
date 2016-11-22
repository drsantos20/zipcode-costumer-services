package com.customer.zipcodeservice.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.customer.zipcodeservice.exception.ZipCodeException;
import com.customer.zipcodeservice.model.ZipCode;

@Component
public class ZipCodeValidation {
   
   
   public static final void validateCEP(final ZipCode zipCode) throws ZipCodeException {

      if (zipCode == null) {
         throw new ZipCodeException("invalid zip code");
      } else if (!StringUtils.isNumeric(zipCode.getZipCodeNumber()) || zipCode.getZipCodeNumber().length() != 8) {
         throw new ZipCodeException("zip code " + zipCode.getZipCodeNumber() + " is invalid");
      }

   }
}
