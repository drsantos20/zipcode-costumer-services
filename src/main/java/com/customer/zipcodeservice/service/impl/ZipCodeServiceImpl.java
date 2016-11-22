package com.customer.zipcodeservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.zipcodeservice.exception.ZipCodeException;
import com.customer.zipcodeservice.mock.ZipCodeDataMock;
import com.customer.zipcodeservice.model.ZipCode;
import com.customer.zipcodeservice.service.ZipCodeService;

@Component
public class ZipCodeServiceImpl implements ZipCodeService {
   
   @Autowired
   private ZipCodeDataMock zipCodeDataMock;
   
   public ZipCode getZipCodeByDesc(String zipCodeNumber) throws ZipCodeException {

      final List<ZipCode> cepList = zipCodeDataMock.getAvailableZipCodeList();
      ZipCode zipCodeFound = null;

      for (ZipCode zipCode : cepList) {
         if (zipCode.getZipCodeNumber().equals(zipCodeNumber)) {
            zipCodeFound = zipCode;
            break;
         }
      }

      if (zipCodeFound == null) {
         throw new ZipCodeException("zipCode " + zipCodeNumber + " not found");
      }

      return zipCodeFound;
   }

}
