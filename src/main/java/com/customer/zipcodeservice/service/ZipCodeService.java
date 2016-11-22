package com.customer.zipcodeservice.service;

import com.customer.zipcodeservice.exception.ZipCodeException;
import com.customer.zipcodeservice.model.ZipCode;

public interface ZipCodeService {
   
   ZipCode getZipCodeByDesc(final String desc) throws ZipCodeException;

}
