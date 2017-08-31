package MyWork;

import java.time.ZonedDateTime;

public class Loan {
    private final CapitalStrategy _strategy;
    private float _notional;
    private float _outstanding;
    private int _rating;
    private ZonedDateTime _expiry;
    private ZonedDateTime _maturity;

    public Loan(float notional, float outstanding, int rating, ZonedDateTime expiry)
    {
        this._strategy = new TermROC();
        this._notional = notional;
        this._outstanding = outstanding;
        this._rating = rating;
        this._expiry = expiry;
    }

    public Loan(float notional, float outstanding, int rating, ZonedDateTime expiry, ZonedDateTime maturity)
    {
        this._strategy = new RevolvingTermROC();
        this._notional = notional;
        this._outstanding = outstanding;
        this._rating = rating;
        this._expiry = expiry;
        this._maturity = maturity;
    }

    public Loan(CapitalStrategy strategy, float notional, float outstanding,
                int rating, ZonedDateTime expiry, ZonedDateTime maturity)
    {
        this._strategy = strategy;
        this._notional = notional;
        this._outstanding = outstanding;
        this._rating = rating;
        this._expiry = expiry;
        this._maturity = maturity;
    }

    public CapitalStrategy GetCapitalStrategy()
    {
        return _strategy;
    }
}
