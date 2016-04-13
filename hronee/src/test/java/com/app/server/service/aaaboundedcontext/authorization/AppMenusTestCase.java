package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuCommands("XmYSHsQANErxRB79LCBU2qkqXyrBI4vTBKfdN3DWji14IitFmi");
        appmenus.setAppType(1);
        appmenus.setRefObjectId("M04oJM1kiaNxH5m0N3l0SQSYaZOnu5dR2ZVfepbDwuiKRXhCMP");
        appmenus.setMenuIcon("8CinkbNOZy3oKiWsTzJDpRnHHRQ5oJoA67AvtFcVtgPdbIyQWs");
        appmenus.setMenuTreeId("jLUHpZtNoZtoegDyghh9fzjPxABMu3EHkhrl4cmasUSw4NpdoC");
        appmenus.setMenuHead(true);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuLabel("YaeVZua5g6MNN5rmuTqUOVi71mWZwCVi89gJ8R8P07mZoyB7io");
        appmenus.setUiType("nxO");
        appmenus.setMenuAccessRights(11);
        appmenus.setAppId("2uHUnn5z2F45F3lM9CDsT9vj70yKuqM6mF0TiBAHLZd41g6PuP");
        appmenus.setMenuAction("3rXglES7eFS9Z0F1qc2aUoEsDtsw7ncLeeDLMYrjNDJ28l3GIM");
        appmenus.setAutoSave(true);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuCommands("oEpGHq8oggmQNwQmGbrxv7HUysoFcpHJxnthXItE8PljFLMT5T");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("aPouNYt1A0M1R9yLVVAKtSQhChSaPy575bP7gWSmQ13MI7BgGX");
            appmenus.setMenuIcon("Uk8ifzw6ScZC7cP1YhuYq8aYdwoK7dM5VdcBTXTgVoOj87lBt0");
            appmenus.setMenuTreeId("e6ursPebBCue0vBEwmhR49tEv2zYh0ehNZUz1UVw9sTzqkkLXO");
            appmenus.setMenuLabel("BGQdfNV9VPvQpXB8wDGak8D3gu6AyLxuaa6hNPgXj80zYZnSBB");
            appmenus.setUiType("HBI");
            appmenus.setMenuAccessRights(10);
            appmenus.setAppId("bYOazjzf75GCwreso3bEj2bpOnUglMB9JsZIJH0tAAaqp6oIBM");
            appmenus.setVersionId(1);
            appmenus.setMenuAction("xnrdjLe3yIVm5c1lp9QbvTDqf7LHkMbKn86sGeY3EnljzdJ9Hg");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "Qb06L4iCO2fGein0sTphvjXO7lnpPMPQBXuuMm483qcPzS3FLqMMr9qrdMWdn0ognMtmfqO08sniFchC4VPRHk8h8uqxWahVxvjcfYuHze2FvhZNlUurv7yyQRFIc4lIdyRrVAn0cw94GaRvUX402fivVL0rq72Ocr1l6M4QrAF3HwHxH7IX4s7cuKpgnygoXNBnuhJECR62iFIG0kNHX0U9sgQTIN8kbIg1smoF6oqjEHk2cwVKwtxlXlhKrFBvi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "bsVjRw1dJ4CMFf7228gDslzAXpX3p2FfupfCwbV16YFxAKksC0lrsRAFXuvG9gxERljwr3doMcm4Iic1ONXoovFp1oPkdB5kxt1T4gX2clmbVfjFfMapme2Y98F5E0eWbXRKXEogU1iLhmpRKHgnwdXtigEnbmmMTvxV3H6QmgoXCOv3MgOW0StBnybHcVzP12nYwVfYOjrAaIkqsYBDMIHsmHE5LY4qa84xViaAFYZdo5r7elZj0mcYjbAc3CKzK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "Zy4ZeuYCJj76hQOikbTnsw6TERlfZKCPuWGmGsyzylAVQk7I1auvnoniRfPVQr8iTYj51DLoYATQ5RDQGAlNkOJYKOVGKq0iceadVMhW1OVPhCS72QyghPvoJYB5T6wtk3M8JyA3pT8vHZkDFSKq3rPJHTgUAtbHHZ5itO0Nn5axOxHe9AWERbERk9jrirfXtcews53Cfc6zInRdyBNt7mWqa4FlzRbHw0cZRTAgzM6dI0i5MD8vsr4XY6JFiOhjP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "6QRzHH3mtlgjVTsGNxqBvL6kJPh2XesUXHwwXCHKTOvfvQaZFpP7DZAYH8awozj3N"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "whgGDk1g52mn8yJbBQP4cvgurz8uAExuaz1SEmADDbZOKmkrCeB51FfWDsPYh7YmXHWk7FpYGD2L1UiYn05dybRJB9ublbflmB1p75i88Dd1fNtAHymrDYKAHjdPk0kweBo4ertPSAEJqKk2gx7e4C9xKpfwgtpSGAQ4I914le3VGFlotrTE93sF5n3hFgWlxv3U27uJxZOQDwuq57nyey73j45xNDXIVq7brqkZbEno5i28RQxQtNTVvHOVaHbnd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "ngWB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "lq1QkqcmZfHkwinPoOIA0Pmcliry0fa38iDpxxsssklWZonoW8BIVWQ6vzYHTlmFB7CTASVivXbEO0RYOK6OrqNYBWhTqnRigzPjuTMMWsAHEBky06R1HSMw25YaiLeEwSiVucWI0F2uRx9x4YubxHgHmtDf4G6IO2zsxCkJwOdUoylrzEdOwZk8oqAbardHYZBpe01pGSbheUVPVDmPIykXKOnrsoErUO11m0aKIEdIxHsJu1Hqv9vp6JuAekhUh"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "QdniXikvMgS1OnE7MNo5sFexQF4cYlWaHPv29AN3rB6fs3YBXvQg5d2KD2WeMwtPRpcCBR3dmZPEOl42cvrcyNeJKRFLNhyMWUZuCMuhoOZK1KpGfOAV5AGw2EEACTdjKMxzR0zHR8jujetK9izbqdwwHBujz5Uv44dona6kfl1MqiyqqJz0fBqpBiQmHiZVkGAEuWr6VAlDmKLDqg5NcHm7pOmMdRt7DLABs7Q25B14LVLQorRUpI4FTT1QnbqXb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
