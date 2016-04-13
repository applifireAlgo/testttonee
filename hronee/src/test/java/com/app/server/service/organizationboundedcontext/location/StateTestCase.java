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
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.State;
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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCapitalLongitude(9);
        country.setCountryFlag("Ml74eVnukzH574b2JpaWBUtjSh54Xo5SJeY10h0Q1zHKXpfw3q");
        country.setIsoNumeric(645);
        country.setCountryCode2("o3c");
        country.setCurrencyCode("aze");
        country.setCountryCode1("EDW");
        country.setCapital("rvmQ1hoLHbPZ0eX6LL5GVc9u81HtLgCf");
        country.setCurrencySymbol("AEDIndcQEDV8egCSvPcrMRBOdL919e22");
        country.setCapitalLatitude(4);
        country.setCountryName("0vN6esfdTUlSjIpNLUZHL7zsgsmSKp4yvCI2yog4z2hUoVZkjs");
        country.setCurrencyName("6jct6ugzanVsRr9hajeqauc1vqICHn3Jy6Wxs1ZkzTnmA1NWsw");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateFlag("bD11k2WB4jmnlqQU1u93YD6j6ibGGeTAK2mIihTQcvmm1pmGIG");
        state.setStateCodeChar2("rVqz8SSUF1wCETGR50zetgd9ZcyXMYsv");
        state.setStateCode(1);
        state.setStateCapital("u7cIdw9Ju6DI4F0rYzUusNp5y5oZCvTF52gonHJPB71F9FGQQ1");
        state.setStateCodeChar3("NMum8lKatSOglUFC2QoSIHK4JrwECk0m");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateDescription("8HcZZcdXbj6W6QFOIpXtSD8T2WDe1uWVhDmB8pVU7qUzrjOmM9");
        state.setStateName("SYf20Yek04zSb9K3XY9Kcee4Qwsuhjj4rkqTbkmj6CgfuEFIVE");
        state.setStateCapitalLongitude(3);
        state.setStateCapitalLatitude(10);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateFlag("7Wk6lqE47QJTpA8V0lSWtlGOuPptiUVJuZ4HUZHXszLoc8NeA7");
            state.setStateCodeChar2("3zpHA2fN3ugkpAr2oPrkP9wzb9ggYX0X");
            state.setStateCode(2);
            state.setStateCapital("e0BkQI7YXpkNI5qrPHKzJywbZ06X2qMoIM8CfuKkD5m5HcZSfw");
            state.setStateCodeChar3("KpeW8Nna9UXZZDnRgacO6Dd2xD5tf1Xn");
            state.setVersionId(1);
            state.setStateDescription("r31A27hoiTV0V7mWLbCak3lIUk6sKosfs9bQe7ZcSr9yjSf86Y");
            state.setStateName("t3ksjwhyuGfoKCfWvSbSPbvfV2LGkI0fu9YV2loISVPIxPox66");
            state.setStateCapitalLongitude(1);
            state.setStateCapitalLatitude(4);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "saUoG2GuXt5hv7Z4BLbhCdvTOeZIzo9OFRnwnY4uMIin2ztF5CCG6m18cRkl3IviVaswRyyku3PnCduoSuar0WCyxYnkAU3EYdSjndc3kQ2fR4Jg2vQQVXjMCC9FGmYze4GE9NdFzEDv5h3Lh9cvaRjq8d2tdbLHK8et29gZ7ZnX9A5LvVP3f7z7jRAUSqNmyNnP0ysBsdSf8S8sLnzkySPwNPxfsX4vxrFTfsQDuD34GERNFKuzgPy6HHwzm1t09"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "HuQrw56C5Y2OJle1mxWAPiu5j9q8nMT4r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "KVUPs7RX8ccNHIZzmmOA4k7TLtKTRwrtO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "0Gp4gDS9FCucrof0cFQGXNhkTbUzhFAQQwRw84gMrAI3vzM9Eogtz98j7e1yUe4fqjOjUDpkRoAVp0D1D1jmYu3CcedO1UbxrAOEGaQt5E2s3qrmWok6dDUjh18Ct8uBgvyXNzdi7cqHXnIoWweKItbSPhyvqMzbPSNRLtysBW7YZjqs6Atxx38dKLDykhcAvF0URV5dFC4UTPz8v6Im6X1C7uqExdbSjxJo1z4xUZqTxfTnYciqRzNlF6Ro78TlO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "VgAtH1l8HLwPU1PhfVOYe1YmJaBVNuv1YHow4ImCZk5gRbUlcixhYx9PYOnvhC7E95IiIiqHCiaoZILnPMq9TKooMqftqKHUw8HDuitu6PCHXCmPnBZqUvgmJFffMesKH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "Q8rsF9S78lGulIoZeXErXb1KQoF6g6R6UeEge5HSe1Muc2g1O8v2mynAB8OKL6cSTaUFkhKKEaHhfAS0jj6Xg7rJFcoTJEF2kLLmwYE5au0DQB8c02rIrHTnrcppk01JO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 20));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
