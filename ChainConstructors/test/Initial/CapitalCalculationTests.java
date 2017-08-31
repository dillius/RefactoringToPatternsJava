package Initial;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;

public class CapitalCalculationTests {

    @Test
    public void four_parameter_constructor_yields_loan_with_TermROC_strategy()
    {
        Loan loan = new Loan(1.0f, 2.0f, 4, ZonedDateTime.now());
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(TermROC.class));
    }

    @Test
    public void five_parameter_constructor_yields_revolving_TermROC_strategy()
    {
        Loan loan = new Loan(1.0f, 2.0f, 4, ZonedDateTime.now(), ZonedDateTime.now());
        Assert.assertThat(loan.GetCapitalStrategy(), new IsInstanceOf(RevolvingTermROC.class));
    }
}
