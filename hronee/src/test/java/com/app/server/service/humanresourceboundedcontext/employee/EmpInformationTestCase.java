package com.app.server.service.humanresourceboundedcontext.employee;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.humanresourceboundedcontext.employee.EmpInformationRepository;
import com.app.shared.humanresourceboundedcontext.employee.EmpInformation;
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
import com.app.shared.humanresourceboundedcontext.employee.JobType;
import com.app.server.repository.humanresourceboundedcontext.employee.JobTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
import com.app.shared.humanresourceboundedcontext.employee.DesignationType;
import com.app.server.repository.humanresourceboundedcontext.employee.DesignationTypeRepository;
import com.app.shared.humanresourceboundedcontext.employee.DepartmentType;
import com.app.server.repository.humanresourceboundedcontext.employee.DepartmentTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EmpInformationTestCase extends EntityTestCriteria {

    @Autowired
    private EmpInformationRepository<EmpInformation> empinformationRepository;

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

    private EmpInformation createEmpInformation(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        JobType jobtype = new JobType();
        jobtype.setJobDescOne("y7PGv3wj7tbaZNvfZtrgrLX2E9m9vhTHHU817F66VccKA4CFzg");
        JobType JobTypeTest = new JobType();
        if (isSave) {
            JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("gzmajrbnCOTtUHP34k8b");
        Gender gender = new Gender();
        gender.setGender("EbBHbsD2joTfaRSivdOkcWcvZtXO9I9uIqe8RtrBdVG6CzqTlQ");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("ygn88dbX3DLDZbkko5OceIOMsKPjoKQEZWKt8nuuz5N67rEkIf");
        timezone.setCities("QZHax2bID70vnXSO7aewdRZ7e9ntXhHWherUv728q34EX0DcaC");
        timezone.setUtcdifference(11);
        timezone.setCountry("cN7VpXltQJiapaadwh6T10fTbhQQSsOo1K6uHPEOUea0O7XacK");
        timezone.setTimeZoneLabel("cPgyEH5xKBJnFMTuxfq0P9zyj65jShH9664cTdnjnkjEXY9A16");
        Language language = new Language();
        language.setLanguage("rYtBC6X168Yv9CEHr6ACtrpoe75KbofAun5AtVGlgVKzQeyif7");
        language.setAlpha4parentid(10);
        language.setLanguageDescription("rtAJkT3batTIvRiE2sKxa2MF11PqnY3iwG5tAzcEEZ1v6noqGj");
        language.setAlpha2("FB");
        language.setLanguageType("9rP1vlZCes9rNGxObxh9ctqO21yRxHOv");
        language.setLanguageIcon("UNuzjicYCJgYt1z3EbXWof9tlBQ1aQSg6Zf7LYZERCCGIBuuRI");
        language.setAlpha3("Q9C");
        language.setAlpha4("GSYx");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("CWNY2LVcNVWYz52C7H0bc2PbwQ1UGJcyQS1URq7uy5OlJwObcJ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setPhoneNumber("V5VrWJwReIpig2f78NUc");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460545602489l));
        corecontacts.setLastName("57BGwCT1Dvhn1Ooz6mf1z5HXKjvSjKP2Cx0XRhB2ytEBaImsOZ");
        corecontacts.setNativeMiddleName("OEfe5boyv8tZk84r1YLgyhp5MT4k6DlWTvZUrlnKXfatyqbsju");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("bQJv6GRVUaTaXJGt005sqlHrcl7pb4C2U22sD9s0bix3D42Moa");
        corecontacts.setMiddleName("Es1iD5Mmnalg5OmXoEzpm8skqtB8IQZHn0XwmEX6PVsDDhVNkl");
        corecontacts.setEmailId("k4YQ1k8TuxBTzvwMm3Hz10IkcEt2du0vxN1d0GqblT8Rss9x3a");
        corecontacts.setNativeFirstName("GQ3eGpyn53IO2qvHCevdwQLOGRFTXjzOSolCB1cjn9d0zAayBM");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("zQptYvX3ifop4hjvgrh4cHMU7dNFiyBPcAEFHTguvunEZcZmz2");
        corecontacts.setFirstName("9g2IbRbLrXEYkZiYK2ZZrqOECDlH1bguv2ryKRcRh7uPnjt27W");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460545602643l));
        corecontacts.setAge(40);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("roow8rYDwzaBVsbFr8SZyaME4vipLnAUCAv2vRqpBEc6ZcDja6");
        communicationgroup.setCommGroupName("5iqRhJWBHYsyn4JccUCVK9x8dE0MOdpvlZoZpHMqyPEPP460ei");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("3c4wyuSp0DqCG7Kg1YKEA0CpzEDEqDnJ3mwXGxoCqTzYNy7wzQ");
        communicationtype.setCommTypeName("shKUf8Rrdry8D4ki8NC6pHiccLBBqy0IJ5AryYnmyqyRtDOCwu");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("tZyUBvnKRVSM8G8lfzoNbCck7yOJ6OsbIvL5gyNjzX2JI2IKQF");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("ehhU4qWRVKQjr31A7EHtdWmrbA5Fzg4athY92OrKa5kPpVwPWG");
        addresstype.setAddressTypeIcon("iNRJRYeDR5K0BDsBLP6fZJaIEYTC0zxnPQkDylwV6U3jXyEBEv");
        addresstype.setAddressType("2KeuaUG8PEG4Ql7yXK5M2j3OOQhPkvDaTbsIHoaAQSEbWePAyH");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("q6ZO1emHKMBGw7VxXJOTmE9s8TAAOpiT9Jm1LCo5KeA8l3TNpf");
        city.setCityCodeChar2("LS3SiBluMEFylDisnJP7soOumZsMurug");
        Country country = new Country();
        country.setCapitalLongitude(10);
        country.setCountryFlag("dKLE2GeR1qCFE3jfhRLRMbTmILtIvFT1MJ4Kq8POBikq0T3ccI");
        country.setIsoNumeric(341);
        country.setCountryCode2("4Td");
        country.setCurrencyCode("9uL");
        country.setCountryCode1("Vch");
        country.setCapital("3aIQ1CP6mDVtHY3OD7pVol35ez0FNvUo");
        country.setCurrencySymbol("8sGFEN9iTv27HWKXEcCJT5NcCbqpxhoz");
        country.setCapitalLatitude(11);
        country.setCountryName("ueGRWXBxu9YlwgkObkpi3OkpXoL5nXUp5h7tf2H11tjU4awfI6");
        country.setCurrencyName("Itmp7ebFG7M2pCRGoYKRVMlCUbkxzmh1Hids4HknlVq6627171");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("0WqQCIEdU5r5geANS4UqDipOPOAQUdkedH7Z6JYI6eDAGeZscF");
        state.setStateCodeChar2("h2kRRBVIyXZ1Hq9uHni8ug9b2vzAXp3S");
        state.setStateCode(2);
        state.setStateCapital("HvBfUFEXy0TRttwQDUUY7PtMDBzp1c7lRu9rNIPqorjebvV95h");
        state.setStateCodeChar3("wRCnw8vIrFdJdoVQeziAOjv5l6zkJ8Ym");
        state.setStateFlag("UTk8cgacjkjMTPnk8yr3yTPSU9NFHZD2mTlINAENtRqHHQYN99");
        state.setStateCodeChar2("6zaE1HnkMjsG7V0xDBCuypjKE4OQhYRB");
        state.setStateCode(2);
        state.setStateCapital("gr5PM4FSg5EljcWazWBT8HvZZR3wRLTjZpIR16vbVO4YrMtVIh");
        state.setStateCodeChar3("BGSgGbfYaJGYb474TeoCD5E4lHvqvqip");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("Dmg3alZpuTDabFJkXlCrsITJ1TOn01imOPcU3XaJC6t4hplgzE");
        state.setStateName("cEITcTznX4nytRNZIrDRXobRiD5jp6mFAwVTmHXS7M5c4ASbgN");
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLatitude(11);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("8KQ2mdeuyQIzdx7xaoSGRzreTRvgNSPqS1ZJx85xNTuFsAETld");
        city.setCityCodeChar2("sAoWwEE0HFRUM9LngXxy88sMaG2GTvgA");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("DUXHz4VhcBu20m5Hjy92k3r2DV0WmlVViFIJnCaZeI3PjmSJ6Z");
        city.setCityLatitude(5);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityCode(2);
        city.setCityFlag("iMCrMBb36V21tpzwgopLGMhuk9v466aY4inOsIPZWMagtD6Nbw");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("FYyPhgcSBf11QAirj05sx6wNyrPahO7HXwQ14P7xwwUvyJXkZ4");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("PUqLbDH5C4wnyzQ0g85IXVp4Rjua56FAp4f0gyAez4jwU7g6Ip");
        address.setAddress1("0cx7TLSWp2xYNZPQA1tql0NUIDa48ww8Kt0WyEpxxv7ETfd89Z");
        address.setZipcode("AeLFag");
        address.setAddress2("VIZqSB3SShLGN1sYuPJHbwAa5TXBQiYaTuRgoyN7JPUFEpx1eA");
        address.setAddressLabel("gsSCaCOdVXB");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("1OaZAcTfrUrr0nkxFp42i5tWqRoMsUxFCmIcvNYjgAYDGvGuDE");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        DesignationType designationtype = new DesignationType();
        designationtype.setDesignatnTypeDesc("tag7xLxdET4cXjcWnDCLaSgJ4P1iyh9UaXekznJLS41V2SD1Os");
        DesignationType DesignationTypeTest = new DesignationType();
        if (isSave) {
            DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
        }
        DepartmentType departmenttype = new DepartmentType();
        departmenttype.setDeptTypeDesc("PaYalcdxcUFCBsQGzPKmsBETMdkKJnZY2dFRUbDzUxnksi3mGl");
        DepartmentType DepartmentTypeTest = new DepartmentType();
        if (isSave) {
            DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
        }
        EmpInformation empinformation = new EmpInformation();
        empinformation.setPan("SJnT7p4SFl1zAjXCbMnCXWMpNyJnfa3QxmFnA91p40zu98OjZf");
        empinformation.setReportingOfficer("lrCMZxOzvU8WsHvtpa4VyDX22g7G17tmovHF3YSHaQANa6qwWL");
        empinformation.setJobTypeCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setContactId(null);
        empinformation.setCoreContacts(isSave ? corecontactsRepository.save(corecontacts) : corecontacts);
        if (isSave) {
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        }
        empinformation.setDesignationTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey());
        empinformation.setEntityValidator(entityValidator);
        return empinformation;
    }

    @Test
    public void test1Save() {
        try {
            EmpInformation empinformation = createEmpInformation(true);
            empinformation.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            empinformation.isValid();
            empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private JobTypeRepository<JobType> jobtypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private DesignationTypeRepository<DesignationType> designationtypeRepository;

    @Autowired
    private DepartmentTypeRepository<DepartmentType> departmenttypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            EmpInformation empinformation = empinformationRepository.findById((java.lang.String) map.get("EmpInformationPrimaryKey"));
            empinformation.setPan("ycjpGh8YQCm6bmzPZFpoAFrHlNpCUwd6ksU4qHaQHgoLsH9pA7");
            empinformation.setReportingOfficer("CyOGlAVpo77Wx7GCPA6qcl6SzwvSnGX7OWM2xXMiv7RzWb1Cmf");
            empinformation.setVersionId(1);
            empinformation.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            empinformationRepository.update(empinformation);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            empinformationRepository.findById((java.lang.String) map.get("EmpInformationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByjobTypeCode() {
        try {
            java.util.List<EmpInformation> listofjobTypeCode = empinformationRepository.findByJobTypeCode((java.lang.String) map.get("JobTypePrimaryKey"));
            if (listofjobTypeCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydesignationTypeCode() {
        try {
            java.util.List<EmpInformation> listofdesignationTypeCode = empinformationRepository.findByDesignationTypeCode((java.lang.String) map.get("DesignationTypePrimaryKey"));
            if (listofdesignationTypeCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydeptTypeCode() {
        try {
            java.util.List<EmpInformation> listofdeptTypeCode = empinformationRepository.findByDeptTypeCode((java.lang.String) map.get("DepartmentTypePrimaryKey"));
            if (listofdeptTypeCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("EmpInformationPrimaryKey"));
            empinformationRepository.delete((java.lang.String) map.get("EmpInformationPrimaryKey")); /* Deleting refrenced data */
            departmenttypeRepository.delete((java.lang.String) map.get("DepartmentTypePrimaryKey")); /* Deleting refrenced data */
            designationtypeRepository.delete((java.lang.String) map.get("DesignationTypePrimaryKey")); /* Deleting refrenced data */
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            jobtypeRepository.delete((java.lang.String) map.get("JobTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateEmpInformation(EntityTestCriteria contraints, EmpInformation empinformation) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            empinformation.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            empinformation.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            empinformation.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            empinformationRepository.save(empinformation);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "reportingOfficer", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "reportingOfficer", "VqMbQY3bonO8ixv6hQKh3gy8q8uIMaxkDwQMa7nAYb4nqk2J13Dy2IK1yTLhGCwVZbGU7H4EXRHkNROYfNsZYUcaTVtJSTVIXKMwAJNjX8bMoQ34BhLKdCwl0iYMkfKo04JycwhjC9IcVUZvdWEUvmAFdOzFCUj7OSrCs5PzEdAfZJ2Va5fIxsT4vODdXemd0ppfHZlpJ6O1F7Nqs7mcwUGqiHqmjdLoTRuQbGspVZCp8jnAyTeZZxxyApOzkX9z9"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "pan", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "pan", "XSBrVCYK5xxnF0kQQB4R7MEMw55pxcsm28t5WBMWBqadcuZqgYGT25kuSft0JGFcaU3wHwDNWt7h17ZcwC2qO7sTsu1UdW5DKQoofxWfK1W0JoYODdSNzxt1drQvIl4fYYTUaPrPCvnh1UiUpn0p8TNET1Rj3jbAKU8UZt2ld70lbrvq7B7rFNQPS6O7oS6VBAZqTwnMy7Pb4xSphUAG8gZanosVCCjPOnFNcJpM2S65y9XfU74IbkYMKDXHL0OCZ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                EmpInformation empinformation = createEmpInformation(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = empinformation.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(empinformation, null);
                        validateEmpInformation(contraints, empinformation);
                        failureCount++;
                        break;
                    case 2:
                        empinformation.setReportingOfficer(contraints.getNegativeValue().toString());
                        validateEmpInformation(contraints, empinformation);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(empinformation, null);
                        validateEmpInformation(contraints, empinformation);
                        failureCount++;
                        break;
                    case 4:
                        empinformation.setPan(contraints.getNegativeValue().toString());
                        validateEmpInformation(contraints, empinformation);
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
