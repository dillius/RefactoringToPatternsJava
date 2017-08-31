package Initial;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CapitalCalculationTests {
    private final ZonedDateTime _maturity = ZonedDateTime.parse("2020-10-02T00:00:00.000Z");
    private final ZonedDateTime _expiry = ZonedDateTime.parse("2021-10-02T00:00:00.000Z");

    private final double Commitment = 3.0;
    private final double Outstanding = 12.9;
    private RiskAdjustedCapitalStrategy _riskAdjustedCapitalStrategy = new RiskAdjustedCapitalStrategy();
    private final int RiskRating = 5;


    @Test
    public void test_term_loan_no_payments()
    {
        Loan loan = new Loan(Commitment, RiskRating, _maturity);
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(CapitalStrategyTermLoan.class));
    }

    @Test
    public void test_term_loan_one_payment()
    {
        Loan loan = new Loan(Commitment, RiskRating, _maturity);
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(CapitalStrategyTermLoan.class));
    }

    @Test
    public void test_revolver_loan_no_payments()
    {
        Loan loan = new Loan(Commitment, RiskRating, null, _expiry);
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(CapitalStrategyRevolver.class));
    }

    @Test
    public void test_RCTL_loan_one_payment()
    {
        Loan loan = new Loan(Commitment, Outstanding, RiskRating, _maturity, _expiry);
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(CapitalStrategyRCTL.class));
    }

    @Test
    public void test_term_loan_with_risk_adjusted_capital_strategy() {
        Loan loan = new Loan(_riskAdjustedCapitalStrategy,
                Commitment, Outstanding, RiskRating,
                _maturity, null);

            Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(RiskAdjustedCapitalStrategy.class));
    }
}
