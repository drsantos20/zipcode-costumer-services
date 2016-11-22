package com.customer.zipcodeservice.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.customer.zipcodeservice.model.ZipCode;

@Component
public class ZipCodeDataMock {
   
   private List<ZipCode> availableZipCodeList;

   @PostConstruct
   public void generatorInit() {

      availableZipCodeList = new ArrayList<ZipCode>(1);

      ZipCode zipcode1 = new ZipCode();
      zipcode1.setZipCodeNumber("09994144");
      zipcode1.setNeighbourhood("Campos Eliseos");
      zipcode1.setCity("São Paulo");
      zipcode1.setState("SP");
      zipcode1.setStreet("Rua Conselheiro Nebias");

      availableZipCodeList.add(zipcode1);

      ZipCode zipcode2 = new ZipCode();
      zipcode2.setZipCodeNumber("01202001");
      zipcode2.setNeighbourhood("Jardins");
      zipcode2.setCity("São Paulo");
      zipcode2.setState("SP");
      zipcode2.setStreet("Rua Sete de Abril");

      availableZipCodeList.add(zipcode2);

      ZipCode zipcode3 = new ZipCode();
      zipcode3.setZipCodeNumber("03544562");
      zipcode3.setNeighbourhood("Republica");
      zipcode3.setCity("São Paulo");
      zipcode3.setState("SP");
      zipcode3.setStreet("Alameda Glete");

      availableZipCodeList.add(zipcode3);

      ZipCode zipcode4 = new ZipCode();
      zipcode4.setZipCodeNumber("08896541");
      zipcode4.setNeighbourhood("Jardim Marajoara");
      zipcode4.setCity("São Paulo");
      zipcode4.setState("SP");
      zipcode4.setStreet("Rua Esquina das Alamedas");
      
      availableZipCodeList.add(zipcode4);

      ZipCode zipcode5 = new ZipCode();
      zipcode5.setZipCodeNumber("08874122");
      zipcode5.setNeighbourhood("Santa Cecilia");
      zipcode5.setCity("São Paulo");
      zipcode5.setState("SP");
      zipcode5.setStreet("Avenida São Josão");
      
      availableZipCodeList.add(zipcode5);

      ZipCode zipcode6 = new ZipCode();
      zipcode6.setZipCodeNumber("09944881");
      zipcode6.setNeighbourhood("Campos Eliseos");
      zipcode6.setCity("São Paulo");
      zipcode6.setState("SP");
      zipcode6.setStreet("Rua Northmann");
      
      availableZipCodeList.add(zipcode6);

      ZipCode zipcode7 = new ZipCode();
      zipcode7.setZipCodeNumber("100000001");
      zipcode7.setNeighbourhood("Santa Cecilia");
      zipcode7.setCity("São Paulo");
      zipcode7.setState("SP");
      zipcode7.setStreet("Alameda Campinas");

      availableZipCodeList.add(zipcode7);
   }

   public List<ZipCode> getAvailableZipCodeList() {
      return availableZipCodeList;
   }

   public void setAvailableZipCodeList(List<ZipCode> availableZipCodeList) {
      this.availableZipCodeList = availableZipCodeList;
   }

}
