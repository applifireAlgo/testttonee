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
import com.app.server.repository.humanresourceboundedcontext.payroll.CostToCompanyRepository;
import com.app.shared.humanresourceboundedcontext.payroll.CostToCompany;
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
public class CostToCompanyTestCase extends EntityTestCriteria {

    @Autowired
    private CostToCompanyRepository<CostToCompany> costtocompanyRepository;

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

    private CostToCompany createCostToCompany(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        EmpInformation empinformation = new EmpInformation();
        empinformation.setPan("0JMNqR9jwofF5WFiKJJuCRKkAz1mYaQ48N3ZjzKw5pd7Eg9sdK");
        empinformation.setReportingOfficer("uAOjf9IaIgGxU4aEr7ecQUb9BnVRePvMUzhs6WEuSg6n0OExfz");
        JobType jobtype = new JobType();
        jobtype.setJobDescOne("cD10MFfIqg93vgq8TOXBxnTJ4Thfxoth4KWSGAcPMZBXoFxgp7");
        JobType JobTypeTest = new JobType();
        if (isSave) {
            JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("nHLzhk0RZZukT9VCC8sp");
        Gender gender = new Gender();
        gender.setGender("os9f8OxaTVA2QZ37q0Qh5svpCtMBbB7oikxiwubICYxJTA6Qdz");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("VqSUkC1cLkPWktCQBXgoUKXOIXhQR3DDjoJkiI2kfwPjkfTAkG");
        timezone.setCities("1uOiC1FMaMYrXDDCQoTmSDUg8tCDAkFRVMd1T19JglsHGEg2Co");
        timezone.setUtcdifference(5);
        timezone.setCountry("RALvyYIKqMhuGuBPA7mtTnxWv7Q8RpjmzyEX9BXfi8sa1uaAWD");
        timezone.setTimeZoneLabel("wk3A2JoodX9GeN6H7mkTElry9YMoBzCLuLX58YOWbWyZ2KXNsi");
        Language language = new Language();
        language.setLanguage("n9fKV1cnogjvyO1GKzHYTvVSW5NmFmGuIfpm1bSCLon8eWHTqY");
        language.setAlpha4parentid(3);
        language.setLanguageDescription("dLeZmStPbPdkckuOYkC3hx7J2jPNYmLBrD8vpxN3AstYWFXA9g");
        language.setAlpha2("xy");
        language.setLanguageType("6Hk9WzNmmJXR01wCCtMYkS2P8gfSMWtI");
        language.setLanguageIcon("REbJoCm9TcsE1L8H3aWI87h0UTaakdr0uFe25UQLJwnqiT8315");
        language.setAlpha3("cWz");
        language.setAlpha4("I72w");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("uQE8vY6Z2BB83s4LxtJAJ4IhQklXr5traPtIKZjJRBLKImNWbW");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setPhoneNumber("V6ZYHghPPziiPD5EtjTo");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460544304748l));
        corecontacts.setLastName("3k1zfjdlO1YGij2W1t4bbfkxkpcI8VUKBgGoDqgK6k4SD3LJQV");
        corecontacts.setNativeMiddleName("7ouvEkyQKG0VQA7MjH51ep9yXDW3NLRgHBqrZgL6TEkYatuc37");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("a5VgBSE5WMqVS0bE1pmZjq6ESAqrZAglNhrOmTpeEWa9O1K7h0");
        corecontacts.setMiddleName("vg7XXvHdXjKtYVjbuSuIfVW549ON982WAxk0kvwAD8jIyT0l1d");
        corecontacts.setEmailId("mqmIkiJ93hHPXp5dMQXHuMdOxAbkqfvR5hwSarMMzO8Z4Jvwr0");
        corecontacts.setNativeFirstName("W9mEyJWVFQrDwRAeS6A5HBaRMSF2Dz1neju4bZ50rnAXletw47");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("MXZU6k20BDMv2nKfe01cCHnrH58yfCKlrxNjlSTR45qjzZPBoT");
        corecontacts.setFirstName("XFBEWT4xlIeuQ4TRIqdQj1OTUe3ZiNsGAcKt3qIAZc5Xou3DMg");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460544304842l));
        corecontacts.setAge(107);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("N4mhApF9iGuzHKTKIZ6pTvH6AAxBLWZfT4y8mXYg4t4zmUmVRh");
        communicationgroup.setCommGroupName("P1PIL9WvSFqTbl4pFHFofmj8HgW6GxF9FMzm1DRHFMEWykiszK");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("ria2IlaXVP8fvBQNLCvoRqxeR9TP0JjCKOktPAL4x5rWfdtOLj");
        communicationtype.setCommTypeName("CwFht8lsGREYwdWY1XG55NdfJAPO3NNNH7tqVdcIVtLEmhfKW9");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("yntMDMta2IAmq9h2vVLMBDfOQFVZ2ZGGLC374fHpOCsxQl0TCo");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("yboMfqWvyjEgjCNMJRyHwzpImsAMstr1RcUFpl6IpdrfXAvKd4");
        addresstype.setAddressTypeIcon("otxfoQH3IYcGV6iv6He4XIYioonna1GKo9QoluHbiNGf2xLsKP");
        addresstype.setAddressType("GimZQgzXSkRPaQSWTerN2GJkdvHzQM1jmaSfKZTBUt59120LnC");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("uD9rPSi3uLmJ8h8pBcQU3BBMqjeJ1AStvU2jvTyci4Z7yhYBpG");
        city.setCityCodeChar2("IUKFUhcQbTHXJD70dx25kmyKi8dWqSOr");
        Country country = new Country();
        country.setCapitalLongitude(4);
        country.setCountryFlag("4HbGrh49reUr2RM7CGKghyekOIurqFtzxjfIhRYzdcCKUATFOg");
        country.setIsoNumeric(259);
        country.setCountryCode2("wax");
        country.setCurrencyCode("L6Q");
        country.setCountryCode1("Se0");
        country.setCapital("fGok7Hu3Nq4U6K2YSxjns5QNYgysAuDU");
        country.setCurrencySymbol("TCjjgSwp026ndypmxiLgyPMSFsb7jSpn");
        country.setCapitalLatitude(7);
        country.setCountryName("p9TiP2PanpwFt3ttG6wyguv1nwjfkNPZCVIv9ezay9mRzIp3xf");
        country.setCurrencyName("otVFMncWAJqJW6LUoqyHm3nq6jZ5GKOL9CO5jv3RYHOMcxBcUQ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("nqMamUoFtVjLycRFdlAN5h15aIwDsc0tpGDjWrpbFCGdHXU5Hv");
        state.setStateCodeChar2("PqC5PIWcpSYllW8Fwr4bl9ByOg9xNj6X");
        state.setStateCode(1);
        state.setStateCapital("JpvCIjwVNBv2ShBCMClwdWsVTIoWVdipf2mKsoq9OQobXtNWDC");
        state.setStateCodeChar3("gqi3e2XCas8fSRuuOb0ruiQPh0u4fWES");
        state.setStateFlag("8LNeYQTryFxVEmU3P1vpaPOVyJCkPzEIP1iDrUxh0xdlJEgNIO");
        state.setStateCodeChar2("mdH7UZbUrOpeL3fyEHsmlPICGPogONOi");
        state.setStateCode(2);
        state.setStateCapital("QxshaxUv4nWU5DEGeoipx9BMxgg4TRoRxXc4m1WayjLmN45cTQ");
        state.setStateCodeChar3("1uPPRno8apzuKuk2PwacFrsmR5nLjMOt");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("10MsPLbiUZvOW9sd23HUGI598qTDDDJmTZ16FyeLml4hZNUfaY");
        state.setStateName("f1zxJtx2LUNrZVsLE05K9pLYC9X2HQzWA0aWn6JV10VRLoXzc8");
        state.setStateCapitalLongitude(8);
        state.setStateCapitalLatitude(3);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("4ifPCXEW6SPKTzNPWg1mU2GlqfUZ3aP5BmuAwVfi74Q7mKddXP");
        city.setCityCodeChar2("r2190gS9qUc9BeDzIzx1aHEOFEzmTOcG");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("V9SST9iAUfLZlv4SUzjYBJ8EzGiXRMI3lfpwABFiRRhKSZNnLp");
        city.setCityLatitude(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(2);
        city.setCityCode(1);
        city.setCityFlag("tOxY8XFaChiwEiSLqPANY4xIJvU7ssI0VvqpcfAPDIxkaS9CNB");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("SbSyzjc6UMsomeJFS7GeQNG0N1nfVrZrFvmudPZ7nWkbpJr59x");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("rJVZTMrKpZiPC7MT7bi7ZV8A1lLnDlzCNOTjgs81DDut9o3Ple");
        address.setAddress1("iYuVdil3wnLkyh6hbecJfQbKYaEz8Bl5fzdYWiIwA4BBpih6vJ");
        address.setZipcode("9ePDpK");
        address.setAddress2("rYHqML8Jc12It0po3JJBqmVXWr0z6o2bceQ6GfGIV8jnLIS5cU");
        address.setAddressLabel("F09RFCXdkcc");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("JH323hT7OiWkprW52uHYdDoXHeDG3b4jmKSfMukREH6U6I1FQW");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        DesignationType designationtype = new DesignationType();
        designationtype.setDesignatnTypeDesc("7cBmCk8cK4PedIj4aBpSjiemFnwEwzc9U0ZSwiWAiRAbzKTu4P");
        DesignationType DesignationTypeTest = new DesignationType();
        if (isSave) {
            DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
        }
        DepartmentType departmenttype = new DepartmentType();
        departmenttype.setDeptTypeDesc("RT6amwRFbpljz0fIevo5Fx5Ybh2eBbER0lASs0pMKBVbSvOQnR");
        DepartmentType DepartmentTypeTest = new DepartmentType();
        if (isSave) {
            DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
        }
        empinformation.setPan("ORoFWIS4Lb4Uu72seXDYZpeofSmgU3llzB1etQcREBEvIGxQ3l");
        empinformation.setReportingOfficer("Z92NBjaBiwyCapk5dknxsHkNO2y7XrJPizhuMO5nTvFAlR64fH");
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
        CostToCompany costtocompany = new CostToCompany();
        costtocompany.setPerk(-4500.0d);
        costtocompany.setEducationalAllowance(-400.0d);
        costtocompany.setTakeHome(3000.0d);
        costtocompany.setMedicalAllowance(-8100.0d);
        costtocompany.setBasic(4500.0d);
        costtocompany.setHra(8000.0d);
        costtocompany.setConvenceAllowance(8000.0d);
        costtocompany.setTotalCTC(9100.0d);
        costtocompany.setYearValue(2147483647);
        costtocompany.setSpecailAllowance(8800.0d);
        costtocompany.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
        costtocompany.setEntityValidator(entityValidator);
        return costtocompany;
    }

    @Test
    public void test1Save() {
        try {
            CostToCompany costtocompany = createCostToCompany(true);
            costtocompany.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            costtocompany.isValid();
            costtocompanyRepository.save(costtocompany);
            map.put("CostToCompanyPrimaryKey", costtocompany._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            CostToCompany costtocompany = costtocompanyRepository.findById((java.lang.String) map.get("CostToCompanyPrimaryKey"));
            costtocompany.setPerk(4900.0d);
            costtocompany.setVersionId(1);
            costtocompany.setEducationalAllowance(-2000.0d);
            costtocompany.setTakeHome(2300.0d);
            costtocompany.setMedicalAllowance(-2624.0d);
            costtocompany.setBasic(-6400.0d);
            costtocompany.setHra(7600.0d);
            costtocompany.setConvenceAllowance(-8700.0d);
            costtocompany.setTotalCTC(-2700.0d);
            costtocompany.setYearValue(2147483647);
            costtocompany.setSpecailAllowance(3300.0d);
            costtocompany.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            costtocompanyRepository.update(costtocompany);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            costtocompanyRepository.findById((java.lang.String) map.get("CostToCompanyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<CostToCompany> listofempId = costtocompanyRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CostToCompanyPrimaryKey"));
            costtocompanyRepository.delete((java.lang.String) map.get("CostToCompanyPrimaryKey")); /* Deleting refrenced data */
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

    private void validateCostToCompany(EntityTestCriteria contraints, CostToCompany costtocompany) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            costtocompany.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            costtocompany.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            costtocompany.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            costtocompanyRepository.save(costtocompany);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "yearValue", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "basic", 1.0182501032269177E19d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "hra", 1.6213429602628538E19d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "convenceAllowance", 1.2617540258087326E19d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "medicalAllowance", 9.55088165242815E18d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "educationalAllowance", 9.993606364940194E18d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "specailAllowance", 1.4302034840908489E19d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "perk", 1.2594316998532542E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "totalCTC", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "totalCTC", 1.0378356336996704E19d));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "takeHome", 1.1858493806196951E19d));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CostToCompany costtocompany = createCostToCompany(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = costtocompany.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(costtocompany, null);
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 2:
                        costtocompany.setBasic(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 3:
                        costtocompany.setHra(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 4:
                        costtocompany.setConvenceAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 5:
                        costtocompany.setMedicalAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 6:
                        costtocompany.setEducationalAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 7:
                        costtocompany.setSpecailAllowance(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 8:
                        costtocompany.setPerk(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(costtocompany, null);
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 10:
                        costtocompany.setTotalCTC(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
                        failureCount++;
                        break;
                    case 11:
                        costtocompany.setTakeHome(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateCostToCompany(contraints, costtocompany);
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
