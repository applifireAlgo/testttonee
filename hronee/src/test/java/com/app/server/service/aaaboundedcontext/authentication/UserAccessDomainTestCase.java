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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("RLQzt80xrZ13rZABSj5jl94WMicvPuxwjEv8ABy4dcjNpBdKKa");
        useraccessdomain.setDomainDescription("VEXv1EegzxUINi7hxQZ6etqNj2CuEPLzCmDxKUFCeNX00U2W0S");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("gAKpCwIkgtriPd3Qhfa5T3tpALII0yzBbTUEFZFMlV6tkJ3yjH");
        useraccessdomain.setDomainName("xhbgEOZWB2s1JVX3IMMqWJ6IXmMWafQRuHAfA9NnjgMAr4otJV");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("Rvfg1cNXmSq5WdgtN8rJi0zMKopHwMEZLhDOq21C26CVvYkDLt");
            useraccessdomain.setDomainDescription("F8AcXhN77FNInewXCqTQKVvc8dPM9JQWyziOQ2NMxQVb02tnOj");
            useraccessdomain.setUserAccessDomain(7587);
            useraccessdomain.setDomainHelp("dmuHqNYwGVm9Hn0X2CoLvtEm0dJZzndSUna7PUgIArMRzDBphe");
            useraccessdomain.setDomainName("tR7jMuUnwnKl7On8RLvdsDABd2zGxbFyaE8MNdiQU47vc5TRrS");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 148270));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "kFgAow9q61KhiNRF5YcIuSXA3vbul424BeS0CY6MHxQAG8W2c9WvgHWsPMRDwRQre2uuOe2KPQNB6hF42ugrAub6wEUV8L1Lz9qluMWW8TT3YoHLoXbKUxyxLy52EhIjFjkA12RLFxhJfaSVtQHLlooVK9apiHsFmmoQfDbTV8prZTigOvWkJ0uBarKqIx7oMfaXwLqbsqj7UJ64rzTaKeB56paj2oKEAxIBGxIC9gmcpHarDVLMmoA3ZvOJhvuTD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "xUT3UT435drayHxyClnt64F0mLL3m2h7Dfi9265jLwHj8JSMu2eiTirTRUW0bOHEj3Rfl9xmWUEChsShXEiPxRFDT0b0IOdanIahVSuNDaxveEjVUA0QNc3TvwTB2QwAwZcNfOKNJPs4i1xxY1DXexrGXqdcibi5LHinrTXAgsZbTyaHW5Iua2lHHOva4XLZFMXJ9fXhdJD1nLDCCxEeBxl5lxhZUoRszLTgVteBRomUvvuLu6yhtNfc6CCob35T2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "Z0poaIqxGxWJwVjWahQJohVf2mauq5Gsi3XSJdHrA1tt9n69zX7FmuB1MFRHjDJvqnYbVm4xZk1pSrX8VDrvgDaDJQj3cLg5h8MvYPLAE88FrW75xQKnAYwcWSygZV7u1IxsPBk5EqL1KVgnvw6hzhhxHlmC6e8PnockYXbZquKBtPkUwsskZ8QYBd7E9pkzcCGU95shdjGZQp9GBYfTpow6sX1oZ9CTjslMoBQbW3YG5TxG7I31Q6dqLQS6nNKKP"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
