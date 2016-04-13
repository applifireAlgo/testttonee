package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("t7KOO3sE7TThCv6L1eLr");
        Gender gender = new Gender();
        gender.setGender("6Q8G5pzfA4DeET5TTg3FTx3TEve3T1kRH93Phu8KGmBaxak4db");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("NCVATMgopbRHeXtt3iY81By2Qa3Zj91wUtCzYeFag7FNW3bbl9");
        timezone.setCities("HPB6ig46JfgXBo1bH9OJ9TSUnZMPJr7e25NJpUiqt1ZZKFKziV");
        timezone.setUtcdifference(1);
        timezone.setCountry("at3IoCvkGx4d8GIxIidQreSn0jjqRM49rLxc9eJ49FTuBrB3Ov");
        timezone.setTimeZoneLabel("ku5JEvDivY5jnrGGIVc1J35aStSKZpsgnqW19GwFRHqVXyYU4N");
        Language language = new Language();
        language.setLanguage("QgrIbOumfw0EdyALPuWBF1fYamZVoUB8u2OqMnwQWEXahnhT73");
        language.setAlpha4parentid(7);
        language.setLanguageDescription("nGLCjxG6EI08iIZUwlRZG79QznWgn2cR66SFl4JiHl0dXcBHTb");
        language.setAlpha2("m2");
        language.setLanguageType("ldM1YZbYZ4vuzLiHCk9huGJ0LAh9nWsn");
        language.setLanguageIcon("Ycpxoqg98LNm1zzkXiGKlwbTFCwKudL98x7LMTvBjGq6Jf17DA");
        language.setAlpha3("Moi");
        language.setAlpha4("hIgu");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("xIDPg9mIE1IOreUsltvtw7YyduoQlQsuntagppAo7CB90kT3fO");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setPhoneNumber("7qhXlqT8zsv6naGEvZAV");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460532734120l));
        corecontacts.setLastName("u8VOq2uta72IcqvO3DlLcJX595ATBJXS2xKqmUj4PbfmkP8tSR");
        corecontacts.setNativeMiddleName("b441uEZ6M6GHBBl5PzY3EToxEVNMYvqp2HBDVI7runIFJ8Plp1");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeLastName("fCnkmfk9E7oC4bsiCb8vjmlNk7E0epCFxyvE5uyWmbCTSSCe3J");
        corecontacts.setMiddleName("x83SIC40AiCSBUzfsF6oqgZOr6ixTzr7eZM6NejZiuMkfqjAe7");
        corecontacts.setEmailId("U2vaJaLDc0SLAc1IQSHzii6clXVO8tptngLlXyt9nQsD0KeqYT");
        corecontacts.setNativeFirstName("PI5y1JNJcepfHeTr6Ca9DiMT5QJ1ZIchJOxXu71ob7YDyAepWF");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("RfB8QSmpPdDWLQaUlGLB8UmXDeKSHfVJMYxvbL8go1I8wZ2mNU");
        corecontacts.setFirstName("uEmbDlPyL9auxYPHLD6QHccOu4CNc49gCnPDEiZyWzIhuAhkv7");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460532734274l));
        corecontacts.setAge(25);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("8XumaESevRtVFpDRIXPDrQXe3su9VSmh37k6ryLTtwPXR4Q83U");
        communicationgroup.setCommGroupName("hRNvOfs6vSK9i1GogIimI9pzipO4xyx6El1XZRf4lO3t7BhEi0");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("qE7BXTp64fCG7c0yGSOn8rQ9xU0lHGIkvabFSCIBKZd7EOia1h");
        communicationtype.setCommTypeName("Jc8Eooxq4hKBCHSATBZ8EhRkBtKbgh7LVTAhkKtN5wjwkcDxx2");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("4Dfym8CS6I4TXaF6AXVfAeVI0QtkTD2c81M0IGGOp2UZIhV7Z3");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("8Kab2BkBkEIiYtI9WK1ECznsswfWTY4anENsLwFCzwHa5IsZNH");
        addresstype.setAddressTypeIcon("NPIE1lKnBfvevrKtIf3pYimdPVAZIeI0fm8jnLdc0jWH6Ag05w");
        addresstype.setAddressType("SeYWXWjOqcA51uGsUQNPeg10brnqLE4rgyVzulRdNvKSMltFsC");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        city.setCityDescription("9fGzBiUkeqi7emLpBjXtpZg61RBfhXuaZdbyzYvnaPFRZdF7uX");
        city.setCityCodeChar2("aqtaA7sKENg7XbnGK1hcgwPle9sKxgBR");
        Country country = new Country();
        country.setCapitalLongitude(9);
        country.setCountryFlag("SVSW5PJR9NhndhfCOThhl9Ptn5uUlO8XJyjDCVM67AQFRA5gXi");
        country.setIsoNumeric(14);
        country.setCountryCode2("4mv");
        country.setCurrencyCode("bzk");
        country.setCountryCode1("kHf");
        country.setCapital("xQKkXAOuyCXF3dKoPMnVrG9QYgDTjbhl");
        country.setCurrencySymbol("6qdgdkNuelt1tVAKWRMk7JfysVIbtqS7");
        country.setCapitalLatitude(8);
        country.setCountryName("HcE6xIOJCbXddDxOT9gtOSC8VSQgEZtDlZzrnoddw8PidsktHo");
        country.setCurrencyName("s3gKqDw9UJEtIhUvRT5gT2jLsl4iFxQmOy1kovghOpLN8Udf5v");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("0QiykA0nweIKQRuvwHpfeRE8F6HNsYzDbdHEbyDeEc5PJn24CE");
        state.setStateCodeChar2("8x82BOlnf0BCuI9cCjPZgymqUqNpdZCO");
        state.setStateCode(1);
        state.setStateCapital("RXpPiAet5TsFfFw1bidA2WmKpv1wcrCru2Gn74UUdFoPfeVhrg");
        state.setStateCodeChar3("sIEvpgth5x6Df425QMAIpYOOvp4Ecsto");
        state.setStateFlag("G7xenk1JLppv1DMZohcqL77p2eTwTKe62bnCHwBjAuG1AZSlgI");
        state.setStateCodeChar2("H2RaBvw3zYegZkhBYQXDUIx8vsVyLJ5u");
        state.setStateCode(2);
        state.setStateCapital("Zc9iLurrUUa09Z529sRjVkl6OZwd2rQsqWbLG9ol2MMNZKPVRE");
        state.setStateCodeChar3("gfz8dgYmpKYTdPC1iy86S8erFiJ5ka9s");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateDescription("sLt97ipbBCA6hkx7MaOn1HGJZVouwcIYBICROdAuGcmHJQvEzT");
        state.setStateName("rYONwGIzN6iJeIj6I4xJGcIazNKClXUkK1azG8w7ly3tEuLuIL");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("bUKMj5dxNVeRhPJtr7M01YmFfjEkxs31TwRLEhLZybYYEyV4RO");
        city.setCityCodeChar2("9TviBFheeP9h0v623k5IGqEYtAUxhiDM");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("PVgWkb2s4gIXboXmVO8W6pbizNw0dsuMf8cBDPRkWjfKirG4e1");
        city.setCityLatitude(6);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(7);
        city.setCityCode(3);
        city.setCityFlag("UTlaeW4qkDjAVPiuE46r6z98HDKLPlZVVS946QWq9wBDKmPsMR");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("dH1Wax2twQ6Oksm7fp5xVqxtomyMkm8VdDEeORxpmLM64ovdKd");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("ODb33RvZcRxleq3r7MSMeMy9WqqXK2JDPZqtIMQB5CahsrQ5LU");
        address.setAddress1("QQp96V3p9E0e8K9B2Zrnl6p4yopVknvLpsYYEmuGVDWQjrsvoi");
        address.setZipcode("BgsRaE");
        address.setAddress2("ByEiNo3wvyRznHO0UOb4fw6KD7zwlRQ1Etn8lHRtAspGFez1yv");
        address.setAddressLabel("FSlGXQO6fwe");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("5vXrrQoUN139BJqLQ3Rw0lsNxefqOQgwhXDSOPD6tGWkb1SUip");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(675);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("iDl79I63lvcTLlqifmX4JBcwko9i4GZVF5stbX8ScDcNMjGbLX");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("z6x1mLydniAuZdJyXb5gChq35RD7CIcH0tFUe7kLKR9r63Qk2N");
        useraccesslevel.setLevelIcon("kqhwtt95WKp5l6vuEkwKhqeIChjhnxj6giuLO4JMuhmO4BTSR5");
        useraccesslevel.setLevelDescription("zPpkTQIdTtaMp4usclMuFO8dzp1K6Z8Qh8QuQJbayD3g4sX3mq");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("Ql4t66ljn9byCAPTriRM32iyFrdvZ6N8j6EzxMpCQpuGPVNg3P");
        useraccessdomain.setDomainDescription("fkV4AW8p1H4bAlWQ9gDAqAYOLMtGZ3elaqaZbjrQatf7ivnkVZ");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("2Aq3q2q1d3M0s0adWFOZbyhObNL5h9uqGsDrrUmaE9GmGx5ah3");
        useraccessdomain.setDomainName("Z1YyP7ww21QSWihWILpkjssXDVsaetvS1dIMGnUfnPE4vgVnyr");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(2250);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setPasswordAlgo("UcaHASmzVdrrYz4jnI4JwqZJaKCCSKUP5p34boEZPeNbOeLHAx");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1460532734964l));
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1460532734964l));
        user.setIsLocked(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(4493);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("tSV7mJuTth6AZvetCgjAN2mQSGOWODU3rQp3HSjBFdRxZJxKUV");
        question.setLevelid(8);
        question.setQuestion("rNBM7BgD1aKWPktGZP5wTWkWAuoO11lYTRHaxjLrbKO0NdaX68");
        question.setQuestionDetails("XMMMMC7oPa");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("JemVTrFiyJyKEdXM6UCOk11tKaIjlTjbVHrhnifMq7LBqqjAPH");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePassword("K4aERKlTkqtcnxj9merhAfqhtTRZUOXT");
        userdata.setLast5Passwords("n3IJsLWohBpw3KcZzQlA43QAT2pv8QckhAqvHBIX2VNT2gmyvG");
        userdata.setOneTimePasswordExpiry(5);
        userdata.setPassword("q9yvxwHIXh7rWS1iGeIOskVBEafYsxmUDD2Wtbn0vVAkEsbOow");
        userdata.setOneTimePassword("1vRNCcjqNoavVYgUOZwC7qsGWlFK7F2D");
        userdata.setLast5Passwords("3ZXPldTbYYcBtBlQrBZVnbFZyOpYmXPUJGaK04AmDqtsygeb5I");
        userdata.setOneTimePasswordExpiry(2);
        userdata.setPassword("o6zOM9xTuPKRMcG1dWVQEuo6sasdbaof4vrRwYWi21usjWmrqu");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1460532735317l));
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("SEqf8fvHbUSahUS3");
        login.setFailedLoginAttempts(2);
        login.setServerAuthImage("h30iFGEQwxWwYCF4R9RWq1iLMS06Lv3i");
        login.setLoginId("vngk1dHIydNf8C26eCxyRmsq0hCkVyOc6AQo2PVYe6o6XYUrq3");
        login.setIsAuthenticated(true);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("QsCufpeVUbq3eWXL");
            login.setVersionId(1);
            login.setFailedLoginAttempts(3);
            login.setServerAuthImage("T4MGkqaPtrDX4foP8JlRbllgWwwhL6EV");
            login.setLoginId("mUkDhsGP5Rn1CkiFRbBEVDJ9uhQ6r869l6AemdxNkbW9VpdUvm");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "2ZIhAq0vkqihizyEWkvjbwtLlrRiJ9JPvaAV6S8FxVW3MwYQxsNIlHLUhoS1oGhXnXhhQmhD47jQPV8AUF5rb8SP1mXUf6WLt62SOrhcY3zH9Z6yKS3WbqBmkeV8o7ncVIRXlV5r7HHk4954GJjFo0LmzRIFkNICGQULNxmF4BpPMtcqppovMXeIptGlzYo5Hoh6JnAyg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "xfDlQLig2Nas8wXRqQTPQEKpTOCzlWc0F"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "sqBZEWfGSw1Hih2Ji"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
