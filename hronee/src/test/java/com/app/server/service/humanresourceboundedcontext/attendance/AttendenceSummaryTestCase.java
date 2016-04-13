package com.app.server.service.humanresourceboundedcontext.attendance;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.humanresourceboundedcontext.attendance.AttendenceSummaryRepository;
import com.app.shared.humanresourceboundedcontext.attendance.AttendenceSummary;
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
public class AttendenceSummaryTestCase extends EntityTestCriteria {

    @Autowired
    private AttendenceSummaryRepository<AttendenceSummary> attendencesummaryRepository;

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

    private AttendenceSummary createAttendenceSummary(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        EmpInformation empinformation = new EmpInformation();
        empinformation.setPan("DayEiJ3wuU5KvRVUvBr4VRyFiv56ViEl25RjwvbtQbpzTn7Ryg");
        empinformation.setReportingOfficer("xLwW6GStQpbobTt6RuT8EbGleOUa4E7TSBqHaPcsK2iEzDj5QM");
        JobType jobtype = new JobType();
        jobtype.setJobDescOne("tJZut8G2PYNBEksWSAfO2lSyvDxjq3Q3EkoM4NnKdKcIzbCwk4");
        JobType JobTypeTest = new JobType();
        if (isSave) {
            JobTypeTest = jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("qSOVw2EYUwZMRwYNM3TV");
        Gender gender = new Gender();
        gender.setGender("m1Ak4UH4Oe70RlDaN9patiLtzYtakikvNM2EJkPSKt719TatZa");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("NA2gG0TonbxXgVy2iHT1Tg2u5ujXG1Ej6FSBTw3s1ZawlC7j7q");
        timezone.setCities("CfBhsw8PvkIP7SJUSn3ZfwXGYKmPNIvqH4Oi8HodGxYDaZEUl0");
        timezone.setUtcdifference(10);
        timezone.setCountry("nxaZhBXN6mUQPmoC97VemLajXD5pjA0yWCEMv7BejZUuPNh1Ok");
        timezone.setTimeZoneLabel("mY04eQ76jZpCuNtVGjG6d2ChHPFBf5IqKuvKWdF8FEW2FPCElN");
        Language language = new Language();
        language.setLanguage("V0vsRpDhvg5ZiY6wVNbwyXMqergtauTMan2HKjRfV0ZmFJ931V");
        language.setAlpha4parentid(3);
        language.setLanguageDescription("NPIwM2XXksGXF66LX23Jvi6lyZEhISKE1INEFyFGvuONc8XJVs");
        language.setAlpha2("nA");
        language.setLanguageType("LrPHWtuS92IO0p3gWhoeTcLejBILdkjM");
        language.setLanguageIcon("tych1oNTzthP0mhPcSZUzCgffPDJgc44kgqd7FOQMYz9T9Xp5g");
        language.setAlpha3("m77");
        language.setAlpha4("5hLI");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("GSKD6pAzrNeemTLkR2FPbZ0bpj5t3qFFWxfQzhXdatWoCCBcY0");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setPhoneNumber("4pLAu8BHnRBXrRvRph6p");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460544307641l));
        corecontacts.setLastName("EpOSMGQZsoZWQ6fLtxr0SswpnCMLdcYxdNKzt8WTPgyQsFnokR");
        corecontacts.setNativeMiddleName("XMpQiY4UwOzjR595WggBqIbxxXTohi4NhnIk1sQk8adKe0rxiF");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("qOTXe7qH5Wo4A4fzob6IgyGv4gaMewJuiFDhp1xV5zAUkYmQln");
        corecontacts.setMiddleName("pdBjLX3LkIkrHPiWwE64AmNVsXP69cYJBgRtw9Ti5VHQEk89Ya");
        corecontacts.setEmailId("14iRhfs5TBh2fuyvlmVUpnbwCIL01QMeQIwiieIpG8j5ei99Et");
        corecontacts.setNativeFirstName("L6JoZBKhnoD7u9ozhoOlxNwQPiuQ8ckXbVfUN1jmidcgUPEJ8L");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("Ks3JsRpphi1RnIT0WaAI8myZerAbbAqNReabO6Gizx2uwAAruV");
        corecontacts.setFirstName("GkbLUFYVIsTXEvuVdh6GQ0ZW9Id1LEteBrkeT7v10wfrixdSqj");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460544307759l));
        corecontacts.setAge(82);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("d3BudD3p3s8OVDHIM4POhC680ekTRgzH5IbsrnVzDpRtHbon7D");
        communicationgroup.setCommGroupName("lCKxHdCrpSfatm0NY6YL1SMoFbJEJ9Mw460tVzK6ya8sPC7J8y");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("9zpyAcnZpa71lOoIqnTGZHEjp4jOEc5XWw8eTeVbdZji5inNzB");
        communicationtype.setCommTypeName("UZInFfedQwdH4WROuzksFjMQdztrKmld0cOl4OzNMp9n5h3POn");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("u5oxVVamY5JZClAhhy5WHKjgtEWy7aulzGN4gHM6uW1YJ63kfK");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("Ra2ToCKFMwDdQMmDrudydnNJW26JhXFNQUs4piOZMOToNLtTne");
        addresstype.setAddressTypeIcon("DsrbfnlRhLf1gnba49BUx6w0eS7PhNiResK8yLOjmqn2o82GtA");
        addresstype.setAddressType("KluVDxf7rXv65OIiWqqEK4tgFxGlp2hGicqTrx2pCXRSsUpiBA");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("SBNxR56HHOoYCBTD0nWRxVoD2D27SO2lDYCfzfRV8NAj2AItgT");
        city.setCityCodeChar2("VYfmGi2UEPzD6fWl0fsXCBrgn0pn7YOH");
        Country country = new Country();
        country.setCapitalLongitude(5);
        country.setCountryFlag("9t22hAMbLUvDMEaMhf4uhRAMVq5WbYAmCnoLyYoouFRMCOwfPL");
        country.setIsoNumeric(113);
        country.setCountryCode2("BRK");
        country.setCurrencyCode("EYd");
        country.setCountryCode1("ZbH");
        country.setCapital("MX20NhTXV61KCELnJQIaVdJFaxT9KxYu");
        country.setCurrencySymbol("yBrIBNOfjGHk7n1YgNsTHDNB4z6KBAG4");
        country.setCapitalLatitude(3);
        country.setCountryName("WQhZFOKRGN39fkvUhXCfT4lVFOwVsHwBNz8D3jy8XelOtXg3G7");
        country.setCurrencyName("bAqU0sDHriQu2c4wiy3HDyIEtvxAdvrBRc9mEPOwhc9eDnbJeF");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("301LQO1IaPjaa0ni5DUlxrcL76FBD9TNMHL8o2koAxAwTAnvsw");
        state.setStateCodeChar2("aFShza4tIOsUvKsOpAMPM5Pk2UCxcEMn");
        state.setStateCode(1);
        state.setStateCapital("bhE9mZLYCOaJCsEvyoErcMMzhwXaEnGxkAFDzQXZYyVQbtUVVL");
        state.setStateCodeChar3("Ca1DjKeP16SufIGudusFd5zf13V7xXGw");
        state.setStateFlag("o3OKPBdJ6dedgLOqYpSUDh9zSsjsQxMYKltB3zCxYLsgNnMYnQ");
        state.setStateCodeChar2("lieJZIuFpoFGwNpEEbPlfzsjQ9TITpGN");
        state.setStateCode(1);
        state.setStateCapital("RDR0UddCh7CWCFB098K7yy2JaGroolh0xKLuHXs90kcl9542CN");
        state.setStateCodeChar3("kZxxzN3JFEXTwOJxt41XlpK4hQSfySqC");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("Ds6beNaBbPzU3qNJlVWTsLgj8s7f7Famit9lebzQYrdNyyNgG9");
        state.setStateName("U21O0ocGPCYGiTYg2ce9irgTMH82YOkpQiIF42rODWxd2hpoVx");
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLatitude(6);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("k8HFAkF8LiqkPGmuu7Mj0Qq8HYxZ3zffjxpXjWbTdweSoyC5VN");
        city.setCityCodeChar2("L6X241ggqSYW4qDrfvaHom5H9IwHL9NX");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("bMc8rkHCRBjbEWJ0ougcTJkedkDjNfETJfePjTzPc2Lj3HPrln");
        city.setCityLatitude(3);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityCode(2);
        city.setCityFlag("89dastqln3UrFNFgiL7dSoz2g6Ag92KB5bMWPGPcrxvr7p02BY");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("IAsesjdhqhtwYEFijc97L6qIvEf5143gmaZFbYjiEYOhzLDeVf");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("7uGE4jhpeuGEDjzLoN1PdUio8keK4BVhgfcWTuOFnhkYmeeRLW");
        address.setAddress1("9Gn2kpXylXXKAGcMxo94fMXTF115WpCgdzloWRYfuf6KMxDvan");
        address.setZipcode("gKfugw");
        address.setAddress2("QERkeYDjfDpFiUuNcm5eAfuQYnR4m7FI9TK2Q0InntCvq4Vqk6");
        address.setAddressLabel("xTMKwRhrFsO");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("ZO5t1MnUrkePT5Vea32yIDwWnQI2mUku287Wr24s2V0QSbJKrl");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        DesignationType designationtype = new DesignationType();
        designationtype.setDesignatnTypeDesc("D9jJuMEBpyiPmV2v6MVFf8KTv6UKINrxB10HUYv28BTV3vuzTT");
        DesignationType DesignationTypeTest = new DesignationType();
        if (isSave) {
            DesignationTypeTest = designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
        }
        DepartmentType departmenttype = new DepartmentType();
        departmenttype.setDeptTypeDesc("L5zZ3M1EmdiLi5fUHTxv30t8QcmP59YV4TLuNs7plfI3bCjgkd");
        DepartmentType DepartmentTypeTest = new DepartmentType();
        if (isSave) {
            DepartmentTypeTest = departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
        }
        empinformation.setPan("vPZHPXX9vbm4ZJ28vCcSU1GhbJvCoo2545u2Dec4zfG8etXAOi");
        empinformation.setReportingOfficer("BQSW30e2AglI5kHkekkqJevW7fuASjOQhkopCek6sQN96OM7g0");
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
        AttendenceSummary attendencesummary = new AttendenceSummary();
        attendencesummary.setEmpId((java.lang.String) EmpInformationTest._getPrimarykey());
        attendencesummary.setAbsent(2147483647);
        attendencesummary.setMaternityLeave(2147483647);
        attendencesummary.setPresent(2147483647);
        attendencesummary.setPrivilegeLeave(2147483647);
        attendencesummary.setYearValue(9368);
        attendencesummary.setCasualLeave(2147483647);
        attendencesummary.setMonthValue(9);
        attendencesummary.setSickLeave(2147483647);
        attendencesummary.setEntityValidator(entityValidator);
        return attendencesummary;
    }

    @Test
    public void test1Save() {
        try {
            AttendenceSummary attendencesummary = createAttendenceSummary(true);
            attendencesummary.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            attendencesummary.isValid();
            attendencesummaryRepository.save(attendencesummary);
            map.put("AttendenceSummaryPrimaryKey", attendencesummary._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            AttendenceSummary attendencesummary = attendencesummaryRepository.findById((java.lang.String) map.get("AttendenceSummaryPrimaryKey"));
            attendencesummary.setAbsent(2147483647);
            attendencesummary.setMaternityLeave(2147483647);
            attendencesummary.setPresent(2147483647);
            attendencesummary.setPrivilegeLeave(2147483647);
            attendencesummary.setYearValue(4112);
            attendencesummary.setCasualLeave(2147483647);
            attendencesummary.setMonthValue(4);
            attendencesummary.setSickLeave(2147483647);
            attendencesummary.setVersionId(1);
            attendencesummary.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            attendencesummaryRepository.update(attendencesummary);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByempId() {
        try {
            java.util.List<AttendenceSummary> listofempId = attendencesummaryRepository.findByEmpId((java.lang.String) map.get("EmpInformationPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            attendencesummaryRepository.findById((java.lang.String) map.get("AttendenceSummaryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AttendenceSummaryPrimaryKey"));
            attendencesummaryRepository.delete((java.lang.String) map.get("AttendenceSummaryPrimaryKey")); /* Deleting refrenced data */
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

    private void validateAttendenceSummary(EntityTestCriteria contraints, AttendenceSummary attendencesummary) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            attendencesummary.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            attendencesummary.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            attendencesummary.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            attendencesummaryRepository.save(attendencesummary);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "monthValue", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "monthValue", 20));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "yearValue", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "yearValue", 15481));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "present", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "absent", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "privilegeLeave", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "casualLeave", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "sickLeave", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "maternityLeave", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AttendenceSummary attendencesummary = createAttendenceSummary(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = attendencesummary.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 2:
                        attendencesummary.setMonthValue(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 4:
                        attendencesummary.setYearValue(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
                        failureCount++;
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(attendencesummary, null);
                        validateAttendenceSummary(contraints, attendencesummary);
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
