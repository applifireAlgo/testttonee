package com.app.shared.humanresourceboundedcontext.payroll;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_CostToCompany_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "anagha.kulkarni@algorhythm.co.in", versionNumber = "4", comments = "CostToCompany", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "CostToCompany.DefaultFinders", query = "select e from CostToCompany e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId and e.basic BETWEEN :minbasic AND :maxbasic and e.hra BETWEEN :minhra AND :maxhra and e.convenceAllowance BETWEEN :minconvenceAllowance AND :maxconvenceAllowance and e.medicalAllowance BETWEEN :minmedicalAllowance AND :maxmedicalAllowance and e.educationalAllowance BETWEEN :mineducationalAllowance AND :maxeducationalAllowance and e.specailAllowance BETWEEN :minspecailAllowance AND :maxspecailAllowance and e.perk BETWEEN :minperk AND :maxperk and e.totalCTC BETWEEN :mintotalCTC AND :maxtotalCTC and e.takeHome BETWEEN :mintakeHome AND :maxtakeHome"), @javax.persistence.NamedQuery(name = "CostToCompany.findByEmpId", query = "select e from CostToCompany e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "CostToCompany.findById", query = "select e from CostToCompany e where e.systemInfo.activeStatus=1 and e.salaryId =:salaryId") })
public class CostToCompany implements Serializable, CommonEntityInterface, Comparator<CostToCompany> {

    @Column(name = "yearValue")
    @JsonProperty("yearValue")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer yearValue;

    @Column(name = "basic")
    @JsonProperty("basic")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double basic;

    @Column(name = "hra")
    @JsonProperty("hra")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double hra;

    @Column(name = "convenceAllowance")
    @JsonProperty("convenceAllowance")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double convenceAllowance;

    @Column(name = "medicalAllowance")
    @JsonProperty("medicalAllowance")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double medicalAllowance;

    @Column(name = "educationalAllowance")
    @JsonProperty("educationalAllowance")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double educationalAllowance;

    @Column(name = "specailAllowance")
    @JsonProperty("specailAllowance")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double specailAllowance;

    @Column(name = "perk")
    @JsonProperty("perk")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double perk;

    @Column(name = "totalCTC")
    @JsonProperty("totalCTC")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double totalCTC;

    @Column(name = "takeHome")
    @JsonProperty("takeHome")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double takeHome;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "salaryId")
    @JsonProperty("salaryId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String salaryId;

    @Column(name = "empId")
    @JsonProperty("empId")
    private String empId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Integer getYearValue() {
        return yearValue;
    }

    public void setYearValue(Integer _yearValue) {
        if (_yearValue != null) {
            this.yearValue = _yearValue;
        }
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double _basic) {
        this.basic = _basic;
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double _hra) {
        this.hra = _hra;
    }

    public Double getConvenceAllowance() {
        return convenceAllowance;
    }

    public void setConvenceAllowance(Double _convenceAllowance) {
        this.convenceAllowance = _convenceAllowance;
    }

    public Double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(Double _medicalAllowance) {
        this.medicalAllowance = _medicalAllowance;
    }

    public Double getEducationalAllowance() {
        return educationalAllowance;
    }

    public void setEducationalAllowance(Double _educationalAllowance) {
        this.educationalAllowance = _educationalAllowance;
    }

    public Double getSpecailAllowance() {
        return specailAllowance;
    }

    public void setSpecailAllowance(Double _specailAllowance) {
        this.specailAllowance = _specailAllowance;
    }

    public Double getPerk() {
        return perk;
    }

    public void setPerk(Double _perk) {
        this.perk = _perk;
    }

    public Double getTotalCTC() {
        return totalCTC;
    }

    public void setTotalCTC(Double _totalCTC) {
        if (_totalCTC != null) {
            this.totalCTC = _totalCTC;
        }
    }

    public Double getTakeHome() {
        return takeHome;
    }

    public void setTakeHome(Double _takeHome) {
        this.takeHome = _takeHome;
    }

    public String getPrimaryKey() {
        return salaryId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return salaryId;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String _salaryId) {
        this.salaryId = _salaryId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String _empId) {
        this.empId = _empId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(CostToCompany object1, CostToCompany object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((yearValue == null ? " " : yearValue) + ",");
        sb.append((totalCTC == null ? " " : totalCTC));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (salaryId == null) {
            return super.hashCode();
        } else {
            return salaryId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.humanresourceboundedcontext.payroll.CostToCompany other = (com.app.shared.humanresourceboundedcontext.payroll.CostToCompany) obj;
            if (salaryId == null) {
                return false;
            } else if (!salaryId.equals(other.salaryId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }

    public Double calSpecialAllowance() {
        return totalCTC - (basic + hra + convenceAllowance + medicalAllowance + educationalAllowance + perk);
    }
}
