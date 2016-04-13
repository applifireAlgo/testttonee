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
import com.app.server.repository.humanresourceboundedcontext.employee.DesignationTypeRepository;
import com.app.shared.humanresourceboundedcontext.employee.DesignationType;
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
public class DesignationTypeTestCase extends EntityTestCriteria {

    @Autowired
    private DesignationTypeRepository<DesignationType> designationtypeRepository;

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

    private DesignationType createDesignationType(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        DesignationType designationtype = new DesignationType();
        designationtype.setDesignatnTypeDesc("0hFxO6Nt3omJeR2lJkafyA7X3oJqf24tkvCmdMohbl8PU2fuYe");
        designationtype.setEntityValidator(entityValidator);
        return designationtype;
    }

    @Test
    public void test1Save() {
        try {
            DesignationType designationtype = createDesignationType(true);
            designationtype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            designationtype.isValid();
            designationtypeRepository.save(designationtype);
            map.put("DesignationTypePrimaryKey", designationtype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DesignationTypePrimaryKey"));
            DesignationType designationtype = designationtypeRepository.findById((java.lang.String) map.get("DesignationTypePrimaryKey"));
            designationtype.setDesignatnTypeDesc("EpOHpTi7blMKi03KzLnmrSXAjrySlZcysCBh8Bm7IL3PAQrdGT");
            designationtype.setVersionId(1);
            designationtype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            designationtypeRepository.update(designationtype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DesignationTypePrimaryKey"));
            designationtypeRepository.findById((java.lang.String) map.get("DesignationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("DesignationTypePrimaryKey"));
            designationtypeRepository.delete((java.lang.String) map.get("DesignationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDesignationType(EntityTestCriteria contraints, DesignationType designationtype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            designationtype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            designationtype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            designationtype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            designationtypeRepository.save(designationtype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "designatnTypeDesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "designatnTypeDesc", "pGGIY2WtPjX4M9MsxcxDGMBaysXAnEmGey0IJvDRKB9AC4ZrVEhVrLdmhpEBuCXGVtDT2ckwt3AGZiPbupFq9TGen51tmrBUwTmvSBjsCdVMWkGzBgibZLSFyZfykM0uNvIFL7o7FqflH18iOzWwOqUxqjyrzV8GRH8i8AAii15c74Hyu10PrngGAIcXHf56u5pAm3nqQ8071SiHJy3wY1qlKtIJX2kg8ATf3qz1edbga83AazyJD30uz6Zdcxp4Q"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                DesignationType designationtype = createDesignationType(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = designationtype.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(designationtype, null);
                        validateDesignationType(contraints, designationtype);
                        failureCount++;
                        break;
                    case 2:
                        designationtype.setDesignatnTypeDesc(contraints.getNegativeValue().toString());
                        validateDesignationType(contraints, designationtype);
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
