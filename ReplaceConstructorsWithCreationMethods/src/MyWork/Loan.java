package MyWork;

import java.time.ZonedDateTime;

public class Loan {
    private double _commitment;
    private final double _outstanding;
    private final int _riskRating;
    private final ZonedDateTime _maturity;
    private final ZonedDateTime _expiry;
    private final CapitalStrategy _capitalStrategy;

    public Loan(double commitment, int riskRating, ZonedDateTime maturity)
    {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, int riskRating, ZonedDateTime maturity, ZonedDateTime expiry)
    {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int riskRating, ZonedDateTime maturity, ZonedDateTime expiry)
    {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, ZonedDateTime maturity, ZonedDateTime expiry)
    {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                double outstanding, int riskRating,
                ZonedDateTime maturity, ZonedDateTime expiry)
    {
        this._commitment = commitment;
        this._outstanding = outstanding;
        this._riskRating = riskRating;
        this._maturity = maturity;
        this._expiry = expiry;

        if (capitalStrategy != null) {
            this._capitalStrategy = capitalStrategy;
        } else {
            if (expiry == null)
                this._capitalStrategy = new CapitalStrategyTermLoan();
            else if (maturity == null)
                this._capitalStrategy = new CapitalStrategyRevolver();
            else
                this._capitalStrategy = new CapitalStrategyRCTL();
        }
    }

    public CapitalStrategy GetCapitalStrategy()
    {
        return _capitalStrategy;
    }
}
