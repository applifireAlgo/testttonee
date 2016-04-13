package com.app.server.service.humanresourceboundedcontext.payroll;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.humanresourceboundedcontext.payroll.SalStrucFinWiseRepository;
import com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise;
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
import com.app.shared.humanresourceboundedcontext.employee.EmpInformation;
import com.app.server.repository.humanresourceboundedcontext.employee.EmpInformationRepository;
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
public class SalStrucFinWiseTestCase extends EntityTestCriteria {

    @Autowired
    private SalStrucFinWiseRepository<SalStrucFinWise> salstrucfinwiseRepository;

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

    private SalStrucFinWise createSalStrucFinWise(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        EmpInformation empinformation = new EmpInformation();
        empinformation.setPan("Ribcmcio2oxMTv7GEUCWqmvddWFJ9bcoOUKaAFH3j2qIU1E86u");
        empinformation.setReportingOfficer("Jlm9XFhVLHMlVTK7Kj5Vjx9kPAZzESGn9Q7bAL23Ima6pI2F4e");
        JobType jobtype = new JobType();
        jobtype.setJobDescOne("hLlJ7N2a76iXKFWcU6ty80AqwqiwNfkTZAY7BJ0DJzUat1f6dy");
        JobType JobTypeTest = new JobType();
        if (isSave) {
            JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("ZT0cFxVg6sEwZBH3Jegd");
        Gender gender = new Gender();
        gender.setGender("6bqOFV9AYNLtK0kkXTrh4NJ2s6H02Ma7CCU6rsueO675bcKQ5s");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("xvYO3TMcynov06DhQstLXPml2DFuUkNuIcXX8rziOBQ4skQ0OQ");
        timezone.setCities("MK6E4lZuXKmt7TP3npyqP0iOINRkdJKkAHfmJmiGAZvEtrriBX");
        timezone.setUtcdifference(7);
        timezone.setCountry("92CIgQkeSUFQktNDfzqBIgCEcv4UMjbyVWSs9pCes9o34W0Kk4");
        timezone.setTimeZoneLabel("l8bLFAmi9hoI2vEhmHiCm9JYkYj5rZ2anm8kaYbKhVgeOBKtLd");
        Language language = new Language();
        language.setLanguage("6B9MszZ23EJWVJPLzirjfxmyK0wx9s9Gdw4GOmoJFCGnOYDfpJ");
        language.setAlpha4parentid(2);
        language.setLanguageDescription("uOxEcy2flNUJZ7Do1FTak7bTxbtZgw5APVrSBA6ftyXLJzsUyG");
        language.setAlpha2("ge");
        language.setLanguageType("NmN3CHfO9MEFwdsWIjSyehVmUOzlhHRj");
        language.setLanguageIcon("8gpPDI87Al2kSlQlsxfyCDNDl20Q9VmtFX8h2WH3ACJAoRywQQ");
        language.setAlpha3("7U9");
        language.setAlpha4("r7bX");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("cAQcUJHZSS7ktCBNV1116GRLIOPUCpSk5pLPZKhYQ9rrRYdx3W");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setPhoneNumber("1ZGvAkcbVrTqQEdlOXrX");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460544306178l));
        corecontacts.setLastName("4KhUhiv0lilBZgQqgK6g86T9CzTbaYVXPtkZ9CHk1ahgNtgTA1");
        corecontacts.setNativeMiddleName("le5pGJ4AmqSqYEIieIOUMfkrXe8kkYUwvvb7nkxKth7QUbfMi9");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("tYigDOsZ1ox2Xu7xxWQH7zDZ5RiHzhMGe0H2ZqWkSLEEhVCZAd");
        corecontacts.setMiddleName("Jl3LMT7dKx1ETewYbGVqoN9YnqgRRXt92LIwj2s3J4EInmRyFZ");
        corecontacts.setEmailId("Ifa1jOEoXtnXYG9oUzLEbF0z84P08oTl7rzCuIdjixT0Uc6ZU9");
        corecontacts.setNativeFirstName("VqsBVvGBylRlMLcxHs2lsG40N5qOUDVZS1a0gFwxaUqqaOsOwG");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("43xTP2BdpxTfkLG7k6xY8OEkT5KN8IRBmt2LVCmBE0XQZQQWjL");
        corecontacts.setFirstName("jX3PtZ23c61WNmx1hYq2Ye5FT7s2U2qbzv3npvspdNgPQybDbA");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460544306287l));
        corecontacts.setAge(91);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("e2Eatc4w1OPzqUvCXuwyeVlxh22KjkiILJG2jpRgETO8S5c3jI");
        communicationgroup.setCommGroupName("D6NSPNpOFpa2pSnadlnSIyG5IvAVPZanlReclPciPvQ1Baqa1N");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("S6bSxtf6uoSR6LQrZNenvt8YVVziWcq6ybFkgh1hOcGJCDGqly");
        communicationtype.setCommTypeName("ehA2aRCgIZyZqgN2XMTl6THjObDMrRuWsbA6Qez6pSHlXU77is");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("w6Pfg5ZMnD7QfVD1sHUBqpeuoYJo2mpzGQUnmW2dRqety0qBLO");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("RX6TETiNa3XHL5CLOfpK90YQ3Bx6QJvtZJpouN5nhKl0Yfsg4v");
        addresstype.setAddressTypeIcon("JhTQBVSBh5aRf58TnwGR6xsg2Db6ZKhMW5lSKIxpGvfQ6Eo5rB");
        addresstype.setAddressType("fskylwGM9SYNxrJRuUjnQH4TFQq9Ea3aaFhqzJnFcdsPZG7JNm");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("fClpasWTxrfiq8VWGUDRx7vTQyWirDNeWjd351ddXrJepH5pYz");
        city.setCityCodeChar2("4Pv6HjI4zbyToQhb7exCz4fxpGt9dhvD");
        Country country = new Country();
        country.setCapitalLongitude(4);
        country.setCountryFlag("hcUALQDVUbhbziO6z79fu3XC4joiy8wp1tCoJz5a4gMrXUhQWJ");
        country.setIsoNumeric(395);
        country.setCountryCode2("ojB");
        country.setCurrencyCode("ssG");
        country.setCountryCode1("HgL");
        country.setCapital("vpqUOW4356WK3frfDXu1g6eBfUCwoGmi");
        country.setCurrencySymbol("byXKqjRoDfPkoskaIT9xq0Gbo6Z44Gce");
        country.setCapitalLatitude(10);
        country.setCountryName("FItUpkwPOojrTXMS7cCP6hmt4fy0cqa3pR5jFTD3pTqM8v3Ugw");
        country.setCurrencyName("MjUC9TW5GQMHsAjlg0kxTTZoCapf5iAb032otMCWt6ZczEPseH");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("wOTo7bjbn8edFlB2rDG7hcC33cbo2RwMGUdQZRrVnVup94k0IW");
        state.setStateCodeChar2("M1Q80xMB3KmQQEJi882glkJQPJo0yf3u");
        state.setStateCode(2);
        state.setStateCapital("YCfzzdaMJenCGvkgNWgrDx5piz0pgBzULculRWgoe8xJiFqJVI");
        state.setStateCodeChar3("74O2DB0rPCXj20KcAy01aLVApRzdpqh8");
        state.setStateFlag("QmWwcVIxLRtuMZSqonCvUYLOHddhCJQJtFDujdsbbqbEEW3KBy");
        state.setStateCodeChar2("uhB6jzHe9Vr1n9rVJdGir4WJVmNDua2H");
        state.setStateCode(1);
        state.setStateCapital("cJ2Xg3W4CxKZt8TlgauH8ewkcwBfwoeifQlYt4iHAzdbPjTD8A");
        state.setStateCodeChar3("rOEvKAGaTHecQaLZ6KueuTamNAy5trXA");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("6GYb2IkwrMpMfImw6cA7ZMbiP7wCt130gEtccumS1wM1insUMM");
        state.setStateName("DTa1FUidwDANKP3tnRNusjJycHvD0vs4MFsKE3zDg2tYCebpYE");
        state.setStateCapitalLongitude(9);
        state.setStateCapitalLatitude(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("qD6zGShHEq3ZaiQyM354pSElfVup6jza1pvnY5OJDwxBJxEY4q");
        city.setCityCodeChar2("XjsywRg40RJwryJiFwa8XlKwpMUelB28");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("mw2xzRWE2iEYP3kMQHnz3aBoo9CQbKhJxiba8WDYopo6zo2L6k");
        city.setCityLatitude(9);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(11);
        city.setCityCode(1);
        city.setCityFlag("lkKlFBuQLcQWrM5lKf2QEfh5Av5LpPudzs0LZDVUE25rAhN329");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("K15yd2pwgFrKvvY8e7iF52RO0NPhJsk3GtfW6Ow1xFHjgZITsG");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("fOEBNQfcthCAPeybic4Js16ChDj3yRm0pRx2bo87eZCCmRtWkr");
        address.setAddress1("nUyGcp6hUmqhCemAm73f4IhqIKCbDpgHPwSx9oKPOL8qe0K2mp");
        address.setZipcode("5F6FgL");
        address.setAddress2("C3Mor9JAaGVMFHeEwXQUS8jfp5wEWDqThPAq413Fgtb5K8GTgL");
        address.setAddressLabel("krEQwQZl1Uo");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("IOL4dnzlwPvax3CtlPFTCjTl79bTxxotqwJ3iJjvGp4YnHsc6a");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        DesignationType designationtype = new DesignationType();
        designationtype.setDesignatnTypeDesc("nR8QGF7Dtau7WkqHGEYlupTjjVkEZgsHRl7ARgUMGChyYfSyJA");
        DesignationType DesignationTypeTest = new DesignationType();
        if (isSave) {
            DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
        }
        DepartmentType departmenttype = new DepartmentType();
        departmenttype.setDeptTypeDesc("IB3fPo60T6br6MUIMc8tvLSmbZQaYJBkBEQ9pWe3qMKrzFrwwO");
        DepartmentType DepartmentTypeTest = new DepartmentType();
        if (isSave) {
            DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
        }
        empinformation.setPan("eNXA43iM6VemxLJlq0lbSaN1w7eEyctcqjsMEjcFUB5a5F5Kc4");
        empinformation.setReportingOfficer("17paMYL9OuMI76hjgANWLkQ3AQ2nnmxtFxs7yipl436ERLLWmv");
        empinformation.setJobTypeCode((java.lang.String) JobTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setContactId(null);
        empinformation.setCoreContacts(isSave ? corecontactsRepository.save(corecontacts) : corecontacts);
        if (isSave) {
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        }
        empinformation.setDesignationTypeCode((java.lang.String) DesignationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        empinformation.setDeptTypeCode((java.lang.String) DepartmentTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        EmpInformation EmpInformationTest = new EmpInformation();
        if (isSave) {
            EmpInformationTest = empinformationRepository.save(empinformation);
            map.put("EmpInformationPrimaryKey", empinformation._getPrimarykey());
        }
        SalStrucFinWise salstrucfinwise = new SalStrucFinWise();
        salstrucfinwise.setMedicalAllowance(-4400.0d);
        salstrucfinwise.setTakeHome(5840.0d);
        salstrucfinwise.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
        salstrucfinwise.setHra(9300.0d);
        salstrucfinwise.setTaxableAmount(4400.0d);
        salstrucfinwise.setYearValue(8905);
        salstrucfinwise.setEducationalAllowance(-2210.0d);
        salstrucfinwise.setTotalCTC(-7800.0d);
        salstrucfinwise.setNonTaxableAmount(8780.0d);
        salstrucfinwise.setBasic(7500.0d);
        salstrucfinwise.setTotalTax(-3220.0d);
        salstrucfinwise.setConvenceAllowance(7570.0d);
        salstrucfinwise.setPerk(-7950.0d);
        salstrucfinwise.setSpecailAllowance(-8020.0d);
        salstrucfinwise.setSalaryDrawn(8400.0d);
        salstrucfinwise.setEntityValidator(entityValidator);
        return salstrucfinwise;
    }

    @Test
    public void test1Save() {
        try {
            SalStrucFinWise salstrucfinwise = createSalStrucFinWise(true);
            salstrucfinwise.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            salstrucfinwise.isValid();
            salstrucfinwiseRepository.save(salstrucfinwise);
            map.put("SalStrucFinWisePrimaryKey", salstrucfinwise._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private EmpInformationRepository<EmpInformation> empinformationRepository;

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
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            SalStrucFinWise salstrucfinwise = salstrucfinwiseRepository.findById((java.lang.String) map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwise.setMedicalAllowance(3800.0d);
            salstrucfinwise.setTakeHome(9800.0d);
            salstrucfinwise.setHra(2300.0d);
            salstrucfinwise.setTaxableAmount(2700.0d);
            salstrucfinwise.setYearValue(8152);
            salstrucfinwise.setEducationalAllowance(2000.0d);
            salstrucfinwise.setTotalCTC(6000.0d);
            salstrucfinwise.setNonTaxableAmount(5700.0d);
            salstrucfinwise.setBasic(-4900.0d);
            salstrucfinwise.setTotalTax(3410.0d);
            salstrucfinwise.setConvenceAllowance(6600.0d);
            salstrucfinwise.setPerk(4100.0d);
            salstrucfinwise.setSpecailAllowance(1680.0d);
            salstrucfinwise.setVersionId(1);
            salstrucfinwise.setSalaryDrawn(-700.0d);
            salstrucfinwise.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            salstrucfinwiseRepository.update(salstrucfinwise);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwiseRepository.findById((java.lang.String) map.get("SalStrucFinWisePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<SalStrucFinWise> listofempId = salstrucfinwiseRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
            if (listofempId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("SalStrucFinWisePrimaryKey"));
            salstrucfinwiseRepository.delete((java.lang.String) map.get("SalStrucFinWisePrimaryKey")); /* Deleting refrenced data */
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

    private void validateSalStrucFinWise(EntityTestCriteria contraints, SalStrucFinWise salstrucfinwise) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            salstrucfinwise.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            salstrucfinwise.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            salstrucfinwise.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            salstrucfinwiseRepository.save(salstrucfinwise);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "yearValue", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "yearValue", 14338));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "basic", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "basic", 1.2066080466622579E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "hra", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "hra", 1.2807780746588727E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "convenceAllowance", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "convenceAllowance", 1.1237765228757692E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "medicalAllowance", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "medicalAllowance", 1.2638560764525392E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "educationalAllowance", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "educationalAllowance", 1.675235812780225E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "specailAllowance", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "specailAllowance", 1.7152791252756713E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 15, "perk", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "perk", 1.5428508423864668E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 17, "totalCTC", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 18, "totalCTC", 1.5957442564259054E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 19, "takeHome", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 20, "takeHome", 1.7495450421715202E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 21, "salaryDrawn", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 22, "salaryDrawn", 1.2156215369380086E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 23, "taxableAmount", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 24, "taxableAmount", 1.4769483512186528E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 25, "nonTaxableAmount", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 26, "nonTaxableAmount", 1.1011110672612305E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 27, "totalTax", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 28, "totalTax", 1.739818706293781E19d));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                SalStrucFinWise salstrucfinwise = createSalStrucFinWise(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = salstrucfinwise.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 2:
                        salstrucfinwise.setYearValue(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 4:
                        salstrucfinwise.setBasic(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 6:
                        salstrucfinwise.setHra(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 8:
                        salstrucfinwise.setConvenceAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 10:
                        salstrucfinwise.setMedicalAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 12:
                        salstrucfinwise.setEducationalAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 14:
                        salstrucfinwise.setSpecailAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 15:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 16:
                        salstrucfinwise.setPerk(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 17:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 18:
                        salstrucfinwise.setTotalCTC(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 19:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 20:
                        salstrucfinwise.setTakeHome(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 21:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 22:
                        salstrucfinwise.setSalaryDrawn(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 23:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 24:
                        salstrucfinwise.setTaxableAmount(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 25:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 26:
                        salstrucfinwise.setNonTaxableAmount(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 27:
                        field.setAccessible(true);
                        field.set(salstrucfinwise, null);
                        validateSalStrucFinWise(contraints, salstrucfinwise);
                        failureCount++;
                        break;
                    case 28:
                        salstrucfinwise.setTotalTax(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalStrucFinWise(contraints, salstrucfinwise);
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
