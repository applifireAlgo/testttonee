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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("oXoeYtZ1CHI7ipWn2jWUjO9FYUoGJZEfWCNI7u8MxKAEAEJNG6");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("if6NAkdm2J5scOdjUFUUMOFitNdkRzzBhFNKkNW23rEhzaxk8c");
        useraccesslevel.setLevelIcon("PufaBNM03iax64KtNbeGsmMZW0rPTq4woGriBtIeQdfLoK4Xmb");
        useraccesslevel.setLevelDescription("FDnNCoju1HYeAAby5gQgL1OdEvwc5m6Qdhrm5ZTLfW1UNhEYiM");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("lQoeXgD5at5CQ8aJahS4Cq9KjcwwTn1NqxoVHp6b5d6omRWBlP");
            useraccesslevel.setUserAccessLevel(62409);
            useraccesslevel.setLevelHelp("olqTM82T90x1PPo9Bf92Ljc6YbW9lOzrAbKUepl2dxuPfndOmz");
            useraccesslevel.setLevelIcon("93N07JN42QWsuhtEIshjqMxwW0stdCkSB6j8YxstcGxw6Ldg21");
            useraccesslevel.setLevelDescription("fPpRrLwRx0a4frbT30oQtciwPYG4s20GD0o1gPUDHkSg6pngta");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 135396));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "nP8RBHO1IHfKaA3eHdd0UvtnQXAf8tLpAhq29y0VVUhlBzLKLs6tkBEl8Sp6kmvbCqYQikpCqmnwv7Og0eiF63HwDtqzZbqdXYC43wRo9ucOGqMUpugJyWpkC6M6RucSs81lvMH7degHU1HuJAqlwNmPmojSO3CQRvUs6lEh54yH704a6QnzD6O36CODulOQYTIMFvckO3TfyMnDfCmuDDuAmw4sQMqB6crB6knA5SVYVC4JyYu9uYGOltSx4y3ro"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "nlObP1RpluPU7QHDmy9YEVrmgixyMFIafQmYYE6zOpf1O7U5SQLx6plClRGU1EpjKH4IA3pJO0WyUr6vO6l0OcBgwEpmf4F4viWxvMDgkz8qJpW5MJZDWsfigpk3mbqyPUVNjWCf6sgrnXqc3Kmy55q9MlCdAyOQAT7wCtncNVpLXRetHK5BN2c3ArcAswxrY8v2MB2EMqMuSy0j94LYW8cmnpb4bFCxEmcEYvybLf3MiExLcQ0wan2m024zRdxdh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "NdfGCUP7TOCm5FnKaFuMuoSoTvlwTwoNPfcqcHdbpuTUtHYJBFf4nnctVTnz42Fyr9nKDWJgAymAQNZGHGPoQIDJ9Fv8Kke06fnPkqVvyKJzUeJe8E7YbWlfYJuRJ04U6Ni19togBiVwP1MS32UQAU5Fio074HKZx4EKojJJKbbN7jtwV8ONhay2SBuOjF4gEeWJWRsM09RjVwbzr4JXyRHn1sCA0EezZfHmqUNKMaHW6Ley406UN2GI2o4VFoBnJ"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
