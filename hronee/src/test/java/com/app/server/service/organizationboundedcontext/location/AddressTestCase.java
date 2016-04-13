package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("EogVT4HcfkDvTdIsEeOdWQUgAxT9M1lwQXLz7uOOeLB1wZBQ7R");
        addresstype.setAddressTypeIcon("SHogMbXKt8Oho7vrDXvItlTEeGfj2BS1dzr4ITsEqiWzgj4Dqg");
        addresstype.setAddressType("9lJGPb0z8H59c75puOa4ww26TY9Y3N3Vthe7a91Md5Aki6Ff03");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("1gdLfHqdp3mzBDr1vTUaopkwvmYdveDAKzu37wg20lY0KBNVIF");
        city.setCityCodeChar2("o9ez36cekg0kCvHR0tnaZVRis3XwVWZ9");
        Country country = new Country();
        country.setCapitalLongitude(10);
        country.setCountryFlag("2lVo0vsunrUzGUWBz4ewyhgz9yDRrFEms5K3Ms1vByY1okygAw");
        country.setIsoNumeric(823);
        country.setCountryCode2("WRP");
        country.setCurrencyCode("sP0");
        country.setCountryCode1("31I");
        country.setCapital("c0blVScikZashj4NFL57RNsDLwlvR1H0");
        country.setCurrencySymbol("u1dlHGIQvNUvcQRXOY4ouSGIBTZaa329");
        country.setCapitalLatitude(10);
        country.setCountryName("JZgDyqMrgX2qMK18v9cJD5WKfa14sNo7TPMxwNrERJZRdnAmUm");
        country.setCurrencyName("8maNESByWTpj13UTY16RZM7jhCBSjE0d3Fdus7gWZc9HZCHhgF");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("cE9QB9q11jSGoWKBLyhHfqABVOggv9gOmJEV8UyEASMwCkwaYu");
        state.setStateCodeChar2("SnUAOLoQyUwT6EzA84cshhY7fn4H6K1l");
        state.setStateCode(1);
        state.setStateCapital("8T3PaWBeZkrQ3rHWs8qdcqgjboTB7tLdahtfVep2kxygnT90ui");
        state.setStateCodeChar3("kmzvSPGUIsVhqZ5yFFumhJgdYZKuZFd9");
        state.setStateFlag("RMUPJlReMfisDuBAuvNghoq13cIug3saLVExcuWvSAF4QpllpL");
        state.setStateCodeChar2("mrfGY80rmFWtd7PXiPFV6bXfHsHVkTul");
        state.setStateCode(2);
        state.setStateCapital("ttrfatTuJC8Cr1o6O30DKBWGGSLKy3tuvg3Ep4XDtkvVWxrC8P");
        state.setStateCodeChar3("nVEdJ5Coe5h8FA7qL9ftzo8d9zfFJO5v");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("yXbwbhB9L5GdEu1zfo3m88XjmqqgrqfI6gcXiu6zc3QwpHFyXn");
        state.setStateName("qc5lmMYNcv8Cwe86j6Lp4JN4xeqngU3so3llD0PZ6GpyxX0Xcz");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(9);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("I6WbOs10ygXp0rVjztBcMENFvLB4ckHYBj8EvNBbQQaHv0C6X4");
        city.setCityCodeChar2("Z8uJtDHahFhLp0VqzsP1ahGPWGhrTFa5");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("HcUxCW9VW92cxCGWFcSGPTbE1ATk59LvhenG7lQhiOCtfZ5usI");
        city.setCityLatitude(9);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityCode(3);
        city.setCityFlag("AHpJ2UkIKmxBwIITdEQqvdqkLDZcLuWSYBhbJa4UTPqEXv43AM");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("vWEAqnfkiR3vhg6xravLuzzLXTGRJMzrMsqTaBoJwXRwfB2Vo8");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("lnEkl0NxK36S6z5klWzRfpEYdmOY9IlgEKAEHGUlWwtt6n5SdA");
        address.setAddress1("eMnoWLOGO8lnmuCtVUexB6m6HKkP1S5hbYD1mUIwbC7OktLugS");
        address.setZipcode("Lux7T1");
        address.setAddress2("yyD8xclvUcqFLLuOcGYap2lRS0hfEnbJ1YKyrCROJmkNCdOyhJ");
        address.setAddressLabel("QYSI0dJkbXz");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("iqFWhnCo9JvwVanW6mPX88018JXYob5KFlPe0NNL73RCQGgQZ5");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("EKECnx45u5nlraES79vhFUlh7RqYtf9VQ02Kkuj4G99AwnB3X9");
            address.setAddress3("X5hq3dLcSEXcte1bvhmCrx3eP1REyjcOtnynxvPoqYW8GNYdbu");
            address.setVersionId(1);
            address.setAddress1("F8BA1LoX6UswbiYYrIt17DzMDUKDskFIxCDJTW0OeuXkgBPDwq");
            address.setZipcode("W0czUO");
            address.setAddress2("dRoAdMuD1Ue93x2qK1bH2Fq4qWUmhw60cPeo3dlDbN1QR0Gc9g");
            address.setAddressLabel("sr0eKsuQSxF");
            address.setLatitude("UmQxVYGUFjTXMyxCzkBIAygbJuqWlE2QRzLYy1HIngwT1Niouj");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "7R2KTE2VGlOo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "i0pXveHZ3KdDxMOQrvB4aqhucqA6wBQhnBqzHOmr8oaxWFCVNX4BBkv77"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "41VVPpRNoS88dscP9CXjPZ15foxZOFaM4IJM81qI1aKImfMwVasNml2Tb"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "Rpc7p0U0B7Z132x6Zo35WXdqqBNfFg1BiEZacqYYl2TfRld0TsclgqLXH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "YL1ld68"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "DxLj0EG0hhxg1by7X54t2vNGE29kmCcaotybIdh5NFh4beoLH9hvp6Px76gbubwsO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "kPaEfbiOwD6vpaoIC8nZL7Wv5LDwjr8bLAz3qGOZvO520lhAVy4rqxpTcmZS5qiKR"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
