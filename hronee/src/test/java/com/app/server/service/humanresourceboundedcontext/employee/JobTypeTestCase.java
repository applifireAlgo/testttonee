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
import com.app.server.repository.humanresourceboundedcontext.employee.JobTypeRepository;
import com.app.shared.humanresourceboundedcontext.employee.JobType;
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
public class JobTypeTestCase extends EntityTestCriteria {

    @Autowired
    private JobTypeRepository<JobType> jobtypeRepository;

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

    private JobType createJobType(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        JobType jobtype = new JobType();
        jobtype.setJobDescOne("L5SxhTqVFe8Y4y5dZtZPwCU1NzlZHxTGw1NHwxB1OAQiGnIvlu");
        jobtype.setEntityValidator(entityValidator);
        return jobtype;
    }

    @Test
    public void test1Save() {
        try {
            JobType jobtype = createJobType(true);
            jobtype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            jobtype.isValid();
            jobtypeRepository.save(jobtype);
            map.put("JobTypePrimaryKey", jobtype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("JobTypePrimaryKey"));
            JobType jobtype = jobtypeRepository.findById((java.lang.String) map.get("JobTypePrimaryKey"));
            jobtype.setJobDescOne("zsw9CDhJoDnM1swbwZVuBv0cQ0w0eJn9dFUsrg1xSqoZSHGD9g");
            jobtype.setVersionId(1);
            jobtype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            jobtypeRepository.update(jobtype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("JobTypePrimaryKey"));
            jobtypeRepository.findById((java.lang.String) map.get("JobTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQJobtypeNQ() {
        try {
            jobtypeRepository.JobtypeNQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQTestOne() {
        try {
            jobtypeRepository.TestOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQTestTwo() {
        try {
            jobtypeRepository.TestTwo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("JobTypePrimaryKey"));
            jobtypeRepository.delete((java.lang.String) map.get("JobTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateJobType(EntityTestCriteria contraints, JobType jobtype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            jobtype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            jobtype.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            jobtype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            jobtypeRepository.save(jobtype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "jobDescOne", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "jobDescOne", "UqN58RIyAn8xoKWwYZsRGBKCfQjC394z1VDJk151qwmkueTpbEWQtxbiWUG5ZgmhnRZ9pL5ixKHvc3IK5twecQ3D3ID8dRNXdh7YsMCSRqrA50GzeKZF8A2b4QzIMnbSTC6n9GIkyiIzjdTzRR2nEmtW7lO6LneMJZ7SqHKjJ0mFVPil7yHr66Tz7qL2kxQ49PMlD0kvcuL5u5tyrlXEhA6y2hCNOF3EXSZpvRdsIzC7IQ3lPY9NaLTvg7OXYewSe"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                JobType jobtype = createJobType(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = jobtype.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(jobtype, null);
                        validateJobType(contraints, jobtype);
                        failureCount++;
                        break;
                    case 2:
                        jobtype.setJobDescOne(contraints.getNegativeValue().toString());
                        validateJobType(contraints, jobtype);
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
