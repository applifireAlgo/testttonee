package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
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
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Gender gender = new Gender();
        gender.setGender("l5AySBvXbY9OaIml6sBgyz8uOogxW4m6MYgEqtqZXS8BYEYFYF");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("ikqKph7Q1zflqELF7ARIW6lai0xweTQlSmxG7FAz2Y47GEeJGS");
        timezone.setCities("G0w8S3TM6RZVFJynW89CQEtQroDXCBq3ZXnDl2GlAZMbkRl5j7");
        timezone.setUtcdifference(10);
        timezone.setCountry("vwA2Kh3UcK2gc46AeT1O4ZTgpd11AZCwaoDzJzwB4l5ETFfoAp");
        timezone.setTimeZoneLabel("NRgmlzdiFBRkRRnlBMtUJ6JXpTDwZkfMs35Z03VgzT2JVDpX7y");
        Language language = new Language();
        language.setLanguage("91ZJzhpYoiQgAZnzcbjISgWExEjJMUob5inVNt1wprH0cfumNF");
        language.setAlpha4parentid(10);
        language.setLanguageDescription("tbnwjIIakr8X3PYqeGfjzeFgklO5y3mFiK1SJ6KDPq3mq0DFSQ");
        language.setAlpha2("id");
        language.setLanguageType("vdikD9S67CZnCoCaX0FbtVqsrM54vzfT");
        language.setLanguageIcon("sPalEDeXEntwjig9qQ8GUVpHtoBvLY6uxRCbQOMmaQBtH7ZlfO");
        language.setAlpha3("E4F");
        language.setAlpha4("QmHl");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("XBJhIu0G2OAYsENDRScAnB5d5vZLqoPwwV6jLSkbCQzoM1YwA9");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("5Z9MS05uYs1vDo7EnINV");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460532721640l));
        corecontacts.setLastName("jWG3htvYGZbf4SiuPTiHdvYnx3udgsmcqDPgzja6cajQBJ5HhQ");
        corecontacts.setNativeMiddleName("zBUz12hpSiIMzv1IVmU1Pt59hlgU8rvO4N5PmodwPtmqtn8ntj");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("cRD18BLAwQbcfhf6ZI0xl9BLzkJXMRfY8qG3G9E71ptLOyN85d");
        corecontacts.setMiddleName("rwGlv5XH7nClflDzNsNSnrQXyCM9mMzzt40IGcIMQyim4X0lAF");
        corecontacts.setEmailId("j71kX9niBOSOHWaGLsV80oHYx7Pfs2dFxMvCLxQ00Cyla8998j");
        corecontacts.setNativeFirstName("lr9x6ph6jHNmSYaMfVTtygPLkGjnwY2fgyRPQENFxRa4nXSs5E");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("aeSy1jtp1PN5qjGwAPPEK0R0ppmXl0EyoIcSrpVZAz1gCNS5TF");
        corecontacts.setFirstName("iIbD88DPwY1q1ckb9R5fCM7WbpBB7ITn19ZTY3HGQ2eakM4AtH");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460532721801l));
        corecontacts.setAge(5);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("rRdsrlQZlK0uJsUccTiZtW8TCdKyWHDVk1WJb3Hd3jxHnGh3em");
        communicationgroup.setCommGroupName("X726TkkJInomFwARasdmRy8vbk88JRG1zDdf1AgqklO0YfFuBR");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("ZwVMBUAlEn8W88spIOT3DvKiu7PcjTfyXIJj6Ntw9K9cAqcpMr");
        communicationtype.setCommTypeName("a8Iagso8zd3JcclNhECZRic9QcEFZcN8HUfXphGLObsVaxsvRA");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("zHoiitCnOAsW5kFzIjn1pICLLSnTsX0nCgHSUB6dWDRaIBIUKI");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("w4frsUlXsrQLTO2MygLdBn1bT8ugPVbRgOA8Ciy9x4eUwaf35o");
        addresstype.setAddressTypeIcon("27G2AU5iA4RuLRjDTFFHMXcJAwNFiK1N6r77XEsz3vNtWzqhTo");
        addresstype.setAddressType("Cr8h6df0wvIT8UWzx3t03op6Uojc3yAn3agmcvhwYJuCF7YxZn");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("fEUcEGtT54uMlVrQx25VBl15IS3GOYhyTcikcIAiicS5eGUiRN");
        city.setCityCodeChar2("YOAT8otkTszbmVBjqq7Jx2GaVICp7zpB");
        Country country = new Country();
        country.setCapitalLongitude(9);
        country.setCountryFlag("cT3sQN7448M7tAo9xL2712UDe88Qcgk3i5cRSOAPpj4QEFAFwe");
        country.setIsoNumeric(132);
        country.setCountryCode2("9W5");
        country.setCurrencyCode("i70");
        country.setCountryCode1("v2D");
        country.setCapital("XzOrhgINa5bGFZLfYrETUZutILLk1vnS");
        country.setCurrencySymbol("D7YEvn3Qqbid8G4eNL7uU28MltRnmpt8");
        country.setCapitalLatitude(7);
        country.setCountryName("TrOxGq2wG5arE468YsuKI4b6Uf7kqvk5tHLPsyQEh07ZVP3cPa");
        country.setCurrencyName("1f4hvnF1M3j0TGaM2co6sxs3PVpvfpD3cTAmVQsn6xl3t6A0XU");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("nVngYUSrsm7Y82Uy942NLb9A0uVCfEyELShwPETrvgWrZaY2O4");
        state.setStateCodeChar2("vKHsvLB01MazsnP1zNzs8an0LyPCB6ji");
        state.setStateCode(2);
        state.setStateCapital("OTMbakuflSRLmSZJWn47nNg3HzjkfOlnHT2NGIkKugWuEY4TC2");
        state.setStateCodeChar3("gJFrxJfUsko785zy99vndRfLQquYLqZR");
        state.setStateFlag("cWGRVSA66igQp5sJjEwT2eFL3NsGVz6evfwdsXyRffJErONZlb");
        state.setStateCodeChar2("7QQ1dB3ikC6sTDfqyA6LYp7EUmQobuzt");
        state.setStateCode(1);
        state.setStateCapital("NGSCxv50IuwXKS6HafXNUO7iIXM0fuTiKWdPYHKS8yMRQrr4pf");
        state.setStateCodeChar3("7dFCQC9bG9GOSk5YPuw9ygvW0yrzOhEn");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("wkyPSYCNXyBInuw1ur8K31ZbhoqwhLfFxlvftwKqRn3ysmhiMe");
        state.setStateName("wsz8l7U3dAHkvm0aObwol332vavYQQYzlWXlrPnmutJQJgSuwL");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(9);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("m0G37PVz3ERGAXxkSuFnNwQsZoC6RBr7IE5KYdIqZUXdzi25fn");
        city.setCityCodeChar2("NAjsyo6Ub0TM0ueVeJgimb4z30KThurx");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("FAqdvHYVMb7NfPzgIAj2slt1gv4BeqslVjYBOOqZ4xrxYaSD8b");
        city.setCityLatitude(7);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(10);
        city.setCityCode(1);
        city.setCityFlag("gIuNycIkkd5gU88uuUwknyKtvopLSo195mzkIneYEdgkzsCQWm");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("ObaHaS0XH1Ac7UBU88ez4kAUyenQOJyk7OMsAdYptvLGJFR8Wo");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("03q2bvnvltErJIrIwfvDcXoqtTIvJRJ4ltLebV2LcM5lF5Gl1X");
        address.setAddress1("S4qH6XgQnt1j2HBVAz1JIF7r2m1Yn7iNOL7uAG7scN9SXoq3Iw");
        address.setZipcode("ItlqKQ");
        address.setAddress2("RTCuVTP0ldLy5HAoaO0S6a6E8lj3u7DiIISfO1Ed8pvfMvzIoI");
        address.setAddressLabel("sfDOjbcN7Z6");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("kQWQZE1Wrjo69nwBspXYmhJ20fi7DYWVJo6E2CF2lo49K0LwuO");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setPhoneNumber("ADXuEB4MnP3W8FopBUHt");
            corecontacts.setVersionId(1);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1460532722547l));
            corecontacts.setLastName("XyvLapBoiNuNYzsUPWDn98mWjnRwtoC6O4E4ab4KF3i0Cz2AIC");
            corecontacts.setNativeMiddleName("THI9TitbfdUrh8Z61K4mqtkVMS22Vq5YfMVFs8MoNbvKMO5W8t");
            corecontacts.setNativeLastName("x8qsJXg93szDUPtlZnG7vRdgvxDRDSJmdeH2vPp9hwJX30RlYd");
            corecontacts.setMiddleName("2rWWPYIvgKZ0E316TQgyngScCnVeW6tNUp5fndkPPgUyXVqXkD");
            corecontacts.setEmailId("o4u4UGldqzINXVBmWg9TZZOuIqfgkU6JJHZDHLvsMQ9cPfefbg");
            corecontacts.setNativeFirstName("CEFnx1vEqVMfYTZOgtKaaBRvtNqbubq1OCcCCsRYVF6gAFbGPS");
            corecontacts.setNativeTitle("xGjZTaCSPOn7WrZl1Hwrn58GEcmynxja7HGZBYLproSrVcCdI8");
            corecontacts.setFirstName("NxdTZmUiRypj6zFdiKJnlk22mhxw5kIkJKJOTr6YeWz3CT9Zuv");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1460532722846l));
            corecontacts.setAge(115);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "nG17N5ZbXZVGfirLvjY73hAQJYW6842p5xuC3z0dyrK3nwo0N3mY3jf3c28Ek3EnzsVRuSiiyrgYMCYeuMNalbqr4JY63wQYmoZkxX9j8cg3mFgaHMrcQQejW0D4l385uGzhYTaHeTVBFy1bKpn37wnehjVXI5IuXEHUMfOMClu6A7IGmYcB1tG16USP3duMBadYntrdhpSfIvQWeWCtmIOfUqWBin0Z05OxVZcs3nsM9XNuWVPeTka7JXVhYfM40"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "jWixOAmzMtEf5Wp5rbQjT8okBLdi245A1TXJlCDksji1ptoatsKrU7bX8uPp5kVQjefUqEKyZw27aHenMHiYOVrT69lKy0dQ3sCEJhjD094wf3YMUuuqNnOqllH3eAYEm2LfgZEmvQMbkH4J91CqrQQDYBznaL8qZkPiN9OX5omMOY9UfngTNeoTBZ3ta2xdKTOnOyCQRxNGVf5GXC66uXE6Anx6ehZbbDUpoE1HdLWbT9JJ6hq0cFCaWN93r3oUJ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "BJCab2SJRtPCOLPumip6OkJDXb88KXqGdr3MttRPN5OUJKW1Tw8rkNHfCmUN9DjvrAlsKWbghX0BXsj6d0aJ1tdE0EgNh3eSOuQpOcqRhp0pMhkOQaIG1eliV6hlv6xR2Uja1C4oTECIv2weEYrdmBLh6uw3ZfP3hxrYDN1TyyXGXMwVngad6vtyF5Hv4kLCT5b5IlfebWO8yiCOHoSYFrGvZFB29o6pnNi9R1vEaYKKn9Wd1VDZlEsssyiROnn9y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "jMjiVHCLr6fx03i8HwQfXJNcGqcWEMEP6maZqDIQDoAKKxKRHC4bHLPkbZkgPIMWW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "26nyvgDEZBJteKmOZ6R2svAaRzLzJtIM8M1Qj9XcMahViVV2KM0ORhkWZmFlioQoDGXzeOsxGWI7F0iE4ytGlomwJ0sOtkCck2aeyRUpoE1mC4eTExmkWi6fUhHbThuAHUDumQG6oKnjn3ajN2OgRRRf532PNH0kv0TCHTC2bDbABj3OmzafdYe8YFpXpesuR2H1Yx3I8qdI1JRCWNXjAZ8ogQ2A7tDYARFwqt3gwrZ4O48Dpi6Rlb5F3mshHJ1aL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "KhOzRK1omntdMwm8xlgtnvHfaqpdkPUNcO46t9bQkuLKlkY6P43w8clz8Vl8IticHJfnabrdO8was0RmKAboN7BQ5PdmiLY1JXteLrVa0pNFB8WLOeTdDnaMKf8VHg555hXgnw6e3GX5Mh6x6Tkj0rb2PeELZ2ZxfrPpHhnEqARb8dlfHC7lmlSLbwKFKlvmoz08kHiAhi4L0CAu7N1J5lT8EwIpa3c4BcsEqOWFEBMkyBBIdBNPnR8usVniYzYWm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "GCoOMOBwDlpwIu5O7mf86oCvyAN5RgXm1Zr44Yc6ZKOxRYYmFXD8MSWRdk1rfDYrvK34Suw4XqlXrbZlBvIil9pASE9iKl0aPy1KxEfYm67ayclokAo8KASR9PDDIAh1UyplbkwZ5kkFeXvOQ5D253e5VuoLDwMVP55m4xXMMPOdfOytNCbnkcqQGOEwMvMNYUTz90zkLbpOdXCwLIARKL4K4UHoTxUDs0l7OJ1jwZN4RaMy2rh6llPJmXSH8692y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 214));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "mOOHVVV35eM2THRagShlzWZRofUmqPWMvUg67SR7GVHMVGJ9UDX9VECAkDEFtZlRDDCz7OkxHu57IK3pYcpzm2FXOpNDsZmY35W9C85grtubxNqsdf8xMr9NAnt0UtW7t2LPOccc52ez4YUjcewLpjanfXLJrRgP0l75tWRGeNI7d5Otcs9g3XEZjUTGCdCfEuG1TV8ZdBHbPQGIgJVgWsgohUVTZYEsUB938PazXGjIY73P3lsnhq39l98P5ewYO"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "klVAAFp1YSG9mQKConMo3"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
