package com.app.server.businessservice.humanresourceboundedcontext.payroll;
import com.app.server.repository.humanresourceboundedcontext.payroll.CostToCompanyRepository;
import com.app.server.repository.humanresourceboundedcontext.payroll.SalStrucFinWiseRepository;
import com.app.shared.humanresourceboundedcontext.payroll.CostToCompany;
import com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class CalCTCService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CostToCompanyRepository<CostToCompany> costToCompanyRepository;

    @Autowired
    private SalStrucFinWiseRepository<SalStrucFinWise> salStrucFinWiseRepository;

    public void processCTC(CostToCompany entity) throws SpartanPersistenceException, SpartanConstraintViolationException, Exception {
        if (entity.getTotalCTC() > 0) {
            entity.setBasic(entity.getTotalCTC() * 0.30);
            entity.setHra(entity.getTotalCTC() * 0.40);
            entity.setEducationalAllowance(java.lang.Double.valueOf(2500));
            entity.setConvenceAllowance(java.lang.Double.valueOf(9600));
            entity.setMedicalAllowance(java.lang.Double.valueOf(15000));
            entity.setPerk(java.lang.Double.valueOf(0));
            entity.setSpecailAllowance(entity.calSpecialAllowance());
            com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise salStrucFinWise = new com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise();
            salStrucFinWise.setEmpId(entity.getEmpId());
            salStrucFinWise.setYearValue(entity.getYearValue());
            salStrucFinWise.setBasic(entity.getBasic());
            salStrucFinWise.setHra(entity.getHra());
            salStrucFinWise.setConvenceAllowance(entity.getConvenceAllowance());
            salStrucFinWise.setEducationalAllowance(entity.getEducationalAllowance());
            salStrucFinWise.setMedicalAllowance(entity.getMedicalAllowance());
            salStrucFinWise.setSpecailAllowance(entity.calSpecialAllowance());
            salStrucFinWise.setPerk(entity.getPerk());
            salStrucFinWise.setSalaryDrawn(java.lang.Double.valueOf(0));
            salStrucFinWise.setTotalCTC(entity.getTotalCTC());
            salStrucFinWise.setTakeHome(entity.getTakeHome());
            salStrucFinWise.setTaxableAmount(entity.getTotalCTC());
            salStrucFinWise.setNonTaxableAmount(java.lang.Double.valueOf(0));
            salStrucFinWise.setTotalTax(java.lang.Double.valueOf(0));
            if (salStrucFinWise.getTaxableAmount() > 1000000) {
                salStrucFinWise.setTotalTax(java.lang.Double.valueOf((salStrucFinWise.getTaxableAmount() - 1000000) * 0.30));
                salStrucFinWise.setTaxableAmount(salStrucFinWise.getTaxableAmount() - (salStrucFinWise.getTaxableAmount() - 1000000));
            }
            if ((salStrucFinWise.getTaxableAmount() > 500000 && salStrucFinWise.getTaxableAmount() < 1000000)) {
                salStrucFinWise.setTotalTax(java.lang.Double.valueOf(salStrucFinWise.getTotalTax() + ((salStrucFinWise.getTaxableAmount() - 500000) * 0.20)));
                salStrucFinWise.setTaxableAmount(java.lang.Double.valueOf(salStrucFinWise.getTaxableAmount() - (salStrucFinWise.getTaxableAmount() - 500000)));
            }
            if (salStrucFinWise.getTaxableAmount() > 0) {
                salStrucFinWise.setTotalTax(java.lang.Double.valueOf(salStrucFinWise.getTotalTax() + 25000));
            }
            if (salStrucFinWise.getTotalCTC() > 0) {
                salStrucFinWise.setTakeHome(java.lang.Double.valueOf(salStrucFinWise.getTotalCTC() - salStrucFinWise.getTotalTax()));
            }
            entity.setTakeHome(salStrucFinWise.getTakeHome());
            com.app.shared.humanresourceboundedcontext.payroll.CostToCompany costToCompany2 = costToCompanyRepository.save(entity);
            com.app.shared.humanresourceboundedcontext.payroll.SalStrucFinWise salStrucFinWise2 = salStrucFinWiseRepository.save(salStrucFinWise);
        }
    }
}
