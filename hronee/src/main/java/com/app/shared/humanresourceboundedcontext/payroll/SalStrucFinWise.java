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

@Table(name = "ast_SalStrucFinWise_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "anagha.kulkarni@algorhythm.co.in", updatedBy = "anagha.kulkarni@algorhythm.co.in", versionNumber = "3", comments = "SalStrucFinWise", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "SalStrucFinWise.DefaultFinders", query = "select e from SalStrucFinWise e where e.systemInfo.activeStatus=1 and e.empId LIKE :empId and e.basic BETWEEN :minbasic AND :maxbasic and e.hra BETWEEN :minhra AND :maxhra and e.convenceAllowance BETWEEN :minconvenceAllowance AND :maxconvenceAllowance and e.medicalAllowance BETWEEN :minmedicalAllowance AND :maxmedicalAllowance and e.educationalAllowance BETWEEN :mineducationalAllowance AND :maxeducationalAllowance and e.specailAllowance BETWEEN :minspecailAllowance AND :maxspecailAllowance and e.perk BETWEEN :minperk AND :maxperk and e.totalCTC BETWEEN :mintotalCTC AND :maxtotalCTC and e.takeHome BETWEEN :mintakeHome AND :maxtakeHome and e.salaryDrawn BETWEEN :minsalaryDrawn AND :maxsalaryDrawn and e.taxableAmount BETWEEN :mintaxableAmount AND :maxtaxableAmount and e.nonTaxableAmount BETWEEN :minnonTaxableAmount AND :maxnonTaxableAmount"), @javax.persistence.NamedQuery(name = "SalStrucFinWise.findByEmpId", query = "select e from SalStrucFinWise e where e.systemInfo.activeStatus=1 and e.empId=:empId"), @javax.persistence.NamedQuery(name = "SalStrucFinWise.findById", query = "select e from SalStrucFinWise e where e.systemInfo.activeStatus=1 and e.applicantId =:applicantId") })
public class SalStrucFinWise implements Serializable, CommonEntityInterface, Comparator<SalStrucFinWise> {

    @Column(name = "yearValue")
    @JsonProperty("yearValue")
    @NotNull
    @Min(2010)
    @Max(9999)
    private Integer yearValue;

    @Column(name = "basic")
    @JsonProperty("basic")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double basic;

    @Column(name = "hra")
    @JsonProperty("hra")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double hra;

    @Column(name = "convenceAllowance")
    @JsonProperty("convenceAllowance")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double convenceAllowance;

    @Column(name = "medicalAllowance")
    @JsonProperty("medicalAllowance")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double medicalAllowance;

    @Column(name = "educationalAllowance")
    @JsonProperty("educationalAllowance")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double educationalAllowance;

    @Column(name = "specailAllowance")
    @JsonProperty("specailAllowance")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double specailAllowance;

    @Column(name = "perk")
    @JsonProperty("perk")
    @NotNull
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
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double takeHome;

    @Column(name = "salaryDrawn")
    @JsonProperty("salaryDrawn")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double salaryDrawn;

    @Column(name = "taxableAmount")
    @JsonProperty("taxableAmount")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double taxableAmount;

    @Column(name = "nonTaxableAmount")
    @JsonProperty("nonTaxableAmount")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double nonTaxableAmount;

    @Column(name = "totalTax")
    @JsonProperty("totalTax")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double totalTax;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "applicantId")
    @JsonProperty("applicantId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String applicantId;

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
        if (_basic != null) {
            this.basic = _basic;
        }
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double _hra) {
        if (_hra != null) {
            this.hra = _hra;
        }
    }

    public Double getConvenceAllowance() {
        return convenceAllowance;
    }

    public void setConvenceAllowance(Double _convenceAllowance) {
        if (_convenceAllowance != null) {
            this.convenceAllowance = _convenceAllowance;
        }
    }

    public Double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(Double _medicalAllowance) {
        if (_medicalAllowance != null) {
            this.medicalAllowance = _medicalAllowance;
        }
    }

    public Double getEducationalAllowance() {
        return educationalAllowance;
    }

    public void setEducationalAllowance(Double _educationalAllowance) {
        if (_educationalAllowance != null) {
            this.educationalAllowance = _educationalAllowance;
        }
    }

    public Double getSpecailAllowance() {
        return specailAllowance;
    }

    public void setSpecailAllowance(Double _specailAllowance) {
        if (_specailAllowance != null) {
            this.specailAllowance = _specailAllowance;
        }
    }

    public Double getPerk() {
        return perk;
    }

    public void setPerk(Double _perk) {
        if (_perk != null) {
            this.perk = _perk;
        }
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
        if (_takeHome != null) {
            this.takeHome = _takeHome;
        }
    }

    public Double getSalaryDrawn() {
        return salaryDrawn;
    }

    public void setSalaryDrawn(Double _salaryDrawn) {
        if (_salaryDrawn != null) {
            this.salaryDrawn = _salaryDrawn;
        }
    }

    public Double getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(Double _taxableAmount) {
        if (_taxableAmount != null) {
            this.taxableAmount = _taxableAmount;
        }
    }

    public Double getNonTaxableAmount() {
        return nonTaxableAmount;
    }

    public void setNonTaxableAmount(Double _nonTaxableAmount) {
        if (_nonTaxableAmount != null) {
            this.nonTaxableAmount = _nonTaxableAmount;
        }
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double _totalTax) {
        if (_totalTax != null) {
            this.totalTax = _totalTax;
        }
    }

    public String getPrimaryKey() {
        return applicantId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return applicantId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String _applicantId) {
        this.applicantId = _applicantId;
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
    public int compare(SalStrucFinWise object1, SalStrucFinWise object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((totalCTC == null ? " " : totalCTC));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (applicantId == null) {
            return super.hashCode();
        } else {
            return applicantId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise other = (com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise) obj;
            if (applicantId == null) {
                return false;
            } else if (!applicantId.equals(other.applicantId)) {
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
}
