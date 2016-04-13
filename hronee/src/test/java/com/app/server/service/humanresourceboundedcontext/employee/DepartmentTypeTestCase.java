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
import com.app.server.repository.humanresourceboundedcontext.employee.DepartmentTypeRepository;
import com.app.shared.humanresourceboundedcontext.employee.DepartmentType;
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
public class DepartmentTypeTestCase extends EntityTestCriteria {

    @Autowired
    private DepartmentTypeRepository<DepartmentType> departmenttypeRepository;

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

    private DepartmentType createDepartmentType(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        DepartmentType departmenttype = new DepartmentType();
        departmenttype.setDeptTypeDesc("BDwJS2pybSAWLeoKTlADkq66GX3eTU1BM9i5gathBcVv2BA7CN");
        departmenttype.setEntityValidator(entityValidator);
        return departmenttype;
    }

    @Test
    public void test1Save() {
        try {
            DepartmentType departmenttype = createDepartmentType(true);
            departmenttype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            departmenttype.isValid();
            departmenttypeRepository.save(departmenttype);
            map.put("DepartmentTypePrimaryKey", departmenttype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DepartmentTypePrimaryKey"));
            DepartmentType departmenttype = departmenttypeRepository.findById((java.lang.String) map.get("DepartmentTypePrimaryKey"));
            departmenttype.setVersionId(1);
            departmenttype.setDeptTypeDesc("nG4ufzzJl6aX9QjJileG35qmrz8sbwrgX7Hs89zbeg7uX43WQr");
            departmenttype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            departmenttypeRepository.update(departmenttype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DepartmentTypePrimaryKey"));
            departmenttypeRepository.findById((java.lang.String) map.get("DepartmentTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("DepartmentTypePrimaryKey"));
            departmenttypeRepository.delete((java.lang.String) map.get("DepartmentTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDepartmentType(EntityTestCriteria contraints, DepartmentType departmenttype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            departmenttype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            departmenttype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            departmenttype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            departmenttypeRepository.save(departmenttype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "deptTypeDesc", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "deptTypeDesc", "x1tfq51w2E9SmCsUA8od4QmgvjGzhVsa85OcrLgKlgZGVFIFDi9tigFiTYFoYRkTsUjLzynhKS8lOdmzudbIFBYU7v4xodDKTKi7UUubyi70NrimZqhxvuwqaLWUOlGs0V6PocxovmK0PEyn173H3zpY9fy4IUQ90vxZi3zkCaQJKVLaDWZfPUlImtS9EmHKjLOeGh4IMCczEXBWQ2jsd6iYLR95eNDLxhiYeeJdqdnpMIMrZMlZpejZRi2DlAc3B"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                DepartmentType departmenttype = createDepartmentType(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = departmenttype.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(departmenttype, null);
                        validateDepartmentType(contraints, departmenttype);
                        failureCount++;
                        break;
                    case 2:
                        departmenttype.setDeptTypeDesc(contraints.getNegativeValue().toString());
                        validateDepartmentType(contraints, departmenttype);
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
